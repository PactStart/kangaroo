package io.github.pactstart.system.enums;

public enum SysVersionStatusEnum {

    DRAFT(1),

    PUBLISHED(2),

    ROLLBACK(3),

    DELETED(4);

    private int value;

    SysVersionStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
