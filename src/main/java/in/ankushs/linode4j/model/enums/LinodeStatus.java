package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.StatusDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = StatusDeserializer.class)
public enum LinodeStatus {

    UNKNOWN("Unknown status"),
    OFFLINE("The Linode is powered off"),
    BOOTING("The Linode is currently booting up."),
    RUNNING("The Linode is currently running."),
    SHUTTING_DOWN("The Linode is currently shutting down."),
    REBOOTING("The Linode is rebooting."),
    PROVISIONING("The Linode is being created"),
    DELETING("The Linode is being deleted."),
    MIGRATING("The Linode is being migrated to a new host/region.");

    private final String description;

    LinodeStatus(final String description){
        this.description = description;
    }

    public static LinodeStatus from(final String code){
        LinodeStatus result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "offline" : result = OFFLINE; break;
                case "booting" : result = BOOTING; break;
                case "running" : result = RUNNING; break;
                case "shutting_down" : result = SHUTTING_DOWN; break;
                case "rebooting" : result = REBOOTING; break;
                case "provisioning" : result = PROVISIONING; break;
                case "deleting" : result = DELETING; break;
                case "migrating" : result = MIGRATING; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}