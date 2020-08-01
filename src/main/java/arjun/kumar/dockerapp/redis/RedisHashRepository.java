package arjun.kumar.dockerapp.redis;

import java.util.Map;

/** @author Arjun Kumar */

public interface RedisHashRepository extends RedisRepository {

    Map<Object, Object> findRedisCacheByKey(String key);

    Object findRedisCacheByKeyAndHashKey(String key, String hashKey);

    void updateRedisCacheByKey(String key, Map<Object, Object> cacheData);

    void updateRedisCacheByKeyAndHashKey(String key, String hashKey, Object cacheData);

    Boolean addCacheByKeyAndHashKey(String key, String hashKey, Object cacheData);

    Boolean isHashKeyExist(String key, String hashKey);

    Long deleteByKeyAndHashKey(String key, Object... hashKey);

}
