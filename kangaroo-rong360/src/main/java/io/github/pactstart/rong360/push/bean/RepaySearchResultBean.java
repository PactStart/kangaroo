package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RepaySearchResultBean {


    /**
     * Is_pay_offline : 1
     * Paytype_offline : [1,2,3]
     * Pay_offline_amount : 1000
     * Alipay_acount : {"alipay_account":"18611111111","alipay_name":"张三"}
     * WeChat_acount : {"wechat_account":"Hello"}
     * Bankcard : {"bankcard_account":"6217000011111111111","bankcard_name":"赵找找","bankcard_deposit":"建设银行","bankcard_house":"海淀"}
     * Pay_offline_note : ["user_name","user_mobile","id_number","order_id"]
     */

    private int Is_pay_offline;
    private float Pay_offline_amount;
    private AlipayAcountBean Alipay_acount;
    private WeChatAcountBean WeChat_acount;
    private BankcardBean Bankcard;
    private List<Integer> Paytype_offline;
    private List<String> Pay_offline_note;

    @NoArgsConstructor
    @Data
    public static class AlipayAcountBean {
        /**
         * alipay_account : 18611111111
         * alipay_name : 张三
         */

        private String alipay_account;
        private String alipay_name;
    }

    @NoArgsConstructor
    @Data
    public static class WeChatAcountBean {
        /**
         * wechat_account : Hello
         */

        private String wechat_account;
    }

    @NoArgsConstructor
    @Data
    public static class BankcardBean {
        /**
         * bankcard_account : 6217000011111111111
         * bankcard_name : 赵找找
         * bankcard_deposit : 建设银行
         * bankcard_house : 海淀
         */

        private String bankcard_account;
        private String bankcard_name;
        private String bankcard_deposit;
        private String bankcard_house;
    }
}
