package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Invoice {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("overdue")
    private final Boolean overdue;

    @JsonProperty("paid")
    private final Boolean paid;

    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime dateTime;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("total")
    private final Double total;

}
