package in.ankushs.linode4j.api;

import in.ankushs.linode4j.model.linode.Devices;
import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.Linode;
import in.ankushs.linode4j.model.linode.request.LinodeCloneRequest;
import in.ankushs.linode4j.model.linode.request.LinodeRebuildRequest;
import in.ankushs.linode4j.model.linode.response.LinodeCloneResponse;
import in.ankushs.linode4j.model.linode.BlockStorageVolume;

/**
 * Created by ankushsharma on 22/11/17.
 */
public interface LinodeApi {

    Page<Linode> getLinodes(int pageNo);

    Linode getLinodeById(int id);

    void bootLinode(int linodeId);

    void bootLinode(int linodeId, Integer configId);

    LinodeCloneResponse cloneLinode(int linodeId, LinodeCloneRequest request);

    void kvmify(int linodeId);

    void mutate(int linodeId);

    void rebootLinode(int linodeId);

    void rebootLinode(int linodeId, Integer configId);

    void rebuildLinode(int linodeId, LinodeRebuildRequest request);

    void rescueLinode(int linodeId, Devices devices);

    void resizeLinode(int linodeId, String type);

    void shutdownLinode(int linodeId);

    Page<BlockStorageVolume> getBlockStorageVolumes(int linodeId);
}

