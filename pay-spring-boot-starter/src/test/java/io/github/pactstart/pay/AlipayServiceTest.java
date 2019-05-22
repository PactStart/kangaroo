package io.github.pactstart.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.*;
import io.github.pactstart.pay.alipay.AliPayService;
import io.github.pactstart.pay.alipay.autoconfigure.AliPayConfig;
import io.github.pactstart.pay.alipay.request.AppPayRequest;
import io.github.pactstart.pay.alipay.request.PagePayRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Slf4j
public class AlipayServiceTest {

    private AliPayService aliPayService;

    //    @Before
    public void init() throws Exception {
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppid("2018071760706339");
        aliPayConfig.setSellerId("2088131531289775");
        aliPayConfig.setAppName("三年六班");
        aliPayConfig.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArcnzBhlhnAcYa0btYpecR4LdALz3K8vIBUW4W5C09n/izsbteXbBs401kh9ZDyGoJlcvJfuKIy/6upEEUYdKFMQOGtIauAeV/DAgywgGOqlB7p39M82BuMH0oQ9aktSIjwZCA+jsrnTivQMDAYOH2ZQBZdvnZzWDx+QUzC1B5ws+nb7mkZp6u7TKeWEFHWA7ffpdf+gmV/YKDI4IzVDgOluBBSC/6Yx8bQrLCbSagQufy+VklgrSTSb11DUES4FXsyU7O1hu/X9I5Gdmf1rTfiCeXSzx15Sy90UBRdNwnGqyntT71FF1JDsoKMqnf0q13/jj9nvb6vwzp75Pof5cJwIDAQAB");
        aliPayConfig.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtyfMGGWGcBxhrRu1il5xHgt0AvPcry8gFRbhbkLT2f+LOxu15dsGzjTWSH1kPIagmVy8l+4ojL/q6kQRRh0oUxA4a0hq4B5X8MCDLCAY6qUHunf0zzYG4wfShD1qS1IiPBkID6OyudOK9AwMBg4fZlAFl2+dnNYPH5BTMLUHnCz6dvuaRmnq7tMp5YQUdYDt9+l1/6CZX9goMjgjNUOA6W4EFIL/pjHxtCssJtJqBC5/L5WSWCtJNJvXUNQRLgVezJTs7WG79f0jkZ2Z/WtN+IJ5dLPHXlLL3RQFF03CcarKe1PvUUXUkOygoyqd/SrXf+OP2e9vq/DOnvk+h/lwnAgMBAAECggEAHTAg1/JlWW47pLDZ58gs4DnTYm9aWAm2w2PtTbulGQ1ri20Pr2nJqJ1b1Pnc3FS7yAy2h3uSvMwvISx//C1rvMcc01ZcVHI5t4xhxZfIbAvHXgs83nlygxRYQMCyZpy5fsP/TGbPcZGCD1q1I4jyxRE9ltzzJXtwcZ8V+yDSw7nxyaop2xjaw6L7QbI92Lb4ariyGrSern4vBVh0UOFAvvNMK5xFiKIW6knzsOdtBT6z39nh1aIChBe2r3WcEPIG1J/yNNjZ5mtL+NkZpREG31etqlXz0ajivgRKTMrS+9a/yZO2GS/El21ZwqrIICrtW4nJG9MlwABVCUxfgxo28QKBgQDe5GScDHlU3CCG5GbhcFgiwrevPmfHH18HzZSOQYHLP1IWUfQdf11zZdmnX2qHwuKN2icempKwnkmxrXhc2fkuNHkD88iFlNOV/Vfxk30Za0vb2R4bNmwTfBws0zVX4qtbuot9FfJeouRv5yGmPC5p4UGeSswqLb1ExjOEmaCwHwKBgQDHml/QeslUSOWfaWdGtA9Nsmt6qRNOeQR4zXb8gO8p0KL2e3AmGnbdwnHR8LA5SfJvOA7Ay6GeyPpGJcDUCg4iCYElbBlZRfEpQkDGe6d9pBBkmZqLj9yVXbzKGJVPb6FwPDyqDWG4obcSrtH9ftviKRydendxeWCWIyqgQBMy+QKBgQCatkmnj3kAkDL7rrpCrSpgJmw9dcGvE3VxAx+kho/DNlaSK5yYhPmmygGEDdTyGzIKaGxS79P2SEi6zcAIIzy097MwLRz4q88aA1nx0wA4jqN/HHurQ+FMvQ8Jhik2sZ1j9F4yGvO7ALIzgml267sDv1k+uIhyloETpcfIuKIy3QKBgQCe7m2yW8JpKS4lE1FXe9HfpNxtq6iiyDtmUPuYLLXCTs0jg8AVpubUxpnId2RqCVZPdoxQuRN0kkStjCwQ6fy832KEwKEic02F86oOILGJmhQvdhsXWzJhgGTtakuhF5qs+lm3cbZIxAM4jhjIRrWgS+nr/nKS2PmuMkwjk0F2SQKBgA6wsIxL6aTsGWtEv8phW2tSWUdZCB7tWe6DVLYuzW0gfb2Y1+aV4KRKtUZg+HUdCWUZWJkvzklNDSlSvhRlAebv7jmY9LKNOrtr6By5Kv2vRZ1DRhLH+29Qr8459jUvWBDDrxwSt4M7TkUcHLKkfDyLxhHNC1nzYqjURzjnhIm5");
        aliPayService = new AliPayService(aliPayConfig);
    }

    //    @Test
    public void testPagePay() throws AlipayApiException {
        PagePayRequest pagePayRequest = new PagePayRequest.PagePayRequestBuilder().setAppId("2017071007701156")
                .setTimeoutExpress("30m")
                .setTotalAmount("70.00")
                .setSubject("我有单-购买货品费用:穿越火线|代练服务|10块钱升到20")
                .setOutTradeNo("0912598189608144896")
                .setNotifyUrl("http://localhost/pay/notify/alipay-app")
                .setReturnUrl("http://localhost/pay/return/alipay-app")
                .build();
        String formStr = aliPayService.getFormStr(pagePayRequest);
        log.info(formStr);
    }

    //    @Test
    public void testAppPay() throws AlipayApiException, UnsupportedEncodingException {
        AliPayConfig aliPayConfig = aliPayService.getAliPayConfig();
        AppPayRequest appPayRequest = new AppPayRequest.AppPayRequestBuilder().setAppId(aliPayConfig.getAppid())
                .setTimeoutExpress("30m")
                .setTotalAmount("70.00")
                .setSubject("我有单-购买货品费用:穿越火线|代练服务|10块钱升到20")
                .setOutTradeNo("0912598189608144896")
                .setNotifyUrl("http://localhost/pay/notify/alipay-app").build();
        String originalStr = appPayRequest.getOriginalStr();
        log.info("originalStr ： {}", originalStr);
        String sign = AlipaySignature.rsaSign(originalStr, aliPayConfig.getPrivateKey(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        log.info("sign ： {}", sign);
        appPayRequest.setSign(sign);
        String signedStr = originalStr + "&sign=" + sign;
        log.info("signedStr ： {}", signedStr);
        String encodedStr = appPayRequest.getEncodedStr();
        log.info("encodedStr ： {}", encodedStr);
    }

    //    @Test
    public void testTradeQuery() throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel queryModel = new AlipayTradeQueryModel();
//        queryModel.setTradeNo("2017092621001004290514021797");
        queryModel.setOutTradeNo("101022798757185589248");
        request.setBizModel(queryModel);
        AlipayTradeQueryResponse response = aliPayService.query(request);
        log.info(JSON.toJSONString(response));
    }

    //    @Test
    public void testRefund() {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel refundModel = new AlipayTradeRefundModel();
        refundModel.setOutTradeNo("30912598189608144896");
        refundModel.setTradeNo("2017092621001004290514021797");
        refundModel.setOperatorId("Rex");
        refundModel.setRefundAmount("0.1");
        refundModel.setRefundReason("测试退款");
        request.setBizModel(refundModel);
        try {
            AlipayTradeRefundResponse response = aliPayService.refund(request);
            log.info(JSON.toJSONString(response));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void testTransfer() {
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        AlipayFundTransToaccountTransferModel transferModel = new AlipayFundTransToaccountTransferModel();
        transferModel.setAmount("0.1");
        transferModel.setPayeeType("ALIPAY_USERID");
        transferModel.setPayeeAccount("2088312853977924");
        transferModel.setPayerShowName("爱淘游");
        transferModel.setPayeeRealName("刘念君");
        transferModel.setRemark("转账备注");
        transferModel.setOutBizNo(UUID.randomUUID().toString().replace("-", ""));
        request.setBizModel(transferModel);
        try {
            AlipayFundTransToaccountTransferResponse response = aliPayService.transfer(request);
            log.info(JSON.toJSONString(response));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void testGetInfoStr() {
        try {
            String infoStr = aliPayService.getInfoStr("Rex");
            log.info(infoStr);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void testGetAuthToken() {
        try {
            AlipaySystemOauthTokenResponse response = aliPayService.getAuthToken("df2fd9f7d7364319ae5a71be0a1bUB92");
            log.info(JSON.toJSONString(response));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void testGetUserInfo() {
        try {
            AlipayUserInfoShareResponse response = aliPayService.getUserInfo("kuaijieB922c5dcec59e49009fa0f12df6505X92");
            log.info(JSON.toJSONString(response));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

}
