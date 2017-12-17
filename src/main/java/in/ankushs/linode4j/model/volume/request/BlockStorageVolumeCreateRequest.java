package in.ankushs.linode4j.model.volume.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 17/12/17.
 */
@Data
@Builder
public final class BlockStorageVolumeCreateRequest {

    @JsonProperty(value = "label", required = true)
    private final String label;

    @JsonProperty(value = "region", required = true)
    private final String region;

    @JsonProperty("size")
    private final Integer size;

    @JsonProperty("linode_id")
    private final Integer linodeId;

    @JsonProperty("config_id")
    private final Integer configId;

}
