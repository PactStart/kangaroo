package io.github.pactstart.commonutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * Created by Rex.Lei on 2017/8/30.
 */
public class JsonUtils {

    public static final SerializerFeature[] COMMON_FEATURES = {
            SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
    };

    public static final SerializerFeature[] FEATURES = {
            SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteClassName //写类名进JSON
    };

    public static final SerializeConfig JSON_LIB_CONFIG;

    static {
        JSON_LIB_CONFIG = new SerializeConfig();
        JSON_LIB_CONFIG.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        JSON_LIB_CONFIG.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    /**
     * bean转json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String obj2String(Object object) {
        return JSON.toJSONString(object, COMMON_FEATURES);
    }

    /**
     * bean转json字符串
     * @param object 对象
     * @param config 序列化配置
     * @param serializerFeatures 序列化特征
     * @return json字符串
     */
    public static String obj2String(Object object, SerializeConfig config, SerializerFeature[] serializerFeatures) {
        return JSON.toJSONString(object, config, serializerFeatures);
    }

    /**
     * bean转json字符串
     * @param object 对象
     * @param serializerFeatures 序列化特征
     * @return json字符串
     */
    public static String obj2String(Object object, SerializerFeature[] serializerFeatures) {
        return JSON.toJSONString(object, serializerFeatures);
    }

    /**
     * 字符串转对象
     * @param text json字符串
     * @param clazz 对象类型
     * @param <T> 泛型类型
     * @return 对象
     */
    public static <T> T string2Obj(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * 字节转对象
     *
     * @param bytes 字节数组
     * @param clazz 对象类型
     * @param <T> 泛型类型
     * @return 对象
     */
    public static <T> T byte2Obj(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }

    /**
     * json字符串转换为List
     *
     * @param text json字符串
     * @param clazz 对象类型
     * @param <T> 泛型类型
     * @return 对象
     */
    public static <T> List<T> string2List(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }


}
