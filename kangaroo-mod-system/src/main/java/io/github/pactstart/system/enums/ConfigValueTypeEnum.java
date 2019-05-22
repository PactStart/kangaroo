package io.github.pactstart.system.enums;

import com.google.common.collect.Lists;
import io.github.pactstart.biz.common.vo.NameValuePair;

import java.util.List;

public enum ConfigValueTypeEnum {

    BOOL_TYPE(1, "布尔"),

    NUMBER_TYPE(2, "数值"),

    STRING_TYPE(3, "字符串"),

    JSON_TYPE(4, "json格式");

    private int value;

    private String name;

    ConfigValueTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ConfigValueTypeEnum valueOf(int value) {
        ConfigValueTypeEnum result = null;
        for (ConfigValueTypeEnum item : values()) {
            if (item.getValue() == value) {
                result = item;
                break;
            }
        }
        return result;
    }

    public static List<NameValuePair> selectAll() {
        List<NameValuePair> list = Lists.newArrayList();
        for (ConfigValueTypeEnum item : values()) {
            NameValuePair pair = new NameValuePair();
            pair.setName(item.getName());
            pair.setValue(item.getValue());
            list.add(pair);
        }
        return list;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
