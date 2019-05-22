package io.github.pactstart.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import io.github.pactstart.pay.alipay.autoconfigure.AliPayConfig;
import io.github.pactstart.pay.alipay.request.AppPayRequest;
import io.github.pactstart.pay.alipay.request.PagePayRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Slf4j
public class AliPayService {

    private AlipayClient alipayClient;
    private AliPayConfig aliPayConfig;

    public AliPayService(AliPayConfig aliPayConfig) {
        this.aliPayConfig = aliPayConfig;
        this.alipayClient = new DefaultAlipayClient(
                aliPayConfig.getServerUrl(), aliPayConfig.getAppid(),
                aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
                aliPayConfig.getAlipayPublicKey(), aliPayConfig.getSignType());
    }

    public AlipayClient getAlipayClient() {
        return alipayClient;
    }

    public AliPayConfig getAliPayConfig() {
        return aliPayConfig;
    }

    /**
     * 验证支付宝通知签名是否合法
     *
     * @param paramsMap 参数
     * @return 是否合法
     * @throws AlipayApiException api异常
     */
    public boolean rsaCheckV1(Map<String, String> paramsMap) throws AlipayApiException {
        return AlipaySignature.rsaCheckV1(paramsMap, aliPayConfig.getAlipayPublicKey(), aliPayConfig.getCharset(), paramsMap.get("sign_type"));
    }

    /**
     * 获取支付宝App授权字符串
     *
     * @param targetId targetId
     * @return 响应
     * @throws AlipayApiException api异常
     * @throws UnsupportedEncodingException 不支持的编码异常
     */
    public String getInfoStr(String targetId) throws AlipayApiException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("apiname=com.alipay.account.auth")
                .append("&app_id=").append(aliPayConfig.getAppid())
                .append("&app_name=").append("mc")
                .append("&auth_type=AUTHACCOUNT")
                .append("&biz_type=openservice")
                .append("&method=alipay.open.auth.sdk.code.get")
                .append("&pid=").append(aliPayConfig.getSellerId())
                .append("&product_id=APP_FAST_LOGIN")
                .append("&scope=kuaijie")
                .append("&sign_type=").append(aliPayConfig.getSignType())
                .append("&target_id=").append(targetId);
        String sign = AlipaySignature.rsaSign(sb.toString(), aliPayConfig.getPrivateKey(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        sb.append("&sign=").append(URLEncoder.encode(sign, aliPayConfig.getCharset()));
        return sb.toString();
    }

    /**
     * 获取支付宝App支付字符串
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException api异常
     * @throws UnsupportedEncodingException 不支持的编码异常
     */
    public String getOrderStr(AppPayRequest request) throws AlipayApiException, UnsupportedEncodingException {
        String originalStr = request.getOriginalStr();
        log.debug("original string：{}", originalStr);
        String sign = AlipaySignature.rsaSign(originalStr, aliPayConfig.getPrivateKey(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        log.debug("signed string：{}", originalStr);
        request.setSign(sign);
        String encodedStr = request.getEncodedStr();
        log.debug("encoded string：{}", originalStr);
        return encodedStr;
    }

    /**
     * JAVA服务端SDK生成APP支付订单信息示例
     * https://docs.open.alipay.com/54/106370/ AlipayTradeAppPayModel
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeAppPayResponse appPay(AlipayTradeAppPayRequest request) throws AlipayApiException {
        return alipayClient.sdkExecute(request);
    }

    /**
     * 获取支付宝PC网页支付Form表单字符串
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public String getFormStr(PagePayRequest request) throws AlipayApiException {
        return alipayClient.pageExecute(request.generate()).getBody(); //调用SDK生成表单
    }

    /**
     * 查询交易
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeQueryResponse query(AlipayTradeQueryRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 退款
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeRefundResponse refund(AlipayTradeRefundRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    public AlipayTradeOrderSettleResponse settle(AlipayTradeOrderSettleRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 关闭交易
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeCloseResponse close(AlipayTradeCloseRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 取消交易
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeCancelResponse cancel(AlipayTradeCancelRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 退款查询
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeFastpayRefundQueryResponse refundQuery(AlipayTradeFastpayRefundQueryRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 交易预创建
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradePrecreateResponse pay(AlipayTradePrecreateRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 创建交易
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradeCreateResponse pay(AlipayTradeCreateRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 支付交易
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayTradePayResponse pay(AlipayTradePayRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 支付宝转账
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayFundTransToaccountTransferResponse transfer(AlipayFundTransToaccountTransferRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 支付宝转账查询
     *
     * @param request 请求
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayFundTransOrderQueryResponse transferQuery(AlipayFundTransOrderQueryRequest request) throws AlipayApiException {
        return alipayClient.execute(request);
    }

    /**
     * 根据授权码换取OAuth2 Token
     *
     * @param authCode 授权码
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipaySystemOauthTokenResponse getAuthToken(String authCode) throws AlipayApiException {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        return alipayClient.execute(request);
    }

    /**
     * 根据access_token换取用户信息
     *
     * @param accessToken 访问凭证
     * @return 响应
     * @throws AlipayApiException 异常
     */
    public AlipayUserInfoShareResponse getUserInfo(String accessToken) throws AlipayApiException {
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        return alipayClient.execute(request, accessToken);
    }
}
