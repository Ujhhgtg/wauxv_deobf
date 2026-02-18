package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.IHasInvokeMethod;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.ens;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.uj;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final rm source;

        public BomAwareReader(rm rmVar, Charset charset) {
            throwIfVar1IsNull(rmVar, "source");
            throwIfVar1IsNull(charset, "charset");
            this.source = rmVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ens ensVar;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                ensVar = ens.a;
            } else {
                ensVar = null;
            }
            if (ensVar == null) {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throwIfVar1IsNull(cArr, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.ak(),
                        Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
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

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType,
                int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            throwIfVar1IsNull(str, "<this>");
            Charset charset = uj.a;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            rh rhVar = new rh();
            throwIfVar1IsNull(charset, "charset");
            rhVar.as(str, 0, str.length(), charset);
            return create(rhVar, mediaType, rhVar.b);
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType,
                int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, sj sjVar, MediaType mediaType,
                int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(sjVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, rm rmVar, MediaType mediaType,
                long j, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.create(rmVar, mediaType, j);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            throwIfVar1IsNull(bArr, "<this>");
            rh rhVar = new rh();
            rhVar.m12write(bArr);
            return create(rhVar, mediaType, bArr.length);
        }

        public final ResponseBody create(sj sjVar, MediaType mediaType) {
            throwIfVar1IsNull(sjVar, "<this>");
            rh rhVar = new rh();
            rhVar.al(sjVar);
            return create(rhVar, mediaType, sjVar.g());
        }

        public final ResponseBody create(final rm rmVar, final MediaType mediaType, final long j) {
            throwIfVar1IsNull(rmVar, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public rm source() {
                    return rmVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            throwIfVar1IsNull(str, "content");
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            throwIfVar1IsNull(bArr, "content");
            return create(bArr, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, sj sjVar) {
            throwIfVar1IsNull(sjVar, "content");
            return create(sjVar, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j, rm rmVar) {
            throwIfVar1IsNull(rmVar, "content");
            return create(rmVar, mediaType, j);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(uj.a)) == null) ? uj.a
                : charset;
    }

    private final <T> T consumeSource(IHasInvokeMethod bgfVar, IHasInvokeMethod bgfVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(dts.b(jContentLength, "Cannot buffer entire body for content length: "));
        }
        rm rmVarSource = source();
        try {
            T t = (T) bgfVar.invoke(rmVarSource);
            cnh.m(rmVarSource, null);
            int iIntValue = ((Number) bgfVar2.invoke(t)).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return t;
            }
            throw new IOException(
                    "Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(rmVarSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public final InputStream byteStream() {
        return source().ak();
    }

    public final sj byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(dts.b(jContentLength, "Cannot buffer entire body for content length: "));
        }
        rm rmVarSource = source();
        try {
            sj sjVarW = rmVarSource.w();
            rmVarSource.close();
            int iG = sjVarW.g();
            if (jContentLength == -1 || jContentLength == iG) {
                return sjVarW;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iG + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(rmVarSource, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(dts.b(jContentLength, "Cannot buffer entire body for content length: "));
        }
        rm rmVarSource = source();
        try {
            byte[] bArrH = rmVarSource.h();
            rmVarSource.close();
            int length = bArrH.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrH;
            }
            throw new IOException(
                    "Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(rmVarSource, th);
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract rm source();

    public final String string() throws IOException {
        rm rmVarSource = source();
        try {
            String string = rmVarSource.readString(Util.readBomAsCharset(rmVarSource, charset()));
            rmVarSource.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(rmVarSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(rm rmVar, MediaType mediaType, long j) {
        return Companion.create(rmVar, mediaType, j);
    }

    public static final ResponseBody create(sj sjVar, MediaType mediaType) {
        return Companion.create(sjVar, mediaType);
    }

    public static final ResponseBody create(MediaType mediaType, long j, rm rmVar) {
        return Companion.create(mediaType, j, rmVar);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, sj sjVar) {
        return Companion.create(mediaType, sjVar);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
