package io.github.pactstart.pay.wxpay.response;

import io.github.pactstart.pay.wxpay.model.OrderRefund;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RefundQueryResponse {

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
     * 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
     * 非必填
     */
    private Integer total_refund_count;

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
     * 订单总金额，单位为分
     */
    private Integer total_fee;

    /**
     * 应结订单金额
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
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
     * 当前返回退款笔数
     * 必填
     */
    private Integer refund_count;

    private List<OrderRefund> orderRefundList;

    public boolean isSuccess() {
        return "SUCCESS".equals(return_code) && "SUCCESS".equals(result_code);
    }
}
