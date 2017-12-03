package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.OAuthClientStatusDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Getter
@JsonDeserialize(using = OAuthClientStatusDeserializer.class)
public enum OAuthClientStatus {

    UNKNOWN("Unknown"),
    ACTIVE("The client application is active and accepting OAuth logins."),
    SUSPENDED("The client application is not accepting OAuth logins.");

    private final String description;

    OAuthClientStatus(final String description){
        this.description = description;
    }

    public static OAuthClientStatus from(final String code){
        OAuthClientStatus result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "active" : result = ACTIVE; break;
                case "suspended" : result = SUSPENDED; break;
                default : result = UNKNOWN; break;
            }
        }

        return result;
    }
}
