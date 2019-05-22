package io.github.pactstart.pay.wxpay.autoconfigure;

import io.github.pactstart.pay.wxpay.WxPayService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://github.com/wxpay/WXPay-SDK-Java/tree/d7ecb4020780b676953ed7de58ef807bd871023f
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=11_1
 */
@Configuration
@ConditionalOnBean(annotation = EnableWxPay.class)
@EnableConfigurationProperties(WxPayProperties.class)
public class WxPayAutoConfiguration {

    @Bean
    public WxPayService wxPayService(WxPayProperties wxPayProperties) throws Exception {
        return new WxPayService(wxPayProperties);
    }
}
