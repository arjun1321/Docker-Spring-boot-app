package arjun.kumar.dockerapp.service.impl;

import arjun.kumar.dockerapp.bean.ActorResponse;
import arjun.kumar.dockerapp.constant.RedisConstant;
import arjun.kumar.dockerapp.redis.RedisHashRepository;
import arjun.kumar.dockerapp.service.ActorRedisService;
import arjun.kumar.dockerapp.service.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Arjun Kumar  */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRedisServiceImpl implements ActorRedisService {

    private final ActorService actorService;

    private final RedisHashRepository redisHashRepository;

    @Override
    public ActorResponse addActorToRedis(Long actorId) {
        log.info("addActorToRedis called with actorId {}", actorId);
        ActorResponse actorResponse = actorService.getActor(actorId);
        redisHashRepository.updateRedisCacheByKeyAndHashKey(RedisConstant.REDIS_ACTOR_KEY, String.valueOf(actorId), actorResponse);
        return actorResponse;
    }

    @Override
    public ActorResponse getActorFromRedis(Long actorId) {
        log.info("getActorFromRedis called with actorId {}", actorId);
        Object redisHashObject = redisHashRepository.findRedisCacheByKeyAndHashKey(RedisConstant.REDIS_ACTOR_KEY, String.valueOf(actorId));

        ObjectMapper objectMapper = new ObjectMapper();
        ActorResponse actorResponse = objectMapper.convertValue(redisHashObject, ActorResponse.class);
        return actorResponse;
    }
}
