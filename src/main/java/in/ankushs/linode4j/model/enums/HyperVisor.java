package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.deserializers.StatusDeserializer;
import lombok.Getter;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = StatusDeserializer.class)
public enum HyperVisor {

    UNKNOWN("unknown"),
    XEN("xen"),
    KVM("kvm");

    private final String code;

    HyperVisor(final String code){
        this.code = code;
    }

    public static HyperVisor from(final String string){
        HyperVisor result;
        switch(string){
            case "xen" : result = XEN; break;
            case "kvm" : result = KVM; break;
            default : result = UNKNOWN;
        }
        return result;
    }
}
