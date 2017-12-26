package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <a href="https://developers.linode.com/v4/reference/endpoints/profile"> Docs </a>
 * Created by ankushsharma on 22/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Referrals {

    @JsonProperty("code")
    private final String code;

    @JsonProperty("url")
    private final String url;

    @JsonProperty("total")
    private final Integer total;

    @JsonProperty("completed")
    private final Integer completed;

    @JsonProperty("pending")
    private final Integer pending;

    @JsonProperty("credit")
    private final Integer credit;

}
