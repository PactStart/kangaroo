package io.github.pactstart.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.http.HttpEntity;

public abstract class Request<T extends Response> {

    /**
     * 重发请求次数
     */
    @JsonIgnore
    private int retryTimes = 1;

    /**
     * 和服务器建立连接的timeout(单位： 毫秒)
     */
    @JsonIgnore
    private int connectTimeout = 10000;

    /**
     * 从服务器读取数据的timeout(单位： 毫秒)
     */
    @JsonIgnore
    private int socketTimeout = 10000;

    /**
     * 从连接池获取连接的timeout(单位： 毫秒)
     */
    @JsonIgnore
    private int connectionRequestTimeout = 10000;

    /**
     * 设置请求体
     *
     * @return
     */
    public abstract HttpEntity getRequestEntity();

    /**
     * 设置请求
     *
     * @return
     */
    public abstract String getRequestPath();

    /**
     * 设置请求方法
     *
     * @return
     */
    public abstract RequestMethod getRequestMethod();

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }


}
