package in.ankushs.linode4j.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.DomainStatus;
import in.ankushs.linode4j.model.enums.DomainType;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 07/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Domain {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("domain")
    private final String domain;

    @JsonProperty("group")
    private final String group;

    @JsonProperty("soa_email")
    private final String soaEmail;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("refresh_sec")
    private final Integer refreshTimeIntervalSeconds;

    @JsonProperty("retry_sec")
    private final Integer retryTimeIntervalSeconds;

    @JsonProperty("expire_sec")
    private final Integer expirationTimeIntervalSeconds;

    @JsonProperty("ttl_sec")
    private final Integer ttlSeconds;

    @JsonProperty("status")
    private final DomainStatus status;

    @JsonProperty("master_ips")
    private final Set<String> masterIps;

    @JsonProperty("axfr_ips")
    private final Set<String> axfrIps;

    @JsonProperty("type")
    private final DomainType type;

}
