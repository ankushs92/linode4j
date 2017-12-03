package in.ankushs.linode4j.model.linode.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@Builder
public class LinodeRebuildRequest {

    @JsonProperty(value = "distribution", required = true)
    private final String distribution;

    @JsonProperty("image")
    private final Integer image;

    @JsonProperty(value = "root_pass", required = true)
    private final String rootPassword;

    @JsonProperty("authorized_keys")
    private final Set<String> authorizedKeys;

    @JsonProperty("stackscript_id")
    private final Integer stackscriptId;

    @JsonProperty("stackscript_data")
    private final String stackscriptData;

    @JsonProperty("booted")
    private final Boolean booted;

}
