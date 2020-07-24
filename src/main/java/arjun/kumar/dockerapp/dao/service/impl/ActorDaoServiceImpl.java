package arjun.kumar.dockerapp.dao.service.impl;

import arjun.kumar.dockerapp.dao.entity.Actor;
import arjun.kumar.dockerapp.dao.repository.ActorRepository;
import arjun.kumar.dockerapp.dao.service.ActorDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Arjun Kumar  */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorDaoServiceImpl implements ActorDaoService {

    private final ActorRepository actorRepository;

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor findByActorId(Long actorId) {
        return actorRepository.findByActorId(actorId);
    }
}
