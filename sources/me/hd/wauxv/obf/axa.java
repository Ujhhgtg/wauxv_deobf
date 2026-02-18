package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axa implements bxs, Serializable {
    public dnx a;
    public Queue b;

    @Override // me.hd.wauxv.obf.bxs
    public final boolean c() {
        return true;
    }

    public final void d(int i) {
        dnz dnzVar = new dnz();
        System.currentTimeMillis();
        dnzVar.a = i;
        dnzVar.b = this.a;
        Thread.currentThread().getName();
        this.b.add(dnzVar);
    }

    @Override // me.hd.wauxv.obf.bxs
    public final void debug(String str) {
        d(4);
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isWarnEnabled() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final void warn(String str, Throwable th) {
        d(2);
    }
}
