package okhttp3.internal.http2;

import java.util.List;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.rm;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface PushObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i, rm rmVar, int i2, boolean z) {
                bzo.q(rmVar, "source");
                rmVar.skip(i2);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i, List<Header> list, boolean z) {
                bzo.q(list, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i, List<Header> list) {
                bzo.q(list, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i, ErrorCode errorCode) {
                bzo.q(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i, rm rmVar, int i2, boolean z);

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
