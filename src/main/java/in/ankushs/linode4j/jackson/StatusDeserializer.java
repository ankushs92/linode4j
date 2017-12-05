package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.LinodeStatus;

import java.io.IOException;

/**
 * Created by ankushsharma on 27/11/17.
 */
public final class StatusDeserializer extends JsonDeserializer<LinodeStatus> {

    @Override
    public LinodeStatus deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException{
        return LinodeStatus.from(jsonParser.getText());
    }
}
