package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class LinkMessage extends AbstractReceivedMessage {

    private String title;

    private String descripton;

    private String url;

    @Override
    public void readMore(Element root) {
        this.title = root.elementText("Title");
        this.descripton = root.elementText("Description");
        this.url = root.elementText("Url");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
