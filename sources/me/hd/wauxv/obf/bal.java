package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bal extends bws implements IRequiresDexLocate {
    public static final bal a = new bal();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(baj.a));
        bal balVar = a;
        aki akiVarAb = csb.ab(balVar, listBf);
        akiVarAb.n(new ayz(12));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(balVar, dqc.bf(emn.bb(bak.a)));
        akiVarAb2.n(new ayz(11));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(baj.a, dexKitBridge, new ayz(13));
        emn.aj(bak.a, dexKitBridge, new ayz(14));
    }
}
