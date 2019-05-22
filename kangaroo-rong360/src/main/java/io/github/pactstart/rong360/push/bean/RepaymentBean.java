package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RepaymentBean {


    /**
     * order_no : 245132241561415
     * period_nos : 1
     * repay_type : 8
     * device_type : ios
     * repay_return_url : xxxxxxxxxxxxxxxxxxx
     */

    private String order_no;
    private String period_nos;
    private int repay_type;
    private String device_type;
    private String repay_return_url;
}
