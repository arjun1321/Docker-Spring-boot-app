package arjun.kumar.dockerapp.bean;

import lombok.Data;

import java.time.LocalDateTime;

/** @author Arjun Kumar  */

@Data
public class ActorResponse {

    private String firstName;

    private String lastName;

    private LocalDateTime lastUpdated;
}
