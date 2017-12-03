package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.ArchitectureDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Getter
@JsonDeserialize(using = ArchitectureDeserializer.class)
public enum Architecture {
    UNKNOWN("Unknown"),
    X86_64("64 bit distribution"),
    i386("32 bit distribution");

    private final String description;

    Architecture(final String description){
        this.description = description;
    }

    public static Architecture from(final String code){
        Architecture result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "x86_64" : result = X86_64; break;
                case "i386" : result = i386; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }

}
