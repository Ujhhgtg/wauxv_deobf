package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher2 extends Dispatcher implements als {
    public final Handler f;
    public final boolean g;
    public final Dispatcher2 l;

    public Dispatcher2(Handler handler, boolean z) {
        this.f = handler;
        this.g = z;
        this.l = z ? this : new Dispatcher2(handler, true);
    }

    @Override // me.hd.wauxv.obf.als
    public final void _av(long j, CancellableContinuation cancellableContinuationVar) {
        hl hlVar = new hl(cancellableContinuationVar, 5, this);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f.postDelayed(hlVar, j)) {
            bhv.ad(cancellableContinuationVar, new sz(new bka(this, 0, hlVar), 0));
        } else {
            m(cancellableContinuationVar.g, hlVar);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dispatcher2)) {
            return false;
        }
        Dispatcher2 dispatcher2Var = (Dispatcher2) obj;
        return dispatcher2Var.f == this.f && dispatcher2Var.g == this.g;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f) ^ (this.g ? 1231 : 1237);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        if (this.f.post(runnable)) {
            return;
        }
        m(ahhVar, runnable);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final boolean j(ahh ahhVar) {
        return (this.g && nullSafeIsEqual(Looper.myLooper(), this.f.getLooper())) ? false : true;
    }

    public final void m(ahh ahhVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException(
                "The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        brf brfVar = (brf) ahhVar._w(arj.i);
        if (brfVar != null) {
            brfVar.q(cancellationException);
        }
        Dispatchers$Default alcVar = aou.a;
        akq.f.i(ahhVar, runnable);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        Dispatcher2 dispatcher2Var;
        String str;
        Dispatchers$Default alcVar = aou.a;
        Dispatcher2 dispatcher2Var2 = bza.a;
        if (this == dispatcher2Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                dispatcher2Var = dispatcher2Var2.l;
            } catch (UnsupportedOperationException unused) {
                dispatcher2Var = null;
            }
            str = this == dispatcher2Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f.toString();
        return this.g ? StaticHelpers6.concat(string, ".immediate") : string;
    }
}
