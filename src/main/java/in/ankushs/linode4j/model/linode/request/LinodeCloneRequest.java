package in.ankushs.linode4j.model.linode.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Set;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Builder
public class LinodeCloneRequest {

    @JsonProperty(value = "region", required = true)
    private final String region;

    @JsonProperty(value = "type", required = true)
    private final String type;

    @JsonProperty(value = "region")
    private final Integer linodeId;

    @JsonProperty(value = "label")
    private final String label;

    @JsonProperty(value = "group")
    private final String group;

    @JsonProperty(value = "backups_enabled")
    private final Boolean backupsEnabled;

    @JsonProperty(value = "disks")
    private final Set<String> disks;

    @JsonProperty(value = "configs")
    private final Set<String> configs;
}
