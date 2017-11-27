package in.ankushs.linode4j.constants;

/**
 * Created by ankushsharma on 21/11/17.
 */
public class LinodeUrl {

    public static final String BASE_URL_V4 = "https://api.linode.com/v4";
    public static final String LINODE_INSTANCES = BASE_URL_V4 + "/linode/instances?page={page}";
    public static final String LINODE_INSTANCE = BASE_URL_V4 + "/linode/instances/{id}";

}
