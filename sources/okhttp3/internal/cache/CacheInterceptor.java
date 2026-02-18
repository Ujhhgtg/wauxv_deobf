package okhttp3.internal.cache;

import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cyk;
import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.ekc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rm;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                String strValue = headers.value(i);
                if ((!"Warning".equalsIgnoreCase(strName) || !dnr.bp(strValue, SdkVersion.MINI_VERSION, false))
                        && (isContentSpecificHeader(strName) || !isEndToEnd(strName)
                                || headers2.get(strName) == null)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strName2 = headers2.name(i2);
                if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                    builder.addLenient$okhttp(strName2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str)
                    || "Content-Type".equalsIgnoreCase(str);
        }

        private final boolean isEndToEnd(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str)
                    || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str)
                    || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str)
                    || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build()
                    : response;
        }

        private Companion() {
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) {
        if (cacheRequest == null) {
            return response;
        }
        dhy dhyVarBody = cacheRequest.body();
        ResponseBody responseBodyBody = response.body();
        throwIfVar1IsNull(responseBodyBody);
        final rm rmVarSource = responseBodyBody.source();
        final cyk cykVarAg = emc.ag(dhyVarBody);
        dlc dlcVar = new dlc() { // from class:
                                 // okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                rmVarSource.close();
            }

            @Override // me.hd.wauxv.obf.dlc
            public long read(rh rhVar, long j) throws IOException {
                throwIfVar1IsNull(rhVar, "sink");
                try {
                    long j2 = rmVarSource.read(rhVar, j);
                    if (j2 == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            cykVarAg.close();
                        }
                        return -1L;
                    }
                    rhVar.l(rhVar.b - j2, cykVarAg.c(), j2);
                    cykVarAg.j();
                    return j2;
                } catch (IOException e) {
                    if (this.cacheRequestClosed) {
                        throw e;
                    }
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                    throw e;
                }
            }

            @Override // me.hd.wauxv.obf.dlc
            public ekc timeout() {
                return rmVarSource.timeout();
            }
        };
        return response.newBuilder()
                .body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null),
                        response.body().contentLength(), emc.ah(dlcVar)))
                .build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        EventListener eventListener$okhttp;
        ResponseBody responseBodyBody;
        ResponseBody responseBodyBody2;
        ResponseBody responseBodyBody3;
        throwIfVar1IsNull(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response response = cache != null ? cache.get$okhttp(chain.request()) : null;
        CacheStrategy cacheStrategyCompute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(),
                response).compute();
        Request networkRequest = cacheStrategyCompute.getNetworkRequest();
        Response cacheResponse = cacheStrategyCompute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(cacheStrategyCompute);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        if (realCall == null || (eventListener$okhttp = realCall.getEventListener$okhttp()) == null) {
            eventListener$okhttp = EventListener.NONE;
        }
        if (response != null && cacheResponse == null && (responseBodyBody3 = response.body()) != null) {
            Util.closeQuietly(responseBodyBody3);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response responseBuild = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1)
                    .code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE)
                    .sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener$okhttp.satisfactionFailure(call, responseBuild);
            return responseBuild;
        }
        if (networkRequest == null) {
            throwIfVar1IsNull(cacheResponse);
            Response responseBuild2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse))
                    .build();
            eventListener$okhttp.cacheHit(call, responseBuild2);
            return responseBuild2;
        }
        if (cacheResponse != null) {
            eventListener$okhttp.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            eventListener$okhttp.cacheMiss(call);
        }
        try {
            Response responseProceed = chain.proceed(networkRequest);
            if (responseProceed == null && response != null && (responseBodyBody2 = response.body()) != null) {
                Util.closeQuietly(responseBodyBody2);
            }
            if (cacheResponse != null) {
                if (responseProceed != null && responseProceed.code() == 304) {
                    Response.Builder builderNewBuilder = cacheResponse.newBuilder();
                    Companion companion = Companion;
                    Response responseBuild3 = builderNewBuilder
                            .headers(companion.combine(cacheResponse.headers(), responseProceed.headers()))
                            .sentRequestAtMillis(responseProceed.sentRequestAtMillis())
                            .receivedResponseAtMillis(responseProceed.receivedResponseAtMillis())
                            .cacheResponse(companion.stripBody(cacheResponse))
                            .networkResponse(companion.stripBody(responseProceed)).build();
                    ResponseBody responseBodyBody4 = responseProceed.body();
                    throwIfVar1IsNull(responseBodyBody4);
                    responseBodyBody4.close();
                    Cache cache3 = this.cache;
                    throwIfVar1IsNull(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, responseBuild3);
                    eventListener$okhttp.cacheHit(call, responseBuild3);
                    return responseBuild3;
                }
                ResponseBody responseBodyBody5 = cacheResponse.body();
                if (responseBodyBody5 != null) {
                    Util.closeQuietly(responseBodyBody5);
                }
            }
            throwIfVar1IsNull(responseProceed);
            Response.Builder builderNewBuilder2 = responseProceed.newBuilder();
            Companion companion2 = Companion;
            Response responseBuild4 = builderNewBuilder2.cacheResponse(companion2.stripBody(cacheResponse))
                    .networkResponse(companion2.stripBody(responseProceed)).build();
            if (this.cache != null) {
                if (HttpHeaders.promisesBody(responseBuild4)
                        && CacheStrategy.Companion.isCacheable(responseBuild4, networkRequest)) {
                    Response responseCacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(responseBuild4),
                            responseBuild4);
                    if (cacheResponse != null) {
                        eventListener$okhttp.cacheMiss(call);
                    }
                    return responseCacheWritingResponse;
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return responseBuild4;
        } catch (Throwable th) {
            if (response != null && (responseBodyBody = response.body()) != null) {
                Util.closeQuietly(responseBodyBody);
            }
            throw th;
        }
    }
}
