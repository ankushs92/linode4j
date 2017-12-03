package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.OAuthClientStatus;

import java.io.IOException;

/**
 * Created by ankushsharma on 30/11/17.
 */
public class OAuthClientStatusDeserializer extends JsonDeserializer<OAuthClientStatus> {

    @Override
    public OAuthClientStatus deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return OAuthClientStatus.from(jsonParser.getText());
    }

}
