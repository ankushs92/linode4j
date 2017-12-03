package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scheduled {

    @JsonProperty("day")
    private final String day;

    @JsonProperty("window")
    private final String window;

}
