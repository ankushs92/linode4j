package in.ankushs.linode4j.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.enums.Status;
import in.ankushs.linode4j.model.interfaces.PageRequest;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 21/11/17.
 */
@Builder
@Data
public class Linode implements PageRequest<Linode> {

    @JsonProperty("alerts")
    private final Set<LinodeAlert> alerts;

    @JsonProperty("status")
    private final Status status;
//    private


    @Override
    public int getPagesCount() {
        return 0;
    }

    @Override
    public int getResultsCount() {
        return 0;
    }

    @Override
    public Set<Linode> getPages() {
        return null;
    }
}
