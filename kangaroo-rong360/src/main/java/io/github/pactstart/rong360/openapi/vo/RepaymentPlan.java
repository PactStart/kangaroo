package io.github.pactstart.rong360.openapi.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RepaymentPlan {

    /**
     * 具体的第几期
     */
    private int period_no;

    /**
     * 到期时间
     */
    private Date due_time;

    /**
     * 应该还的金额
     * 1. 逾期后，需要加入逾期费用
     * 2.注意：当该期完成还款后，该金额与之前保持一致，不要传0
     */
    private float amount;

    /**
     * 当机构有部分扣款的时候，必传。已经还成功的金额，amount-paid_amount计算出待还金额
     */
    private float paid_amount;

    /**
     * 账单状态
     * 1未到期；2已还款；3逾期
     */
    private int bill_status;

    /**
     * 支持的还款方式类型
     * 机构当前支持的还款方式，1=主动还款；2=跳转H5；4=银行代扣；8=跳转支付宝还款  除了3,7,11,15外，支持以上数字的其他组合，例如：5=1+4同时支持主动还款和银行代扣; 6=2+4同时支持跳转H5和银行代扣;
     */
    private int pay_type;

    /**
     * 还款成功时间
     * 当账单状态bill_status为2时必传
     */
    private Date success_time;

    /**
     * 当期最早可以还款的时间
     */
    private Date can_repay_time;

    /**
     * 当期还款金额的相关描述,需可读。
     * 例如：含本金473.10元，利息&手续费172.40元，初审费15.00元，逾期费20.00元
     */
    private String remark;

    /**
     * 支持展期时传递，必须传1。否则传0或不传
     */
    private int is_able_defer;

    public RepaymentPlan(int period_no, Date due_time, float amount, float paid_amount, int bill_status, int pay_type, Date success_time, Date can_repay_time, String remark, int is_able_defer) {
        this.period_no = period_no;
        this.due_time = due_time;
        this.amount = amount;
        this.paid_amount = paid_amount;
        this.bill_status = bill_status;
        this.pay_type = pay_type;
        this.success_time = success_time;
        this.can_repay_time = can_repay_time;
        this.remark = remark;
        this.is_able_defer = is_able_defer;
    }
}
