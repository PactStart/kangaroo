package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;
import io.github.pactstart.weixin.mp.message.data.Article;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class kfNewsMessage extends KfMessageRequest<DefaultJsonResponse> {

    private List<Article> articleList;

    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.news;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articles", articleList);
        return jsonObject;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
