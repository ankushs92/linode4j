package in.ankushs.linode4j.model.managed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 21/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Phone {

    @JsonProperty("primary")
    private final String primary;

    @JsonProperty("secondary")
    private final String secondary;

}
