package arjun.kumar.dockerapp.dao.repository;

import arjun.kumar.dockerapp.dao.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** @author Arjun Kumar  */

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findByActorId(Long actorId);
}
