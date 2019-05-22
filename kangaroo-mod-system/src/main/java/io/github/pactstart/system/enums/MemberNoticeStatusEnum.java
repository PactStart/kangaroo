package io.github.pactstart.system.enums;

public enum MemberNoticeStatusEnum {
    /**
     * 正在发送
     */
    SENDING(0),

    /**
     * 发送成功
     */
    SEND_SUCCESS(1),

    /**
     * 发送失败
     */
    SEND_FAIL(2),

    /**
     * 无需发送
     */
    ONLY_STORE(3);

    private int value;

    MemberNoticeStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
