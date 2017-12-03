package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.VirtualizationModeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Getter
@JsonDeserialize(using = VirtualizationModeDeserializer.class)
public enum VirtualizationMode {

    UNKNOWN("Unknown"),
    FULL_VIRTUALIZATION("Complete system virtualization"),
    PARA_VIRTUALIZATION("Some hardware is unvirtualized; often faster than fullvirt");

    private final String description;

    VirtualizationMode(final String description){
        this.description = description;
    }

    public static VirtualizationMode from(final String code){
        VirtualizationMode result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "fullvirt" : result = FULL_VIRTUALIZATION; break;
                case "paravirt" : result = PARA_VIRTUALIZATION; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
