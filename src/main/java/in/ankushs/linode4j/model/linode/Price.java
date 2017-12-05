package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Price {

    @JsonProperty("hourly")
    private final Float hourly;

    @JsonProperty("monthly")
    private final Float monthly;

}
