package in.ankushs.linode4j.api;

import in.ankushs.linode4j.model.Linode;
import in.ankushs.linode4j.util.PreConditions;
import lombok.Data;

import java.util.Set;

/**
 * Created by ankushsharma on 22/11/17.
 */
@Data
public class LinodeApi {

    private final String key;

    public LinodeApi(final String key){
        this.key = key;
    }

    public Set<Linode> getLinodes(){
        return null;
    }

    public Linode getLinodeById(final Integer id){
        PreConditions.notNull(id ,"id cannot be null");
        return null;
    }



}
