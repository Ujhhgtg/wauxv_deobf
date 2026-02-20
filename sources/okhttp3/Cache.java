package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.avh;
import me.hd.wauxv.obf.bcz;
import me.hd.wauxv.obf.bda;
import me.hd.wauxv.obf.IEmpty;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.cyk;
import me.hd.wauxv.obf.cyl;
import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.StringsKt;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rg;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rl;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class CacheResponseBody extends ResponseBody {
        private final rm bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            throwIfVar1IsNull(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = emc.ah(new bda(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // me.hd.wauxv.obf.bda, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public rm source() {
            return this.bodySource;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if ("Vary".equalsIgnoreCase(headers.name(i))) {
                    String strValue = headers.value(i);
                    if (treeSet == null) {
                        dnr.bk();
                        treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                    }
                    Iterator it = StringsKt.ar(strValue, new char[] { ',' }).iterator();
                    while (it.hasNext()) {
                        treeSet.add(StringsKt.ba((String) it.next()).toString());
                    }
                }
            }
            return treeSet == null ? avh.a : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            throwIfVar1IsNull(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            throwIfVar1IsNull(httpUrl, "url");
            sj sjVar = sj.a;
            return nu.g(httpUrl.toString()).f("MD5").h();
        }

        public final int readInt$okhttp(rm rmVar) throws IOException {
            throwIfVar1IsNull(rmVar, "source");
            try {
                long jK = rmVar.k();
                String strAa = rmVar.aa();
                if (jK >= 0 && jK <= 2147483647L && strAa.length() <= 0) {
                    return (int) jK;
                }
                throw new IOException("expected an int but was \"" + jK + strAa + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            throwIfVar1IsNull(response, "<this>");
            Response responseNetworkResponse = response.networkResponse();
            throwIfVar1IsNull(responseNetworkResponse);
            return varyHeaders(responseNetworkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            throwIfVar1IsNull(response, "cachedResponse");
            throwIfVar1IsNull(headers, "cachedRequest");
            throwIfVar1IsNull(request, "newRequest");
            Set<String> setVaryFields = varyFields(response.headers());
            if (setVaryFields != null && setVaryFields.isEmpty()) {
                return true;
            }
            for (String str : setVaryFields) {
                if (!nullSafeIsEqual(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private Companion() {
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> setVaryFields = varyFields(headers2);
            if (setVaryFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                if (setVaryFields.contains(strName)) {
                    builder.add(strName, headers.value(i));
                }
            }
            return builder.build();
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public final class RealCacheRequest implements CacheRequest {
        private final dhy body;
        private final dhy cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            throwIfVar1IsNull(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            dhy dhyVarNewSink = editor.newSink(1);
            this.cacheOut = dhyVarNewSink;
            this.body = new bcz(dhyVarNewSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy, java.io.Closeable,
                          // java.lang.AutoCloseable
                public void close() {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public dhy body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class AnonymousClass1 implements Iterator<String>, IEmpty {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;

        public AnonymousClass1(Cache cache) {
            this.delegate = cache.getCache$okhttp().snapshots();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        continue;
                        this.nextUrl = emc.ah(next.getSource(0)).m(Long.MAX_VALUE);
                        cnh.m(next, null);
                        return true;
                    } catch (Throwable th) {
                        try {
                            continue;
                            throw th;
                        } catch (Throwable th2) {
                            cnh.m(next, th);
                            throw th2;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()");
            }
            this.delegate.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            throwIfVar1IsNull(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public Cache(File file, long j, FileSystem fileSystem) {
        throwIfVar1IsNull(file, "directory");
        throwIfVar1IsNull(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    public final File a() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        throwIfVar1IsNull(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    Util.closeQuietly(responseBodyBody);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editorEdit$default;
        throwIfVar1IsNull(response, "response");
        String strMethod = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!nullSafeIsEqual(strMethod, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorEdit$default = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2,
                    null);
            if (editorEdit$default == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit$default);
                return new RealCacheRequest(this, editorEdit$default);
            } catch (IOException unused2) {
                abortQuietly(editorEdit$default);
                return null;
            }
        } catch (IOException unused3) {
            editorEdit$default = null;
        }
    }

    public final void remove$okhttp(Request request) {
        throwIfVar1IsNull(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final long size() {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        try {
            throwIfVar1IsNull(cacheStrategy, "cacheStrategy");
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        DiskLruCache.Editor editorEdit;
        throwIfVar1IsNull(response, "cached");
        throwIfVar1IsNull(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody responseBodyBody = response.body();
        throwIfVar1IsNull(responseBodyBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editorEdit = ((CacheResponseBody) responseBodyBody).getSnapshot().edit();
            if (editorEdit == null) {
                return;
            }
            try {
                entry.writeTo(editorEdit);
                editorEdit.commit();
            } catch (IOException unused) {
                abortQuietly(editorEdit);
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    public final Iterator<String> urls() {
        return new AnonymousClass1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
        throwIfVar1IsNull(file, "directory");
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static final class Companion {
            public /* synthetic */ Companion(akd akdVar) {
                this();
            }

            private Companion() {
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(dlc dlcVar) throws IOException {
            throwIfVar1IsNull(dlcVar, "rawSource");
            try {
                cyl cylVarAh = emc.ah(dlcVar);
                String strM = cylVarAh.m(Long.MAX_VALUE);
                HttpUrl httpUrl = HttpUrl.Companion.parse(strM);
                if (httpUrl == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(strM));
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = httpUrl;
                this.requestMethod = cylVarAh.m(Long.MAX_VALUE);
                Headers.Builder builder = new Headers.Builder();
                int int$okhttp = Cache.Companion.readInt$okhttp(cylVarAh);
                for (int i = 0; i < int$okhttp; i++) {
                    builder.addLenient$okhttp(cylVarAh.m(Long.MAX_VALUE));
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(cylVarAh.m(Long.MAX_VALUE));
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int int$okhttp2 = Cache.Companion.readInt$okhttp(cylVarAh);
                for (int i2 = 0; i2 < int$okhttp2; i2++) {
                    builder2.addLenient$okhttp(cylVarAh.m(Long.MAX_VALUE));
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String strM2 = cylVarAh.m(Long.MAX_VALUE);
                    if (strM2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strM2 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(
                            !cylVarAh.i() ? TlsVersion.Companion.forJavaName(cylVarAh.m(Long.MAX_VALUE))
                                    : TlsVersion.SSL_3_0,
                            CipherSuite.Companion.forJavaName(cylVarAh.m(Long.MAX_VALUE)),
                            readCertificateList(cylVarAh), readCertificateList(cylVarAh));
                } else {
                    this.handshake = null;
                }
                dlcVar.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(dlcVar, th);
                    throw th2;
                }
            }
        }

        private final boolean isHttps() {
            return nullSafeIsEqual(this.url.scheme(), "https");
        }

        private final List<Certificate> readCertificateList(rm rmVar) throws IOException {
            int int$okhttp = Cache.Companion.readInt$okhttp(rmVar);
            if (int$okhttp == -1) {
                return EmptyReadonlyList.INSTANCE;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(int$okhttp);
                int i = 0;
                for (int i2 = 0; i2 < int$okhttp; i2++) {
                    String strAa = rmVar.aa();
                    rh rhVar = new rh();
                    sj sjVar = sj.a;
                    sj sjVarE = nu.e(strAa);
                    if (sjVarE == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    rhVar.al(sjVarE);
                    arrayList.add(certificateFactory.generateCertificate(new rg(rhVar, i)));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(rl rlVar, List<? extends Certificate> list) throws IOException {
            try {
                rlVar.ai(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    sj sjVar = sj.a;
                    throwIfVar1IsNull(encoded, "bytes");
                    rlVar.q(nu.i(encoded).e()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            throwIfVar1IsNull(request, "request");
            throwIfVar1IsNull(response, "response");
            return nullSafeIsEqual(this.url, request.url()) && nullSafeIsEqual(this.requestMethod, request.method())
                    && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            throwIfVar1IsNull(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder()
                    .request(new Request.Builder().url(this.url).method(this.requestMethod, null)
                            .headers(this.varyHeaders).build())
                    .protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders)
                    .body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake)
                    .sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis)
                    .build();
        }

        public final void writeTo(DiskLruCache.Editor editor) {
            throwIfVar1IsNull(editor, "editor");
            cyk cykVarAg = emc.ag(editor.newSink(0));
            try {
                cykVarAg.q(this.url.toString());
                cykVarAg.writeByte(10);
                cykVarAg.q(this.requestMethod);
                cykVarAg.writeByte(10);
                cykVarAg.ai(this.varyHeaders.size());
                cykVarAg.writeByte(10);
                int size = this.varyHeaders.size();
                for (int i = 0; i < size; i++) {
                    cykVarAg.q(this.varyHeaders.name(i));
                    cykVarAg.q(": ");
                    cykVarAg.q(this.varyHeaders.value(i));
                    cykVarAg.writeByte(10);
                }
                cykVarAg.q(new StatusLine(this.protocol, this.code, this.message).toString());
                cykVarAg.writeByte(10);
                cykVarAg.ai(this.responseHeaders.size() + 2);
                cykVarAg.writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    cykVarAg.q(this.responseHeaders.name(i2));
                    cykVarAg.q(": ");
                    cykVarAg.q(this.responseHeaders.value(i2));
                    cykVarAg.writeByte(10);
                }
                cykVarAg.q(SENT_MILLIS);
                cykVarAg.q(": ");
                cykVarAg.ai(this.sentRequestMillis);
                cykVarAg.writeByte(10);
                cykVarAg.q(RECEIVED_MILLIS);
                cykVarAg.q(": ");
                cykVarAg.ai(this.receivedResponseMillis);
                cykVarAg.writeByte(10);
                if (isHttps()) {
                    cykVarAg.writeByte(10);
                    Handshake handshake = this.handshake;
                    throwIfVar1IsNull(handshake);
                    cykVarAg.q(handshake.cipherSuite().javaName());
                    cykVarAg.writeByte(10);
                    writeCertList(cykVarAg, this.handshake.peerCertificates());
                    writeCertList(cykVarAg, this.handshake.localCertificates());
                    cykVarAg.q(this.handshake.tlsVersion().javaName());
                    cykVarAg.writeByte(10);
                }
                cykVarAg.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cykVarAg, th);
                    throw th2;
                }
            }
        }

        public Entry(Response response) {
            throwIfVar1IsNull(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
