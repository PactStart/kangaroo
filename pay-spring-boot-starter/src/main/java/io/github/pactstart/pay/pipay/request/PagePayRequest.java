package io.github.pactstart.pay.pipay.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class PagePayRequest {

    private String orderid;

    private String orderDesc;

    private String orderAmount;

    private Integer cancelSeconds;

    private Map<String, String> extParams;

}
