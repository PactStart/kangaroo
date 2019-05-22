package io.github.pactstart.pay.alipay.enums;

public enum PayChannel {

    /**
     * 余额
     */
    balance,

    /**
     * 余额宝
     */
    moneyFund,

    /**
     * 红包
     */
    coupon,

    /**
     * 花呗
     */
    pcredit,

    /**
     * 花呗分期
     */
    pcreditpayInstallment,

    /**
     * 信用卡
     */
    creditCard,

    /**
     * 信用卡快捷
     */
    creditCardExpress,

    /**
     * 信用卡卡通
     */
    creditCardCartoon,

    /**
     * 信用支付类型（包含信用卡卡通、信用卡快捷、花呗、花呗分期）
     */
    credit_group,

    /**
     * 借记卡快捷
     */
    debitCardExpress,

    /**
     * 商户预存卡
     */
    mcard,

    /**
     * 个人预存卡
     */
    pcard,

    /**
     * 优惠（包含实时优惠+商户优惠）
     */
    promotion,

    /**
     * 营销券
     */
    voucher,

    /**
     * 积分
     */
    point,

    /**
     * 商户优惠
     */
    mdiscount,

    /**
     * 网银
     */
    bankPay;

}
