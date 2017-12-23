package in.ankushs.linode4j.model.managed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.Kernel;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 21/12/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PageContactImpl implements Page<Contact> {

    @JsonProperty("pages")
    private final Integer totalPages;

    @JsonProperty("page")
    private final Integer currentPageCount;

    @JsonProperty("results")
    private final Integer totalResults;

    @JsonProperty("data")
    private final Set<Contact> content;

}
