package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.LishAuthMethod;

import java.io.IOException;

/**
 * Created by ankushsharma on 24/12/17.
 */
public class LishAuthMethodDeserializer extends JsonDeserializer<LishAuthMethod> {

    @Override
    public LishAuthMethod deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LishAuthMethod.from(jsonParser.getText());
    }

}
