package in.ankushs.linode4j.model.enums;

import lombok.Getter;

/**
 * Created by ankushsharma on 27/11/17.
 */
@Getter
public enum HttpMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String code;

    HttpMethod(final String code){
        this.code = code;
    }
}
