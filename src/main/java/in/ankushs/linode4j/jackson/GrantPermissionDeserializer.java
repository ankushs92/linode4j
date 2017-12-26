package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.GrantPermission;

import java.io.IOException;

/**
 * Created by ankushsharma on 24/12/17.
 */
public final class GrantPermissionDeserializer extends JsonDeserializer<GrantPermission> {

    @Override
    public GrantPermission deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return GrantPermission.from(jsonParser.getText());
    }

}
