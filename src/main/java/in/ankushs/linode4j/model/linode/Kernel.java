package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.Architecture;
import lombok.Data;

/**
 * Created by ankushsharma on 07/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Kernel {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("xen")
    private final Boolean isSuitableForXen;

    @JsonProperty("kvm")
    private final Boolean isSuitableForKvm;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("version")
    private final String version;

    @JsonProperty("architecture")
    private final Architecture architecture;

    @JsonProperty("pvops")
    private final Boolean isSuitableForParaVirtualizedOps;

}
