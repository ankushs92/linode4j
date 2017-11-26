package in.ankushs.linode4j.model;

import lombok.Getter;

import java.util.Set;

/**
 * Created by ankushsharma on 24/11/17.
 */
@Getter
public class Page<T> {

    private final Set<T> data;

    public Page(final Set<T> data){
        this.data = data;
    }

}
