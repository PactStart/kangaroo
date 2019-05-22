package io.github.pactstart.biz.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NameValuePair {

    private String name;

    private Object value;
}
