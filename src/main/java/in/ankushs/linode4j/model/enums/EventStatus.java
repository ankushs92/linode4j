package in.ankushs.linode4j.model.enums;

import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Getter
public enum EventStatus {

    UNKNOWN("Unknown event"),
    SCHEDULED("Event has not yet started."),
    STARTED("Event is in progress."),
    FINISHED("Event is completed."),
    FAILED("Something went wrong."),
    NOTIFICATION("Stateless event.");

    private final String description;

    EventStatus(final String description){
        this.description = description;
    }

    public static EventStatus from(final String code){
        EventStatus result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "scheduled" : result = SCHEDULED; break;
                case "started" : result = STARTED; break;
                case "finished" : result = FINISHED; break;
                case "failed" : result = FAILED; break;
                case "notification" : result = NOTIFICATION; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
