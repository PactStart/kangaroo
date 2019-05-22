package io.github.pactstart.weixin.common.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Rex.Lei on 2017/7/26.
 */
public class SettingsManager {

    private static Logger logger = LoggerFactory.getLogger(SettingsManager.class);
    private static Properties properties = new Properties();

    static {
        InputStream in = null;
        try {
            in = SettingsManager.class.getClassLoader().getResourceAsStream("weixin.properties");
            if (in == null) {
                logger.warn("wexin.properties not exists!");
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("loading weixin.properties");
                }
                properties.load(new InputStreamReader(in, "utf-8"));
            }
        } catch (Exception e) {
            logger.error("loading weixin.properties failed", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {

            }
        }
        if (logger.isDebugEnabled()) {
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                Object value = properties.getProperty(key);
                logger.debug("{}={}", key, value);
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("loading weixin.properties finished");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key, int defaultValue) {
        try {
            return Integer.valueOf(getProperty(key));
        } catch (NumberFormatException e) {
            logger.error("cannot get int value for key ：{}", key, e);
            return defaultValue;
        }
    }

    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        try {
            return Boolean.valueOf(getProperty(key));
        } catch (NumberFormatException e) {
            logger.error("cannot get bool value for key ：{}", key, e);
            return defaultValue;
        }
    }

    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }
}
