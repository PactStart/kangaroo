package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 认证过期通知
 * Created by Di.Lei on 2017/8/12.
 */
public class VerifyExpiredEvent extends AbstractReceivedMessage {

    private Long expiredTime;

    @Override
    public void readMore(Element root) {
        this.expiredTime = Long.valueOf(root.elementText("ExpiredTime"));
    }

    public Long getExpiredTime() {
        return expiredTime;
    }
}
