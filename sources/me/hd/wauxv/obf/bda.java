package me.hd.wauxv.obf;

import net.bytebuddy.implementation.MethodDelegation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bda implements dlc {
    private final dlc delegate;

    public bda(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = dlcVar;
    }

    public final dlc b() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final dlc delegate() {
        return this.delegate;
    }

    @Override // me.hd.wauxv.obf.dlc
    public long read(rh rhVar, long j) {
        throwIfVar1IsNull(rhVar, "sink");
        return this.delegate.read(rhVar, j);
    }

    @Override // me.hd.wauxv.obf.dlc
    public ekc timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
