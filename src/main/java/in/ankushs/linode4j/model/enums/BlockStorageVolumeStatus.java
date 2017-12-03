package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.BlockStorageVolumeStatusDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Getter
@JsonDeserialize(using = BlockStorageVolumeStatusDeserializer.class)
public enum BlockStorageVolumeStatus {

    UNKNOWN,
    CREATING,
    ACTIVE,
    RESIZING,
    OFFLINE;

    public static BlockStorageVolumeStatus from(final String code){
        BlockStorageVolumeStatus result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "creating" : result = CREATING; break;
                case "active" : result = ACTIVE; break;
                case "resizing" : result = RESIZING; break;
                case "offline" : result = OFFLINE; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
