package io.github.pactstart.pay.wxpay.response.transfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferQueryResponse {

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
     * 商户订单号
     * 必填，String(32)
     */
    private String partner_trade_no;

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
     * 调用企业付款API时，微信系统内部产生的单号
     * 必填，String(64)
     */
    private String detail_id;

    /**
     * 转账状态
     * SUCCESS:转账成功
     * FAILED:转账失败
     * PROCESSING:处理中
     * <p>
     * 必填，String(16)
     */
    private String status;

    /**
     * 如果失败则有失败原因
     * 非必填String(128)
     */
    private String reason;

    /**
     * 收款用户openid
     */
    private String openid;

    /**
     * 收款用户姓名
     */
    private String transfer_name;

    /**
     * 付款金额单位分）
     */
    private Integer payment_amount;

    /**
     * 微信付款单号
     * 必填，String(64)
     */
    private String payment_no;

    /**
     * 发起转账的时间
     */
    private String transfer_time;

    /**
     * 付款成功时间
     */
    private String payment_time;

    /**
     * 企业付款备注
     */
    private String desc;
}
