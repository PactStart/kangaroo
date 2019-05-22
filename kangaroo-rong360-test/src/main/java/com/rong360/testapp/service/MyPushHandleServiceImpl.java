package com.rong360.testapp.service;

import io.github.pactstart.rong360.push.bean.*;
import io.github.pactstart.rong360.push.dto.ResultDto;
import io.github.pactstart.rong360.push.service.PushHandleService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MyPushHandleServiceImpl implements PushHandleService {

    @Override
    public ResultDto handleOrderBaseInfoPush(OrderBean orderBean) {
        return ResultDto.OK;
    }

    @Override
    public ResultDto handleOrderSupplyInfoPush(OrderSupplyBean orderSupplyBean) {
        return null;
    }

    @Override
    public ResultDto<BandCardListBean> handleGetUserBandCardList(OrderNoBean orderNoBean) {
        return null;
    }

    @Override
    public ResultDto<BindCardBindResultBean> bindBandCard(BandCardBindBean bandCardBindBean) {
        return null;
    }

    @Override
    public ResultDto<Map<String, Object>> getOrderApproveResult(OrderNoBean orderNoBean) {
        return null;
    }

    @Override
    public ResultDto<ApproveConfirmResultBean> handleApproveConfirm(ApproveConfirmBean approveConfirmBean) {
        return null;
    }

    @Override
    public ResultDto<ApproveConfirmYzmResultBean> handleApproveConfirmYzm(ApproveConfirmYzmBean approveConfirmYzmBean) {
        return null;
    }

    @Override
    public ResultDto<ContractGetResultBean> handleGetContract(ContractGetBean contractGetBean) {
        return null;
    }

    @Override
    public ResultDto<Map<String, Object>> getRepaymentPlan(OrderNoBean orderNoBean) {
        return null;
    }

    @Override
    public ResultDto<Map<String, Object>> getOrderStatus(OrderNoBean orderNoBean) {
        return null;
    }

    @Override
    public ResultDto<RepaymentResultBean> handleRepayment(RepaymentBean repaymentBean) {
        return null;
    }

    @Override
    public ResultDto<RepaymentCodeVerifyResultBean> handleRepaymentVerifyCode(RepaymentVerifyCodeBean repaymentVerifyCodeBean) {
        return null;
    }

    @Override
    public ResultDto<RepaymentDetailBean> getRepaymentDetail(RepaymentPeriodBean repaymentPeriodBean) {
        return null;
    }

    @Override
    public ResultDto<DeferDetailBean> getDeferDetail(OrderNoBean orderNoBean) {
        return null;
    }

    @Override
    public ResultDto handleDefer(DeferBean deferBean) {
        return null;
    }

    @Override
    public ResultDto<TrialResultBean> handleTrial(TrialBean trialBean) {
        return null;
    }

    @Override
    public ResultDto handleSecondAssay(SecondAssayBean secondAssayBean) {
        return null;
    }

    @Override
    public ResultDto<RepaySearchResultBean> handleRepaySearch(RepaymentPeriodBean repaymentPeriodBean) {
        return null;
    }

    @Override
    public ResultDto<OpenAccountResultBean> handleOpenAccount(OpenAccountBean openAccountBean) {
        return null;
    }

    @Override
    public ResultDto<CreditQueryResultBean> queryCredit(CreditQueryBean creditQueryBean) {
        return null;
    }
}
