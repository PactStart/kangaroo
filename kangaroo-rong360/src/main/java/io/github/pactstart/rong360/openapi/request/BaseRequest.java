package io.github.pactstart.rong360.openapi.request;

import com.google.common.collect.Maps;

import java.util.Map;

public abstract class BaseRequest<T> {

    /**
     * 业务数据集合
     */
    private Map<String, Object> bizDataMap = Maps.newHashMap();

    /**
     * 设置业务数据
     *
     * @param key    键
     * @param object 值
     */
    public void putBizData(String key, Object object) {
        bizDataMap.put(key, object);
    }

    /**
     * 获取业务数据集合
     *
     * @return
     */
    public Map<String, Object> getBizDataMap() {
        return bizDataMap;
    }

    /**
     * 要请求的API方法名称,留给子类实现
     *
     * @return API方法名称
     */
    public abstract String getMethod();

    /**
     * 获取连接超时时间，单位ms
     *
     * @return 连接超时时间
     */
    public int getConnectTimeOutMs() {
        return 3000;
    }

    /**
     * 获取读超时时间，单位ms
     *
     * @return
     */
    public int getReadTimeOutMs() {
        return 15000;
    }

}
