package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @JsonProperty("hourly")
    private final Float hourly;

    @JsonProperty("monthly")
    private final Float monthly;

}
