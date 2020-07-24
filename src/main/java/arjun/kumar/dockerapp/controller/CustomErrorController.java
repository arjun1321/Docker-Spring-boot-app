package arjun.kumar.dockerapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Arjun Kumar  */

@RestController
public class CustomErrorController implements ErrorController {

    @GetMapping("error")
    public ResponseEntity<String> error() {
        return ResponseEntity.ok("Please enter valid url!");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
