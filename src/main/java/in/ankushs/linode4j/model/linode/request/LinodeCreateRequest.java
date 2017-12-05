package in.ankushs.linode4j.model.linode.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@Builder
public final class LinodeCreateRequest {

    @JsonProperty(value = "region", required = true)
    private final String region;

    @JsonProperty(value = "type", required = true)
    private final String type;

    @JsonProperty(value = "label")
    private final String label;

    @JsonProperty(value = "group")
    private final String group;

    @JsonProperty(value = "distribution")
    private final String distribution;

    @JsonProperty(value = "root_pass")
    private final String rootPass;

    @JsonProperty(value = "authorized_keys")
    private final Set<String> authKeys;

    @JsonProperty(value = "stackscript_id")
    private final Integer stackScriptId;

    @JsonProperty(value = "stackscript_data")
    private final String stackScriptData;

    @JsonProperty(value = "backup_id")
    private final Integer backupId;

    @JsonProperty(value = "image")
    private final Integer image;

    @JsonProperty(value = "backups_enabled", defaultValue = "false")
    private final boolean backupsEnabled;
}
