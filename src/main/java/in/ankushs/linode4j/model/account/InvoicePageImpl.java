package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.ankushs.linode4j.model.interfaces.Page;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InvoicePageImpl implements Page<Invoice>  {

    @JsonProperty("pages")
    private final Integer totalPages;

    @JsonProperty("page")
    private final Integer currentPageCount;

    @JsonProperty("results")
    private final Integer totalResults;

    @JsonProperty("data")
    private final Set<Invoice> content;

}
