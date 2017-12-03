package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.RunLevelDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Getter
@JsonDeserialize(using = RunLevelDeserializer.class)
public enum RunLevel {

    UNKNOWN("Unknown"),
    DEFAULT("Normal multi-user boot mode"),
    SINGLE("Single user boot mode"),
    BINBASH("Boots to a root bash shell");

    private final String description;

    RunLevel(final String description){
        this.description = description;
    }

    public static RunLevel from(final String code){
        RunLevel result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "default" : result = DEFAULT; break;
                case "single" : result = SINGLE; break;
                case "binbash" : result = BINBASH; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
