package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.model.enums.LishAuthMethod;
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

    @JsonProperty("referrals")
    private final Referrals referrals;

    @JsonProperty("ip_whitelist_enabled")
    private final Boolean ipWhitelistEnabled;

    @JsonProperty("authorized_keys")
    private final String authorizedKeys;

    @JsonProperty("two_factor_auth")
    private final Boolean twoFactorAuthEnabled;

    @JsonProperty("restricted")
    private final Boolean isUserRestricted;

    @JsonProperty("lish_auth_method")
    private final LishAuthMethod lishAuthMethod;
}
