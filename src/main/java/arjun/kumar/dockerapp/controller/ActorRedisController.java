package arjun.kumar.dockerapp.controller;

import arjun.kumar.dockerapp.bean.RedisActorCache;
import arjun.kumar.dockerapp.service.ActorRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** @author Arjun Kumar  */

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRedisController {

    private final ActorRedisService actorRedisService;

    @PostMapping("redis/push/actor/{actorId}")
    public ResponseEntity<RedisActorCache> addActorToRedis(@PathVariable(name = "actorId") Long actorId) {
        return ResponseEntity.ok(actorRedisService.addActorToRedis(actorId));
    }

    @GetMapping("redis/pull/actor/{actorId}")
    public ResponseEntity<RedisActorCache> getActorFromRedis(@PathVariable(name = "actorId") Long actorId) {
        return ResponseEntity.ok((actorRedisService.getActorFromRedis(actorId)));
    }
}
