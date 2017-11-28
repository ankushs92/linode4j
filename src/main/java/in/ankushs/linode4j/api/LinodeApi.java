package in.ankushs.linode4j.api;

import in.ankushs.linode4j.model.interfaces.Page;
import in.ankushs.linode4j.model.linode.Linode;
import in.ankushs.linode4j.model.linode.LinodePageImpl;
import in.ankushs.linode4j.util.Json;
import in.ankushs.linode4j.util.PreConditions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Objects;

import static in.ankushs.linode4j.constants.LinodeUrl.LINODE_INSTANCE;
import static in.ankushs.linode4j.constants.LinodeUrl.LINODE_INSTANCES;

/**
 * Created by ankushsharma on 22/11/17.
 */
@Data
@Slf4j
public final class LinodeApi {

    private static final OkHttpClient defaultHttpClient = new OkHttpClient();

    @Getter(AccessLevel.NONE)
    private final String token;

    @Getter(AccessLevel.NONE)
    private final OkHttpClient okHttpClient;

    public LinodeApi(final String token) {
        PreConditions.notEmptyString(token, "token cannot be null or empty");

        this.token = token;
        this.okHttpClient = defaultHttpClient;
    }

    public LinodeApi(final String token, final OkHttpClient okHttpClient) {
        PreConditions.notEmptyString(token, "token cannot be null or empty");
        PreConditions.notNull(okHttpClient, "okHttpClient cannot be null");

        this.token = token;
        this.okHttpClient = okHttpClient;
    }

    public Page<Linode> getLinodes(final int pageNo) {
        PreConditions.isPositive(pageNo, "pageNo has to be greater than 0. If unsure, start with pageNo = 1");
        val request = new Request
                .Builder()
                .addHeader("Authorization", "Bearer " + token)
                .url(LINODE_INSTANCES.replace("{page}", String.valueOf(pageNo)))
                .build();

        LinodePageImpl page = null;

        try (val response = okHttpClient.newCall(request).execute()) {
            val respBody = response.body();
            if (Objects.nonNull(respBody)) {
                val json = respBody.string();
                page = Json.toObject(json, LinodePageImpl.class);
            }
        } catch (final Exception ex) {
            log.error("", ex);
        }

        return page;
    }


    public Linode getLinodeById(final Integer id) {
        PreConditions.notNull(id, "id cannot be null or empty");
        Linode linode = null;

        val request = new Request
                .Builder()
                .addHeader("Authorization", "Bearer " + token)
                .url(LINODE_INSTANCE.replace("{id}", String.valueOf(id)))
                .build();

        try (val response = okHttpClient.newCall(request).execute()) {
            val respBody = response.body();
            if (Objects.nonNull(respBody)) {
                val json = respBody.string();
                linode = Json.toObject(json, Linode.class);
            }
        } catch (final Exception ex) {
            log.error("", ex);
        }

        return linode;
    }
}

