package me.hd.wauxv.obf;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.RealResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcm implements Closeable, Flushable {
    public final DiskLruCache a;

    public bcm(DiskLruCache diskLruCache) {
        this.a = diskLruCache;
    }

    public final Response b(Request request) {
        throwIfVar1IsNull(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.a.get(bch.a(request));
            if (snapshot != null) {
                try {
                    bci bciVar = new bci(snapshot.getSource(0));
                    RequestBody requestBodyBody = request.body();
                    Headers headers = bciVar.i;
                    String str = headers.get("Content-Type");
                    String str2 = headers.get("Content-Length");
                    Response.Builder builderReceivedResponseAtMillis = new Response.Builder()
                            .request(new Request.Builder().url(bciVar.c).method(bciVar.e, requestBodyBody)
                                    .headers(bciVar.d).build())
                            .protocol(bciVar.f).code(bciVar.g).message(bciVar.h).headers(headers).handshake(bciVar.j)
                            .sentRequestAtMillis(bciVar.k).receivedResponseAtMillis(bciVar.l);
                    Response responseBuild = builderReceivedResponseAtMillis
                            .cacheResponse(builderReceivedResponseAtMillis.build()).body(new bcg(snapshot, str, str2))
                            .build();
                    if (request.tag(cna.class) == null) {
                        return responseBuild.newBuilder().request(request).build();
                    }
                    throw new ClassCastException();
                } catch (IOException unused) {
                    Util.closeQuietly(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public final Response c(Response response) {
        DiskLruCache.Editor editorEdit$default;
        bck bckVar;
        throwIfVar1IsNull(response, "response");
        if (response.isSuccessful()) {
            bci bciVar = new bci(response);
            try {
                editorEdit$default = DiskLruCache.edit$default(this.a, bch.a(response.request()), 0L, 2, null);
            } catch (IOException unused) {
                editorEdit$default = null;
            }
            if (editorEdit$default != null) {
                try {
                    bciVar.o(editorEdit$default);
                    bckVar = new bck(this, editorEdit$default);
                } catch (IOException unused2) {
                    if (editorEdit$default != null) {
                        try {
                            editorEdit$default.abort();
                        } catch (IOException unused3) {
                        }
                    }
                    bckVar = null;
                }
                if (bckVar != null) {
                    cyk cykVarAg = emc.ag(bckVar.c);
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody != null) {
                        return response.newBuilder()
                                .body(new RealResponseBody(
                                        Response.header$default(response, "Content-Type", null, 2, null),
                                        responseBodyBody.contentLength(),
                                        emc.ah(new bcl(responseBodyBody.source(), bckVar, cykVarAg))))
                                .build();
                    }
                }
            }
        }
        return response;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.a.flush();
    }
}
