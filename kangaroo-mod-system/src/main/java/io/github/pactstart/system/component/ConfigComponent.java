package io.github.pactstart.system.component;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dto.ConfigDto;
import io.github.pactstart.system.service.ConfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConfigComponent implements ApplicationListener<ContextRefreshedEvent> {

    private static ConcurrentHashMap<String, Map<String, String>> mapping = null;

    private static Logger logger = LoggerFactory.getLogger(ConfigComponent.class);

    private ConfigService configService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.configService = event.getApplicationContext().getBean(ConfigService.class);
        reload();
    }

    public void reload() {
        if (configService == null) {
            logger.warn("未配置ConfigService Bean");
            return;
        }

        if (mapping == null) {
            mapping = new ConcurrentHashMap<>();
        } else {
            mapping.clear();
        }

        List<ConfigDto> sysConfigList = configService.getAll();
        if (!ValidUtils.isValid(sysConfigList)) {
            logger.warn("未加载到任何配置");
            return;
        }

        for (ConfigDto sysConfig : sysConfigList) {
            if (!mapping.containsKey(sysConfig.getNamespace())) {
                mapping.put(sysConfig.getNamespace(), new HashMap<>());
            }
            mapping.get(sysConfig.getNamespace()).put(sysConfig.getName(), sysConfig.getValue());
        }
    }

    public void updateConfig(String namespace, String key, String value) {
        logger.debug("更新系统配置:namespace:{},key:{},value:{}", namespace, key, value);
        if (!mapping.containsKey(namespace)) {
            mapping.put(namespace, new HashMap<>());
        }
        mapping.get(namespace).put(key, value);
    }


    public String getProperty(String namespace, String key) {
        if (mapping.containsKey(namespace)) {
            return mapping.get(namespace).get(key);
        } else {
            return null;
        }
    }

    public int getIntProperty(String namespace, String key, int defaultValue) {
        try {
            String value = getProperty(namespace, key);
            if (value == null) {
                logger.error("cannot get int value for key ：{}", key);
                return defaultValue;
            }
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            logger.error("cannot get int value for key ：{}", key, e);
            return defaultValue;
        }
    }

    public double getDoubleProperty(String namespace, String key, double defaultValue) {
        try {
            String value = getProperty(namespace, key);
            if (value == null) {
                logger.error("cannot get double value for key ：{}", key);
                return defaultValue;
            }
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            logger.error("cannot get double value for key ：{}", key, e);
            return defaultValue;
        }
    }

    public boolean getBooleanProperty(String namespace, String key, boolean defaultValue) {
        try {
            String value = getProperty(namespace, key);
            return value == null ? defaultValue : Boolean.valueOf(value);
        } catch (NumberFormatException e) {
            logger.error("cannot get bool value for key ：{}", key, e);
            return defaultValue;
        }
    }

    public String getProperty(String namespace, String key, String defaultValue) {
        String value = getProperty(namespace, key);
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }

    public <T> T getJsonConfig(String namespace, String key, Class<T> classType) {
        String json = getProperty(namespace, key);
        if (json == null) {
            return null;
        }

        try {
            return JSON.parseObject(json, classType);
        } catch (Exception e) {
            logger.error(String.format("解析Json配置%s失败", key), e);
        }

        return null;
    }

    public void removeConfig(String namespace, String name) {
        logger.debug("移除系统配置:namespace:{},key:{}", namespace, name);
        if (mapping.containsKey(namespace)) {
            Map<String, String> map = mapping.get(namespace);
            if (map != null && map.containsKey(name)) {
                map.remove(name);
            }
        }
    }
}
