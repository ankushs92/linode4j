package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.PlanDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Getter
@JsonDeserialize(using = PlanDeserializer.class)
public enum Plan {

    UNKNOWN,
    NANODE,
    STANDARD,
    HIGH_MEMORY;

    public static Plan from(final String code){
        Plan result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "nanode" : result = NANODE; break;
                case "standard" : result = STANDARD; break;
                case "highmem" : result = HIGH_MEMORY; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
