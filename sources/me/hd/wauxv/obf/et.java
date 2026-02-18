package me.hd.wauxv.obf;

import java.io.Closeable;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class et implements ahp, Closeable {
    public final es a;
    public final ahh b;

    public et(bug bugVar, ahj ahjVar) {
        bzo.q(bugVar, "lifeEvent");
        bzo.q(ahjVar, "dispatcher");
        doh.b(new dx(bugVar, this));
        es esVar = new es(this);
        this.a = esVar;
        this.b = bmy.aa(ahjVar, esVar)._v(new dob());
    }

    public void c(CancellationException cancellationException) {
        brf brfVar = (brf) this.b._w(arj.i);
        if (brfVar != null) {
            brfVar.q(null);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + this).toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c(null);
    }

    public void d(Throwable th) {
        bzo.q(th, "e");
        f(th);
    }

    @Override // me.hd.wauxv.obf.ahp
    public final ahh e() {
        return this.b;
    }

    public void f(Throwable th) {
        bzo.q(th, "e");
        cnf.ay(th);
    }
}
