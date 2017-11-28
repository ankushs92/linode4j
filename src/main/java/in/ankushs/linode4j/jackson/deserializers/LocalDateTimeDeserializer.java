package in.ankushs.linode4j.jackson.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ankushsharma on 27/11/17.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException{
        return LocalDateTime.parse(
                jsonParser.getText(),
                DateTimeFormatter.ISO_DATE_TIME
        );
    }
}
