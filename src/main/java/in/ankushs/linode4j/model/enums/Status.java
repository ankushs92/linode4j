package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.StatusDeserializer;
import lombok.Getter;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = StatusDeserializer.class)
public enum Status {

    UNKNOWN("unknown","Unknown status"),
    OFFLINE("offline","The Linode is powered off"),
    BOOTING("booting","The Linode is currently booting up."),
    RUNNING("running","The Linode is currently running."),
    SHUTTING_DOWN( "shutting_down","The Linode is currently shutting down."),
    REBOOTING("rebooting","The Linode is rebooting."),
    PROVISIONING("provisioning","The Linode is being created"),
    DELETING("deleting","The Linode is being deleted."),
    MIGRATING("migrating","The Linode is being migrated to a new host/region.");

    private final String code;
    private final String description;

    Status(
            final String code,
            final String description
    )
    {
        this.code = code;
        this.description = description;
    }

    public static Status from(final String string){
        Status result;
        switch(string){
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
        return result;
    }
}