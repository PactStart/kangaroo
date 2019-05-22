package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class BandCardListBean {


    /**
     * order_no :
     * bank_card_list : [{"open_bank":"ICBC","bank_card":"6212262308004359191","extra_info":{"cardId":"12345"},"is_repay_card":1},{"open_bank":"ABC","bank_card":"6212262308004359192","card_type":2,"is_repay_card":0}]
     */

    private String order_no;
    private List<BankCardBean> bank_card_list;

    @NoArgsConstructor
    @Data
    public static class BankCardBean {
        /**
         * open_bank : ICBC
         * bank_card : 6212262308004359191
         * extra_info : {"cardId":"12345"}
         * is_repay_card : 1
         * card_type : 2
         */

        private String open_bank;
        private String bank_card;
        private Map<String, String> extra_info;
        private int is_repay_card;
        private int card_type;

    }
}
