package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Specification {

    @JsonProperty("disk")
    private final Integer disk;

    @JsonProperty("memory")
    private final Integer memory;

    @JsonProperty("vcpus")
    private final Integer vcpus;

    @JsonProperty("transfer")
    private final Integer transfer;

}
