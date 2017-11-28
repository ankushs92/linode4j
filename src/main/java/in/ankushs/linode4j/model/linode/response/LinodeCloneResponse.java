package in.ankushs.linode4j.model.linode.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinodeCloneResponse {

    @JsonProperty("region")
    private final String region;

    @JsonProperty("type")
    private final String type;

}
