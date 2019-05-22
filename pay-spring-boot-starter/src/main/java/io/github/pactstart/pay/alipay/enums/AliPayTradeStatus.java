package io.github.pactstart.pay.alipay.enums;

public enum AliPayTradeStatus {

    /**
     * 正在等待用户付款
     */
    WAIT_BUYER_PAY,

    /**
     * 未付款交易超时关闭，或支付完成后全额退款
     */
    TRADE_CLOSED,

    /**
     * 交易成功
     */
    TRADE_SUCCESS,

    /**
     * 交易完成
     */
    TRADE_FINISHED;

}
