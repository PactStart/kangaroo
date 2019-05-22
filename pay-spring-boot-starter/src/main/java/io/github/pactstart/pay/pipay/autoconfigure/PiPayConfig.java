package io.github.pactstart.pay.pipay.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "pay.pipay")
public class PiPayConfig {

    private String mid;

    private String sid;

    private String did;

    private String currency;

    private String transactionUrl;

    private String verifyUrl;

    private String confirmUrl;

    private String cancelUrl;

}
