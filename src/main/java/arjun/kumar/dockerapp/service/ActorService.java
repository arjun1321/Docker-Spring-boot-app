package arjun.kumar.dockerapp.service;

import arjun.kumar.dockerapp.bean.ActorRequest;
import arjun.kumar.dockerapp.bean.ActorResponse;

/** @author Arjun Kumar  */

public interface ActorService {

    ActorResponse createActor(ActorRequest actorRequest);

    ActorResponse getActor(Long actorId);
}
