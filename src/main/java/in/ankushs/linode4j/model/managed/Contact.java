package in.ankushs.linode4j.model.managed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 21/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Contact {

    @JsonProperty("id")
    private final Integer id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("email")
    private final String email;

    @JsonProperty("group")
    private final String group;

    @JsonProperty("phone")
    private final Phone phone;

}
