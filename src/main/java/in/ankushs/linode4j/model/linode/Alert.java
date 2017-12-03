package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alert {

    @JsonProperty(value = "cpu")
    private final Integer cpu;

    @JsonProperty(value = "io")
    private final Integer io;

    @JsonProperty(value = "network_in")
    private final Integer networkIn;

    @JsonProperty(value = "network_out")
    private final Integer networkOut;

    @JsonProperty(value = "transfer_quota")
    private final Integer transferQuota;

}
