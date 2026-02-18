package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import me.hd.wauxv.obf.bcz;
import me.hd.wauxv.obf.bgf;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.rh;
import net.bytebuddy.implementation.MethodDelegation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class FaultHidingSink extends bcz {
    private boolean hasErrors;
    private final bgf onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(dhy dhyVar, bgf bgfVar) {
        super(dhyVar);
        bzo.q(dhyVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        bzo.q(bgfVar, "onException");
        this.onException = bgfVar;
    }

    @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public final bgf getOnException() {
        return this.onException;
    }

    @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy
    public void write(rh rhVar, long j) throws EOFException {
        bzo.q(rhVar, "source");
        if (this.hasErrors) {
            rhVar.skip(j);
            return;
        }
        try {
            super.write(rhVar, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
