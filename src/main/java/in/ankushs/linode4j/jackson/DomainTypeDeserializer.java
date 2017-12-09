package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.DomainType;

import java.io.IOException;

/**
 * Created by ankushsharma on 07/12/17.
 */
public class DomainTypeDeserializer extends JsonDeserializer<DomainType> {

    @Override
    public DomainType deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return DomainType.from(jsonParser.getText());
    }

}
