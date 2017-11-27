package in.ankushs.linode4j.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by Ankush on 17/07/17.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Json {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static{
        //Omit all fields that have null value
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T toObject(final String json, final Class<T> clazz ) throws Exception {
        PreConditions.notNull(clazz, "clazz cannot be null");
        return objectMapper
                   .readValue(json,clazz);
    }

    public static String toJson(final Object object) throws Exception {
        PreConditions.notNull(object, "object cannot be null");
        return objectMapper
                .writer()
                .writeValueAsString(object);
    }

    public static String toPrettyJson(final Object object) throws Exception {
        PreConditions.notNull(object, "object cannot be null");
        return objectMapper
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(object);
    }

}
