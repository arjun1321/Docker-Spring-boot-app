package arjun.kumar.dockerapp.controller;

import arjun.kumar.dockerapp.bean.ActorRequest;
import arjun.kumar.dockerapp.bean.ActorResponse;
import arjun.kumar.dockerapp.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** @author Arjun Kumar  */

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorController {

    private final ActorService actorService;

    @PostMapping("actor")
    ResponseEntity<ActorResponse> createActor(@RequestBody ActorRequest actorRequest) {
        return ResponseEntity.ok(actorService.createActor(actorRequest));
    }

    @GetMapping("actor/{actorId}")
    ResponseEntity<ActorResponse> getActor(@PathVariable(name = "actorId") Long actorId) {
        return ResponseEntity.ok(actorService.getActor(actorId));
    }
}
