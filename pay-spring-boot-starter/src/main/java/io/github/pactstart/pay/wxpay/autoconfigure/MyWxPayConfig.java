package io.github.pactstart.pay.wxpay.autoconfigure;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyWxPayConfig extends WXPayConfig {

    private String appId;

    private String mchId;

    private String key;

    private String certFile;

    private IWXPayDomain wxPayDomain;

    public MyWxPayConfig(String appId, String mchId, String key, String certFile) {
        this.appId = appId;
        this.mchId = mchId;
        this.key = key;
        this.certFile = certFile;
        this.wxPayDomain = new MyWxPayDomain();
    }

    @Override
    public String getAppID() {
        return this.appId;
    }

    @Override
    public String getMchID() {
        return this.mchId;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public InputStream getCertStream() {
        return this.getClass().getResourceAsStream(certFile);
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
        return this.wxPayDomain;
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
