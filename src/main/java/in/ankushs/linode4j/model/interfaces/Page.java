package in.ankushs.linode4j.model.interfaces;

import java.util.Set;

/**
 * Created by ankushsharma on 28/11/17.
 */
public interface Page<T> {

    Integer getTotalPages();

    Integer getCurrentPageCount();

    Integer getTotalResults();

    Set<T> getContent();

}
