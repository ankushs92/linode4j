package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.EventStatus;

import java.io.IOException;

/**
 * Created by ankushsharma on 03/12/17.
 */
public class EventStatusDeserializer extends JsonDeserializer<EventStatus>{
    @Override
    public EventStatus deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return EventStatus.from(jsonParser.getText());
    }
}
