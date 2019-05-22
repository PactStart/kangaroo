package io.github.pactstart.simple.web.framework.encrypt.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignUtils {

    public static String sign(Map<String, Object> data, String signKey) {
        Map<String, Object> nonNullValueMap = Maps.newHashMap();
        List<String> keyList = Lists.newArrayList();
        data.forEach((key, value) -> {
            if (value != null) {
                nonNullValueMap.put(key, value);
                keyList.add(key);
            }
        });
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        keyList.forEach(key -> {
            String value = nonNullValueMap.get(key).toString();
            if (!"".equals(value)) {
                sb.append(key).append("=").append(value).append("&");
            }
        });
        sb.append("key=").append(signKey);
        String signTemp = sb.toString();
        return md5(signTemp);
    }

    public static String md5(String src) {
        try {
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            byte[] bytes = src.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] targ = md.digest(bytes);
            byte[] var6 = targ;
            int var7 = targ.length;

            for (int var8 = 0; var8 < var7; ++var8) {
                byte b = var6[var8];
                buffer.append(chars[b >> 4 & 15]);
                buffer.append(chars[b & 15]);
            }

            return buffer.toString();
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }
    }
}
