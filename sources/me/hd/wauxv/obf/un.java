package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class un extends doo implements bng {
    public static final un a = new un(cnb.z(-488586889657130L));
    public static final String b = cnb.z(-477385614949162L);
    public static final String c = cnb.z(-477389909916458L);
    public static final String d = cnb.z(-477308305537834L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-490090128210730L).t();
        cdeVarT.ab = cnb.z(-489914034551594L);
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        un unVar = a;
        aki akiVarAd = unVar.ad(cdkVar, exgVar);
        unVar.y(akiVarAd, new mj(14));
        akiVarAd.o();
        emn.bc(um.a, new mj(15));
        emn.bc(ul.a, new mj(16));
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
        emn.aj(um.a, dexKitBridge, new mj(19));
        emn.aj(ul.a, dexKitBridge, new mj(20));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
