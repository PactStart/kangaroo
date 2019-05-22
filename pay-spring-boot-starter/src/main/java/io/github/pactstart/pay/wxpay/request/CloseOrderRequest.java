package io.github.pactstart.pay.wxpay.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CloseOrderRequest {

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。
     */
    @Pattern(regexp = "[A-Za-z0-9\\_\\-\\|\\*]{1,32}", message = "商户订单号不合法")
    @Length(max = 32, message = "商户系统内部订单号out_trade_no限32个字符")
    @NotNull(message = "商户系统内部订单号不能为空")
    private String out_trade_no;
}
