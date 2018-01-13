package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.ImageTypeDeserializer;
import in.ankushs.linode4j.util.Strings;

/**
 * Created by ankushsharma on 11/01/18.
 */
@JsonDeserialize(using = ImageTypeDeserializer.class)
public enum ImageType {

    UNKNOWN,
    MANUAL,
    AUTOMATIC;

    public static ImageType from(final String code){
        ImageType result = UNKNOWN;
        if(Strings.hasText(code)){
            switch(code){
                case "manual" : result = MANUAL; break;
                case "automatic" : result = AUTOMATIC; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }

}
