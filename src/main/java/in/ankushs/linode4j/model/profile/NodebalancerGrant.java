package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.GrantPermission;
import in.ankushs.linode4j.model.interfaces.IndividualGrant;
import lombok.Data;

/**
 * Created by ankushsharma on 01/01/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodebalancerGrant implements IndividualGrant {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("permissions")
    private final GrantPermission permissions;

}
