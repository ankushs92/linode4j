package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.OAuthScope;

import java.io.IOException;

/**
 *
 * Created by ankushsharma on 08/01/18.
 */
public final class OAuthScopeDeserializer extends JsonDeserializer<OAuthScope> {

    @Override
    public OAuthScope deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        // Currently, the API returns scopes as a comma separated string.
        // For example, we can get value : linodes:view,volumes:view,stackscript:modify etc
        return OAuthScope.from(jsonParser.getText());
    }
}
