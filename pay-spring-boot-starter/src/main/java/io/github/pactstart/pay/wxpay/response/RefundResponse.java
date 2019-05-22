package io.github.pactstart.pay.wxpay.response;

import io.github.pactstart.pay.wxpay.model.CouponRefund;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RefundResponse {

    /**
     * 返回状态码
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     * 必填，String(16)
     */
    private String return_code;

    /**
     * 返回信息
     * 非必填，String(128)
     */
    private String return_msg;

    //------------------以下字段在return_code为SUCCESS的时候有返回-----------------------

    /**
     * 应用APPID
     * 必填，String(32)
     */
    private String appid;

    /**
     * 商户号
     * 必填，String(32)
     */
    private String mch_id;

    /**
     * 随机字符串
     * 必填，String(32)
     */
    private String nonce_str;

    /**
     * 签名
     * 必填，String(32)
     */
    private String sign;

    /**
     * 业务结果
     * 必填，String(16)
     */
    private String result_code;

    /**
     * 错误代码
     * 非必填，String(32)
     */
    private String err_code;

    /**
     * 错误代码描述
     * 非必填，	String(128)
     */
    private String err_code_des;

    /**
     * 微信的订单号，优先使用
     * 必填，String(32)
     */
    private String transaction_id;

    /**
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     * 必填，String(32)
     */
    private String out_trade_no;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     * 必填，String(64)
     */
    private String out_refund_no;

    /**
     * 微信退款单号
     * 必填，String(32)
     */
    private String refund_id;

    /**
     * 退款金额	，单位为分
     */
    private Integer refund_fee;

    /**
     * 应结退款金额
     * 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额&lt;=申请退款金额
     */
    private Integer settlement_refund_fee;

    /**
     * 订单总金额，单位为分
     */
    private Integer total_fee;

    /**
     * 应结订单金额
     * 去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额&lt;=订单金额。
     * 非必填
     */
    private Integer settlement_total_fee;

    /**
     * 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * 非必填，String(8)
     */
    private String fee_type;

    /**
     * 现金支付金额，单位为分，只能为整数，详见支付金额
     * 必填，Int
     */
    private Integer cash_fee;

    /**
     * 现金支付币种	，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * 非必填，String(16)
     */
    private Integer cash_fee_type;

    /**
     * 现金退款金额，单位为分，只能为整数，详见支付金额
     * 非必填
     */
    private Integer cash_refund_fee;

    /**
     * 退款代金券使用数量
     * 非必填
     */
    private Integer coupon_refund_count;

    /**
     * 代金券退款总金额
     * 非必填
     */
    private Integer coupon_refund_fee;

    /**
     * 优惠券列表
     */
    private List<CouponRefund> couponRefundList;

    public boolean isSuccess() {
        return "SUCCESS".equals(return_code) && "SUCCESS".equals(result_code);
    }
}
