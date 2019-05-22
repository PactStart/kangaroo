package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.ContractStatusFeedbackResponse;

/**
 * 合同状态反馈请求
 */
public class ContractStatusFeedbackRequest extends BaseRequest<ContractStatusFeedbackResponse> {

    private ContractStatusFeedbackRequest() {

    }

    /**
     * 合同签订成功
     *
     * @param order_no 订单号
     * @return 合同状态反馈请求
     */
    public static ContractStatusFeedbackRequest success(String order_no) {
        ContractStatusFeedbackRequest request = new ContractStatusFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("contract_status", 1);
        return request;
    }

    /**
     * 合同签订失败
     *
     * @param order_no 订单号
     * @param reason   失败原因
     * @return 合同状态反馈请求
     */
    public ContractStatusFeedbackRequest fail(String order_no, String reason) {
        ContractStatusFeedbackRequest request = new ContractStatusFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("contract_status", 2);
        request.putBizData("reason", reason);
        return request;
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.contractstatus";
    }
}
