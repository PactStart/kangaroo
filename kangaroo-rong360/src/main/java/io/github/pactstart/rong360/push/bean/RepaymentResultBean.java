package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RepaymentResultBean {


    /**
     * repay_url : xxxxxxxxxxxxxxxxxxxxx
     * repay_status : 1
     */

    private String repay_url;

    private int repay_status;
}
