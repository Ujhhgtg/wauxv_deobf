package okhttp3;

import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.f;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rl;
import me.hd.wauxv.obf.sj;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final sj boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Builder {
        private final sj boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String str, String str2) {
            bzo.q(str, "name");
            bzo.q(str2, "value");
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            bzo.q(requestBody, "body");
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        }

        public final Builder setType(MediaType mediaType) {
            bzo.q(mediaType, f.y);
            if (bzo.f(mediaType.type(), "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }

        public Builder(String str) {
            bzo.q(str, "boundary");
            sj sjVar = sj.a;
            this.boundary = nu.g(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            bzo.q(str, "name");
            bzo.q(requestBody, "body");
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            bzo.q(requestBody, "body");
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            bzo.q(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i, akd akdVar) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                bzo.p(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String str) {
            bzo.q(sb, "<this>");
            bzo.q(str, "key");
            sb.append('\"');
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static final class Companion {
            public /* synthetic */ Companion(akd akdVar) {
                this();
            }

            public final Part create(RequestBody requestBody) {
                bzo.q(requestBody, "body");
                return create(null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                bzo.q(str, "name");
                bzo.q(str2, "value");
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                bzo.q(requestBody, "body");
                akd akdVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, requestBody, akdVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                bzo.q(str, "name");
                bzo.q(requestBody, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str2);
                }
                String string = sb.toString();
                bzo.p(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", string).build(), requestBody);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, akd akdVar) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        public final RequestBody a() {
            return this.body;
        }

        public final Headers b() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{dn.k, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(sj sjVar, MediaType mediaType, List<Part> list) {
        bzo.q(sjVar, "boundaryByteString");
        bzo.q(mediaType, f.y);
        bzo.q(list, "parts");
        this.boundaryByteString = sjVar;
        this.type = mediaType;
        this.parts = list;
        this.contentType = MediaType.Companion.get(mediaType + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(rl rlVar, boolean z) throws EOFException {
        rh rhVar;
        if (z) {
            rlVar = new rh();
            rhVar = rlVar;
        } else {
            rhVar = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            bzo.n(rlVar);
            rlVar.write(DASHDASH);
            rlVar.ae(this.boundaryByteString);
            rlVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    rlVar.q(headers.name(i2)).write(COLONSPACE).q(headers.value(i2)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                rlVar.q("Content-Type: ").q(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                rlVar.q("Content-Length: ").ai(jContentLength).write(CRLF);
            } else if (z) {
                bzo.n(rhVar);
                rhVar.d();
                return -1L;
            }
            byte[] bArr = CRLF;
            rlVar.write(bArr);
            if (z) {
                j += jContentLength;
            } else {
                requestBodyBody.writeTo(rlVar);
            }
            rlVar.write(bArr);
        }
        bzo.n(rlVar);
        byte[] bArr2 = DASHDASH;
        rlVar.write(bArr2);
        rlVar.ae(this.boundaryByteString);
        rlVar.write(bArr2);
        rlVar.write(CRLF);
        if (!z) {
            return j;
        }
        bzo.n(rhVar);
        long j2 = j + rhVar.b;
        rhVar.d();
        return j2;
    }

    public final String a() {
        return boundary();
    }

    public final List<Part> b() {
        return this.parts;
    }

    public final String boundary() {
        return this.boundaryByteString.n();
    }

    public final int c() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws EOFException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final MediaType d() {
        return this.type;
    }

    public final Part part(int i) {
        return this.parts.get(i);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(rl rlVar) throws EOFException {
        bzo.q(rlVar, "sink");
        writeOrCountBytes(rlVar, false);
    }
}
