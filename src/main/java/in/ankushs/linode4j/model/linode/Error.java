package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    @JsonProperty("field")
    private final String field;

    @JsonProperty("reason")
    private final String reason;

}
