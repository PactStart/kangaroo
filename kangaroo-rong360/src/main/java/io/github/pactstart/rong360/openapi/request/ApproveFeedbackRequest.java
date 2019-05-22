package io.github.pactstart.rong360.openapi.request;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.rong360.openapi.response.ApproveFeedbackResponse;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 审批结论反馈请求
 */
public class ApproveFeedbackRequest extends BaseRequest<ApproveFeedbackResponse> {

    private ApproveFeedbackRequest() {

    }

    /**
     * 审批不通过
     *
     * @param order_no    反馈订单的订单编号
     * @param remark      备注（例如：信用评分过低##拒绝客户，如果没备注，信用评分过低##）
     * @param refuse_time 审批拒绝时间
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newRefuse(String order_no, String remark, Date refuse_time) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 40);
        request.putBizData("refuse_time", refuse_time.getTime() / 1000);
        request.putBizData("remark", remark);
        return request;
    }

    /**
     * 审批需重填材料参数
     * <pre>
     *     	supplements字段key说明:仅限于补充信息推送接口推送的用户填写项（抓取项除外）抓取项：contacts，is_simulator，device_info等
     *     	value(string类型)说明：枚举指['C01','C02','C03'].
     *     	C01:资料项为空（融360未传）.
     *     	C02:身份证图片模糊／姿势不对／超过有效期.
     *     	C03:信息不完整／不规范（如邮箱格式不对，地址不详细）
     *     	示例：
     *     	<code>
     *     	     "supplements":{
     *       	     "user_marriage":"C01",
     *      	     "ID_Positive":"C02",
     *         	     "company_addr_detail":"C03"
     *             }
     *     	</code>
     * </pre>
     * 当补充信息推送接口推送的数据有问题时，如需要用户重新填写部分资料，可使用本项
     *
     * @param order_no    反馈订单的订单编号
     * @param supplements 需重填的资料项
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSupplements(String order_no, Map<String, String> supplements) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 30);
        request.putBizData("supplements", supplements);
        return request;
    }

    /**
     * 1) 审批通过，单期-固定金额-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param approval_amount 审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param approval_term   审批天（月）数-固定
     * @param pay_amount      总还款额	1. 用户的总还款额（包括本金利息管理费手续费等一切费用）；2. 保留小数点后4位；
     * @param remark          总还款额组成说明	说明机构的总还款金额组成，金额加起来为总还款额。例如：本金：100元，利息：300元，其他手续费：10元。
     * @param receive_amount  总到账金额,1. 实际打款到银行卡的金额；2. 保留小数点后4位，单位元；
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermFixedAmountFixedTerm(String order_no, Date approval_time, float approval_amount, int approval_term, float pay_amount, String remark, float receive_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("pay_amount", pay_amount);
        request.putBizData("remark", remark);
        request.putBizData("receive_amount", receive_amount);
        return request;
    }

    /**
     * 1) 审批通过，单期-固定金额-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param approval_amount 审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param approval_term   审批天（月）数-固定
     * @param pay_amount      总还款额   1. 用户的总还款额（包括本金利息管理费手续费等一切费用）；2. 保留小数点后4位；
     * @param remark          总还款额组成说明	说明机构的总还款金额组成，金额加起来为总还款额。例如：本金：100元，利息：300元，其他手续费：10元。
     * @param receive_amount  总到账金额,1. 实际打款到银行卡的金额；2. 保留小数点后4位，单位元；
     * @param is_vip          是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount 会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermFixedAmountFixedTerm(String order_no, Date approval_time, float approval_amount, int approval_term, float pay_amount, String remark, float receive_amount, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("pay_amount", pay_amount);
        request.putBizData("remark", remark);
        request.putBizData("receive_amount", receive_amount);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 2) 单期-固定金额-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param approval_amount  审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param loan_term_option 审批天数-可选
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermFixedAmountOptionalTerm(String order_no, Date approval_time, float approval_amount, Set<Integer> loan_term_option) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", JSON.toJSONString(loan_term_option));
        return request;
    }

    /**
     * 3) 单期-金额范围-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param max_loan_amount 审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount    金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param approval_term   审批天（月）数-固定
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermRangeAmountFixedTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, int approval_term) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        return request;
    }

    /**
     * 3) 单期-金额范围-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param max_loan_amount 审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount    金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param approval_term   审批天（月）数-固定
     * @param is_vip          是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount 会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermRangeAmountFixedTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, int approval_term, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 4） 单期-金额范围-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param max_loan_amount  审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount  1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount     金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param loan_term_option 审批天数-可选 此字段代表审批天数；string需要按照如"[1,2,3]"格式返回
     * @param is_vip           是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount  会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newSingleTermRangeAmountOptionalTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, Set<Integer> loan_term_option, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", loan_term_option);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 5） 审批通过，多期-固定金额-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param approval_amount 审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param approval_term   审批天（月）数-固定
     * @param pay_amount      总还款额	1. 用户的总还款额（包括本金利息管理费手续费等一切费用）；2. 保留小数点后4位；
     * @param remark          总还款额组成说明	说明机构的总还款金额组成，金额加起来为总还款额。例如：本金：100元，利息：300元，其他手续费：10元。
     * @param receive_amount  总到账金额,1. 实际打款到银行卡的金额；2. 保留小数点后4位，单位元；
     * @param period_amount   每期应还金额/首期应还金额	1. 保留小数点后4位；2. 若多期账单在还款时某期（如首期）需要额外付一些手续费，则此费用不计算在每期应还金额中；3.对于等额本金的方式，该字段为首期应还金额。
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermFixedAmountFixedTerm(String order_no, Date approval_time, float approval_amount, int approval_term, float pay_amount, String remark, float receive_amount, float period_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("pay_amount", pay_amount);
        request.putBizData("remark", remark);
        request.putBizData("receive_amount", receive_amount);
        request.putBizData("period_amount", period_amount);
        return request;
    }

    /**
     * 6）审批通过，多期-固定金额-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param approval_amount  审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param loan_term_option 审批月数-范围	 此字段代表审批月数；string需要按照如"[1,2,3]"格式返回
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermFixedAmountOptionalTerm(String order_no, Date approval_time, float approval_amount, Set<Integer> loan_term_option) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", JSON.toJSONString(loan_term_option));
        return request;
    }

    /**
     * 6）审批通过，多期-固定金额-固定期限
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param approval_amount  审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param loan_term_option 审批月数-范围	 此字段代表审批月数；string需要按照如"[1,2,3]"格式返回
     * @param is_vip           是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount  会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermFixedAmountOptionalTerm(String order_no, Date approval_time, float approval_amount, Set<Integer> loan_term_option, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", JSON.toJSONString(loan_term_option));
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 7) 多期-金额范围-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param max_loan_amount 审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount    金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param approval_term   审批天（月）数-固定
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermRangeAmountFixedTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, int approval_term) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        return request;
    }

    /**
     * 7) 多期-金额范围-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param max_loan_amount 审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount    金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param approval_term   审批天（月）数-固定
     * @param is_vip          是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount 会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermRangeAmountFixedTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, int approval_term, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 8） 多期-金额范围-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param max_loan_amount  审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount  1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount     金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param loan_term_option 审批天数-可选 此字段代表审批天数；string需要按照如"[1,2,3]"格式返回
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermRangeAmountOptionalTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, Set<Integer> loan_term_option) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", loan_term_option);
        return request;
    }

    /**
     * 8） 多期-金额范围-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param max_loan_amount  审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount  1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount     金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param loan_term_option 审批天数-可选 此字段代表审批天数；string需要按照如"[1,2,3]"格式返回
     * @param is_vip           是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount  会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public static ApproveFeedbackRequest newMultipleTermRangeAmountOptionalTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, Set<Integer> loan_term_option, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", loan_term_option);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 2) 单期-固定金额-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param approval_amount  审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param loan_term_option 审批天数-可选
     * @param is_vip           是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount  会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public ApproveFeedbackRequest newSingleTermFixedAmountOptionalTerm(String order_no, Date approval_time, float approval_amount, Set<Integer> loan_term_option, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", JSON.toJSONString(loan_term_option));
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    /**
     * 4） 单期-金额范围-期限范围
     *
     * @param order_no         反馈订单的订单编号
     * @param approval_time    审批通过时间
     * @param max_loan_amount  审批金额最大值 1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param min_loan_amount  1. 此字段在amount_type=1（金额范围）返回； 2. 保留小数点后4位,单位元；
     * @param range_amount     金额变更粒度	此字段在amount_type=1（金额范围）返回，代表在最大审批金额和最小审批金额间的最小变更金额； 例如，审批金额最大值为200，审批金额最小值为100，金额变更粒度为50，则表示审批范围值为：100,150,200。
     * @param loan_term_option 审批天数-可选 此字段代表审批天数；string需要按照如"[1,2,3]"格式返回
     * @return ApproveFeedbackRequest实例
     */
    public ApproveFeedbackRequest newSingleTermRangeAmountOptionalTerm(String order_no, Date approval_time, float max_loan_amount, float min_loan_amount, float range_amount, Set<Integer> loan_term_option) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 1);
        request.putBizData("max_loan_amount", max_loan_amount);
        request.putBizData("min_loan_amount", min_loan_amount);
        request.putBizData("range_amount", range_amount);
        request.putBizData("term_unit", 1);
        request.putBizData("term_type", 1);
        request.putBizData("loan_term_option", loan_term_option);
        return request;
    }

    /**
     * 5）审批通过，多期-固定金额-固定期限
     *
     * @param order_no        反馈订单的订单编号
     * @param approval_time   审批通过时间
     * @param approval_amount 审批金额	1. 即审批本金，参与各种利息管理费手续费等各项费用计算的金额，而非用户拿到钱的金额； 2. 保留小数点后4位,单位元；
     * @param approval_term   审批天（月）数-固定
     * @param pay_amount      总还款额	1. 用户的总还款额（包括本金利息管理费手续费等一切费用）；2. 保留小数点后4位；
     * @param remark          总还款额组成说明	说明机构的总还款金额组成，金额加起来为总还款额。例如：本金：100元，利息：300元，其他手续费：10元。
     * @param receive_amount  总到账金额,1. 实际打款到银行卡的金额；2. 保留小数点后4位，单位元；
     * @param period_amount   每期应还金额/首期应还金额	1. 保留小数点后4位；2. 若多期账单在还款时某期（如首期）需要额外付一些手续费，则此费用不计算在每期应还金额中；3.对于等额本金的方式，该字段为首期应还金额。
     * @param is_vip          是否需要缴纳会员费	1需要缴纳或扣除会员费等,0不需要缴纳或扣除会员费等，默认为0。
     * @param recharge_amount 会员等模式扣费金额     会员等模式需要用户缴纳或者扣除用户的金额
     * @return ApproveFeedbackRequest实例
     */
    public ApproveFeedbackRequest newMultipleTermFixedAmountFixedTerm(String order_no, Date approval_time, float approval_amount, int approval_term, float pay_amount, String remark, float receive_amount, float period_amount, int is_vip, int recharge_amount) {
        ApproveFeedbackRequest request = new ApproveFeedbackRequest();
        request.putBizData("order_no", order_no);
        request.putBizData("conclusion", 10);
        request.putBizData("approval_time", approval_time.getTime() / 1000);
        request.putBizData("amount_type", 0);
        request.putBizData("approval_amount", approval_amount);
        request.putBizData("term_unit", 2);
        request.putBizData("term_type", 0);
        request.putBizData("approval_term", approval_term);
        request.putBizData("pay_amount", pay_amount);
        request.putBizData("remark", remark);
        request.putBizData("receive_amount", receive_amount);
        request.putBizData("period_amount", period_amount);
        request.putBizData("is_vip", is_vip);
        request.putBizData("recharge_amount", recharge_amount);
        return request;
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.approvefeedback";
    }
}
