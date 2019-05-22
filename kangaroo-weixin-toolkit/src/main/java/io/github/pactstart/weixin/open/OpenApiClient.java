package io.github.pactstart.weixin.open;

import io.github.pactstart.weixin.common.WeixinApiClient;
import io.github.pactstart.weixin.common.config.SettingsManager;

/**
 * Created by Rex.Lei on 2017/8/19.
 */
public final class OpenApiClient extends WeixinApiClient {

    private OpenApiClient() {

    }

    public static WeixinApiClient getInstance() {
        return WeixinApiClientHolder.instance;
    }

    @Override
    public String getUrlRoot() {
        return SettingsManager.getProperty("weixin.open.rootUrl", "https://open.weixin.qq.com");
    }

    private static class WeixinApiClientHolder {
        private static WeixinApiClient instance = new OpenApiClient();
    }
}
