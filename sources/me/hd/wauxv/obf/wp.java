package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wp extends bws implements IRequiresDexLocate {
    public static final wp a = new wp();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(wo.a));
        wp wpVar = a;
        aki akiVarAb = csb.ab(wpVar, listBf);
        akiVarAb.m(new us(17));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(wpVar, dqc.bf(emn.bb(wn.a)));
        akiVarAb2.m(new us(18));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(wo.a, dexKitBridge, new us(19));
        emn.aj(wn.a, dexKitBridge, new us(20));
    }
}
