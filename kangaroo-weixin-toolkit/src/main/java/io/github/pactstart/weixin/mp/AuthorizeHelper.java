package io.github.pactstart.weixin.mp;

import io.github.pactstart.weixin.common.enums.Scope;
import io.github.pactstart.weixin.common.util.StringUtils;

/**
 * Created by Di.Lei on 2017/8/9.
 */
public class AuthorizeHelper {

    /**
     * 构造一次性订阅消息用户授权url
     *
     * @param appid
     * @param templateId
     * @param redirectUrl
     * @return
     */
    public static String buildSubscribeMsgUrl(String appid, String templateId, String redirectUrl) {
        return "https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm"
                + "&appid=" + appid
                + "&scene=get_confirm&template_id=" + templateId
                + "&redirect_url=" + StringUtils.encodeUrl(redirectUrl)
                + "&reserved=test#wechat_redirect";

    }

    /**
     * 构造微信网页授权url
     *
     * @param appid
     * @param scope
     * @param redirectUri
     * @return
     */
    public static String buildOAuth2Url(String appid, Scope scope, String redirectUri, String state) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?")
                .append("appid=").append(appid)
                .append("&redirect_uri=").append(StringUtils.encodeUrl(redirectUri))
                .append("&response_type=code")
                .append("&scope=").append(scope.name())
                .append("&state=").append(state).append("#wechat_redirect");
        return sb.toString();
    }
}
