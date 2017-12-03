package in.ankushs.linode4j.api;

import in.ankushs.linode4j.model.account.AccountEvent;
import in.ankushs.linode4j.model.account.AccountNotification;
import in.ankushs.linode4j.model.account.Invoice;
import in.ankushs.linode4j.model.account.InvoiceItem;
import in.ankushs.linode4j.model.image.Image;
import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.BlockStorageVolume;
import in.ankushs.linode4j.model.linode.Devices;
import in.ankushs.linode4j.model.linode.Linode;
import in.ankushs.linode4j.model.linode.LinodeType;
import in.ankushs.linode4j.model.linode.request.LinodeCloneRequest;
import in.ankushs.linode4j.model.linode.request.LinodeCreateRequest;
import in.ankushs.linode4j.model.linode.request.LinodeRebuildRequest;
import in.ankushs.linode4j.model.linode.response.LinodeRebuildResponse;
import in.ankushs.linode4j.model.region.Region;

/**
 * Created by ankushsharma on 22/11/17.
 */
public interface LinodeApi {


    // Linodes
    Page<Linode> getLinodes(int pageNo);

    Linode getLinodeById(int linodeId);

    void createLinode(LinodeCreateRequest request);

    void deleteLinode(int linodeId);

    void bootLinode(int linodeId);

    void bootLinode(int linodeId, Integer configId);

    void cloneLinode(int linodeId, LinodeCloneRequest request);

    void kvmifyLinode(int linodeId);

    void mutateLinode(int linodeId);

    void rebootLinode(int linodeId);

    void rebootLinode(int linodeId, Integer configId);

    LinodeRebuildResponse rebuildLinode(int linodeId, LinodeRebuildRequest request);

    void rescueLinode(int linodeId, Devices devices);

    void resizeLinode(int linodeId, String linodeType);

    void shutdownLinode(int linodeId);

    Page<BlockStorageVolume> getBlockStorageVolumesByLinodeId(int linodeId);

    Page<LinodeType> getLinodeTypes(int pageNo);

    LinodeType getLinodeTypeById(String linodeTypeId);

    //~~~~~ Image ~~~~~~
    Page<Image> getImages(int pageNo);

    Image getImageById(int imageId);

    void deleteImage(int imageId);


    // ~~~ Account ~~~~~~~~

    Page<AccountEvent> getAccountEvents(int pageNo);

    AccountEvent getAccountEventById(int accountEventId);

    void markAccountEventAsRead(int accountEventId);

    void markAccountEventsAsSeen(int accountEventId);

    Page<Invoice> getInvoices(int pageNo);

    Invoice getInvoiceById(int invoiceId);

    Page<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId);


    Page<AccountNotification> getAccountNotifications(int pageNo);


    // ~~~~ Region ~~~~
    Page<Region> getRegions(int pageNo);

    Region getRegionById(String regionId);


}

