package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 22/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Profile {

    @JsonProperty("username")
    private final String username;

    @JsonProperty("email")
    private final String email;

    @JsonProperty("timezone")
    private final String timezone;

    @JsonProperty("email_notifications")
    private final Boolean emailNotifications;



}
