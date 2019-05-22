package io.github.pactstart.weixin.mp;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class ArticleContentHelper {

    public static String buildCardLink(String miniProgramAppId, String miniProgramPath, String miniprogramTitle, String programImgaeUrl) {
        return "<mp-miniprogram " +
                "param-miniprogram-appid=\"" + miniProgramAppId + "\" " +
                "param-miniprogram-path=\"" + miniProgramPath + "\" " +
                "param-miniprogram-title=\"" + miniprogramTitle + "\" " +
                "param-progarm-imageurl=\"" + programImgaeUrl + "\">" +
                "</mp-miniprogram>";
    }

    public static String buildTextLink(String miniProgramAppId, String miniProgramPath, String text) {
        return "<p><a param-miniprogram-appid=\"" + miniProgramAppId + "\" " +
                "param-miniprogram-path=\"" + miniProgramPath +
                "\" href=\"\">" + text + "</a></p>";
    }

    public static String buildImageLink(String miniProgramAppId, String miniProgramPath, String imgUrl) {
        return "<p><a param-miniprogram-appid=\"" + miniProgramAppId +
                "\" param-miniprogram-path=\"" + miniProgramPath +
                "\" href=\"\">" +
                "<img param-src=\"" + imgUrl + "\">" +
                "</a></p>";
    }
}
