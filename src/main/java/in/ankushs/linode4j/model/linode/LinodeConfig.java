package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.RunLevel;
import in.ankushs.linode4j.model.enums.VirtualizationMode;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class LinodeConfig {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("comments")
    private final String comments;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime createdAt;

    @JsonProperty("devices")
    private final Devices devices;

    @JsonProperty("helpers")
    private final ConfigHelpers helpers;

    @JsonProperty("initrd")
    private final Integer initrd;

    @JsonProperty("kernel")
    private final String kernel;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("memory_limit")
    private final Integer memoryLimit;

    @JsonProperty("root_device")
    private final String rootDevice;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updatedAt;

    @JsonProperty("run_level")
    private final RunLevel runLevel;

    @JsonProperty("virt_mode")
    private final VirtualizationMode virtualizationMode;
}
