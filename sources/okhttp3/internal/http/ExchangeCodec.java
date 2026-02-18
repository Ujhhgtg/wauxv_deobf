package okhttp3.internal.http;

import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.dlc;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ExchangeCodec {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }

    void cancel();

    dhy createRequestBody(Request request, long j);

    void finishRequest();

    void flushRequest();

    RealConnection getConnection();

    dlc openResponseBodySource(Response response);

    Response.Builder readResponseHeaders(boolean z);

    long reportedContentLength(Response response);

    Headers trailers();

    void writeRequestHeaders(Request request);
}
