package okhttp3.internal.ws;

import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.sj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageDeflaterKt {
    private static final sj EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        sj sjVar = sj.a;
        EMPTY_DEFLATE_BLOCK = nu.f("000000ffff");
    }
}
