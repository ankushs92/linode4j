package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastBackup {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("status")
    private final Status status;

    @JsonProperty("region")
    private final String region;

    @JsonProperty("created")
    private final LocalDateTime created;

    @JsonProperty("updated")
    private final LocalDateTime updated;

    @JsonProperty("finished")
    private final LocalDateTime finished;

    @JsonProperty("configs")
    private final Set<String> configs;

    @JsonProperty("disks")
    private final Set<Disk> disks;

    //Should be an enum
    @JsonProperty("availability")
    private final String availability;

}
