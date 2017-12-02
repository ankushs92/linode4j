package in.ankushs.linode4j.api;

import in.ankushs.linode4j.constants.LinodeUrl;
import in.ankushs.linode4j.exception.LinodeException;
import in.ankushs.linode4j.model.account.*;
import in.ankushs.linode4j.model.account.request.OAuthClientRequest;
import in.ankushs.linode4j.model.enums.HttpMethod;
import in.ankushs.linode4j.model.enums.HttpStatusCode;
import in.ankushs.linode4j.model.image.Image;
import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.BlockStorageVolume;
import in.ankushs.linode4j.model.linode.Devices;
import in.ankushs.linode4j.model.linode.Linode;
import in.ankushs.linode4j.model.linode.LinodePageImpl;
import in.ankushs.linode4j.model.linode.request.LinodeCloneRequest;
import in.ankushs.linode4j.model.linode.request.LinodeRebuildRequest;
import in.ankushs.linode4j.model.linode.response.LinodeCloneResponse;
import in.ankushs.linode4j.util.Json;
import in.ankushs.linode4j.util.PreConditions;
import in.ankushs.linode4j.util.Strings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Objects;

import static in.ankushs.linode4j.constants.LinodeUrl.*;

/**
 * Created by ankushsharma on 29/11/17.
 */
@Data
@Slf4j
public class LinodeApiClient implements LinodeApi {

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

        return (LinodePageImpl) executeReq(url, httpMethod, LinodePageImpl.class);
    }

    @Override
    public Linode getLinodeById(final int id) {
        val url = LINODE_INSTANCE.replace("{id}", String.valueOf(id));
        val httpMethod = HttpMethod.GET;

        return (Linode) executeReq(url, httpMethod, Linode.class);
    }



    @Override
    public void bootLinode(final int linodeId) {

    }

    @Override
    public void bootLinode(final int linodeId, final Integer configId) {
        PreConditions.notNull(configId, "configId cannot be null");

    }

    @Override
    public LinodeCloneResponse cloneLinode(final int linodeId, final LinodeCloneRequest request) {
        PreConditions.notNull(request, "request cannot be null");
        return null;
    }

    @Override
    public void kvmify(final int linodeId) {

    }

    @Override
    public void mutate(final int linodeId) {

    }

    @Override
    public void rebootLinode(final int linodeId) {

    }

    @Override
    public void rebootLinode(final int linodeId, final Integer configId) {
        PreConditions.notNull(configId, "configId cannot be null");
    }

    @Override
    public void rebuildLinode(final int linodeId, final LinodeRebuildRequest request) {
        PreConditions.notNull(request, "request cannot be null");

    }

    @Override
    public void rescueLinode(final int linodeId, final Devices devices) {

    }

    @Override
    public void resizeLinode(final int linodeId, final String type) {
        PreConditions.notEmptyString(type , "type cannot be null");

    }

    @Override
    public void shutdownLinode(final int linodeId) {

    }

    @Override
    public Page<BlockStorageVolume> getBlockStorageVolumesByLinodeId(final int linodeId) {

        return null;
    }

    //~~~ Images ~~~~~
    @Override
    public Image getImageById(final int imageId) {
        val url = IMAGE_BY_ID.replace("{image_id}", String.valueOf(imageId));
        val httpMethod = HttpMethod.GET;

        return (Image) executeReq(url, httpMethod, Image.class);
    }

    @Override
    public Page<Image> getImages(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        val url = IMAGES.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (ImagePageImpl) executeReq(url, httpMethod, ImagePageImpl.class);
    }

    @Override
    public void deleteImage(final int imageId) {
        val url = IMAGE_BY_ID.replace("{image_id}", String.valueOf(imageId));
        val httpMethod = HttpMethod.DELETE;

        executeReq(url, httpMethod, Void.TYPE);
    }

    // ~~~~~~~~~~~~~~~~~~~~~

    @Override
    public Page<AccountEvent> getAccountEvents(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");

        val url = ACCOUNTS.replace("{page}", String.valueOf(pageNo));
        val httpMethod = HttpMethod.GET;

        return (AccountEventPageImpl) executeReq(url, httpMethod, AccountEventPageImpl.class);
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

    private static boolean okResponse(final int statusCode){
        return statusCode == HttpStatusCode.OK.getCode();
    }

    private Object executeReq(
            final String url,
            final HttpMethod httpMethod,
            final Class<?> returnType
    )
    {
        PreConditions.notEmptyString(url, "url cannot be null or empty");
        PreConditions.notNull(httpMethod, "httpMethod cannot be null");
        PreConditions.notNull(returnType, "returnType cannot be null or empty");

        log.trace("Request details : Authorization {} ; url {}", token, url);
        val request = new Request
                            .Builder()
                                .addHeader("Authorization", "Bearer " + token)
                                .addHeader("Content-Type","application/json;utf-8")
                                .url(url)
                            .build();

        Object result = null;
        try (val response = okHttpClient.newCall(request).execute()) {
            val respBody = response.body();

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
}
