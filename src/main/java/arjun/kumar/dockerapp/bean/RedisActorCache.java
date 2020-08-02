package arjun.kumar.dockerapp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** @author Arjun Kumar  */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedisActorCache {

    private String firstName;

    private String lastName;

}
