package arjun.kumar.dockerapp.helper;

import arjun.kumar.dockerapp.bean.ActorResponse;
import arjun.kumar.dockerapp.dao.entity.Actor;
import org.springframework.stereotype.Component;

/** @author Arjun Kumar  */

@Component
public class ActorHelper {

    public ActorResponse getActorResponse(Actor actor) {
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setFirstName(actor.getFirstName());
        actorResponse.setLastName(actor.getLastName());
        actorResponse.setLastUpdated(actor.getLastUpdate());
        return actorResponse;
    }
}
