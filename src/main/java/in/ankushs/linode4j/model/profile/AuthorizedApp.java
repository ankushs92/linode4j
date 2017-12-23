package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 22/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AuthorizedApp {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("thumbnailUrl")
    private final String thumbnailUrl;

    @JsonProperty("scopes")
    private final String scopes;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime createdOn;

    @JsonProperty("expiry")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime expiresOn;

    @JsonProperty("website")
    private final String website;

}
