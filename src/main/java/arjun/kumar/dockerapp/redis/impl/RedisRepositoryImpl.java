package arjun.kumar.dockerapp.redis.impl;

import arjun.kumar.dockerapp.redis.RedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/** @author Arjun Kumar  */

@Repository
public abstract class RedisRepositoryImpl implements RedisRepository {

    protected abstract RedisTemplate<String, Object> getRedisTemplate();

    @Override
    public Boolean deleteByKey(String key) {
        return getRedisTemplate().delete(key);
    }
}
