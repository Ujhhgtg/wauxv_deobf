package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dkl extends doo implements bng {
    public static final dkl a = new dkl(cnb.z(-548527453240106L));
    public static final String b = cnb.z(-547835963505450L);
    public static final String c = cnb.z(-547853143374634L);
    public static final String i = cnb.z(-549468051077930L);
    public static final djk j = new djk(17);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dki.a));
        dkl dklVar = a;
        aki akiVarAb = csb.ab(dklVar, listBf);
        dklVar.y(akiVarAb, new djk(18));
        dklVar.x(akiVarAb, new djk(19));
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
        emn.aj(dki.a, dexKitBridge, new djk(20));
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
