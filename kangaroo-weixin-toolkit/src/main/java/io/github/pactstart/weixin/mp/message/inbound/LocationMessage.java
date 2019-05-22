package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class LocationMessage extends AbstractReceivedMessage {

    private String locationX;

    private String locationY;

    private String scale;

    private String label;

    @Override
    public void readMore(Element root) {
        this.locationX = root.elementText("Location_X");
        this.locationY = root.elementText("Location_Y");
        this.scale = root.elementText("Scale");
        this.label = root.elementText("Label");
    }

    public String getLocationX() {
        return locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public String getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }
}
