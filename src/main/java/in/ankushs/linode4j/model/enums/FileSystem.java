package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.FileSystemDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Getter
@JsonDeserialize(using = FileSystemDeserializer.class)
public enum FileSystem {

    UNKNOWN("Unknown"),
    RAW("No filesystem, just a raw binary stream"),
    SWAP("Linux swap area"),
    EXT3("The ext3 journaling filesystem for Linux"),
    EXT4("The ext4 journaling filesystem for Linux"),
    INITRD("initrd (uncompressed initrd, ext2, max 32 MB)");

    private final String description;

    FileSystem(final String description){
        this.description = description;
    }

    public static FileSystem from(final String code){
        FileSystem result;
        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "raw" : result = RAW; break;
                case "swap" : result = SWAP; break;
                case "ext3" : result = EXT3; break;
                case "ext4" : result = EXT4; break;
                case "initrd" : result = INITRD; break;
                default : result = UNKNOWN;
            }
        }
        return result;
    }
}
