package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.account.OAuthClient;
import in.ankushs.linode4j.model.enums.TokenType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 01/01/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProfileToken {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("client")
    private final OAuthClient oAuthClient ;

    @JsonProperty("type")
    private final TokenType type;

    @JsonProperty("scopes")
    private final String scopes;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("expiry")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime expiry;

    //The OAuth Token that you can use in API requests. Except for the inital creation of the token, this field is truncated to 16 characters.
    @JsonProperty("token")
    private final String token;

}
