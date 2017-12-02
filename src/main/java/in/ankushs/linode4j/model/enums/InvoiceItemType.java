package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.InvoiceItemTypeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Getter
@JsonDeserialize(using = InvoiceItemTypeDeserializer.class)
public enum InvoiceItemType {

    UNKNOWN("Unknown"),
    PREPAY("The invoice was pre-paid."),
    MISC("The invoice was not pre-paid.");

    private final String description;

    InvoiceItemType(final String description){
        this.description = description;
    }

    public static InvoiceItemType from(final String code){
        InvoiceItemType result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "prepay" : result = PREPAY; break;
                case "misc" : result = MISC; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
