package io.github.pactstart.pay.wxpay.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderRefund {

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
     * 退款渠道
     * ORIGINAL—原路退款
     * BALANCE—退回到余额
     * OTHER_BALANCE—原账户异常退到其他余额账户
     * OTHER_BANKCARD—原银行卡异常退到其他银行卡
     */
    private String refund_channel;

    /**
     * 申请退款金额
     * 退款总金额,单位为分,可以做部分退款
     */
    private Integer refund_fee;

    /**
     * 退款金额
     * 退款金额=申请退款金额-非充值代金券退款金额，退款金额&lt;=申请退款金额
     */
    private Integer settlement_refund_fee;

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

    /**
     * 退款状态：
     * SUCCESS—退款成功
     * REFUNDCLOSE—退款关闭
     * PROCESSING—退款处理中
     * CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
     * 必填，String(16)
     */
    private String refund_status;

    /**
     * 退款资金来源
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     * 非必填，String(30)
     */
    private String refund_account;

    /**
     * 退款入账账户
     * 取当前退款单的退款入账方
     * 1）退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱: 支付用户零钱
     * 3）退还商户: 商户基本账户 商户结算银行账户
     * 4）退回支付用户零钱通:支付用户零钱通
     */
    private String refund_recv_accout;

    /**
     * 退款成功时间，当退款状态为退款成功时有返回
     * 示例：2016-07-25 15:26:26
     * 非必填，String(20)
     */
    private String refund_success_time;

    public static List<OrderRefund> parse(Map<String, String> responseParamMap) {
        List<OrderRefund> orderRefundList = Lists.newArrayList();
        if (responseParamMap.get("refund_count") != null) {
            int refund_count = Integer.valueOf(responseParamMap.get("refund_count"));
            for (int i = 0; i < refund_count; i++) {
                OrderRefund orderRefund = new OrderRefund();
                orderRefund.setOut_refund_no(responseParamMap.get("out_refund_no_" + i));
                orderRefund.setRefund_id(responseParamMap.get("refund_id_" + i));
                if (responseParamMap.containsKey("refund_channel_" + i)) {
                    orderRefund.setRefund_channel(responseParamMap.get("refund_channel_" + i));
                }
                orderRefund.setRefund_fee(Integer.valueOf(responseParamMap.get("refund_fee_" + i)));
                if (responseParamMap.containsKey("settlement_refund_fee" + i)) {
                    orderRefund.setSettlement_refund_fee(Integer.valueOf(responseParamMap.get("settlement_refund_fee" + i)));
                }
                if (responseParamMap.containsKey("coupon_refund_count_" + i)) {
                    int coupon_refund_count = Integer.valueOf(responseParamMap.get("coupon_refund_count_" + i));
                    orderRefund.setCoupon_refund_count(coupon_refund_count);
                    List<CouponRefund> couponRefundList = Lists.newArrayList();
                    for (int j = 0; j < coupon_refund_count; j++) {
                        CouponRefund couponRefund = new CouponRefund();
                        couponRefund.setCoupon_refund_id(responseParamMap.get("coupon_refund_id_" + i + "_" + j));
                        couponRefund.setCoupon_type(responseParamMap.get("coupon_type_" + i + "_" + j));
                        couponRefund.setCoupon_refund_fee(Integer.valueOf(responseParamMap.get("coupon_refund_fee_" + i + "_" + j)));
                        couponRefundList.add(couponRefund);
                    }
                    orderRefund.setCoupon_refund_fee(Integer.valueOf(responseParamMap.get("coupon_refund_fee_" + i)));
                    orderRefund.setCouponRefundList(couponRefundList);
                }
                orderRefund.setRefund_status(responseParamMap.get("refund_status_" + i));
                orderRefund.setRefund_account(responseParamMap.get("refund_account_" + i));
                orderRefund.setRefund_recv_accout(responseParamMap.get("refund_recv_accout_" + i));
                orderRefund.setRefund_success_time(responseParamMap.get("refund_success_time_" + i));
                orderRefundList.add(orderRefund);
            }
        }
        return orderRefundList;
    }
}
