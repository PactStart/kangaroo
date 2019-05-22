package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 扫码推事件的事件推送
 * 扫码推事件且弹出“消息接收中”提示框的事件推送
 * Created by Di.Lei on 2017/8/1.
 */
public class ScancodeMenuEvent extends AbstractReceivedMessage {

    private String eventKey;

    private String scanType;

    private String scanResult;


    @Override
    public void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        Element scanCodeInfoElement = root.element("ScanCodeInfo");
        this.scanType = scanCodeInfoElement.elementText("ScanType");
        this.scanResult = scanCodeInfoElement.elementText("ScanResult");
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}
