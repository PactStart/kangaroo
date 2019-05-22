package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.RepayFeedbackResponse;

import java.util.Date;

/**
 * 还款或展期结果反馈请求
 */
public class RepayFeedbackRequest extends BaseRequest<RepayFeedbackResponse> {

    private RepayFeedbackRequest() {

    }

    /**
     * 还款成功
     *
     * @param order_no     还款账单所属的订单编号
     * @param period_nos   期数：1,2,3...all。all表示所有期。
     * @param repay_place  1：主动还款；2：机构方自动发起代扣 3：在融360主动申请展期
     * @param success_time 时间戳，秒。当还款成功时需要回传该字段
     * @param remark       成功时：返回还款具体的组成。
     * @return RepayFeedbackRequest实例
     */
    public static RepayFeedbackRequest success(String order_no, String period_nos, String repay_place, Date success_time, String remark) {
        RepayFeedbackRequest request = new RepayFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("period_nos", period_nos);
        request.putBizData("repay_place", repay_place);
        request.putBizData("repay_status", "1");
        request.putBizData("success_time", success_time.getTime() / 1000);
        request.putBizData("remark", remark);
        return request;
    }

    /**
     * 还款失败
     *
     * @param order_no    还款账单所属的订单编号
     * @param period_nos  期数：1,2,3...all。all表示所有期。
     * @param repay_place 1：主动还款；2：机构方自动发起代扣 3：在融360主动申请展期
     * @param remark      失败时：返回失败原因(如余额不足，卡不支持线上还款)
     * @return
     */
    public static RepayFeedbackRequest fail(String order_no, String period_nos, String repay_place, String remark) {
        RepayFeedbackRequest request = new RepayFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("period_nos", period_nos);
        request.putBizData("repay_place", repay_place);
        request.putBizData("repay_status", "1");
        request.putBizData("remark", remark);
        return request;
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.repayfeedback";
    }
}
