package in.ankushs.linode4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@Builder
public class LinodeAlert {

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
