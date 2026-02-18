package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brr implements btd {
    public static final brr b = new brr();
    public static final brq d = brq.a;

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        cnb.n(ajtVar);
        return new brp((List) new ko(bsb.b).a(ajtVar));
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        brp brpVar = (brp) obj;
        bzo.q(brpVar, "value");
        cnb.l(avtVar);
        bsb bsbVar = bsb.b;
        dfx descriptor = bsbVar.getDescriptor();
        bzo.q(descriptor, "elementDesc");
        kl klVar = new kl(descriptor, 1);
        int size = brpVar.size();
        acn acnVarV = avtVar.v(klVar, size);
        Iterator<brx> it = brpVar.iterator();
        for (int i = 0; i < size; i++) {
            acnVarV._ca(klVar, i, bsbVar, it.next());
        }
        acnVarV.a(klVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
