package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.BlockStorageVolumeStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockStorageVolume {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("status")
    private final BlockStorageVolumeStatus status;

    @JsonProperty("size")
    private final Integer size;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    @JsonProperty("region")
    private final String region;

    @JsonProperty("linode_id")
    private final Integer linodeId;


}
