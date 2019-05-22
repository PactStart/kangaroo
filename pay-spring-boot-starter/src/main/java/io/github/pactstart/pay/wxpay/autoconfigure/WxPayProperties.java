package io.github.pactstart.pay.wxpay.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "pay.wxpay")
public class WxPayProperties {

    private String appId;

    private String mchId;

    private String key;

    private String certFile;

    private String notifyUrl;

    private boolean autoReport;

    private boolean useSandbox;

}
