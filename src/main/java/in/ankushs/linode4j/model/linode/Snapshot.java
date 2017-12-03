package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.LinodeStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Snapshot {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("status")
    private final LinodeStatus status;

    //Should be an enum
    @JsonProperty("type")
    private final String type;

    @JsonProperty("region")
    private final String region;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    @JsonProperty("finished")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime finished;

    @JsonProperty("configs")
    private final Set<String> configs;

    @JsonProperty("disks")
    private final Set<Disk> disks;

    //Should be an enum
    @JsonProperty("availability")
    private final String availability;

}
