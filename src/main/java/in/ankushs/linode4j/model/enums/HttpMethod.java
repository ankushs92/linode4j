package in.ankushs.linode4j.model.enums;

/**
 * Created by ankushsharma on 30/11/17.
 */
public enum HttpMethod {

    GET,
    POST,
    PUT,
    DELETE;

    public boolean isNotGet(){
        return !isGet();
    }

    public boolean isGet(){
        return this == GET;
    }

    public boolean isPost(){
        return this == POST;
    }

    public boolean isPut(){
        return this == PUT;
    }
}
