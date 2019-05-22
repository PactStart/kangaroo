package io.github.pactstart.weixin.common.request;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.Response;
import org.apache.http.HttpEntity;

/**
 * Created by Rex.Lei on 2017/7/26.
 */
public abstract class Request<T extends Response> {

    /**
     * 获取请求方式
     *
     * @return
     */
    public abstract RequestMethod getRequestMethod();

    /**
     * 获取请求路径
     *
     * @return
     */
    public abstract String getRequestPath();

    /**
     * 获取请求内容
     *
     * @return
     */
    public abstract HttpEntity getRequestEntity();
}
