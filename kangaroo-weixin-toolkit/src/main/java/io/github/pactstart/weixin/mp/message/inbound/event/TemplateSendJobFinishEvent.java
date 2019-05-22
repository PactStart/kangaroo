package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 事件推送:在模版消息发送任务完成后
 * Created by Rex.Lei on 2017/8/3.
 */
public class TemplateSendJobFinishEvent extends AbstractReceivedMessage {

    private String status;

    @Override
    protected void readMore(Element root) {
        this.msgId = root.elementText("MsgID");
        this.status = root.elementText("Status");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
