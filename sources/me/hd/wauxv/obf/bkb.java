package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkb extends ahj implements als {
    public final Handler f;
    public final boolean g;
    public final bkb l;

    public bkb(Handler handler, boolean z) {
        this.f = handler;
        this.g = z;
        this.l = z ? this : new bkb(handler, true);
    }

    @Override // me.hd.wauxv.obf.als
    public final void _av(long j, tc tcVar) {
        hl hlVar = new hl(tcVar, 5, this);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f.postDelayed(hlVar, j)) {
            bhv.ad(tcVar, new sz(new bka(this, 0, hlVar), 0));
        } else {
            m(tcVar.g, hlVar);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bkb)) {
            return false;
        }
        bkb bkbVar = (bkb) obj;
        return bkbVar.f == this.f && bkbVar.g == this.g;
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
        return (this.g && bzo.f(Looper.myLooper(), this.f.getLooper())) ? false : true;
    }

    public final void m(ahh ahhVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        brf brfVar = (brf) ahhVar._w(arj.i);
        if (brfVar != null) {
            brfVar.q(cancellationException);
        }
        alc alcVar = aou.a;
        akq.f.i(ahhVar, runnable);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        bkb bkbVar;
        String str;
        alc alcVar = aou.a;
        bkb bkbVar2 = bza.a;
        if (this == bkbVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                bkbVar = bkbVar2.l;
            } catch (UnsupportedOperationException unused) {
                bkbVar = null;
            }
            str = this == bkbVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f.toString();
        return this.g ? dkz.s(string, ".immediate") : string;
    }
}
