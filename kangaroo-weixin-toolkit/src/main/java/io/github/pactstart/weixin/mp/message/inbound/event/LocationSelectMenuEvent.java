package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class LocationSelectMenuEvent extends AbstractReceivedMessage {

    /**
     * 事件KEY值，由开发者在创建菜单时设定事件KEY值，由开发者在创建菜单时设定
     */
    private String eventKey;

    /**
     * X坐标信息
     */
    private String locationX;

    /**
     * Y坐标信息
     */
    private String locationY;

    /**
     * 精度，可理解为精度或者比例尺、越精细的话 scale越高
     */
    private int scale;

    /**
     * 地理位置的字符串信息
     */
    private String label;

    /**
     * 朋友圈POI的名字，可能为空
     */
    private String poiName;

    @Override
    public void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        Element locationInfoEle = root.element("SendLocationInfo");
        this.locationX = locationInfoEle.elementText("Location_X");
        this.locationY = locationInfoEle.elementText("Location_Y");
        this.scale = Integer.valueOf(locationInfoEle.elementText("Scale"));
        this.label = locationInfoEle.elementText("Label");
        this.poiName = locationInfoEle.elementText("Poiname");
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }
}
