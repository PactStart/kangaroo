package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 上报地理位置事件
 * Created by Di.Lei on 2017/8/1.
 */
public class LocationReportEvent extends AbstractReceivedMessage {

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 地理位置精度
     */
    private String precision;

    @Override
    public void readMore(Element root) {
        this.latitude = root.elementText("Latitude");
        this.longitude = root.elementText("Longitude");
        this.precision = root.elementText("Precision");
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
