package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.FileSystem;
import in.ankushs.linode4j.model.enums.LinodeStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Disk {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("status")
    private final LinodeStatus status;

    @JsonProperty("size")
    private final Integer size;

    @JsonProperty("filesystem")
    private final FileSystem fileSystem;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

}
