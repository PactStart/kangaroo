package io.github.pactstart.weixin.common;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Di.Lei on 2017/8/9.
 */
public class HttpClientFactory {

    private static PoolingHttpClientConnectionManager manager = null;

    private static CloseableHttpClient httpClient;

    /**
     * 1.开启长连接时才是真正的连接池，如果是短连接，则只是作为一个信号量来限制总请求数，连接并没有复用
     * 2.HttpClient是线程安全的，不要每次使用创建一个
     * 3.如果连接池配置得比较大，则可以考虑创建多个HttpClient实例，而不是使用一个HttpClient实例
     * 4.使用连接池时要尽快消费响应提并释放连接到连接池，不要保持太久
     *
     * @return
     */
    public static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            //注册访问协议相关的socket工厂
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", SSLConnectionSocketFactory.getSystemSocketFactory()).build();

            //httpConnection工厂:配置写请求/解析响应处理器
            ManagedHttpClientConnectionFactory connFactory = new ManagedHttpClientConnectionFactory(DefaultHttpRequestWriterFactory.INSTANCE
                    , DefaultHttpResponseParserFactory.INSTANCE);

            //DNS解析器
            SystemDefaultDnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;

            //创建池化连接管理器
            manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, connFactory, dnsResolver);

            //默认socket配置
            SocketConfig defaultSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            manager.setDefaultSocketConfig(defaultSocketConfig);

            //设置整个连接池的最大连接数
            manager.setMaxTotal(300);

            //每个路由(ip+port)的默认最大连接数
            manager.setDefaultMaxPerRoute(200);

            //自定义
            manager.setMaxPerRoute(new HttpRoute(new HttpHost("api.weixin.com", 80)), 100);

            //从连接池获取连接时，连接不活跃多长时间后需要进行一次验证，默认为2s
            manager.setValidateAfterInactivity(5 * 1000);

            //默认请求配置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(2 * 1000)
                    .setSocketTimeout(5 * 1000)
                    .setConnectionRequestTimeout(2000)
                    .build();

            //创建HttpClient
            httpClient = HttpClients.custom()
                    .setConnectionManager(manager)
                    .setConnectionManagerShared(false) //连接池不是共享模式,默认为false
                    //配置一个后台线程定期释放过期连接和空闲连接，前提是连接池是非共享的
                    //内部使用IdleConnectionEvictor周期性调用closeExpiredConnections和closeIdleConnections，锁住整个连接池后遍历
                    //建议只启用closeExpiredConnections,前提是http服务生产者在返回响应中包含超时时间"Keep-Alive:timeout=time"
                    .evictIdleConnections(60, TimeUnit.SECONDS) //定期回收空闲连接
                    .evictExpiredConnections() //定期回收过期连接
                    .setConnectionTimeToLive(60, TimeUnit.SECONDS) //连接存活时间，如果不设置，根据长连接信息决定
                    .setDefaultRequestConfig(requestConfig) //设置默认请求配置
                    .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE) //连接重用策略，即是否能keepAlive
                    .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE) //长连接配置，即后去长连接生产多长时间
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)) //设置重试次数，默认是3次，当前禁用，根据需要开启
                    .build();

            //JVM停止或重启时，关闭连接池释放连接
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return httpClient;
    }
}
