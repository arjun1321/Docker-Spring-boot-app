package arjun.kumar.dockerapp.redis.impl;

import arjun.kumar.dockerapp.redis.RedisListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/** @author Arjun Kumar  */

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisListRepositoryImpl extends RedisRepositoryImpl implements RedisListRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private ListOperations listOperations;

    @PostConstruct
    private void init() {
        listOperations = redisTemplate.opsForList();
    }

    @Override
    protected RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    @Override
    public Long leftPushByKey(String key, Object cacheData) {
        return listOperations.leftPush(key, cacheData);
    }
}
