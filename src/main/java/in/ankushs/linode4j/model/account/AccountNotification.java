package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountNotification {

    @JsonProperty("when")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime dateTime;

    @JsonProperty("type")
    private final NotificationType type;

    @JsonProperty("entity")
    private final EventEntity entity;


}
