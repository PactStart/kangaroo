package io.github.pactstart.system.enums;

public enum SysUserStatus {

    FROZEN(0),

    NORMAL(1),

    DELETED(2);

    private int value;

    private SysUserStatus(int value) {
        this.value = value;
    }

    public static SysUserStatus valueOf(int value) {
        SysUserStatus result = null;
        for (SysUserStatus item :
                values()) {
            if (item.getValue() == value) {
                result = item;
                break;
            }
        }
        return result;
    }

    public int getValue() {
        return value;
    }
}
