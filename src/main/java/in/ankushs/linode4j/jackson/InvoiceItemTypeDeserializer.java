package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.InvoiceItemType;

import java.io.IOException;

/**
 * Created by ankushsharma on 30/11/17.
 */
public class InvoiceItemTypeDeserializer extends JsonDeserializer<InvoiceItemType>{

    @Override
    public InvoiceItemType deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return InvoiceItemType.from(jsonParser.getText());
    }
}
