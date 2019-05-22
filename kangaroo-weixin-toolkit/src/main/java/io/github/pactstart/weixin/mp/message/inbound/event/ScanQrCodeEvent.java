package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

public class ScanQrCodeEvent extends AbstractReceivedMessage {

    private String eventKey;

    private String scanType;

    private String scanResult;

    @Override
    protected void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        Element scanCodeInfoElement = root.element("ScanCodeInfo");
        this.scanType = scanCodeInfoElement.elementText("ScanType");
        this.scanResult = scanCodeInfoElement.elementText("ScanResult");
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getScanType() {
        return scanType;
    }

    public String getScanResult() {
        return scanResult;
    }
}
