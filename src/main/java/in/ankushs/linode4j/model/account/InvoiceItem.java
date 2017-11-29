package in.ankushs.linode4j.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItem {
}
