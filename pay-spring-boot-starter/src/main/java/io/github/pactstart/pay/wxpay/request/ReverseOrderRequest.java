package io.github.pactstart.pay.wxpay.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReverseOrderRequest {

    /**
     * 微信的订单号，优先使用
     */
    private String transaction_id;

    /**
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    private String out_trade_no;

    public ReverseOrderRequest(String transaction_id, String out_trade_no) {
        this.transaction_id = transaction_id;
        this.out_trade_no = out_trade_no;
    }
}
