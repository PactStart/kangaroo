package io.github.pactstart.pay.wxpay.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundQueryRequest {

    /**
     * <pre>
     *     微信的订单号，微信订单号查询的优先级是： refund_id &gt; out_refund_no &gt; transaction_id &gt; out_trade_no
     * </pre>
     */
    private String transaction_id;

    /**
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    private String out_trade_no;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    private String out_refund_no;

    /**
     * 微信退款单号
     */
    private String refund_id;

    /**
     * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     */
    private Integer offset;

}
