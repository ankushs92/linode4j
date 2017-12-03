package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Backup {

    @JsonProperty("enabled")
    private final Boolean isEnabled;

    @JsonProperty("scheduled")
    private final Scheduled scheduled;

    @JsonProperty("last_backup")
    private final LastBackup lastBackup;

    @JsonProperty("snapshot")
    private final Snapshot snapshot;

}
