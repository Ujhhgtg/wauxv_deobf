package me.hd.wauxv.obf;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsn implements btd {
    public static final bsn b = new bsn();
    public static final bsm d = bsm.a;

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        cnb.n(ajtVar);
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        return new bsl((Map) new bvt().a(ajtVar));
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bsl bslVar = (bsl) obj;
        bzo.q(bslVar, "value");
        cnb.l(avtVar);
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        new bvt().c(avtVar, bslVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
