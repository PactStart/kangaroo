package io.github.pactstart.weixin.mp.vo;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class ValueColor {

    private String value;

    private String color;

    public ValueColor(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
