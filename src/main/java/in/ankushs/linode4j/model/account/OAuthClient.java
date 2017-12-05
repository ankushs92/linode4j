package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.OAuthClientStatus;
import lombok.Data;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class OAuthClient {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("secret")
    private final String secret;

    @JsonProperty("redirect_uri")
    private final String redirectUri;

    @JsonProperty("status")
    private final OAuthClientStatus status;


}
