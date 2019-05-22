package io.github.pactstart.pay.wxpay.request;

import io.github.pactstart.pay.wxpay.model.Coupon;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PayResultNoticeRequest {

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

    //------------------以下字段在return_code 和result_code都为SUCCESS的时候有返回-----------------------

    /**
     * 设备号
     * 非必填，	String(32)
     */
    private String device_info;

    /**
     * 用户标识
     * 必填，String(128)
     */
    private String openid;

    /**
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     * 非必填
     */
    private String is_subscribe;

    /**
     * 调用接口提交的交易类型
     * 必填，String(1)
     */
    private String trade_type;

    /**
     * 银行类型，采用字符串类型的银行标识
     * 必填，String(16)
     */
    private String bank_type;

    /**
     * 订单总金额，单位为分
     * 必填，int
     */
    private Integer total_fee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * 非必填，String(8)
     */
    private String fee_type;

    /**
     * 现金支付金额
     * 订单现金支付金额，详见支付金额
     * 必填，Int
     */
    private Integer cash_fee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * 非必填，String(16)
     */
    private Integer cash_fee_type;

    /**
     * 代金券金额
     * “代金券或立减优惠”金额&lt;=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额
     * 非必填，Int
     */
    private Integer coupon_fee;

    /**
     * 代金券使用数量
     * 代金券或立减优惠使用数量
     * 非必填，Int
     */
    private Integer coupon_count;

    /**
     * 优惠券列表
     */
    private List<Coupon> couponList;

    /**
     * 微信支付订单号
     * 必填，String(32)
     */
    private String transaction_id;

    /**
     * 商户订单号
     * 必填，String(32)
     */
    private String out_trade_no;

    /**
     * 附加数据，原样返回
     * 非必填，String(128)
     */
    private String attach;

    /**
     * 支付完成时间
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     * 必填，String(14)
     */
    private String time_end;


    public boolean isSuccess() {
        return "SUCCESS".equals(return_code) && "SUCCESS".equals(result_code);
    }

}
