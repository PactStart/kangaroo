package io.github.pactstart.commonutils;

import java.util.regex.Pattern;

public class PhoneUtils {

    /**
     * 暂时不支持的号段,可能时虚拟运营商的号段
     * 17[01356]
     */
    public final static Pattern UN_SUPPORTED = Pattern.compile("^1(7[01356])\\d{8}$");
    /**
     * 130,131,132,152,155,156,185,186
     */
    private final static Pattern UNICOM_REGEX = Pattern.compile("^1(3[0-2]|5[256]|8[56])\\d{8}$");
    /**
     * 134[0-8],135,136,137,138,139,150,151,157,158,159,18[2,3,4,7,8],178
     */
    private final static Pattern MOBILE_REGEX = Pattern.compile("^1(34[0-8]|(3[5-9]|5[017-9]|8[23478])\\d)\\d{7}$");
    /**
     * 133,1349,153,180,189,173,177
     */
    private final static Pattern TELECOM_REGEX = Pattern.compile("^1((33|53|7[37]|8[019])[0-9]|349)\\d{7}$");

    public static boolean isChinaUnicom(String phone) {
        return UNICOM_REGEX.matcher(phone).matches();
    }

    public static boolean isChinaMobile(String phone) {
        return MOBILE_REGEX.matcher(phone).matches();
    }

    public static boolean isChinaTelecom(String phone) {
        return TELECOM_REGEX.matcher(phone).matches();
    }

    public static boolean isUnknown(String phone) {
        return UN_SUPPORTED.matcher(phone).matches();
    }

}
