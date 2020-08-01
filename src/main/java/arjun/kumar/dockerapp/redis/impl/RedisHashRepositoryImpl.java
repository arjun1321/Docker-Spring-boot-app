package arjun.kumar.dockerapp.redis.impl;

import arjun.kumar.dockerapp.redis.RedisHashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

/** @author Arjun Kumar  */

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisHashRepositoryImpl extends RedisRepositoryImpl implements RedisHashRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    protected RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    @Override
    public Map<Object, Object> findRedisCacheByKey(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public Object findRedisCacheByKeyAndHashKey(String key, String hashKey) {
        return hashOperations.get(key, hashKey);
    }

    @Override
    public void updateRedisCacheByKey(String key, Map<Object, Object> cacheData) {
        hashOperations.putAll(key, cacheData);
    }

    @Override
    public void updateRedisCacheByKeyAndHashKey(String key, String hashKey, Object cacheData) {
        hashOperations.put(key, hashKey, cacheData);
    }

    @Override
    public Boolean addCacheByKeyAndHashKey(String key, String hashKey, Object cacheData) {
        return hashOperations.putIfAbsent(key, hashKey, cacheData);
    }

    @Override
    public Boolean isHashKeyExist(String key, String hashKey) {
        return hashOperations.hasKey(key, hashKey);
    }

    @Override
    public Long deleteByKeyAndHashKey(String key, Object... hashKey) {
        return hashOperations.delete(key, hashKey);
    }
}
