package io.github.pactstart.juhe.enums;

public enum JuheResTypeEnum {

    YES(1),

    NO(2);

    private int value;

    JuheResTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
