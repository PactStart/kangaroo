package io.github.pactstart.weixin.mp.enums;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public enum Language {

    /**
     * 简体中文
     */
    ZH_CN("zh_CN"),
    /**
     * 繁体中文TW
     */
    ZH_TW("zh_TW"),
    /**
     * 繁体中文HK
     */
    ZH_HK("zh_HK"),
    /**
     * 英文
     */
    EN("en"),
    /**
     * 印尼
     */
    ID("id"),
    /**
     * 马来
     */
    MS("ms"),
    /**
     * 西班牙
     */
    ES("es"),
    /**
     * 韩国
     */
    KO("ko"),
    /**
     * 意大利
     */
    IT("it"),
    /**
     * 日本
     */
    JA("ja"),
    /**
     * 波兰
     */
    PL("pl"),
    /**
     * 葡萄牙
     */
    PT("pt"),
    /**
     * 俄国
     */
    RU("ru"),
    /**
     * 泰文
     */
    TH("th"),
    /**
     * 越南
     */
    VI("vi"),
    /**
     * 阿拉伯语
     */
    AR("ar"),
    /**
     * 北印度
     */
    HI("hi"),
    /**
     * 希伯来
     */
    HE("he"),
    /**
     * 土耳其
     */
    TR("tr"),
    /**
     * 德语
     */
    DE("de"),
    /**
     * 法语
     */
    FR("fr");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
