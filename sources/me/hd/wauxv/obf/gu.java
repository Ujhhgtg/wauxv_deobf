package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gu extends doo implements bng {
    public static final gu a = new gu(cnb.z(-412578853419818L));
    public static final String b = cnb.z(-409920268663594L);
    public static final String c = cnb.z(-409937448532778L);
    public static final String d = cnb.z(-409890203892522L);
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.ba(gt.a));
        gu guVar = a;
        aki akiVarAb = csb.ab(guVar, listBf);
        guVar.y(akiVarAb, new gi(11));
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
        emn.aj(gt.a, dexKitBridge, new gi(12));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return i;
    }
}
