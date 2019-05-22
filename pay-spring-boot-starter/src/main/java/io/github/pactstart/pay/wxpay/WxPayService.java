package io.github.pactstart.pay.wxpay;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.common.collect.Maps;
import io.github.pactstart.biz.common.utils.BeanMapUtils;
import io.github.pactstart.pay.wxpay.autoconfigure.MyWxPayConfig;
import io.github.pactstart.pay.wxpay.autoconfigure.WxPayProperties;
import io.github.pactstart.pay.wxpay.model.Coupon;
import io.github.pactstart.pay.wxpay.model.CouponRefund;
import io.github.pactstart.pay.wxpay.model.OrderRefund;
import io.github.pactstart.pay.wxpay.request.*;
import io.github.pactstart.pay.wxpay.request.transfer.TransferQueryRequest;
import io.github.pactstart.pay.wxpay.request.transfer.TransferRequest;
import io.github.pactstart.pay.wxpay.response.*;
import io.github.pactstart.pay.wxpay.response.transfer.TransferQueryResponse;
import io.github.pactstart.pay.wxpay.response.transfer.TransferResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Slf4j
public class WxPayService {

    private final WXPay wxPay;

    private final WxPayProperties wxPayProperties;

    public WxPayService(WxPayProperties wxPayProperties) throws Exception {
        this.wxPayProperties = wxPayProperties;
        this.wxPay = new WXPay(new MyWxPayConfig(wxPayProperties), wxPayProperties.getNotifyUrl(), wxPayProperties.isAutoReport(), wxPayProperties.isUseSandbox());
        this.wxPay.checkWXPayConfig();
        if (StringUtils.isBlank(wxPayProperties.getNotifyUrl())) {
            throw new Exception("notifyUrl in config is empty");
        }
    }

    public WXPay getWxPay() {
        return wxPay;
    }

    public WxPayProperties getWxPayProperties() {
        return wxPayProperties;
    }

    private Map<String, String> getParamMap(Object request) {
        Map<String, Object> paramMap = BeanMapUtils.beanToMap(request);
        Map<String, String> filteredParamMap = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if (entry.getValue() != null) {
                filteredParamMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return filteredParamMap;
    }

    private void validateParam(Object request) {
//        Map<String, String> invalidParamMap = BeanValidator.validate(request);
//        if (invalidParamMap != null && invalidParamMap.size() > 0) {
//            log.error("调用微信支付相关接口参数不合法", JSON.toJSONString(invalidParamMap));
//            throw new WxPayException("参数不合法");
//        }
    }

    /**
     * 企业付款到零钱
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public TransferResponse transfer(TransferRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.transfer(paramMap);
        TransferResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), TransferResponse.class);
        return response;
    }

    /**
     * 查询企业付款
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public TransferQueryResponse transferQuery(TransferQueryRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.transfer(paramMap);
        TransferQueryResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), TransferQueryResponse.class);
        return response;
    }

    /**
     * app支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public AppUnifiedOrderResponse appUnifiedOrder(AppUnifiedOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.unifiedOrder(paramMap);
        AppUnifiedOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), AppUnifiedOrderResponse.class);
        return response;
    }

    /**
     * 获取app支付参数
     * @param response 预支付响应
     * @return app支付参数
     * @throws Exception 异常
     */
    public Map<String, String> getAppPayParam(AppUnifiedOrderResponse response) throws Exception {
        Map<String, String> appPayParamMap = Maps.newHashMap();
        appPayParamMap.put("appid", response.getAppid());
        appPayParamMap.put("partnerid", response.getMch_id());
        appPayParamMap.put("prepayid", response.getPrepay_id());
        appPayParamMap.put("package", "Sign=WXPay");
        appPayParamMap.put("noncestr", WXPayUtil.generateNonceStr());
        appPayParamMap.put("timestamp", WXPayUtil.getCurrentTimestamp() + "");
        //签名方式一定要与统一下单接口使用的一致
        appPayParamMap.put("sign", WXPayUtil.generateSignature(appPayParamMap, wxPayProperties.getKey(), wxPay.getSignType()));
        //SB的微信支付接口文档
        appPayParamMap.put("packageTag", "Sign=WXPay");
        return appPayParamMap;
    }

    /**
     * H5支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public H5UnifiedOrderResponse h5UnifiedOrder(H5UnifiedOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.unifiedOrder(paramMap);
        H5UnifiedOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), H5UnifiedOrderResponse.class);
        return response;
    }

    /**
     * 公众号支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public JsapiUnifiedOrderResponse jsapiUnifiedOrder(JsapiUnifiedOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.unifiedOrder(paramMap);
        JsapiUnifiedOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), JsapiUnifiedOrderResponse.class);
        return response;
    }

    /**
     * 小程序支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public WxaUnifiedOrderResponse wxaUnifiedOrder(WxaUnifiedOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.unifiedOrder(paramMap);
        WxaUnifiedOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), WxaUnifiedOrderResponse.class);
        return response;
    }

    /**
     * 扫码支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public NativeUnifiedOrderResponse nativeUnifiedOrder(NativeUnifiedOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.unifiedOrder(paramMap);
        NativeUnifiedOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), NativeUnifiedOrderResponse.class);
        return response;
    }

    /**
     * 刷卡支付
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public MicropayResponse microUnifiedOrder(MicropayRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.microPay(paramMap);
        MicropayResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), MicropayResponse.class);
        return response;
    }

    /**
     * 关闭订单
     * 以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public CloseOrderResponse closeOrder(CloseOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.closeOrder(paramMap);
        CloseOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), CloseOrderResponse.class);
        return response;
    }

    /**
     * 撤销订单
     * 支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。
     * 注意：7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
     * 调用支付接口后请勿立即调用撤销订单API，建议支付后至少15s后再调用撤销订单接口。
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public ReverseOrderResponse reverseOrder(ReverseOrderRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.reverse(paramMap);
        ReverseOrderResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), ReverseOrderResponse.class);
        return response;
    }

    /**
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。<br>
     * 注意：<br>
     * 1、交易时间超过一年的订单无法提交退款<br>
     * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号<br>
     * 3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次
     * 错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次<br>
     * 4、每个支付订单的部分退款次数不能超过50次<br>
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public RefundResponse refund(RefundRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.refund(paramMap);
        RefundResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), RefundResponse.class);
        if (response.isSuccess()) {
            response.setCouponRefundList(CouponRefund.parse(responseParamMap));
        }
        return response;
    }

    /**
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。<br>
     * 需要调用查询接口的情况：<br>
     * 1、当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；<br>
     * 2、 调用支付接口后，返回系统错误或未知交易状态情况；<br>
     * 3、 调用刷卡支付API，返回USERPAYING的状态；<br>
     * 4、调用关单或撤销接口API之前，需确认支付状态；<br>
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public OrderQueryResponse orderQuery(OrderQueryRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.orderQuery(paramMap);
        OrderQueryResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), OrderQueryResponse.class);
        if (response.isSuccess()) {
            response.setCouponList(Coupon.parse(responseParamMap));
        }
        return response;
    }

    /**
     * 查询退款<br>
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。<br>
     * 注意：如果单个支付订单部分退款次数超过20次请使用退款单号查询<br>
     * 当一个订单部分退款超过10笔后，商户用微信订单号或商户订单号调退款查询API查询退款时，默认返回前10笔和total_refund_count（订单总退款次数）。<br>
     * 商户需要查询同一订单下超过10笔的退款单时，可传入订单号及offset来查询，微信支付会返回offset及后面的10笔，以此类推。当商户传入的offset超过total_refund_count，则系统会返回报错PARAM_ERROR。<br>
     * 举例：一笔订单下的退款单有36笔，当商户想查询第25笔时，可传入订单号及offset=24，微信支付平台会返回第25笔到第35笔的退款单信息，或商户可直接传入退款单号查询退款<br>
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.refundQuery(paramMap);
        RefundQueryResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), RefundQueryResponse.class);
        if (response.isSuccess()) {
            response.setOrderRefundList(OrderRefund.parse(responseParamMap));
        }
        return response;
    }

    /**
     * 下载对账单<br>
     * 商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。<br>
     * 注意：<br>
     * 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致；<br>
     * 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；<br>
     * 3、对账单中涉及金额的字段单位为“元”。<br>
     * 4、对账单接口只能下载三个月以内的账单。<br>
     * 5、对账单是以商户号纬度来生成的，如一个商户号与多个appid有绑定关系，则使用其中任何一个appid都可以请求下载对账单。对账单中的appid取自交易时候提交的appid，与请求下载对账单时使用的appid无关。<br>
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public DownloadBillResponse downloadBill(DownloadBillRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.downloadBill(paramMap);
        DownloadBillResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), DownloadBillResponse.class);
        return response;
    }

    /**
     * 接口主要用于扫码原生支付模式一中的二维码链接转成短链接(weixin://wxpay/s/XXXXXX)，减小二维码数据量，提升扫描速度和精确度。
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public ShortUrlResponse shortUrl(ShortUrlRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.shortUrl(paramMap);
        ShortUrlResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), ShortUrlResponse.class);
        return response;
    }

    /**
     * 通过授权码查询公众号Openid，调用查询后，该授权码只能由此商户号发起扣款，直至授权码更新。
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    public AuthCodeToOpenIdResponse authCodeToOpenid(AuthCodeToOpenIdRequest request) throws Exception {
        validateParam(request);
        Map<String, String> paramMap = getParamMap(request);
        Map<String, String> responseParamMap = wxPay.authCodeToOpenid(paramMap);
        AuthCodeToOpenIdResponse response = JSON.parseObject(JSON.toJSONString(responseParamMap), AuthCodeToOpenIdResponse.class);
        return response;
    }

    /**
     * 解析支付结果通知数据
     *
     * @param noticeXml 通知xml
     * @return 通知bean对象
     * @throws Exception 异常
     */
    public PayResultNoticeRequest parsePayNoticeData(String noticeXml) throws Exception {
        Map<String, String> reqData = WXPayUtil.xmlToMap(noticeXml);
        boolean payResultNotifySignatureValid = wxPay.isPayResultNotifySignatureValid(reqData);
        if (!payResultNotifySignatureValid) {
            log.error("支付通知签名不合法:{}", noticeXml);
        }
        PayResultNoticeRequest request = JSON.parseObject(JSON.toJSONString(reqData), PayResultNoticeRequest.class);
        return request;
    }

    /**
     * 验证支付结果通知签名
     *
     * @param reqData 参数
     * @return 是否合法
     * @throws Exception 异常
     */
    public boolean isPayResultNotifySignatureValid(Map<String, Object> reqData) throws Exception {
        Map<String, String> data = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : reqData.entrySet()) {
            if (entry.getValue() != null) {
                data.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return wxPay.isPayResultNotifySignatureValid(data);
    }
}
