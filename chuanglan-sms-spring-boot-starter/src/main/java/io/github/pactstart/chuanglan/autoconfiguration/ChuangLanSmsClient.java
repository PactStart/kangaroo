package io.github.pactstart.chuanglan.autoconfiguration;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.chuanglan.autoconfiguration.request.SmsBalanceRequest;
import io.github.pactstart.chuanglan.autoconfiguration.request.SmsPullRequest;
import io.github.pactstart.chuanglan.autoconfiguration.request.SmsSendRequest;
import io.github.pactstart.chuanglan.autoconfiguration.request.SmsVariableRequest;
import io.github.pactstart.chuanglan.autoconfiguration.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChuangLanSmsClient {

    private ChuangLanConfig chuangLanConfig;

    private Logger logger = LoggerFactory.getLogger(ChuangLanSmsClient.class);

    public ChuangLanSmsClient(ChuangLanConfig chuangLanConfig) {
        this.chuangLanConfig = chuangLanConfig;
    }

    /**
     * 查询余额
     *
     * @return
     */
    public SmsBalanceResponse sendSmsBlanceRequest() {
        //余额查询 请登录zz.253.com 获取完整的URL接口信息
        String smsBalanceRequestUrl = chuangLanConfig.getUrl() + "/msg/balance/json";

        SmsBalanceRequest smsBalanceRequest = new SmsBalanceRequest(chuangLanConfig.getAccount(), chuangLanConfig.getPassword());

        String requestJson = JSON.toJSONString(smsBalanceRequest);

        logger.info("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsBalanceRequestUrl, requestJson);

        logger.info("response after request result is : " + response);

        SmsBalanceResponse smsBalanceResponse = JSON.parseObject(response, SmsBalanceResponse.class);

        logger.info("response  toString is : " + smsBalanceResponse);

        return smsBalanceResponse;
    }

    /**
     * 查询上行短信
     *
     * @param count 上行拉取条数
     * @return
     */
    public SmsPullResponse sendSmsPullRequest(Integer count) {
        //拉取上行的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsPullRequestUrl = chuangLanConfig.getUrl() + "/msg/pull/mo";

        SmsPullRequest smsPullRequest = new SmsPullRequest(chuangLanConfig.getAccount(), chuangLanConfig.getPassword(), count + "");

        String requestJson = JSON.toJSONString(smsPullRequest);

        logger.info("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsPullRequestUrl, requestJson);

        logger.info("response after request result is : " + response);

        SmsPullResponse smsPullResponse = JSON.parseObject(response, SmsPullResponse.class);

        logger.info("response  toString is : " + smsPullResponse);

        return smsPullResponse;
    }

    /**
     * 查询状态报告
     *
     * @param count
     * @return
     */
    public SmsReportResponse sendSmsReportRequest(Integer count) {
        //拉取上行的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsReportRequestUrl = chuangLanConfig.getUrl() + "/msg/pull/report";

        SmsPullRequest smsPullRequest = new SmsPullRequest(chuangLanConfig.getAccount(), chuangLanConfig.getPassword(), count + "");

        String requestJson = JSON.toJSONString(smsPullRequest);

        logger.info("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);

        logger.info("response after request result is : " + response);

        SmsReportResponse smsReportResponse = JSON.parseObject(response, SmsReportResponse.class);

        logger.info("response  toString is : " + smsReportResponse);

        return smsReportResponse;
    }

    /**
     * 普通短信发送
     *
     * @param msg   【253云通讯】你好,你的验证码是123456",其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
     * @param phone 159*******
     * @return
     */
    public SmsSendResponse sendSmsSendRequest(String msg, String phone) {

        //短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsSingleRequestServerUrl = chuangLanConfig.getUrl() + "/msg/send/json";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(chuangLanConfig.getAccount(), chuangLanConfig.getPassword(), msg, phone);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        logger.info("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        logger.info("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        logger.info("response  toString is :" + smsSingleResponse);

        return smsSingleResponse;

    }

    /**
     * 变量短信发送
     *
     * @param msg    "【253云通讯】尊敬的{$var},您好,您的验证码是{$var},{$var}分钟内有效";
     * @param params "159*******,先生,123456,3;130********,先生,123456,3;"
     * @return
     */
    public SmsVariableResponse sendSmsVariableRequest(String msg, String params) {
        //变量短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsVariableRequestUrl = chuangLanConfig.getUrl() + "/msg/variable/json";
        //设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        //状态报告
        String report = "true";

        SmsVariableRequest smsVariableRequest = new SmsVariableRequest(chuangLanConfig.getAccount(), chuangLanConfig.getPassword(), msg, params, report);

        String requestJson = JSON.toJSONString(smsVariableRequest);

        logger.info("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsVariableRequestUrl, requestJson);

        logger.info("response after request result is : " + response);

        SmsVariableResponse smsVariableResponse = JSON.parseObject(response, SmsVariableResponse.class);

        logger.info("response  toString is : " + smsVariableResponse);

        return smsVariableResponse;
    }

}
