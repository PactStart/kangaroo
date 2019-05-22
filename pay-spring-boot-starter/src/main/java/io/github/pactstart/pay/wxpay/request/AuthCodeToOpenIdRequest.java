package io.github.pactstart.pay.wxpay.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AuthCodeToOpenIdRequest {

    /**
     * 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
     * （注：用户刷卡条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    @Length(max = 128, message = "授权码auth_code限128个字符")
    @NotNull(message = "授权码auth_code不能为空")
    private String auth_code;

    public AuthCodeToOpenIdRequest(String auth_code) {
        this.auth_code = auth_code;
    }
}
