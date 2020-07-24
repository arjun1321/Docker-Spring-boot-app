package arjun.kumar.dockerapp.service.impl;

import arjun.kumar.dockerapp.bean.ActorRequest;
import arjun.kumar.dockerapp.bean.ActorResponse;
import arjun.kumar.dockerapp.dao.entity.Actor;
import arjun.kumar.dockerapp.dao.service.ActorDaoService;
import arjun.kumar.dockerapp.helper.ActorHelper;
import arjun.kumar.dockerapp.service.ActorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/** @author Arjun Kumar  */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorServiceImpl implements ActorService {

    private final ActorDaoService actorDaoService;

    private final ActorHelper actorHelper;

    @Override
    public ActorResponse createActor(ActorRequest actorRequest) {
        log.info("createActor called with actorRequest {}", actorRequest);

        Actor actor = new Actor();
        actor.setFirstName(actorRequest.getFirstName());
        actor.setLastName(actorRequest.getLastName());
        actor.setLastUpdate(LocalDateTime.now());
        actor = actorDaoService.save(actor);

        return actorHelper.getActorResponse(actor);
    }

    @Override
    public ActorResponse getActor(Long actorId) {
        log.info("getActor called with actorId {}", actorId);
        Actor actor = actorDaoService.findByActorId(actorId);
        return actorHelper.getActorResponse(actor);
    }
}
