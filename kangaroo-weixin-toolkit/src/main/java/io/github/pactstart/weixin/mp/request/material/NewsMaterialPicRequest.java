package io.github.pactstart.weixin.mp.request.material;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.NewsMaterialPicResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;

/**
 * 上传图文消息内的图片获取URL
 * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
 * Created by Di.Lei on 2017/8/4.
 */
public class NewsMaterialPicRequest extends AbstractAccessTokenRequest<NewsMaterialPicResponse> {

    private File file;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/media/uploadimg?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA, file.getName());
        return MultipartEntityBuilder.create().addPart("media", fileBody).build();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
