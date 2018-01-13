package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.ImageType;

import java.io.IOException;

/**
 * Created by ankushsharma on 11/01/18.
 */
public final class ImageTypeDeserializer extends JsonDeserializer<ImageType> {

    @Override
    public ImageType deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return ImageType.from(jsonParser.getText());
    }
}
