package io.github.pactstart.pay.wxpay.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RefundRequest {

    /**
     * 微信的订单号，优先使用
     */
    private String transaction_id;

    /**
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    private String out_trade_no;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @Pattern(regexp = "[A-Za-z0-9\\_\\-\\|\\*]{1,32}", message = "商户系统内部的退款单号不合法")
    @Length(max = 32, message = "商户系统内部的退款单号out_refund_no限32个字符")
    @NotNull(message = "商户系统内部的退款单号不能为空")
    private String out_refund_no;

    /**
     * 订单总金额，单位为分
     */
    @NotNull(message = "订单总金额不能为空")
    private Integer total_fee;

    /**
     * 退款金额	，单位为分
     */
    @NotNull(message = "订单总金额不能为空")
    private Integer refund_fee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @Length(max = 16, message = "货币类型refund_fee_type限16个字符")
    private String refund_fee_type = "CNY";

    /**
     * 退款原因
     * 若商户传入，会在下发给用户的退款消息中体现退款原因
     */
    @Length(max = 16, message = "退款原因refund_desc限80个字符")
    private String refund_desc;

    /**
     * 仅针对老资金流商户使用
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    @Length(max = 30, message = "退款资金来源refund_account限30个字符")
    private String refund_account;

    /**
     * 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
     */
    @Length(max = 256, message = "通知地址notify_url限256个字符")
//    @NotNull(message = "通知地址不能为空")
    private String notify_url;

    public RefundRequest(String transaction_id, String out_trade_no, String out_refund_no, Integer total_fee, Integer refund_fee, String refund_desc) {
        this.transaction_id = transaction_id;
        this.out_trade_no = out_trade_no;
        this.out_refund_no = out_refund_no;
        this.total_fee = total_fee;
        this.refund_fee = refund_fee;
        this.refund_desc = refund_desc;
    }
}
