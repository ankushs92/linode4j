package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.Architecture;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Distribution {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("disk_minimum")
    private final Integer minimumDisk;

    @JsonProperty("deprecated")
    private final Boolean deprecated;

    @JsonProperty("vendor")
    private final String vendor;

    @JsonProperty("architecture")
    private final Architecture architecture;

}
