package in.ankushs.linode4j.model.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("description")
    private final String description;

    //NOTE : This should be an enum. Linode's documentation is missing these enum types.
    @JsonProperty("status")
    private final String status;

    @JsonProperty("filesystem")
    private final String filesystem;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    //NOTE : This should be an enum. Linode's documentation is missing these enum types.
    @JsonProperty("type")
    private final String type;

    @JsonProperty("is_public")
    private final Boolean isPublic;

    @JsonProperty("last_used")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime lastUsed;

}
