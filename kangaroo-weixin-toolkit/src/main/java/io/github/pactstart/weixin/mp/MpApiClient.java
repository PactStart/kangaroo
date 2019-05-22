package io.github.pactstart.weixin.mp;

import io.github.pactstart.weixin.common.WeixinApiClient;
import io.github.pactstart.weixin.common.config.SettingsManager;

/**
 * Created by Rex.Lei on 2017/8/19.
 */
public final class MpApiClient extends WeixinApiClient {

    private MpApiClient() {

    }

    public static WeixinApiClient getInstance() {
        return WeixinApiClientHolder.instance;
    }

    @Override
    public String getUrlRoot() {
        return SettingsManager.getProperty("weixin.mp.rootUrl", "https://api.weixin.qq.com");
    }

    private static class WeixinApiClientHolder {
        private static WeixinApiClient instance = new MpApiClient();
    }
}
