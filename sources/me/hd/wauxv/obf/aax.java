package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aax extends s {
    public final btd n;

    public aax(btd btdVar) {
        this.n = btdVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public void c(avt avtVar, Object obj) {
        int iE = e(obj);
        dfx descriptor = getDescriptor();
        acn acnVarV = avtVar.v(descriptor, iE);
        Iterator itD = d(obj);
        for (int i = 0; i < iE; i++) {
            acnVarV._ca(getDescriptor(), i, this.n, itD.next());
        }
        acnVarV.a(descriptor);
    }

    @Override // me.hd.wauxv.obf.s
    public void g(acm acmVar, int i, Object obj) {
        l(obj, i, acmVar.h(getDescriptor(), i, this.n, null));
    }

    public abstract void l(Object obj, int i, Object obj2);
}
