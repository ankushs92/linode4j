package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.BlockStorageVolumeStatus;

import java.io.IOException;

/**
 * Created by ankushsharma on 29/11/17.
 */
public final class BlockStorageVolumeStatusDeserializer extends JsonDeserializer<BlockStorageVolumeStatus> {

    @Override
    public BlockStorageVolumeStatus deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        return BlockStorageVolumeStatus.from(jsonParser.getText());
    }

}
