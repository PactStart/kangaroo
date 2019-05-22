package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RepaymentDetailBean {


    /**
     * amount : 1000.0
     * remark : 含本金477.83元，利息&手续费167.67元
     */

    private double amount;
    private String remark;
}
