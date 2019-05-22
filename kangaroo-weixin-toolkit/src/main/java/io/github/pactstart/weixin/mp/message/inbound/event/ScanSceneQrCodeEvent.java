package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 扫描带参数二维码事件
 * Created by Di.Lei on 2017/8/1.
 */
public class ScanSceneQrCodeEvent extends AbstractReceivedMessage {

    /**
     * 事件KEY值：
     * event为subscribe时，qrscene_为前缀，后面为二维码的参数值
     * event为scan时，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    private String eventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String ticket;

    @Override
    public void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        this.ticket = root.elementText("Ticket");
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
