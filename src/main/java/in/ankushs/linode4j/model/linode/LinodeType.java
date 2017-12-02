package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.Plan;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinodeType {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("disk")
    private final Integer diskInMb;

    @JsonProperty("class")
    private final Plan plan;

    @JsonProperty("price")
    private final Price price;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("vcpus")
    private final Integer vcpus;

    @JsonProperty("transfer")
    private final Integer transfer;

    @JsonProperty("memory")
    private final Integer ram;

    @JsonProperty("network_out")
    private final Integer outboundBandwidth;

}
