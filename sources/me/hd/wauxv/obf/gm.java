package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class gm extends doo implements bng {
    public static final gm a = new gm(cnb.z(-636862045616938L));
    public static final String b = cnb.z(-633872748378922L);
    public static final String c = cnb.z(-633898518182698L);
    public static final String d = cnb.z(-634413914258218L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(gj.a));
        gm gmVar = a;
        aki akiVarAb = csb.ab(gmVar, listBf);
        gmVar.y(akiVarAb, new gi(1));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(gmVar, dqc.bf(emn.bb(gk.a)));
        gmVar.y(akiVarAb2, new gi(0));
        akiVarAb2.o();
        aki akiVarAb3 = csb.ab(gmVar, dqc.bf(emn.bb(gl.a)));
        gmVar.y(akiVarAb3, new bn(29));
        akiVarAb3.o();
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
        emn.aj(gj.a, dexKitBridge, new gi(2));
        emn.aj(gk.a, dexKitBridge, new gi(3));
        emn.aj(gl.a, dexKitBridge, new gi(4));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
