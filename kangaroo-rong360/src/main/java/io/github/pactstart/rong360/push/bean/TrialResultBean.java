package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrialResultBean {


    /**
     * serviceFee : 100.01
     * actual_amount : 900
     * repay_amount : 1000
     * goods_amount : 200
     * remark : 本金1000元，利息100元
     */

    private float serviceFee;
    private float actual_amount;
    private float repay_amount;
    private float goods_amount;
    private float vip_amount;
    private String remark;
}
