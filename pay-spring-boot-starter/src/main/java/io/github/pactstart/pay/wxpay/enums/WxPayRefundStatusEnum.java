package io.github.pactstart.pay.wxpay.enums;

public enum WxPayRefundStatusEnum {

    /**
     * 退款成功
     */
    SUCCESS,

    /**
     * 退款关闭
     */
    REFUNDCLOSE,

    /**
     * 退款处理中
     */
    PROCESSING,

    /**
     * 退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
     */
    CHANGE;

    /**
     * 默认valueOf找不到匹配项会抛出异常，这里返回空
     *
     * @param refundStatus 退款状态
     * @return 退款状态枚举
     */
    public static WxPayRefundStatusEnum valueOfName(String refundStatus) {
        WxPayRefundStatusEnum result = null;
        for (WxPayRefundStatusEnum item : values()) {
            if (item.equals(refundStatus)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
