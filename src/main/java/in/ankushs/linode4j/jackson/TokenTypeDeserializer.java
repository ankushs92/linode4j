package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.TokenType;

import java.io.IOException;

/**
 * Created by ankushsharma on 08/01/18.
 */
public final class TokenTypeDeserializer extends JsonDeserializer<TokenType> {

    @Override
    public TokenType deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return TokenType.from(jsonParser.getText());
    }

}
