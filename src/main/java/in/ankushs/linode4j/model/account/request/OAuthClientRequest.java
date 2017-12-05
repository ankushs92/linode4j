package in.ankushs.linode4j.model.account.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 01/12/17.
 */
@Data
@Builder
public final class OAuthClientRequest {

    @JsonProperty(value = "label", required = true)
    private final String label;

    @JsonProperty(value = "redirect_uri", required = true)
    private final String redirectUri;

    @JsonProperty("public")
    private final Boolean isPublic;

    public static void main(String[] args) {
        OAuthClientRequest.builder()
                .label("a")
                .build();
    }
}
