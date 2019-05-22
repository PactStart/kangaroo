package io.github.pactstart.system.enums;

public enum PlatformNoticeStatusEnum {
    /**
     * 草稿
     */
    DRAFT(1),

    /**
     * 已发布
     */
    PUBLISH(2),

    /**
     * 已删除
     */
    DELETE(3);

    private int value;

    PlatformNoticeStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlatformNoticeStatusEnum valueOf(int value) {
        PlatformNoticeStatusEnum result = null;
        for (PlatformNoticeStatusEnum item : values()) {
            if (item.getValue() == value) {
                result = item;
                break;
            }
        }
        return result;
    }
}
