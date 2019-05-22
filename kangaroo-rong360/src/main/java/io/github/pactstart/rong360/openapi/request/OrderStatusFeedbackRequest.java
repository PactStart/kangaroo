package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.enums.Rong360OrderStatus;
import io.github.pactstart.rong360.openapi.response.OrderStatusFeedbackResponse;

import java.util.Date;

/**
 * 订单状态反馈请求
 */
public class OrderStatusFeedbackRequest extends BaseRequest<OrderStatusFeedbackResponse> {

    /**
     * 实例化订单状态
     *
     * @param order_no     订单号
     * @param order_status 订单状态
     * @param update_time  订单变更时间
     */
    public OrderStatusFeedbackRequest(String order_no, Rong360OrderStatus order_status, Date update_time) {
        this.putBizData("order_no", order_no);
        this.putBizData("order_status", order_status.getValue());
        this.putBizData("update_time", update_time.getTime() / 1000);
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.orderfeedback";
    }
}
