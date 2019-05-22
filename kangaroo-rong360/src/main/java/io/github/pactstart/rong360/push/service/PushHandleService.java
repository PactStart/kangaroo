package io.github.pactstart.rong360.push.service;

import io.github.pactstart.rong360.push.bean.*;
import io.github.pactstart.rong360.push.dto.ResultDto;

import java.util.Map;

public interface PushHandleService {

    /**
     * 处理订单基本信息推送
     *
     * @param orderBean 订单基本信息
     * @return 处理结果
     * @See <a href="https://taojinyundev.rong360.com/_book/order_detail_info.html"></a>
     */
    ResultDto handleOrderBaseInfoPush(OrderBean orderBean);

    /**
     * 处理补充信息推送
     *
     * @param orderSupplyBean 订单补充信息
     * @return 处理结果
     * @See <a href="https://taojinyundev.rong360.com/_book/append_info.html"></a>
     */
    ResultDto handleOrderSupplyInfoPush(OrderSupplyBean orderSupplyBean);

    /**
     * 获取用户已绑定的银行卡
     *
     * @param orderNoBean 订单号
     * @return 银行卡列表
     * @See <a href="https://taojinyundev.rong360.com/_book/bank_card_list.html"></a>
     */
    ResultDto<BandCardListBean> handleGetUserBandCardList(OrderNoBean orderNoBean);

    /**
     * 处理绑定银行卡
     *
     * @param bandCardBindBean
     * @return 绑卡结果
     * @See <a href="https://taojinyundev.rong360.com/_book/bind_card.html".></a>
     */
    ResultDto<BindCardBindResultBean> bindBandCard(BandCardBindBean bandCardBindBean);

    /**
     * 获取订单审批结论
     * <p>
     * 调用{@link io.github.pactstart.rong360.openapi.request.ApproveFeedbackRequest}的静态实例化接口获取ApproveFeedbackRequest实例，调用getBizDataMap()方法获取审批结果，将其设置到ResultDto实例中返回
     * </p>
     *
     * @param orderNoBean 订单号
     * @return {@link io.github.pactstart.rong360.openapi.request.ApproveFeedbackRequest}
     * @See <a href="https://taojinyundev.rong360.com/_book/pull_order_approve.html"></a>
     */
    ResultDto<Map<String, Object>> getOrderApproveResult(OrderNoBean orderNoBean);

    /**
     * 处理审批确认
     * <p>用户确认贷款时融360推送</p>
     *
     * @param approveConfirmBean 审批确认通知
     * @return 审批确认处理结果
     * @See <a href="https://taojinyundev.rong360.com/_book/comfirm_approve.html"></a>
     */
    ResultDto<ApproveConfirmResultBean> handleApproveConfirm(ApproveConfirmBean approveConfirmBean);

    /**
     * 校验审批确认验证码
     * <p>用户确认贷款时融360推送</p>
     *
     * @param approveConfirmYzmBean 验证码
     * @return 验证码校验结果
     * @See <a href="https://taojinyundev.rong360.com/_book/comfirm_approve.html"></a>
     */
    ResultDto<ApproveConfirmYzmResultBean> handleApproveConfirmYzm(ApproveConfirmYzmBean approveConfirmYzmBean);

    /**
     * 获取合同URL
     *
     * @param contractGetBean 订单信息
     * @return 合同地址
     * @See <a href="https://taojinyundev.rong360.com/_book/contract.html"></a>
     */
    ResultDto<ContractGetResultBean> handleGetContract(ContractGetBean contractGetBean);

    /**
     * 获取还款计划
     * <p>
     * 调用{@link io.github.pactstart.rong360.openapi.request.RepayFeedbackRequest}的静态实例化方法获取RepayFeedbackRequest实例，调用getBizDataMap()方法获取还款计划，将其设置到ResultDto实例中返回
     * </p>
     *
     * @param orderNoBean 订单号
     * @return {@link io.github.pactstart.rong360.openapi.request.RepayFeedbackRequest}
     * @See <a href="https://taojinyundev.rong360.com/_book/pull_order_approve.html"></a>
     */
    ResultDto<Map<String, Object>> getRepaymentPlan(OrderNoBean orderNoBean);

    /**
     * 拉取订单状态
     * <p>
     * 构造{@link io.github.pactstart.rong360.openapi.request.OrderStatusFeedbackRequest}实例，调用getBizDataMap()方法获取订单状态，将其设置到ResultDto实例中返回
     * </p>
     *
     * @param orderNoBean 订单号
     * @return 订单状态
     * @See <a href="https://taojinyundev.rong360.com/_book/pull_order_status.html"></a>
     */
    ResultDto<Map<String, Object>> getOrderStatus(OrderNoBean orderNoBean);

    /**
     * 处理主动还款
     *
     * @param repaymentBean 还款信息
     * @return
     * @See <a href="https://taojinyundev.rong360.com/_book/active_repayment.html"></a>
     */
    ResultDto<RepaymentResultBean> handleRepayment(RepaymentBean repaymentBean);

    /**
     * 校验还款验证码
     *
     * @param repaymentVerifyCodeBean 还款信息
     * @return
     * @See <a href="https://taojinyundev.rong360.com/_book/active_repayment.html"></a>
     */
    ResultDto<RepaymentCodeVerifyResultBean> handleRepaymentVerifyCode(RepaymentVerifyCodeBean repaymentVerifyCodeBean);

    /**
     * 获取还款详情
     *
     * @param repaymentPeriodBean 还款期数
     * @return 还款详情
     * @See <a href="https://taojinyundev.rong360.com/_book/repay_detail.html"></a>
     */
    ResultDto<RepaymentDetailBean> getRepaymentDetail(RepaymentPeriodBean repaymentPeriodBean);

    /**
     * 获取展期详情
     *
     * @param orderNoBean 订单号
     * @return 展期数据
     * @See <a href="https://taojinyundev.rong360.com/_book/defer.html"></a>
     */
    ResultDto<DeferDetailBean> getDeferDetail(OrderNoBean orderNoBean);

    /**
     * 执行展期
     *
     * @param deferBean 展期信息
     * @return 执行展期结果
     * @See <a href="https://taojinyundev.rong360.com/_book/defer.html"></a>
     */
    ResultDto handleDefer(DeferBean deferBean);

    /**
     * 试算
     *
     * @param trialBean
     * @return 试算结果
     * @See <a href="https://taojinyundev.rong360.com/_book/trial.html"></a>
     */
    ResultDto<TrialResultBean> handleTrial(TrialBean trialBean);

    /**
     * 处理二次活体信息推送
     *
     * @param secondAssayBean
     * @return 处理结果
     * @See <a href="https://taojinyundev.rong360.com/_book/second_assay.html"></a>
     */
    ResultDto handleSecondAssay(SecondAssayBean secondAssayBean);

    /**
     * 线下还款查询
     *
     * @param repaymentPeriodBean 还款期数
     * @return 还款方式
     * @See <a href="https://taojinyundev.rong360.com/_book/repay_search.html"></a>
     */
    ResultDto<RepaySearchResultBean> handleRepaySearch(RepaymentPeriodBean repaymentPeriodBean);

    /**
     * 处理开户
     *
     * @param openAccountBean 订单号一级融360回跳地址
     * @return 开户地址
     * @See <a href="https://taojinyundev.rong360.com/_book/repay_search.html"></a>
     */
    ResultDto<OpenAccountResultBean> handleOpenAccount(OpenAccountBean openAccountBean);

    /**
     * 征信查询
     *
     * @param creditQueryBean 订单号和回调地址
     * @return 征信结果地址
     * @See <a href="https://taojinyundev.rong360.com/_book/credit_inquiry.html"></a>
     */
    ResultDto<CreditQueryResultBean> queryCredit(CreditQueryBean creditQueryBean);

}
