package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.RunLevel;

import java.io.IOException;

/**
 * Created by ankushsharma on 03/12/17.
 */
public class RunLevelDeserializer extends JsonDeserializer<RunLevel> {

    @Override
    public RunLevel deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return RunLevel.from(jsonParser.getText());
    }

}
