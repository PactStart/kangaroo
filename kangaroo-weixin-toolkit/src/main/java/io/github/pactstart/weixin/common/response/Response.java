package io.github.pactstart.weixin.common.response;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * Created by Rex.Lei on 2017/7/26.
 */
public abstract class Response {

    protected int errcode;

    protected String errmsg;

    public void process(HttpResponse response) throws Exception {
        process(response.getEntity(), response.getAllHeaders());
    }

    public abstract void process(HttpEntity entity, Header[] headers) throws Exception;

    public boolean isOk() {
        return errcode == 0;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

}
