package arjun.kumar.dockerapp.dao.service;

import arjun.kumar.dockerapp.dao.entity.Actor;

/** @author Arjun Kumar  */


public interface ActorDaoService {

    Actor save(Actor actor);

    Actor findByActorId(Long actorId);
}
