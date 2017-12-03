package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.EventAction;
import in.ankushs.linode4j.model.enums.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountEvent {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("entity")
    private final EventEntity entity;

    @JsonProperty("action")
    private final EventAction action;

    @JsonProperty("username")
    private final String username;

    @JsonProperty("status")
    private final EventStatus status;

    @JsonProperty("percent_complete")
    private final Integer percentComplete;

    @JsonProperty("rate")
    private final String rate;

    @JsonProperty("time_remaining")
    private final String timeRemaining;

    @JsonProperty("seen")
    private final Boolean hasBeenSeen;

    @JsonProperty("read")
    private final Boolean hasBeenRead;

    @JsonProperty("created")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime created;

    @JsonProperty("updated")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime updated;


}
