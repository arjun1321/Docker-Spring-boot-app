package arjun.kumar.dockerapp.service;

import arjun.kumar.dockerapp.bean.RedisActorCache;

/** @author Arjun Kumar  */

public interface ActorRedisService {

    RedisActorCache addActorToRedis(Long actorId);

    RedisActorCache getActorFromRedis(Long actorId);
}
