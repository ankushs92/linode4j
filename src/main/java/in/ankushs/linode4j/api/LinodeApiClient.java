package in.ankushs.linode4j.api;

import com.google.common.collect.ImmutableMap;
import in.ankushs.linode4j.exception.LinodeException;
import in.ankushs.linode4j.model.account.*;
import in.ankushs.linode4j.model.account.request.OAuthClientRequest;
import in.ankushs.linode4j.model.enums.HttpMethod;
import in.ankushs.linode4j.model.enums.HttpStatusCode;
import in.ankushs.linode4j.model.enums.HyperVisor;
import in.ankushs.linode4j.model.enums.LinodeStatus;
import in.ankushs.linode4j.model.image.Image;
import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.*;
import in.ankushs.linode4j.model.linode.request.LinodeCloneRequest;
import in.ankushs.linode4j.model.linode.request.LinodeCreateRequest;
import in.ankushs.linode4j.model.linode.request.LinodeRebuildRequest;
import in.ankushs.linode4j.model.linode.response.LinodeRebuildResponse;
import in.ankushs.linode4j.model.region.Region;
import in.ankushs.linode4j.model.region.RegionPageImpl;
import in.ankushs.linode4j.util.AuthorizedKeysUtils;
import in.ankushs.linode4j.util.Json;
import in.ankushs.linode4j.util.PreConditions;
import in.ankushs.linode4j.util.Strings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import static in.ankushs.linode4j.constants.LinodeUrl.*;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@Slf4j
public class LinodeApiClient implements LinodeApi {

    private static final String JSON_MEDIA_TYPE = "application/json;utf-8";
    private static final MediaType JSON = MediaType.parse(JSON_MEDIA_TYPE);

    private static final OkHttpClient defaultHttpClient = new OkHttpClient();

    @Getter(AccessLevel.NONE)
    private final String token;

    @Getter(AccessLevel.NONE)
    private final OkHttpClient okHttpClient;

    public LinodeApiClient(final String token) {
        PreConditions.notEmptyString(token, "token cannot be null or empty");

        this.token = token;
        this.okHttpClient = defaultHttpClient;
    }

    public LinodeApiClient(final String token, final OkHttpClient okHttpClient) {
        PreConditions.notEmptyString(token, "token cannot be null or empty");
        PreConditions.notNull(okHttpClient, "okHttpClient cannot be null");

        this.token = token;
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Page<Linode> getLinodes(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        val url = LINODE_INSTANCES.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (LinodePageImpl) executeReq(url, httpMethod, LinodePageImpl.class, null);
    }

    @Override
    public Linode getLinodeById(final int linodeId) {
        val url = LINODE_BY_ID.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.GET;

        return (Linode) executeReq(url, httpMethod, Linode.class, null);
    }

    @Override
    public void createLinode(final LinodeCreateRequest request) {
        PreConditions.notNull(request, "LinodeCreateRequest cannot be null");

        val sshKeys = request.getAuthKeys();
        AuthorizedKeysUtils.validate(sshKeys);

        PreConditions.notEmptyString(request.getRegion(), "region is a required field for creating linode. It cannot be null or empty");
        PreConditions.notEmptyString(request.getType(), "type is a required field for creating linode. It cannot be null or empty");

        //We're making a POST request. No need for paging params
        val url = LINODE_INSTANCES.replace("?page={page}", Strings.EMPTY);
        val httpMethod = HttpMethod.POST;
        val jsonReq = Json.toJson(request);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void deleteLinode(final int linodeId) {
        val url = LINODE_BY_ID.replace("{linode_id}", String.valueOf(linodeId));
        val httMethod = HttpMethod.DELETE;

        executeReq(url, httMethod, Void.TYPE, null);
    }


    @Override
    public void bootLinode(final int linodeId) {
        val url = LINODE_BOOT.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;
        val emptyMap = ImmutableMap.of();

        val jsonReq = Json.toJson(emptyMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void bootLinode(final int linodeId, final Integer configId) {
        PreConditions.notNull(configId, "configId cannot be null");

        val url = LINODE_BOOT.replace("{linode_id}", String.valueOf(linodeId));
        val singletonMap = ImmutableMap.of("config_id", String.valueOf(configId));
        val httpMethod = HttpMethod.POST;

        val jsonReq = Json.toJson(singletonMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void cloneLinode(final int linodeId, final LinodeCloneRequest request) {
        PreConditions.notNull(request, "request cannot be null");

        val url = LINODE_CLONE.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethpd = HttpMethod.POST;

        val jsonReq = Json.toJson(request);
        log.debug("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethpd, Void.TYPE, reqBody);
    }

    @Override
    public void kvmifyLinode(final int linodeId) {
        val url = LINODE_KVMIFY.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethpd = HttpMethod.POST;
        val emptyMap = ImmutableMap.of();

        val jsonReq = Json.toJson(emptyMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethpd, Void.TYPE, reqBody);
    }

    @Override
    public void mutateLinode(final int linodeId) {
        val url = LINODE_MUTATE.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethpd = HttpMethod.POST;
        val emptyMap = ImmutableMap.of();

        val jsonReq = Json.toJson(emptyMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethpd, Void.TYPE, reqBody);

    }

    @Override
    public void rebootLinode(final int linodeId) {
        val url = LINODE_REBOOT.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;
        val emptyMap = ImmutableMap.of();

        val jsonReq = Json.toJson(emptyMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void rebootLinode(final int linodeId, final Integer configId) {
        PreConditions.notNull(configId, "configId cannot be null");

        val url = LINODE_REBOOT.replace("{linode_id}", String.valueOf(linodeId));
        val singletonMap = ImmutableMap.of("config_id", String.valueOf(configId));
        val httpMethod = HttpMethod.POST;

        val jsonReq = Json.toJson(singletonMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public LinodeRebuildResponse rebuildLinode(final int linodeId, final LinodeRebuildRequest request) {
        PreConditions.notNull(request, "request cannot be null");
        PreConditions.notEmptyString(request.getDistribution(), "distribution is a required param. It cannot be null or empty");
        PreConditions.notEmptyString(request.getRootPassword(), "rootPassword is a required param. It cannot be null or empty");

        val url = LINODE_REBUILD.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;

        val jsonReq = Json.toJson(request);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        return (LinodeRebuildResponse) executeReq(url, httpMethod, LinodeRebuildResponse.class, reqBody);
    }

    @Override
    public void rescueLinode(final int linodeId, final Devices devices) {
        PreConditions.notNull(devices, "devices cannot be null");

        val url = LINODE_RESCUE.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;

        val jsonReq = Json.toJson(devices);
        log.debug("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void resizeLinode(final int linodeId, final String linodeType) {
        PreConditions.notEmptyString(linodeType , "linodeType cannot be null");

        val url = LINODE_RESIZE.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;
        val singletonMap = ImmutableMap.of("type", linodeType);

        val jsonReq = Json.toJson(singletonMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public void shutdownLinode(final int linodeId) {
        val url = LINODE_SHUTDOWN.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.POST;
        val emptyMap = ImmutableMap.of();

        val jsonReq = Json.toJson(emptyMap);
        log.trace("JSON request {}", jsonReq);

        val reqBody = RequestBody.create(JSON, jsonReq);

        executeReq(url, httpMethod, Void.TYPE, reqBody);
    }

    @Override
    public Page<BlockStorageVolume> getBlockStorageVolumesByLinodeId(final int linodeId) {
        val url = LINODE_VOLUMES.replace("{linode_id}", String.valueOf(linodeId));
        val httpMethod = HttpMethod.GET;

        return (BlockStorageVolumePageImpl) executeReq(url, httpMethod, BlockStorageVolumePageImpl.class, null);
    }

    @Override
    public Page<LinodeType> getLinodeTypes(final int pageNo) {
        val url = LINODE_TYPES.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (LinodeTypePageImpl) executeReq(url, httpMethod, LinodeTypePageImpl.class, null);
    }

    @Override
    public LinodeType getLinodeTypeById(final String linodeTypeId) {
        val url = LINODE_TYPE_BY_ID.replace("{type_id}", linodeTypeId);
        val httpMethod = HttpMethod.GET;

        return (LinodeType) executeReq(url, httpMethod, LinodeType.class, null);
    }

    //~~~ Images ~~~~~
    @Override
    public Image getImageById(final int imageId) {
        val url = IMAGE_BY_ID.replace("{image_id}", String.valueOf(imageId));
        val httpMethod = HttpMethod.GET;

        return (Image) executeReq(url, httpMethod, Image.class, null);
    }

    @Override
    public Page<Image> getImages(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        val url = IMAGES.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (ImagePageImpl) executeReq(url, httpMethod, ImagePageImpl.class, null);
    }

    @Override
    public void deleteImage(final int imageId) {
        val url = IMAGE_BY_ID.replace("{image_id}", String.valueOf(imageId));
        val httpMethod = HttpMethod.DELETE;

        executeReq(url, httpMethod, Void.TYPE, null);
    }

    // ~~~~~~~~~~~~~~~~~~~~~

    @Override
    public Page<AccountEvent> getAccountEvents(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        val url = ACCOUNTS.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (AccountEventPageImpl) executeReq(url, httpMethod, AccountEventPageImpl.class, null);
    }

    @Override
    public AccountEvent getAccountEventById(final int id) {
        return null;
    }

    @Override
    public void markAccountEventAsRead(final int accountEventId) {

    }

    @Override
    public Page<Invoice> getInvoices(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        return null;
    }

    @Override
    public InvoiceItem getInvoiceItemByInvoiceId(int invoiceId) {
        return null;
    }

    @Override
    public Page<AccountNotification> getAccountNotifications(int pageNo) {
        return null;
    }

    @Override
    public Page<OAuthClient> getOAuthClients(int pageNo) {
        return null;
    }

    @Override
    public void createOAuthClient(final OAuthClientRequest request) {
        PreConditions.notNull(request, "OAuthClientRequest cannot be null");

        PreConditions.notEmptyString(request.getRedirectUri(), "redirectUri cannot be null or empty");
        PreConditions.notEmptyString(request.getLabel(), "label cannot be null or empty");

    }

    @Override
    public void markAccountEventsAsSeen(final int accountEventId) {

    }


    @Override
    public Page<Region> getRegions(final int pageNo) {
        val url = REGIONS.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (RegionPageImpl) executeReq(url, httpMethod, RegionPageImpl.class, null);
    }

    @Override
    public Region getRegionById(final String regionId) {
        PreConditions.notEmptyString(regionId, "regionId cannot be null");

        val url = REGION_BY_ID.replace("{region_id}", regionId);
        val httpMethod = HttpMethod.GET;

        return (Region) executeReq(url, httpMethod, Region.class, null);
    }


    private static boolean okResponse(final int statusCode){
        return statusCode == HttpStatusCode.OK.getCode();
    }

    private Object executeReq(
            final String url,
            final HttpMethod httpMethod,
            final Class<?> returnType,
            final RequestBody requestBody
    )
    {
        PreConditions.notEmptyString(url, "url cannot be null or empty");
        PreConditions.notNull(httpMethod, "httpMethod cannot be null");
        PreConditions.notNull(returnType, "returnType cannot be null or empty");

        if(httpMethod.isPost() || httpMethod.isPut()){
            PreConditions.notNull(requestBody, "requestBody cannot be null");
        }

        log.debug("Request details : Http Method : {} ; url {}", httpMethod, url);

        //default method is GET
        val requestBuilder = new Request.Builder()
                                .addHeader("Connection","Keep-Alive")
                                .addHeader("Content-Type", JSON_MEDIA_TYPE)
                                .addHeader("Authorization", "Bearer " + token)
                                .url(url);

        //For any request that is not a GET request, we need to prepare a Request Body
        if(httpMethod.isNotGet()){
            //We set RequestBody to our HTTP req in case of POST and PUT req
            if(httpMethod.isPost() || httpMethod.isPut()){
                //HttpMethod.POST -> "POST", HttpMethod.PUT -> "PUT" and so on
                requestBuilder.method(httpMethod.name(), requestBody);
            }
            //No need for a Request body in case of DELETE req
            else{
                requestBuilder.delete();
            }
        }

        //Our values have been set. Build the request
        val request = requestBuilder.build();

        Object result = null;
        try (val response = okHttpClient.newCall(request).execute()) {
            val respBody = response.body();

            log.trace("Headers returned {}", response.headers());
            //We'll be getting a JSON response in any case, even if linode returns an error Http code
            //If our response body is null, we set json to an empty string
            val json = Objects.nonNull(respBody)? respBody.string() : Strings.EMPTY;
            log.debug("JSON response {}", json);

            val statusCode = response.code();
            log.debug("HTTP response code {}", statusCode);

            if(!okResponse(statusCode)){
                throw new LinodeException("Error from Linode : " + json);
            }

            if(returnType != Void.TYPE){
                result = Json.toObject(json, returnType);
                log.debug("Result {}", result);
            }

        } catch (final Exception ex) {

            if(ex instanceof LinodeException){
                throw (LinodeException) ex;
            }
            log.error("", ex);
        }
        return result;
    }
    public static void main(String[] args) {
        //Your OAuth token
        final String oauthToken = "e5081e9845c8f2ebad90e85393c1848841dacc5af395d2dbd6020f2b28a0fa08";

        //Connect with Linode
        final LinodeApiClient api = new LinodeApiClient(oauthToken);

        final int pageNo = 1;
        //Get Linodes along with paging parameters
        final Page<Linode> pagedLinodes = api.getLinodes(pageNo);

        final Set<Linode> linodes = pagedLinodes.getContent();

        //Discover linode properties
        for(final Linode linode : linodes){
            final int id = linode.getId();

            //When was the linode created?
            final LocalDateTime createdOn = linode.getCreatedOn();

            //The alerts set on this linode
            final Alert alerts = linode.getAlerts();

            final Set<String> publicIps = linode.getIpv4Addresses();

            final String linodeIpv6 = linode.getIpv6Address();

            final HyperVisor hyperVisor = linode.getHyperVisor();
            if(hyperVisor == HyperVisor.KVM) {
                // DO SOMETHING
            }

            final LinodeStatus status = linode.getStatus();
            //Etc
        }

    }


}
