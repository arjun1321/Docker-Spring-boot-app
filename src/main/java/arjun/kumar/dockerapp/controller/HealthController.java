package arjun.kumar.dockerapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/** @author Arjun Kumar  */

@RequestMapping("public")
@RestController
public class HealthController {

    private LocalDateTime versionDateTime = LocalDateTime.now();

    @GetMapping("health")
    public ResponseEntity<String> checkServiceHealth() {
        return ResponseEntity.ok("Service is up!");
    }

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok(versionDateTime.toString());
    }
}
