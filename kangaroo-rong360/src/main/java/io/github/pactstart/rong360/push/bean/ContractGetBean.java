package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContractGetBean {


    /**
     * order_no : 245132241561415
     * user_id : 32857782
     * contract_return_url : xxxxxxx
     * contract_page : 2
     * contract_pos : 1
     */

    private String order_no;
    private int user_id;
    private String contract_return_url;
    private int contract_page;
    private int contract_pos;
}
