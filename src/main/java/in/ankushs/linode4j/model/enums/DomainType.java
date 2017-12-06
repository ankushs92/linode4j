package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.DomainTypeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 07/12/17.
 */
@Getter
@JsonDeserialize(using = DomainTypeDeserializer.class)
public enum DomainType {

    UNKNOWN("Unknown"),
    MASTER("A primary, authoritative Domain"),
    SLAVE("A secondary Domain which gets its updates from a master Domain.");

    private final String description;

    DomainType(final String description){
        this.description = description;
    }

    public static DomainType from(final String code){
        DomainType result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "master" : result = MASTER; break;
                case "slave" : result = SLAVE; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }

}
