package io.github.pactstart.weixin.mp.message.outbound;

import io.github.pactstart.weixin.common.WeixinAsserts;
import io.github.pactstart.weixin.common.config.SettingsManager;
import io.github.pactstart.weixin.mp.message.data.Article;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class ReplyArticleMessage extends AbstractReplyMessage {

    private List<Article> articleList;

    @Override
    public void writeMore(Element root) {
        int maxReplayArticleSize = SettingsManager.getIntProperty("weixin.reply.article.maxSize", 8);
        WeixinAsserts.check(articleList.size() > maxReplayArticleSize, "回复图文数不能超过%d", maxReplayArticleSize);

        root.addElement("MsgType").addCDATA("news");
        root.addElement("ArticleCount").addCDATA("" + articleList.size());
        Element articlesEle = root.addElement("Articles");
        for (Article article : articleList) {
            Element itemEle = articlesEle.addElement("item");
            itemEle.addElement("Title").addCDATA(article.getTitle());
            itemEle.addElement("Description").addCDATA(article.getDescription());
            itemEle.addElement("PicUrl").addCDATA(article.getPicUrl());
            itemEle.addElement("Url").addCDATA(article.getUrl());
        }
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
