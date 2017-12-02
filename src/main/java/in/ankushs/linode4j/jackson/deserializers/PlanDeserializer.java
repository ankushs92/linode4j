package in.ankushs.linode4j.jackson.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.Plan;

import java.io.IOException;

/**
 * Created by ankushsharma on 03/12/17.
 */
public class PlanDeserializer extends JsonDeserializer<Plan> {

    @Override
    public Plan deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return Plan.from(jsonParser.getText());
    }
}
