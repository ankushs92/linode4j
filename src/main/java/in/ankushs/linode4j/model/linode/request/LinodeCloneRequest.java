package in.ankushs.linode4j.model.linode.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@Builder
public final class LinodeCloneRequest {

    @JsonProperty(value = "region", required = true)
    private final String region;

    @JsonProperty(value = "type", required = true)
    private final String type;

    @JsonProperty(value = "linode_id")
    private final Integer targetLinodeId;

    @JsonProperty(value = "label")
    private final String label;

    @JsonProperty(value = "group")
    private final String group;

    @JsonProperty(value = "backups_enabled")
    private final boolean backupsEnabled;

    @JsonProperty(value = "disks")
    private final Set<String> disks;

    @JsonProperty(value = "configs")
    private final Set<String> configs;
}
