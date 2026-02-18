package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import me.hd.wauxv.obf.bpd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.rh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageInflater implements Closeable {
    private final rh deflatedBytes;
    private final Inflater inflater;
    private final bpd inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z) {
        this.noContextTakeover = z;
        rh rhVar = new rh();
        this.deflatedBytes = rhVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new bpd(emc.ah(rhVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(rh rhVar) throws IOException {
        throwIfVar1IsNull(rhVar, "buffer");
        if (this.deflatedBytes.b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.r(rhVar);
        this.deflatedBytes.ap(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.b;
        do {
            this.inflaterSource.e(rhVar, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }
}
