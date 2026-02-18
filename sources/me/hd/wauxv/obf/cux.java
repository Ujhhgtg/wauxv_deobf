package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cux extends cuw {
    public final Object d;

    public cux(int i) {
        super(i);
        this.d = new Object();
    }

    @Override // me.hd.wauxv.obf.cuw, me.hd.wauxv.obf.cuv
    public final Object acquire() {
        Object objAcquire;
        synchronized (this.d) {
            objAcquire = super.acquire();
        }
        return objAcquire;
    }

    @Override // me.hd.wauxv.obf.cuw, me.hd.wauxv.obf.cuv
    public final boolean l(Object obj) {
        boolean zL;
        bzo.q(obj, "instance");
        synchronized (this.d) {
            zL = super.l(obj);
        }
        return zL;
    }
}
