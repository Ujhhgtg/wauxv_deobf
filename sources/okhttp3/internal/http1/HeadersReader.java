package okhttp3.internal.http1;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.rm;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final rm source;

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

    public HeadersReader(rm rmVar) {
        throwIfVar1IsNull(rmVar, "source");
        this.source = rmVar;
        this.headerLimit = 262144L;
    }

    public final rm getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() {
        String strM = this.source.m(this.headerLimit);
        this.headerLimit -= (long) strM.length();
        return strM;
    }
}
