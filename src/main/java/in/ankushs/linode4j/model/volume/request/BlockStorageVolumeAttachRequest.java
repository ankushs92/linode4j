package in.ankushs.linode4j.model.volume.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 17/12/17.
 */
@Data
@Builder
public final class BlockStorageVolumeAttachRequest {

    @JsonProperty(value = "linode_id", required = true)
    private final Integer linodeId;

    @JsonProperty("config_id")
    private final Integer configId;

}
