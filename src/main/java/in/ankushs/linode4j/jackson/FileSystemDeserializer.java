package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.FileSystem;

import java.io.IOException;

/**
 * Created by ankushsharma on 27/11/17.
 */
public final class FileSystemDeserializer extends JsonDeserializer<FileSystem> {

    @Override
    public FileSystem deserialize(final JsonParser jsonParser, final DeserializationContext ctxt)throws IOException{
        return FileSystem.from(jsonParser.getText());
    }

}
