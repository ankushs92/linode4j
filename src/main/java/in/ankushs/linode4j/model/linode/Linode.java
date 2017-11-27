package in.ankushs.linode4j.model.linode;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.HyperVisor;
import in.ankushs.linode4j.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Linode  {

    @JsonProperty("alerts")
    private final Set<Alert> alerts;

    @JsonProperty("backups")
    private final Set<Backup> backups;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("region")
    private final String region;

    @JsonProperty("distribution")
    private final String distribution;

    @JsonProperty("display")
    private final String displayGroup;

    @JsonProperty("ipv4")
    private final Set<String> ipv4Addresses;

    @JsonProperty("ipv6")
    private final String ipv6Address;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("type")
    private final String slug;

    @JsonProperty("status")
    private final Status status;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;

    @JsonProperty("hypervisor")
    private final HyperVisor hyperVisor;

    @JsonProperty("specs")
    private final Specification specification;

}
