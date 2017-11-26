package in.ankushs.linode4j.model.interfaces;

import java.util.Set;

/**
 * Created by ankushsharma on 24/11/17.
 */
public interface PageRequest<T> {

    int getPagesCount();

    int getResultsCount();

    Set<T> getPages();


}
