package in.ankushs.linode4j.constants;

/**
 * Created by ankushsharma on 21/11/17.
 */
public final class LinodeUrl {

    private static final String BASE_URL_V4 = "https://api.linode.com/v4";

    // Linode
    public static final String LINODE_INSTANCES = BASE_URL_V4 + "/linode/instances?page={page}";
    public static final String LINODE_BY_ID = BASE_URL_V4 + "/linode/instances/{linode_id}";
    public static final String LINODE_BOOT = BASE_URL_V4 + "/linode/instances/{linode_id}/boot";
    public static final String LINODE_CLONE = BASE_URL_V4 + "/linode/instances/{linode_id}/clone";
    public static final String LINODE_KVMIFY = BASE_URL_V4 + "/linode/instances/{linode_id}/kvmify";
    public static final String LINODE_MUTATE = BASE_URL_V4 + "/linode/instances/{linode_id}/mutate";
    public static final String LINODE_REBOOT = BASE_URL_V4 + "/linode/instances/{linode_id}/reboot";
    public static final String LINODE_REBUILD= BASE_URL_V4 + "/linode/instances/{linode_id}/rebuild";
    public static final String LINODE_RESCUE= BASE_URL_V4 + "/linode/instances/{linode_id}/rescue";
    public static final String LINODE_RESIZE= BASE_URL_V4 + "/linode/instances/{linode_id}/resize";
    public static final String LINODE_SHUTDOWN = BASE_URL_V4 + "/linode/instances/{linode_id}/shutdown";
    public static final String LINODE_VOLUMES = BASE_URL_V4 + "/linode/instances/{linode_id}/volumes";

    //Kernel
    public static final String KERNELS = BASE_URL_V4 + "/linode/kernels?page={page}";
    public static final String KERNEL_BY_ID = BASE_URL_V4 + "/linode/kernels/{kernel_id}";

    //Domain
    public static final String DOMAINS = BASE_URL_V4 + "/domains?page={page}";


    //Image
    public static final String IMAGES = BASE_URL_V4 + "/images?page={page}";
    public static final String IMAGE_BY_ID = BASE_URL_V4 + "/images/{image_id}";


    //Account
    public static final String ACCOUNTS_EVENTS = BASE_URL_V4 + "/account/events?page={page}";
    public static final String ACCOUNT_EVENT_BY_ID = BASE_URL_V4 + "/account/events/{account_id}";
    public static final String ACCOUNT_EVENT_READ = BASE_URL_V4 + "/account/events/{account_id}/read";
    public static final String ACCOUNT_EVENT_SEEN= BASE_URL_V4 + "/account/events/{account_id}/seen";

    //Invoices
    public static final String INVOICES = BASE_URL_V4 + "/account/invoices?page={page}";
    public static final String INVOICE_BY_ID = BASE_URL_V4 + "/account/invoices/{invoice_id}";
    public static final String INVOICE_ITEMS_BY_ID = BASE_URL_V4 + "/account/invoices/{invoice_id}/items?page={page}";

    //Notifications
    public static final String NOTIFICATIONS = BASE_URL_V4 + "/account/notifications?page={page}";

    //Region
    public static final String REGIONS = BASE_URL_V4 + "/regions?page={page}";
    public static final String REGION_BY_ID = BASE_URL_V4 + "/regions/{region_id}";

    //Types
    public static final String LINODE_TYPES = BASE_URL_V4 + "/linode/types?page={page}";
    public static final String LINODE_TYPE_BY_ID = BASE_URL_V4 + "/linode/types/{type_id}";

    //Volumes
    public static final String VOLUMES = BASE_URL_V4 + "/volumes?page={page} ";
    public static final String VOLUME_BY_ID = BASE_URL_V4 + "/volumes/{volume_id}";
    public static final String VOLUME_BY_ID_ATTACH = BASE_URL_V4 + "/volumes/{volume_id}/attach";
    public static final String VOLUME_BY_ID_CLONE = BASE_URL_V4 + "/volumes/{volume_id}/clone";
    public static final String VOLUME_BY_ID_DETACH = BASE_URL_V4 + "/volumes/{volume_id}/detach";


}
