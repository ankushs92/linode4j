package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 24/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProfileGrants {

    @JsonProperty("global")
    private final GlobalGrants global;

    @JsonProperty("stackscript")
    private final Set<StackscriptGrant> stackscriptGrants;

    @JsonProperty("nodebalancer")
    private final Set<NodebalancerGrant> nodebalancerGrants;

    @JsonProperty("linode")
    private final Set<LinodeGrant> linodeGrants;

    @JsonProperty("domain")
    private final Set<DomainGrant> domainGrants;

    @JsonProperty("volume")
    private final Set<VolumeGrant> volumeGrants;

    @JsonProperty("image")
    private final Set<ImageGrant> imageGrants;

    @JsonProperty("longview")
    private final Set<LongviewGrant> longviewGrants;


}
