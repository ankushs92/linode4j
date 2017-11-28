package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.LinuxDevice;
import lombok.Data;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
public class Sdb implements LinuxDevice {

    @JsonProperty("disk_id")
    private final Integer diskId;

    @JsonProperty("volume_id")
    private final Integer volumeId;

    public Sdb(final Integer diskId, final Integer volumeId){
        this.diskId = diskId;
        this.volumeId = volumeId;
    }

}
