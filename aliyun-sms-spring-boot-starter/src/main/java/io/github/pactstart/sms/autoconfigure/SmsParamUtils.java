package io.github.pactstart.sms.autoconfigure;

import java.util.Map;

public class SmsParamUtils {

    public static String convert2Json(Map<String, String> params) {
        if (params == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\"").append(",");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setCharAt(sb.length() - 1, '}');
        } else {
            sb.append("}");
        }
        return sb.toString();
    }
}
