package io.github.pactstart.weixin.common;


import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.exception.WeixinApiException;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.common.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Di.Lei on 2017/7/26.
 */
public abstract class WeixinApiClient {

    private static Logger logger = LoggerFactory.getLogger(WeixinApiClient.class);

    public abstract String getUrlRoot();

    public <T extends Response> T execute(Request<T> request) throws WeixinApiException {
        //1.获取请求url
        String url = getUrlRoot().concat(request.getRequestPath());
        if (logger.isDebugEnabled()) {
            logger.debug("请求地址>>>{}", url);
        }
        //2.构造请求
        HttpUriRequest httpUriRequest = null;
        CloseableHttpResponse httpResponse = null;
        try {
            if (request.getRequestMethod() == RequestMethod.GET) {
                httpUriRequest = new HttpGet(url);
            } else {
                HttpPost httpPost = new HttpPost(url);
                if (request.getRequestEntity() != null) {
                    httpPost.setEntity(request.getRequestEntity());
                    if (logger.isDebugEnabled() && request.getRequestEntity() instanceof StringEntity) {
                        logger.debug("请求数据>>>{}", EntityUtils.toString(request.getRequestEntity()));
                    }
                }
                httpUriRequest = httpPost;
            }
            CloseableHttpClient httpClient = HttpClientFactory.getHttpClient();
            //3.执行请求
            httpResponse = httpClient.execute(httpUriRequest);
            if (logger.isDebugEnabled()) {
                logger.debug("响应状态>>>{}", httpResponse.getStatusLine());
            }
            int status = httpResponse.getStatusLine().getStatusCode();
            //4.判断http响应状态码
            if (status == HttpStatus.SC_OK) {
                //5.获取响应类型并实例化
                ParameterizedType type = (ParameterizedType) request.getClass().getGenericSuperclass();
                Class<T> responseClass = (Class<T>) type.getActualTypeArguments()[0];
                T response = responseClass.newInstance();
                //6.填充响应对象
                response.process(httpResponse);
                if (!response.isOk()) {
                    logger.error("返回结果异常：" + response.getErrcode() + "," + response.getErrmsg());
                }
                return response;
            } else {
                throw new WeixinApiException("调用结果异常，响应状态码：" + status);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WeixinApiException("调用微信接口失败", e);
        } finally {
            if (httpResponse != null) {
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
        }
    }

}
