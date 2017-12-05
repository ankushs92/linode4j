package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.LinuxDevice;
import lombok.Data;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
public final class Sda implements LinuxDevice {

    @JsonProperty("disk_id")
    private final Integer diskId;

    @JsonProperty("volume_id")
    private final Integer volumeId;

    public Sda(final Integer diskId, final Integer volumeId){
        this.diskId = diskId;
        this.volumeId = volumeId;
    }

}
