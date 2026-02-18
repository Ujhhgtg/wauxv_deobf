package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class anp extends alz {
    public int q;

    public anp(eun eunVar) {
        super(eunVar);
        if (eunVar instanceof bmn) {
            this.f = 2;
        } else {
            this.f = 3;
        }
    }

    @Override // me.hd.wauxv.obf.alz
    public final void p(int i) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.h = i;
        for (alx alxVar : this.l) {
            alxVar.c(alxVar);
        }
    }
}
