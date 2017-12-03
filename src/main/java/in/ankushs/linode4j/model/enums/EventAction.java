package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.EventActionDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Getter
@JsonDeserialize(using = EventActionDeserializer.class)
public enum EventAction {

    UNKNOWN,
    LINODE_BOOT,
    LINODE_CREATE,
    LINODE_DELETE,
    LINODE_SHUTDOWN,
    LINODE_REBOOT,
    LINODE_SNAPSHOT,
    LINODE_ADDIP,
    LINODE_MIGRATE,
    LINODE_REBUILD,
    LINODE_CLONE,
    LINODE_KVMIFY,
    DISK_CREATE,
    DISK_DELETE,
    DISK_DUPLICATE,
    DISK_RESIZE,
    BACKUPS_ENABLE,
    BACKUPS_CANCEL,
    BACKUPS_RESTORE,
    PASSWORD_RESET,
    DOMAIN_CREATE,
    DOMAIN_DELETE,
    DOMAIN_RECORD_CREATE,
    DOMAIN_RECORD_DELETE,
    STACKSCRIPT_CREATE,
    STACKSCRIPT_PUBLICIZE,
    STACKSCRIPT_REVISE,
    STACKSCRIPT_DELETE;

    public static EventAction from(final String code){
        EventAction result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "linode_boot" : result = LINODE_BOOT; break;
                case "linode_create" : result = LINODE_CREATE; break;
                case "linode_delete" : result = LINODE_DELETE; break;
                case "linode_shutdown" : result = LINODE_SHUTDOWN; break;
                case "linode_reboot" : result = LINODE_REBOOT; break;
                case "linode_snapshot" : result = LINODE_SNAPSHOT; break;
                case "linode_addip" : result = LINODE_ADDIP; break;
                case "linode_migrate" : result = LINODE_MIGRATE; break;
                case "linode_rebuild" : result = LINODE_REBUILD; break;
                case "linode_clone" : result = LINODE_CLONE; break;
                case "linode_kvmify" : result = LINODE_KVMIFY; break;
                case "disk_create" : result = DISK_CREATE; break;
                case "disk_delete" : result = DISK_DELETE; break;
                case "disk_duplicate" : result = DISK_DUPLICATE; break;
                case "disk_resize" : result = DISK_RESIZE; break;
                case "backups_enable" : result = BACKUPS_ENABLE; break;
                case "backups_cancel" : result = BACKUPS_CANCEL; break;
                case "backups_restore" : result = BACKUPS_RESTORE; break;
                case "password_reset" : result = PASSWORD_RESET; break;
                case "domain_create" : result = DOMAIN_CREATE; break;
                case "domain_delete" : result = DOMAIN_DELETE; break;
                case "domain_record_create" : result = DOMAIN_RECORD_CREATE; break;
                case "stackscript_create" : result = STACKSCRIPT_CREATE; break;
                case "stackscript_publicize" : result = STACKSCRIPT_PUBLICIZE; break;
                case "stackscript_revise" : result = STACKSCRIPT_REVISE; break;
                case "stackscript_delete" : result = STACKSCRIPT_DELETE; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
