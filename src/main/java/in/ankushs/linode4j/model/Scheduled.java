package in.ankushs.linode4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@Builder
public class Scheduled {

    @JsonProperty("day")
    private final String day;

    @JsonProperty("window")
    private final String window;





}
