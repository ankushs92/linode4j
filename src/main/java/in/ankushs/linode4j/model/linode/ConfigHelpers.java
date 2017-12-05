package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ConfigHelpers {

    @JsonProperty("updatedb_disabled")
    private final Boolean isDbUpdateDisabled;

    @JsonProperty("distro")
    private final Boolean distro;

    @JsonProperty("modules_dep")
    private final Boolean modulesDependencies;

    @JsonProperty("network")
    private final Boolean network;

    @JsonProperty("devtmpfs_automount")
    private final Boolean devtmpfsAutomount;

}
