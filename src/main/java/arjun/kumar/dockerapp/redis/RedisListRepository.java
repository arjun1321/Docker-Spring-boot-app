package arjun.kumar.dockerapp.redis;

/** @author Arjun Kumar  */

public interface RedisListRepository {

    Long leftPushByKey(String key, Object cacheData);

}
