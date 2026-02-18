package me.hd.wauxv.obf;

import net.bytebuddy.implementation.MethodDelegation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bcz implements dhy {
    private final dhy delegate;

    public bcz(dhy dhyVar) {
        throwIfVar1IsNull(dhyVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = dhyVar;
    }

    public final dhy c() {
        return this.delegate;
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final dhy delegate() {
        return this.delegate;
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // me.hd.wauxv.obf.dhy
    public ekc timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // me.hd.wauxv.obf.dhy
    public void write(rh rhVar, long j) {
        throwIfVar1IsNull(rhVar, "source");
        this.delegate.write(rhVar, j);
    }
}
