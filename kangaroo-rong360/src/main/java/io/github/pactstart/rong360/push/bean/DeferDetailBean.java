package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DeferDetailBean {


    /**
     * order_no : 247235959089974
     * defer_option : [{"after_defer_amount":130.9,"defer_due_time":1484063999,"defer_day":7,"remark":"本金100元，管理费10.4元，利息10.4元，延期手续费10.1元"},{"after_defer_amount":140.9,"defer_due_time":1484668799,"defer_day":14,"remark":"本金100元，管理费10.4元，利息20.4元，延期手续费20.1元"}]
     * defer_amount_option : [{"defer_day":7,"defer_amount":30.9,"remark":"管理费10.4元，利息10.4元，延期手续费10.1元"},{"defer_day":14,"defer_amount":50.9,"remark":"管理费10.4元，利息20.4元，延期手续费20.1元"}]
     * defer_amount_type : 1
     */

    private String order_no;
    private int defer_amount_type;
    private List<DeferOptionBean> defer_option;
    private List<DeferAmountOptionBean> defer_amount_option;

    @NoArgsConstructor
    @Data
    public static class DeferOptionBean {
        /**
         * after_defer_amount : 130.9
         * defer_due_time : 1484063999
         * defer_day : 7
         * remark : 本金100元，管理费10.4元，利息10.4元，延期手续费10.1元
         */

        private float after_defer_amount;
        private int defer_due_time;
        private int defer_day;
        private String remark;
    }

    @NoArgsConstructor
    @Data
    public static class DeferAmountOptionBean {
        /**
         * defer_day : 7
         * defer_amount : 30.9
         * remark : 管理费10.4元，利息10.4元，延期手续费10.1元
         */

        private int defer_day;
        private float defer_amount;
        private String remark;
    }
}
