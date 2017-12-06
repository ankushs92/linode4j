package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.DomainStatus;

import java.io.IOException;

/**
 * Created by ankushsharma on 07/12/17.
 */
public class DomainStatusDeserializer extends JsonDeserializer<DomainStatus> {

    @Override
    public DomainStatus deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return DomainStatus.from(jsonParser.getText());
    }

}
