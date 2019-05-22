package io.github.pactstart.pay.wxpay.enums;

public enum WxPayTradeStateEnum {

    /**
     * 支付成功
     */
    SUCCESS,

    /**
     * 转入退款
     */
    REFUND,

    /**
     * 未支付
     */
    NOTPAY,

    /**
     * 已关闭
     */
    CLOSED,

    /**
     * 已撤销（刷卡支付）
     */
    REVOKED,

    /**
     * 用户支付中
     */
    USERPAYING,

    /**
     * 支付失败(其他原因，如银行返回失败)
     */
    PAYERROR;

    /**
     * 默认valueOf找不到匹配项会抛出异常，这里返回空
     *
     * @param tradeState 交易状态
     * @return 交易状态枚举
     */
    public static WxPayTradeStateEnum valueOfName(String tradeState) {
        WxPayTradeStateEnum result = null;
        for (WxPayTradeStateEnum item : values()) {
            if (item.equals(tradeState)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
