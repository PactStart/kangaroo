package io.github.pactstart.simple.web.framework.enums;

public enum RequestSource {

    Android(1),

    iOS(2),

    PC(3),

    weixin(4);

    private int value;

    RequestSource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * 不抛异常，没找到返回null
     *
     * @param name 来源
     * @return 枚举
     */
    public static RequestSource valueOfName(String name) {
        if (name == null || name.trim().length() == 0) {
            return null;
        }
        RequestSource result = null;
        for (RequestSource item : values()) {
            if (item.name().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public boolean isApp() {
        return this == RequestSource.Android || this == RequestSource.iOS;
    }
}
