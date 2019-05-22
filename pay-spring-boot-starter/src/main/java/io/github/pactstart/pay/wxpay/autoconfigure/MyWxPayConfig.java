package io.github.pactstart.pay.wxpay.autoconfigure;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyWxPayConfig extends WXPayConfig {

    private WxPayProperties wxPayProperties;

    private IWXPayDomain wxPayDomain;

    public MyWxPayConfig(WxPayProperties wxPayProperties) {
        this.wxPayProperties = wxPayProperties;
        this.wxPayDomain = new MyWxPayDomain();
    }

    @Override
    public String getAppID() {
        return wxPayProperties.getAppId();
    }

    @Override
    public String getMchID() {
        return wxPayProperties.getMchId();
    }

    @Override
    public String getKey() {
        return wxPayProperties.getKey();
    }

    @Override
    public InputStream getCertStream() {
        return this.getClass().getResourceAsStream(wxPayProperties.getCertFile());
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return super.getHttpConnectTimeoutMs();
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return super.getHttpReadTimeoutMs();
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return new MyWxPayDomain();
    }

    @Override
    public boolean shouldAutoReport() {
        return super.shouldAutoReport();
    }

    @Override
    public int getReportWorkerNum() {
        return super.getReportWorkerNum();
    }

    @Override
    public int getReportQueueMaxSize() {
        return super.getReportQueueMaxSize();
    }

    @Override
    public int getReportBatchSize() {
        return super.getReportBatchSize();
    }
}
