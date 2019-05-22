package io.github.pactstart.weixin.mp.request.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.enums.MediaType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.MaterialAddResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;

/**
 * 添加非图文永久素材
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialAddRequest extends AbstractAccessTokenRequest<MaterialAddResponse> {

    private File file;

    private MediaType mediaType;

    private String title;

    private String introduction;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/add_material?access_token=" + getAccessToken() + "&type=" + mediaType.name();
    }

    @Override
    public HttpEntity getRequestEntity() {
        FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA, file.getName());
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("media", fileBody);
        if (mediaType == MediaType.video) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", title);
            jsonObject.put("introduction", introduction);
            StringBody jsonBody = new StringBody(jsonObject.toJSONString(), ContentType.MULTIPART_FORM_DATA);
            builder.addPart("description", jsonBody);
        }
        return builder.build();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
