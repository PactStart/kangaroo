package io.github.pactstart.weixin.mp.enums;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public enum ClientPlatformType {

    IOS("1"), Android("2"), OTHER("3");

    private String value;

    ClientPlatformType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
