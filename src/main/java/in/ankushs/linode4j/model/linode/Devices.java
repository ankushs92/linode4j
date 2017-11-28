package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Builder
public class Devices {

    @JsonProperty("sda")
    private final Sda sda;

    @JsonProperty("sdb")
    private final Sda sdb;

    @JsonProperty("sdc")
    private final Sda sdc;

    @JsonProperty("sdd")
    private final Sda sdd;

    @JsonProperty("sde")
    private final Sda sde;

    @JsonProperty("sdf")
    private final Sda sdf;

    @JsonProperty("sdg")
    private final Sda sdg;

}
