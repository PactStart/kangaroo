package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.BindCardFeedbackResponse;

/**
 * 绑卡反馈请求
 */
public class BindCardFeedbackRequest extends BaseRequest<BindCardFeedbackResponse> {

    /**
     * 绑卡成功
     *
     * @param order_no 订单编号，必填
     */
    public BindCardFeedbackRequest(String order_no) {
        this.putBizData("order_no", order_no);
        this.putBizData("bind_status", 1);
        this.putBizData("reason", "");
    }

    /**
     * 绑卡失败
     *
     * @param order_no 订单编号，必填
     * @param reason   失败原因，必填
     */
    public BindCardFeedbackRequest(String order_no, String reason) {
        this.putBizData("order_no", order_no);
        this.putBizData("bind_status", 2);
        this.putBizData("reason", reason);
    }

    /**
     * 设置绑卡的卡类型，只有机构需要绑定信用卡的时候回传
     *
     * @param bind_card_type 绑卡的卡类型，0：储蓄卡，1：信用卡
     */
    public void setBind_card_type(int bind_card_type) {
        this.putBizData("bind_card_type", bind_card_type);
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.bindcardfeedback";
    }

}
