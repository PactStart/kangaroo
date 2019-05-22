package io.github.pactstart.weixin.mp.request.material;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.enums.MediaType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.TempMaterialAddResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;

/**
 * Created by Di.Lei on 2017/8/4.
 */
public class TempMaterialAddRequest extends AbstractAccessTokenRequest<TempMaterialAddResponse> {

    private File file;

    private MediaType mediaType;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/media/upload?access_token=" + getAccessToken() + "&type=" + mediaType.name();
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

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
