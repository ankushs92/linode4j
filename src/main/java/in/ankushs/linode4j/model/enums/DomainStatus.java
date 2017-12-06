package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.DomainStatusDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 07/12/17.
 */
@Getter
@JsonDeserialize(using = DomainStatusDeserializer.class)
public enum DomainStatus {

    UNKNOWN("Unknown"),
    ACTIVE("Turn on serving of this Domain."),
    DISABLED("Turn off serving of this Domain."),
    EDIT_MODE("Use this mode while making edits.");

    private final String description;

    DomainStatus(final String description){
        this.description = description;
    }

    public static DomainStatus from(final String code){
        DomainStatus result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "active" : result = ACTIVE; break;
                case "disabled" : result = DISABLED; break;
                case "edit_mode" : result = EDIT_MODE; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
