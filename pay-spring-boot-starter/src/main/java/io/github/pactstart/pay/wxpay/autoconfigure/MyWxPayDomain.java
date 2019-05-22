package io.github.pactstart.pay.wxpay.autoconfigure;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyWxPayDomain implements IWXPayDomain {

    private Logger logger = LoggerFactory.getLogger(MyWxPayDomain.class);

    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {
        if (ex != null) {
            logger.error(String.format("wxpay report, domain: %s , elapsedTimeMillis: %d ms ", domain, elapsedTimeMillis), ex);
        } else {
            logger.debug(String.format("wxpay report, domain: %s , elapsedTimeMillis: %d ms ", domain, elapsedTimeMillis), ex);
        }

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new IWXPayDomain.DomainInfo("api.mch.weixin.qq.com", true);
    }
}
