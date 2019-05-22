package io.github.pactstart.cache.autoconfigure;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface CacheService {

    void delete(String key);

    void delete(List<String> keys);

    void delPattern(String pattern);

    void set(String key, String value);

    void set(String key, String value, long timeout);

    String get(String key);

    List<String> multiGet(Set<String> keys);

    Set<String> getKeys(String regular);

    boolean exists(String key);

    String flushDB();

    long dbSize();

    String ping();

    void setSet(String key, String[] values);

    void setSet(String key, long timeout, String[] values);

    List<String> getSetMember(String key);

    long removeSetMember(String key, String[] values);

    void setHash(String key, String hashKey, String hashValue);

    Map<String, String> getHash(String key);

    void setHash(String key, String hashKey, String hashValue, long timeout);

    void putHash(String key, String hashKey, String value);

    void delHash(String key, String hashKey);

    void putHash(String key, String hashKey, String value, long timeout);

    void setObject(String key, Object value);

    void setObject(String key, Object value, long timeout);

    <T> T getObject(String key, Class<T> clazz);

    Boolean expire(String key, long timeout);

    Boolean expire(String key, long timeout, TimeUnit unit);

    Long incr(String key, long incrValue);

    Long incr(String key, long incrValue, long ttl);

    Long incr(String key, long defaultValue, long incrValue, long timeout);
}