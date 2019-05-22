package io.github.pactstart.system.enums;

public enum SuggestionStatusEnum {

    PENDING_HANDLE(1),

    HANDLED(2);

    private int value;

    SuggestionStatusEnum(int value) {
        this.value = value;
    }

    public static SuggestionStatusEnum valueOf(int value) {
        SuggestionStatusEnum result = null;
        for (SuggestionStatusEnum item : values()) {
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
