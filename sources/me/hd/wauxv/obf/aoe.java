package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aoe extends doo implements bng {
    public static final aoe a = new aoe(cnb.z(-445057396112170L));
    public static final String b = cnb.z(-444563474873130L);
    public static final String c = cnb.z(-444567769840426L);
    public static final String i = cnb.z(-444537705069354L);
    public static final amb j = new amb(12);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(aob.a));
        aoe aoeVar = a;
        aki akiVarAb = csb.ab(aoeVar, listBf);
        aoeVar.y(akiVarAb, new amb(13));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(aob.a, dexKitBridge, new amb(14));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
