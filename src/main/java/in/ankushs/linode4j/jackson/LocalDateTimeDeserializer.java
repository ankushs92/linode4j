package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.val;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ankushsharma on 27/11/17.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException{
        val text = jsonParser.getText();
        LocalDateTime result = null;
        if(Strings.hasText(text)){
            result =  LocalDateTime.parse(
                    jsonParser.getText(),
                    DateTimeFormatter.ISO_DATE_TIME
            );
        }
        return result;
    }
}
