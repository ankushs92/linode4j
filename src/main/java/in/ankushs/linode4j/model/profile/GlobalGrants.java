package in.ankushs.linode4j.model.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.GrantPermission;
import lombok.Data;

/**
 * Created by ankushsharma on 24/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class GlobalGrants {

    @JsonProperty("add_linodes")
    private final Boolean addLinodes;

    @JsonProperty("add_nodebalancers")
    private final Boolean addNodebalancers;

    @JsonProperty("add_domains")
    private final Boolean addDomains;

    @JsonProperty("add_longview")
    private final Boolean addLongview;

    @JsonProperty("add_stackscripts")
    private final Boolean addStackscripts;

    @JsonProperty("longview_subscription")
    private final Boolean longviewSubscriptions;

    @JsonProperty("add_images")
    private final Boolean addImages;

    @JsonProperty("add_volumes")
    private final Boolean addVolumes;

    @JsonProperty("cancel_account")
    private final Boolean cancelAccount;

    @JsonProperty("account_access")
    private final GrantPermission accountAccess;

}
