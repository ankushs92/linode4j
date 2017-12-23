package in.ankushs.linode4j.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by Ankush on 17/07/17.
 */
@Slf4j
public final class Json {

    private Json(){}

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static{
        //Omit all fields that have null value
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T toObject(final String json, final Class<T> clazz ) {
        Assert.notNull(clazz, "clazz cannot be null");
        try {
            return objectMapper.readValue(json,clazz);
        }
        catch (final IOException e) {
            log.error("", e);
            return null;
        }
    }

    public static String toJson(final Object object)  {
        Assert.notNull(object, "object cannot be null");

        try {
            return objectMapper.writer().writeValueAsString(object);
        }
        catch (final JsonProcessingException e) {
            log.error("", e);
            return Strings.EMPTY;
        }
    }
}
