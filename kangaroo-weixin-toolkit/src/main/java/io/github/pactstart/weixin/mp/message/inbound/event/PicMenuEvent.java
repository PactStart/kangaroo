package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 弹出系统拍照发图的事件推送
 * 弹出拍照或者相册发图的事件推送
 * Created by Di.Lei on 2017/8/1.
 */
public class PicMenuEvent extends AbstractReceivedMessage {

    /**
     * 事件KEY值，由开发者在创建菜单时设定
     */
    private String eventKey;

    /**
     * 发送的图片数量
     */
    private int count;

    /**
     * 图片的MD5值，开发者若需要，可用于验证接收到图片
     */
    private List<String> picMd5SumList;

    @Override
    public void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        Element sendPicInfoEle = root.element("SendPicsInfo");
        this.count = Integer.valueOf(sendPicInfoEle.elementTextTrim("Count"));
        picMd5SumList = new ArrayList<>();
        Element PicListEle = sendPicInfoEle.element("PicList");
        List<Element> itemEleList = PicListEle.elements("item");
        for (Element itemEle : itemEleList) {
            picMd5SumList.add(itemEle.elementText("PicMd5Sum"));
        }
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getPicMd5SumList() {
        return picMd5SumList;
    }

    public void setPicMd5SumList(List<String> picMd5SumList) {
        this.picMd5SumList = picMd5SumList;
    }
}
