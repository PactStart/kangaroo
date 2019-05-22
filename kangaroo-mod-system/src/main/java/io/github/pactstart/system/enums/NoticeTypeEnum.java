package io.github.pactstart.system.enums;

public enum NoticeTypeEnum {

    /**
     * 会员通知
     */
    MEMBER_NOTICE(0),

    /**
     * 平台通知
     */
    PLATFORM(1);

    private int value;

    NoticeTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
