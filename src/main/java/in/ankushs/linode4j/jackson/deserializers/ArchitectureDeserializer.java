package in.ankushs.linode4j.jackson.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.Architecture;

import java.io.IOException;

/**
 * Created by ankushsharma on 27/11/17.
 */
public class ArchitectureDeserializer extends JsonDeserializer<Architecture> {

    @Override
    public Architecture deserialize(
            final JsonParser jsonParser,
            final DeserializationContext ctxt
    )
    throws IOException
    {
        return Architecture.from(jsonParser.getText());
    }
}
