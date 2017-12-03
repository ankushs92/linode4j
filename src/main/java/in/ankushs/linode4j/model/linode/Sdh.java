package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.LinuxDevice;
import lombok.Data;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
public class Sdh implements LinuxDevice {

    @JsonProperty("disk_id")
    private final Integer diskId;

    @JsonProperty("volume_id")
    private final Integer volumeId;

    public Sdh(final Integer diskId, final Integer volumeId){
        this.diskId = diskId;
        this.volumeId = volumeId;
    }



}
