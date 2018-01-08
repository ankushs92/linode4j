package in.ankushs.linode4j.model.interfaces;

import in.ankushs.linode4j.model.enums.GrantPermission;

/**
 * Created by ankushsharma on 01/01/18.
 */
public interface IndividualGrant {

    Integer getId();

    String getLabel();

    GrantPermission getPermissions();
}
