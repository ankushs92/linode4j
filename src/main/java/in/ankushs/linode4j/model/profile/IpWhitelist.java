package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 13/01/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class IpWhitelist {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("address")
    private final String address;

    @JsonProperty("netmask")
    private final String netmask;

    @JsonProperty("note")
    private final String note;

}
