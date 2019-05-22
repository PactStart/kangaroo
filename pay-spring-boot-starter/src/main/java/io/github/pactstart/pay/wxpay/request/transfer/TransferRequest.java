package io.github.pactstart.pay.wxpay.request.transfer;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TransferRequest {

    /**
     * 微信支付分配的终端设备号
     * 示例值：013467007045764
     * 非必填,String(32)
     */
    @Length(max = 32, message = "设备号device_info限32个字符")
    private String device_info;

    /**
     * 商户订单号，需保持唯一性
     * (只能是字母或者数字，不能包含有其他字符)
     * 必填String(32)
     */
    @NotBlank
    @Length(max = 32, message = "商户订单号限32个字符")
    private String partner_trade_no;

    /**
     * 商户appid下，某用户的openid
     */
    @NotBlank
    @Length(max = 64, message = "openid限64个字符")
    private String openid;

    /**
     * 校验用户姓名选项
     * NO_CHECK：不校验真实姓名
     * FORCE_CHECK：强校验真实姓名
     */
    private String check_name = "NO_CHECK";

    /**
     * 收款用户真实姓名。
     * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
     */
    private String re_user_name;

    /**
     * 企业付款金额，单位为分
     */
    @NotNull(message = "付款金额不能为空")
    @Min(value = 1, message = "付款最低金额为1分")
    private Integer amount;

    /**
     * 企业付款备注，必填。注意：备注中的敏感词会被转成字符*
     */
    @Length(max = 100, message = "企业付款备注限100个字符")
    private String desc;

    /**
     * 用户端实际ip
     */
    @Length(max = 16, message = "终端IP spbill_create_iph限16个字符")
    @NotNull(message = "终端IP不能为空")
    private String spbill_create_ip;

    public TransferRequest(String partner_trade_no, String openid, Integer amount, String desc, String spbill_create_ip) {
        this.partner_trade_no = partner_trade_no;
        this.openid = openid;
        this.amount = amount;
        this.desc = desc;
        this.spbill_create_ip = spbill_create_ip;
    }
}
