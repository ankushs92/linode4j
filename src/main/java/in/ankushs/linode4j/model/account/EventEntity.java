package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("type")
    private final String type;

    @JsonProperty("url")
    private final String url;

}
