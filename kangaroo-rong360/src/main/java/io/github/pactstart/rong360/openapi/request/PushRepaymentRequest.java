package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.PushRepaymentResponse;
import io.github.pactstart.rong360.openapi.vo.RepaymentPlan;

import java.util.Date;
import java.util.List;

/**
 * 还款计划推送请求
 */
public class PushRepaymentRequest extends BaseRequest<PushRepaymentResponse> {

    /**
     * @param order_no        查询账单的订单编号
     * @param open_bank       银行名称，还款银行名，中文名，不要传代码，会展示给用户
     * @param band_card       银行卡号，还款银行卡号
     * @param repayment_plan  还款计划
     * @param can_prepay      是否支持提前全部结清	，仅多期产品需回传，1=支持；0=不支持。
     * @param can_prepay_time 可提前全部结清的开始时间 can_prepay为1是需回传
     */
    public PushRepaymentRequest(String order_no, String open_bank, String band_card, List<RepaymentPlan> repayment_plan, int can_prepay, Date can_prepay_time) {
        this.putBizData("order_no", order_no);
        this.putBizData("open_bank", open_bank);
        this.putBizData("band_card", band_card);
        this.putBizData("repayment_plan", repayment_plan);
        this.putBizData("can_prepay", can_prepay);
        if (can_prepay == 1) {
            this.putBizData("can_prepay_time", can_prepay_time.getTime() / 1000);
        }
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.pushrepayment";
    }
}
