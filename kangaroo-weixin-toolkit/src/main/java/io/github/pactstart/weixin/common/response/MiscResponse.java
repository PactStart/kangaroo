package io.github.pactstart.weixin.common.response;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public abstract class MiscResponse extends Response {

    private static Logger logger = LoggerFactory.getLogger(MiscResponse.class);

    protected String contentType;

    protected long contentLength;

    protected String attachFileName;

    protected InputStream data;

    @Override
    public void process(HttpEntity entity, Header[] headers) throws Exception {
        walkHeader(headers);
        if (entity.getContentType() != null) {
            this.contentType = entity.getContentType().getValue();
        } else {
            //永久非图文和视频素材没有返回ContentType头信息
            if (attachFileName.endsWith(".bmp") || attachFileName.endsWith(".bmp") ||
                    attachFileName.endsWith(".jpeg") || attachFileName.endsWith(".jpg") || attachFileName.endsWith(".gif")) {
                this.contentType = "image/" + attachFileName.substring(attachFileName.lastIndexOf('.') + 1);
            } else if (attachFileName.endsWith(".mp3") || attachFileName.endsWith(".wma") ||
                    attachFileName.endsWith(".wav") || attachFileName.endsWith(".amr")) {
                this.contentType = "audio/" + attachFileName.substring(attachFileName.lastIndexOf('.') + 1);
            } else if (attachFileName.endsWith(".mp4")) {
                this.contentType = "video/" + attachFileName.substring(attachFileName.lastIndexOf('.') + 1);
            }
        }
        this.contentLength = entity.getContentLength();
        if (isJsonOrText()) {
            String result = EntityUtils.toString(entity, "utf-8");
            if (logger.isDebugEnabled()) {
                logger.debug("响应结果>>>{}", result);
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.containsKey("errcode")) {
                this.errcode = jsonObject.getIntValue("errcode");
                this.errmsg = jsonObject.getString("errmsg");
            }
            parseJSON(jsonObject);
        } else {
            this.data = entity.getContent();
        }
        EntityUtils.consumeQuietly(entity);
    }

    public abstract void parseJSON(JSONObject jsonObject);

    public boolean isJsonOrText() {
        return ContentType.APPLICATION_JSON.getMimeType().equals(contentType) || ContentType.TEXT_PLAIN.getMimeType().equals(contentType);
    }

    public String getContentType() {
        return contentType;
    }

    private void walkHeader(Header[] headers) {
        for (Header header : headers) {
            logger.debug("{}:{}", header.getName(), header.getValue());
            walkHeaderElement(header);
        }
    }

    private void walkHeaderElement(Header header) {
        HeaderElement[] headerElements = header.getElements();
        for (HeaderElement element : headerElements) {
            logger.debug("{}:{}", element.getName(), element.getValue());
            NameValuePair[] pairs = element.getParameters();
            for (NameValuePair pair : pairs) {
                logger.debug("{}:{}", pair.getName(), pair.getValue());
                if ("Content-disposition" .equals(header.getName()) && "filename" .equals(pair.getName())) {
                    this.attachFileName = pair.getValue();
                }
            }
        }
    }

    public long getContentLength() {
        return contentLength;
    }

    public String getAttachFileName() {
        return attachFileName;
    }
}
