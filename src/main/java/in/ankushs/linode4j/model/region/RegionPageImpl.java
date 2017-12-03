package in.ankushs.linode4j.model.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.Page;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 03/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionPageImpl implements Page<Region> {

    @JsonProperty(value = "pages", required = true)
    private final Integer totalPages;

    @JsonProperty(value = "page", required = true)
    private final Integer currentPageCount;

    @JsonProperty(value = "results", required = true)
    private final Integer totalResults;

    @JsonProperty(value = "data", required = true)
    private final Set<Region> content;

}
