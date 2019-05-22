package io.github.pactstart.system.enums;

public enum SysLogStatus {

    UN_RESTORE(0),

    RESTORE(1);

    private int value;

    private SysLogStatus(int value) {
        this.value = value;
    }

    public static SysLogStatus valueOf(int value) {
        SysLogStatus result = null;
        for (SysLogStatus item :
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
