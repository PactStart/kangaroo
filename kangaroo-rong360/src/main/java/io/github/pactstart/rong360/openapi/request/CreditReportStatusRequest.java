package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.CreditReportStatusResponse;

/**
 * 征信查询状态反馈请求
 */
public class CreditReportStatusRequest extends BaseRequest<CreditReportStatusResponse> {

    /**
     * 构造征信查询状态反馈请求
     *
     * @param order_no      订单编号
     * @param report_status 征信查询状态：1：征信查询中；2：征信查询成功；3.征信查询失败
     * @param reason        失败原因	 中文可读
     */
    public CreditReportStatusRequest(String order_no, String report_status, String reason) {
        this.putBizData("order_no", order_no);
        this.putBizData("report_status", report_status);
        this.putBizData("reason", reason);
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.creditreportstatus";
    }
}
