package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ApproveConfirmBean {


    /**
     * order_no : 245132241561415
     * loan_amount : 1000
     * loan_term : 15
     * term_unit : 1
     * goods_info : [{"tjy_order_no":"245132241561415","sku_id":"180111111","buynum":"1","address":"北京市海淀区丹棱街互联网金融中心","name":"张三","mobile":"158111111111","note":"","chargeaccount":"","sale_price":23}]
     * all_goods_info : [{"tjy_order_no":"245132241561415","sku_id":"180111111","buynum":"1","address":"北京市海淀区丹棱街互联网金融中心","name":"张三","mobile":"158111111111","note":"","chargeaccount":"","sale_price":23},{"tjy_order_no":"245132241561415","sku_id":"180111111","buynum":"1","address":"北京市海淀区丹棱街互联网金融中心","name":"张三","mobile":"158111111111","note":"","chargeaccount":"","sale_price":"23.00"}]
     */

    private String order_no;
    private String loan_amount;
    private int loan_term;
    private int term_unit;
    private List<GoodsInfoBean> goods_info;
    private List<AllGoodsInfoBean> all_goods_info;

    @NoArgsConstructor
    @Data
    public static class GoodsInfoBean {
        /**
         * tjy_order_no : 245132241561415
         * sku_id : 180111111
         * buynum : 1
         * address : 北京市海淀区丹棱街互联网金融中心
         * name : 张三
         * mobile : 158111111111
         * note :
         * chargeaccount :
         * sale_price : 23
         */

        private String tjy_order_no;
        private String sku_id;
        private String buynum;
        private String address;
        private String name;
        private String mobile;
        private String note;
        private String chargeaccount;
        private float sale_price;
    }

    @NoArgsConstructor
    @Data
    public static class AllGoodsInfoBean {
        /**
         * tjy_order_no : 245132241561415
         * sku_id : 180111111
         * buynum : 1
         * address : 北京市海淀区丹棱街互联网金融中心
         * name : 张三
         * mobile : 158111111111
         * note :
         * chargeaccount :
         * sale_price : 23
         */

        private String tjy_order_no;
        private String sku_id;
        private String buynum;
        private String address;
        private String name;
        private String mobile;
        private String note;
        private String chargeaccount;
        private float sale_price;
    }
}
