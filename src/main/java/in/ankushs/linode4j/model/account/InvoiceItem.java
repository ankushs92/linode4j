package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.LocalDateTimeDeserializer;
import in.ankushs.linode4j.model.enums.InvoiceItemType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InvoiceItem {

    @JsonProperty("to")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime startedOn;

    @JsonProperty("from")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime endedOn;

    @JsonProperty("type")
    private final InvoiceItemType type;

    @JsonProperty("amount")
    private final Integer amount;

    @JsonProperty("unitprice")
    private final Integer unitPrice;

    @JsonProperty("quantity")
    private final Integer quantity;

    @JsonProperty("label")
    private final String label;

}
