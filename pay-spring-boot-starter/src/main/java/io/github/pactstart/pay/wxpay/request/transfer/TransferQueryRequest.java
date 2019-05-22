package io.github.pactstart.pay.wxpay.request.transfer;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class TransferQueryRequest {

    /**
     * 商户订单号，需保持唯一性
     * (只能是字母或者数字，不能包含有其他字符)
     * 必填String(32)
     */
    @NotBlank
    @Length(max = 32, message = "商户订单号限32个字符")
    private String partner_trade_no;

    public TransferQueryRequest(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }
}
