package in.ankushs.linode4j.model.enums;

import lombok.Getter;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Getter
public enum Status {

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

}