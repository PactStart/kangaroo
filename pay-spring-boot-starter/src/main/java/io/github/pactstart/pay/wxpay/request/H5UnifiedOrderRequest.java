package io.github.pactstart.pay.wxpay.request;

import io.github.pactstart.pay.wxpay.enums.WxPayTradeTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class H5UnifiedOrderRequest {

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     * 示例值：013467007045764fe
     * 非必填,String(32)
     */
    @Length(max = 32, message = "设备号device_info限32个字符")
    private String device_info = "WEB";

    /**
     * 商品描述交易字段格式根据不同的应用场景按照以下格式：
     * APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
     * 示例值： 腾讯充值中心-QQ会员充值
     * 必填，String(128)
     */
    @Length(max = 128, message = "商品描述body限128个字符")
    @NotNull(message = "商品描述不能为空")
    private String body;

    /**
     * <pre>
     *     商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”：@See <a href="https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_102&index=2"></a>
     *     非必填，String(8192)
     * </pre>
     *
     */
    @Length(max = 128, message = "商品详细描述detail限8192个字符")
    private String detail;

    /**
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     * 示例值：深圳分店
     * 非必填，String(127)
     */
    @Length(max = 127, message = "附加数据attach限127个字符")
    private String attach;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。
     */
    @Pattern(regexp = "[A-Za-z0-9\\_\\-\\|\\*]{1,32}", message = "商户订单号不合法")
    @Length(max = 32, message = "商户系统内部订单号out_trade_no限32个字符")
    @NotNull(message = "商户系统内部订单号不能为空")
    private String out_trade_no;

    /**
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @Length(max = 16, message = "货币类型fee_typeh限16个字符")
    private String fee_type = "CNY";

    /**
     * 订单总金额，单位为分
     */
    @NotNull(message = "订单总金额不能为空")
    private Integer total_fee;

    /**
     * 用户端实际ip
     */
    @Length(max = 16, message = "终端IP spbill_create_iph限16个字符")
    @NotNull(message = "终端IP不能为空")
    private String spbill_create_ip;

    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     */
    @Length(max = 16, message = "交易起始时间time_start限14个字符")
    private String time_start;

    /**
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，
     * 由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id
     * <p>
     * 建议：最短失效时间间隔大于1分钟
     */
    @Length(max = 16, message = "交易结束时间time_expire限14个字符")
    private String time_expire;

    /**
     * 订单优惠标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    @Length(max = 16, message = "订单优惠标记goods_tag限32个字符")
    private String goods_tag;

    /**
     * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     * 示例：http://www.weixin.qq.com/wxpay/pay.php
     */
    @Length(max = 256, message = "通知地址notify_url限256个字符")
//    @NotNull(message = "通知地址不能为空")
    private String notify_url;

    /**
     * 支付类型
     */
    @Length(max = 16, message = "支付类型trade_type限16个字符")
    @NotNull(message = "支付类型trade_type不能为空")
    private String trade_type = WxPayTradeTypeEnum.MWEB.name();

    /**
     * no_credit--指定不能使用信用卡支付
     */
    @Length(max = 32, message = "指定支付方式limit_pay限32个字符")
    private String limit_pay;

    /**
     * 该字段用于统一下单时上报场景信息，针对H5支付有以下三种场景,请根据对应场景上报,H5支付不建议在APP端使用，针对场景1，2请接入APP支付，不然可能会出现兼容性问题
     * <pre>
     *      1，IOS移动应用
     *        {"h5_info": //h5支付固定传"h5_info"
     *       {"type": "",  //场景类型
     *       "app_name": "",  //应用名
     *       "bundle_id": ""  //bundle_id
     *        }
     *        }
     *
     *       2，安卓移动应用
     *        {"h5_info": //h5支付固定传"h5_info"
     *       {"type": "",  //场景类型
     *        "app_name": "",  //应用名
     *        "package_name": ""  //包名
     *        }
     *       }
     *
     *       3，WAP网站应用
     *       {"h5_info": //h5支付固定传"h5_info"
     *       {"type": "",  //场景类型
     *        "wap_url": "",//WAP网站URL地址
     *        "wap_name": ""  //WAP 网站名
     *        }
     *       }
     * </pre>
     */
    @Length(max = 256, message = "场景信息scene_info限256个字符")
    private String scene_info;

    public H5UnifiedOrderRequest(String body, String attach, String out_trade_no, Integer total_fee, String spbill_create_ip) {
        this.body = body;
        this.attach = attach;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
    }

    public H5UnifiedOrderRequest(String body, String attach, String out_trade_no, Integer total_fee, String spbill_create_ip, String notify_url) {
        this.body = body;
        this.attach = attach;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.notify_url = notify_url;
    }
}
