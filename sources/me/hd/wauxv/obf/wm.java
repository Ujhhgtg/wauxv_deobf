package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wm extends bws implements bng {
    public static final wm a = new wm();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(wk.a));
        wm wmVar = a;
        aki akiVarAb = csb.ab(wmVar, listBf);
        akiVarAb.n(new us(11));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(wmVar, dqc.bf(emn.bb(wl.a)));
        akiVarAb2.n(new us(12));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(wk.a, dexKitBridge, new us(14));
        emn.aj(wl.a, dexKitBridge, new us(15));
    }
}
