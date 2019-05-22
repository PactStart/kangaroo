package io.github.pactstart.cache.autoconfigure;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisCacheServiceImpl implements CacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheServiceImpl.class);
    private static String redisEncoding = "utf-8";

    private RedisTemplate<String, String> redisTemplate;

    public RedisCacheServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    @Override
    public void delete(List<String> keys) {
        this.redisTemplate.delete(keys);
    }

    @Override
    public void delPattern(String pattern) {
        Set<String> keys = this.redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }
    }

    public void set(String key, String value) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            connection.set(key.getBytes(), value.getBytes());
            return 1;
        });
    }

    @Override
    public void set(String key, String value, long timeout) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            connection.setEx(key.getBytes(), timeout, value.getBytes());
            return 1;
        });
    }

    @Override
    public String get(String key) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            String result = null;
            byte[] resultByte = connection.get(key.getBytes());
            if (resultByte != null) {
                try {
                    result = new String(resultByte, RedisCacheServiceImpl.redisEncoding);
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("根据key获取数据时异常", e);
                }
            }
            return result;
        });
    }

    @Override
    public List<String> multiGet(Set<String> keys) {
        return this.redisTemplate.opsForValue().multiGet(keys);
    }

    @Override
    public Set<String> getKeys(String regular) {
        return this.redisTemplate.keys(regular);
    }

    @Override
    public boolean exists(String key) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.exists(key.getBytes());
        });
    }

    @Override
    public String flushDB() {
        return null;
    }

    @Override
    public long dbSize() {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.dbSize();
        });
    }

    @Override
    public String ping() {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.ping();
        });
    }

    @Override
    public void setSet(String key, String[] values) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            byte[][] byteValue = new byte[values.length][];
            for (int i = 0; i < values.length; i++) {
                byteValue[i] = values[i].getBytes();
            }
            connection.sAdd(key.getBytes(), byteValue);
            return 1;
        });
    }

    @Override
    public void setSet(String key, long timeout, String[] values) {
        setSet(key, values);
        expire(key, timeout);
    }

    @Override
    public List<String> getSetMember(String key) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            Set<byte[]> sets = connection.sMembers(key.getBytes());
            List<String> returnList = new ArrayList<>();
            if ((sets != null) && (sets.size() > 0)) {
                for (byte[] byteOne : sets) {
                    try {
                        returnList.add(new String(byteOne, RedisCacheServiceImpl.redisEncoding));
                    } catch (UnsupportedEncodingException e) {
                        LOGGER.error("redis key={}的数据byte转化为string时异常", key, e);
                    }
                }
            }
            return returnList;
        });
    }

    @Override
    public long removeSetMember(String key, String[] values) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            byte[][] byteValue = new byte[values.length][];
            for (int i = 0; i < values.length; i++) {
                byteValue[i] = values[i].getBytes();
            }
            return connection.sRem(key.getBytes(), byteValue);
        });
    }

    @Override
    public void setHash(String key, String hashKey, String hashValue) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            connection.hSetNX(key.getBytes(), hashKey.getBytes(), hashValue.getBytes());
            return 1;
        });
    }

    @Override
    public Map<String, String> getHash(String key) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            Map<byte[], byte[]> mapByte = connection.hGetAll(key.getBytes());
            Map<String, String> returnMap = new HashMap<>();
            if ((mapByte != null) && (mapByte.size() > 0)) {
                try {
                    for (Map.Entry entry : mapByte.entrySet()) {
                        returnMap.put(new String((byte[]) entry.getKey(), RedisCacheServiceImpl.redisEncoding), new String((byte[]) entry.getValue(), RedisCacheServiceImpl.redisEncoding));
                    }
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("获取redis中的hash值时失败", e);
                }
            }
            return returnMap;
        });
    }

    @Override
    public void setHash(String key, String hashKey, String hashValue, long timeout) {
        setHash(key, hashKey, hashValue);
        expire(key, timeout);
    }

    @Override
    public void putHash(String key, String hashKey, String value, long timeout) {
        putHash(key, hashKey, value);
        expire(key, timeout);
    }

    @Override
    public void delHash(String key, String hashKey) {
        this.redisTemplate.opsForHash().delete(key, hashKey);
    }

    @Override
    public void putHash(String key, String hashKey, String value) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            connection.hSet(key.getBytes(), hashKey.getBytes(), value.getBytes());
            return 1;
        });
    }

    @Override
    public void setObject(String key, Object value) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            connection.set(key.getBytes(), JSON.toJSONString(value).getBytes());
            return 1;
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getObject(String key, Class<T> clazz) {
        return (T) this.redisTemplate.execute((RedisConnection connection) -> {
            byte[] arr = connection.get(key.getBytes());
            if (arr == null) {
                return null;
            } else {
                return JSON.parseObject(arr, clazz);
            }
        });
    }

    @Override
    public void setObject(String key, Object value, long timeout) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            String json = value == null ? "{}" : JSON.toJSONString(value);
            connection.setEx(key.getBytes(), timeout, json.getBytes());
            return 1;
        });
    }

    @Override
    public Boolean expire(String key, long timeout) {
        return this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return this.redisTemplate.expire(key, timeout, unit);
    }

    @Override
    public Long incr(String key, long incrValue) {
        return this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.incrBy(key.getBytes(), incrValue);
        });
    }

    @Override
    public Long incr(String key, long incrValue, long ttl) {
        long result = this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.incrBy(key.getBytes(), incrValue);
        });
        if (result == incrValue) {
            expire(key, ttl);
        }
        return result;
    }

    @Override
    public Long incr(String key, long defaultValue, long incrValue, long timeout) {
        Assert.notNull(key, "key不能为空");
        boolean exists = exists(key);
        if (!exists) {
            synchronized (this) {
                if (!exists(key)) {
                    set(key, defaultValue + "");
                    expire(key, timeout);
                    return Long.parseLong(get(key));
                }
            }
        }
        return this.redisTemplate.execute((RedisConnection connection) -> {
            return connection.incrBy(key.getBytes(), incrValue);
        });
    }
}