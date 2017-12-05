package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.VirtualizationMode;

import java.io.IOException;

/**
 * Created by ankushsharma on 03/12/17.
 */
public final class VirtualizationModeDeserializer extends JsonDeserializer<VirtualizationMode> {

    @Override
    public VirtualizationMode deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
         return VirtualizationMode.from(jsonParser.getText());
    }
}
