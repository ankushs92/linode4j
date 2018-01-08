package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.TokenTypeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 08/01/18.
 */
@Getter
@JsonDeserialize(using = TokenTypeDeserializer.class)
public enum TokenType {

    UNKNOWN,
    CLIENT_TOKEN,
    PERSONAL_ACCESS_TOKEN;

    public static TokenType from(final String code){
        TokenType result = UNKNOWN;
        if(Strings.hasText(code)){
            switch(code){
                case "client_token" : result = CLIENT_TOKEN; break;
                case "personal_access_token" : result = PERSONAL_ACCESS_TOKEN; break;
                default : result = UNKNOWN; break;

            }
        }
        return result;
    }
}
