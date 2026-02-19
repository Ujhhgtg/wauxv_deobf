package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ayb implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ayd b;

    public /* synthetic */ ayb(ayd aydVar, int i) {
        this.a = i;
        this.b = aydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ayd aydVar = this.b;
                aydVar.getClass();
                FastKV.bj(aydVar);
                return;
            default:
                ayd aydVar2 = this.b;
                synchronized (aydVar2) {
                    try {
                        synchronized (aydVar2.j) {
                            aydVar2.k = true;
                            aydVar2.j.notify();
                            break;
                        }
                        System.nanoTime();
                        if (!FastKV.ai(aydVar2) && aydVar2.aa == 0) {
                            FastKV.ah(aydVar2);
                        }
                        if (aydVar2.l == null) {
                            aydVar2.l = new ik(ayd.c);
                        }
                        if (aydVar2.h == 0) {
                            aydVar2.h = 12;
                        }
                        if (aydVar2.p) {
                            FastKV.ba(aydVar2);
                            bhv.ab(aydVar2, "rewrite data");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
