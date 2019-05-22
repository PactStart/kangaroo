package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BandCardBindBean {


    /**
     * order_no : 246964109149933
     * bank_card : 6222022005001212723
     * open_bank : ICBC
     * user_name : 张三
     * id_number : 110108198802019650
     * user_mobile : 13420504517
     * bank_address : 北京市 市辖区
     * return_url : https://m.rong360.com/center
     * bankCardType : 0
     * bind_card_src : 1
     */

    private String order_no;
    private String bank_card;
    private String open_bank;
    private String user_name;
    private String id_number;
    private String user_mobile;
    private String bank_address;
    private String return_url;
    private int bankCardType;
    private int bind_card_src;
}
