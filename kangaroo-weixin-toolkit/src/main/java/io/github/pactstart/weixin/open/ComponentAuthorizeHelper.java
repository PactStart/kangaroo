package io.github.pactstart.weixin.open;

import io.github.pactstart.weixin.common.enums.Scope;
import io.github.pactstart.weixin.common.util.StringUtils;

/**
 * Created by Rex.Lei on 2017/8/14.
 */
public class ComponentAuthorizeHelper {

    /**
     * 构造微信网页授权url,用于小程序或者公众号授权给第三方平台
     *
     * @param appid
     * @param scope
     * @param redirectUri
     * @return
     */
    public static String buildOAuth2Url(String appid, Scope scope, String redirectUri, String state, String componentAppid) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?")
                .append("appid=").append(appid)
                .append("&redirect_uri=").append(StringUtils.encodeUrl(redirectUri))
                .append("&response_type=code")
                .append("&scope=").append(scope.name())
                .append("&state=").append(state)
                .append("&component_appid=").append(componentAppid)
                .append("#wechat_redirect");
        return sb.toString();
    }

    /**
     * 构造微信网页登录url，用于用户在WEB网页授权登录
     *
     * @param appid
     * @param redirectUri
     * @param state
     * @return
     */
    public static String buildWebLoginUrl(String appid, String redirectUri, String state) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://open.weixin.qq.com/connect/qrconnect?")
                .append("appid=").append(appid)
                .append("&redirect_uri=").append(StringUtils.encodeUrl(redirectUri))
                .append("&response_type=code")
                .append("&scope=").append("snsapi_login")
                .append("&state=").append(state)
                .append("#wechat_redirect");
        return sb.toString();
    }
}
