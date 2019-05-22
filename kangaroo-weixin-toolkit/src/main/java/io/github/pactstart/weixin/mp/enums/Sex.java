package io.github.pactstart.weixin.mp.enums;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public enum Sex {

    MALE("1"), FEMALE("2");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
