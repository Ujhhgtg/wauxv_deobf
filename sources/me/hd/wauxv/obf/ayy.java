package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayy extends bws implements bng {
    public static final ayy a = new ayy();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(ayw.a));
        ayy ayyVar = a;
        aki akiVarAb = csb.ab(ayyVar, listBf);
        akiVarAb.n(new atn(22));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(ayyVar, dqc.bf(emn.bb(ayx.a)));
        akiVarAb2.n(new atn(23));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(ayw.a, dexKitBridge, new atn(24));
        emn.aj(ayx.a, dexKitBridge, new atn(25));
    }
}
