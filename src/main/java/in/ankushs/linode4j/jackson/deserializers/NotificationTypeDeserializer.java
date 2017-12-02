package in.ankushs.linode4j.jackson.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.NotificationType;

import java.io.IOException;

/**
 * Created by ankushsharma on 30/11/17.
 */
public class NotificationTypeDeserializer extends JsonDeserializer<NotificationType>{

    @Override
    public NotificationType deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return NotificationType.from(jsonParser.getText());
    }
}
