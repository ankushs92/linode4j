package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.OAuthScopeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 01/01/18.
 */
@Getter
@JsonDeserialize(using = OAuthScopeDeserializer.class)
public enum OAuthScope {

    UNKNOWN,
    ALL,
    LINODE_VIEW,
    LINODE_MODIFY,
    LINODE_CREATE,
    LINODE_DELETE,

    DOMAIN_VIEW,
    DOMAIN_CREATE,
    DOMAIN_MODIFY,
    DOMAIN_DELETE,

    NODEBALANCER_VIEW,
    NODEBALANCER_CREATE,
    NODEBALANCER_MODIFY,
    NODEBALANCER_DELETE,

    IMAGE_VIEW,
    IMAGE_CREATE,
    IMAGE_MODIFY,
    IMAGE_DELETE,

    STACKSCRIPT_VIEW,
    STACKSCRIPT_CREATE,
    STACKSCRIPT_MODIFY,
    STACKSCRIPT_DELETE,

    LONGVIEW_VIEW,
    LONGVIEW_CREATE,
    LONGVIEW_MODIFY,
    LONGVIEW_DELETE,

    EVENT_VIEW,
    EVENT_CREATE,
    EVENT_MODIFY,
    EVENT_DELETE,

    TOKEN_VIEW,
    TOKEN_CREATE,
    TOKEN_MODIFY,
    TOKEN_DELETE,

    CLIENT_VIEW,
    CLIENT_CREATE,
    CLIENT_MODIFY,
    CLIENT_DELETE,

    ACCOUNT_VIEW,
    ACCOUNT_CREATE,
    ACCOUNT_MODIFY,
    ACCOUNT_DELETE,

    USER_VIEW,
    USER_CREATE,
    USER_MODIFY,
    USER_DELETE,

    TICKET_VIEW,
    TICKET_CREATE,
    TICKET_MODIFY,
    TICKET_DELETE,

    IP_VIEW,
    IP_CREATE,
    IP_MODIFY,
    IP_DELETE,

    VOLUME_VIEW,
    VOLUME_CREATE,
    VOLUME_MODIFY,
    VOLUME_DELETE;

    public static OAuthScope from(final String code){
        OAuthScope result = UNKNOWN;
        if(Strings.hasText(code)){
           switch(code){

               case "*" : result = ALL; break;

               case "linodes:view": result = LINODE_VIEW; break;
               case "linodes:create": result = LINODE_CREATE; break;
               case "linodes:modify": result = LINODE_MODIFY; break;
               case "linodes:delete": result = LINODE_DELETE; break;

               case "domains:view": result = DOMAIN_VIEW; break;
               case "domains:create": result = DOMAIN_CREATE; break;
               case "domains:modify": result = DOMAIN_MODIFY; break;
               case "domains:delete": result = DOMAIN_DELETE; break;

               case "nodebalancers:view": result = NODEBALANCER_VIEW; break;
               case "nodebalancers:create": result = NODEBALANCER_CREATE; break;
               case "nodebalancers:modify": result = NODEBALANCER_MODIFY; break;
               case "nodebalancers:delete": result = NODEBALANCER_DELETE; break;

               case "images:view": result = IMAGE_VIEW; break;
               case "images:create": result = IMAGE_CREATE; break;
               case "images:modify": result = IMAGE_MODIFY; break;
               case "images:delete": result = IMAGE_DELETE; break;

               case "stackscripts:view": result = STACKSCRIPT_VIEW; break;
               case "stackscripts:create": result = STACKSCRIPT_CREATE; break;
               case "stackscripts:modify": result = STACKSCRIPT_MODIFY; break;
               case "stackscripts:delete": result = STACKSCRIPT_DELETE; break;

               case "longviewclients:view": result = LONGVIEW_VIEW; break;
               case "longviewclients:create": result = LONGVIEW_CREATE; break;
               case "longviewclients:modify": result = LONGVIEW_MODIFY; break;
               case "longviewclients:delete": result = LONGVIEW_DELETE; break;

               case "events:view": result = EVENT_VIEW; break;
               case "events:create": result = EVENT_CREATE; break;
               case "events:modify": result = EVENT_MODIFY; break;
               case "events:delete": result = EVENT_DELETE; break;

               case "tokens:view": result = TOKEN_VIEW; break;
               case "tokens:create": result = TOKEN_CREATE; break;
               case "tokens:modify": result = TOKEN_MODIFY; break;
               case "tokens:delete": result = TOKEN_DELETE; break;

               case "clients:view": result = CLIENT_VIEW; break;
               case "clients:create": result = CLIENT_CREATE; break;
               case "clients:modify": result = CLIENT_MODIFY; break;
               case "clients:delete": result = CLIENT_DELETE; break;

               case "accounts:view": result = ACCOUNT_VIEW; break;
               case "accounts:create": result = ACCOUNT_CREATE; break;
               case "accounts:modify": result = ACCOUNT_MODIFY; break;
               case "accounts:delete": result = ACCOUNT_DELETE; break;

               case "users:view": result = USER_VIEW; break;
               case "users:create": result = USER_CREATE; break;
               case "users:modify": result = USER_MODIFY; break;
               case "users:delete": result = USER_DELETE; break;

               case "tickets:view": result = TICKET_VIEW; break;
               case "tickets:create": result = TICKET_CREATE; break;
               case "tickets:modify": result = TICKET_MODIFY; break;
               case "tickets:delete": result = TICKET_DELETE; break;

               case "ips:view": result = IP_VIEW; break;
               case "ips:create": result = IP_CREATE; break;
               case "ips:modify": result = IP_MODIFY; break;
               case "ips:delete": result = IP_DELETE; break;

               case "volumes:view": result = VOLUME_VIEW; break;
               case "volumes:create": result = VOLUME_CREATE; break;
               case "volumes:modify": result = VOLUME_MODIFY; break;
               case "volumes:delete": result = VOLUME_DELETE; break;

               default : result = UNKNOWN;
           }
        }
        return result;
    }
}
