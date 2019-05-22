package io.github.pactstart.weixin.mp.request.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.NewsMaterialAddResponse;
import io.github.pactstart.weixin.mp.vo.NewsArticle;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.List;


/**
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsMaterialAddRequest extends AbstractAccessTokenRequest<NewsMaterialAddResponse> {

    private List<NewsArticle> articleList;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/add_news?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articles", articleList);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public List<NewsArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<NewsArticle> articleList) {
        this.articleList = articleList;
    }
}
