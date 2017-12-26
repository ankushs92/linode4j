package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.InvoiceItemTypeDeserializer;
import in.ankushs.linode4j.jackson.LishAuthMethodDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Data;
import lombok.Getter;

/**
 * Created by ankushsharma on 24/12/17.
 */
@Getter
@JsonDeserialize(using = LishAuthMethodDeserializer.class)
public enum LishAuthMethod {

    UNKNOWN("Unknown"),
    PASSWORD_KEYS("Allow both password and key authentication"),
    KEYS_ONLY("Allow key authentication only"),
    DISABLED("Disable Lish");

    private final String description;

    LishAuthMethod(final String description){
        this.description = description;
    }

    public static LishAuthMethod from(final String code){
        LishAuthMethod result = UNKNOWN;
        if(Strings.hasText(code)){
            switch(code){
                case "password_keys" : result = PASSWORD_KEYS; break;
                case "keys_only" : result = KEYS_ONLY; break;
                case "disabled" : result = DISABLED; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
