package arjun.kumar.dockerapp.service;

import arjun.kumar.dockerapp.bean.ActorResponse;

/** @author Arjun Kumar  */

public interface ActorRedisService {

    ActorResponse addActorToRedis(Long actorId);

    ActorResponse getActorFromRedis(Long actorId);
}
