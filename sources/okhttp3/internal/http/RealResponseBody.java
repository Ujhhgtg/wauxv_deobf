package okhttp3.internal.http;

import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.rm;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final rm source;

    public RealResponseBody(String str, long j, rm rmVar) {
        bzo.q(rmVar, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = rmVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public rm source() {
        return this.source;
    }
}
