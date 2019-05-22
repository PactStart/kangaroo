package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreditQueryBean {


    /**
     * order_no : 245132241561415
     * credit_return_url : https://m.rong360.com/center
     */

    private String order_no;
    private String credit_return_url;
}
