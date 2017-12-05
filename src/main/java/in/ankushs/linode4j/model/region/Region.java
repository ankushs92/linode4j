package in.ankushs.linode4j.model.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Region {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("country")
    private final String country;

}
