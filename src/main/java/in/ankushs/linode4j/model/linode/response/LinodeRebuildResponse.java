package in.ankushs.linode4j.model.linode.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.linode.Disk;
import in.ankushs.linode4j.model.linode.LinodeConfig;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinodeRebuildResponse {

    @JsonProperty("configs")
    private final Set<LinodeConfig> configs;

    @JsonProperty("disks")
    private final Set<Disk> disk;
}
