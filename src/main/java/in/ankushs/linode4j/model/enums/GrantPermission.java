package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.GrantPermissionDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 24/12/17.
 */
@Getter
@JsonDeserialize(using = GrantPermissionDeserializer.class)
public enum GrantPermission {

    UNKNOWN("Unknown"),
    NO_ACCESS("no access"),
    READ_ONLY("access to GET endpoints related to this entity and its subobjects, events related to it, and this entities appearance in listing endpoints."),
    READ_WRITE("access to all endpoints related to this entity, including POST, PUT, and DELETE endpoints for this entity and its subobjects");

    private final String description;

    GrantPermission(final String description){
        this.description = description;
    }

    public static GrantPermission from(final String code){
        GrantPermission result = UNKNOWN;
        if(Strings.hasText(code)){
            switch(code){
                case "null" : result = NO_ACCESS; break;
                case "read_only" : result = READ_ONLY; break;
                case "read_write" : result = READ_WRITE; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
