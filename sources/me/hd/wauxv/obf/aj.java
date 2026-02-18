package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aj extends emc {
    @Override // me.hd.wauxv.obf.emc
    public final boolean f(al alVar, ah ahVar) {
        ah ahVar2 = ah.a;
        synchronized (alVar) {
            try {
                if (alVar.f != ahVar) {
                    return false;
                }
                alVar.f = ahVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean g(al alVar, Object obj, Object obj2) {
        synchronized (alVar) {
            try {
                if (alVar.e != obj) {
                    return false;
                }
                alVar.e = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean h(al alVar, ak akVar, ak akVar2) {
        synchronized (alVar) {
            try {
                if (alVar.g != akVar) {
                    return false;
                }
                alVar.g = akVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final void i(ak akVar, ak akVar2) {
        akVar.c = akVar2;
    }

    @Override // me.hd.wauxv.obf.emc
    public final void j(ak akVar, Thread thread) {
        akVar.b = thread;
    }
}
