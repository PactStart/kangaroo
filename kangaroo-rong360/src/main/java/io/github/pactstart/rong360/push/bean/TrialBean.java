package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TrialBean {


    /**
     * order_no : 245132241561415
     * amount : 1000.00
     * peroid : 10
     * term_unit : 1
     */

    private String order_no;
    private String amount;
    private int peroid;
    private int term_unit;
}
