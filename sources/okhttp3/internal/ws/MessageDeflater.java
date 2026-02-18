package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import me.hd.wauxv.obf.alr;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.rf;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.sj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageDeflater implements Closeable {
    private final rh deflatedBytes;
    private final Deflater deflater;
    private final alr deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        rh rhVar = new rh();
        this.deflatedBytes = rhVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new alr(rhVar, deflater);
    }

    private final boolean endsWith(rh rhVar, sj sjVar) {
        return rhVar.s(rhVar.b - ((long) sjVar.g()), sjVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    public final void deflate(rh rhVar) throws IOException {
        bzo.q(rhVar, "buffer");
        if (this.deflatedBytes.b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(rhVar, rhVar.b);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            rh rhVar2 = this.deflatedBytes;
            long j = rhVar2.b - ((long) 4);
            rf rfVarV = rhVar2.v(aye.b);
            try {
                rfVarV.h(j);
                rfVarV.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(rfVarV, th);
                    throw th2;
                }
            }
        } else {
            this.deflatedBytes.am(0);
        }
        rh rhVar3 = this.deflatedBytes;
        rhVar.write(rhVar3, rhVar3.b);
    }
}
