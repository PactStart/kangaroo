package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class QualificationVerifyEvent extends AbstractReceivedMessage {

    private Long expiredTime;

    private Long failTime;

    private String failReason;

    private boolean isVerifySuccess() {
        return "qualification_verify_success".equals(this.getEvent());
    }

    @Override
    public void readMore(Element root) {
        if (isVerifySuccess()) {
            this.expiredTime = Long.valueOf(root.elementText("expiredTime"));
        } else {
            this.failTime = Long.valueOf(root.elementText("FailTime"));
            this.failReason = root.elementText("FailReason");
        }
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public Long getFailTime() {
        return failTime;
    }

    public String getFailReason() {
        return failReason;
    }
}
