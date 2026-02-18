package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wr extends bws implements IRequiresDexLocate {
    public static final wr a = new wr();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() throws NoSuchMethodException {
        aki akiVarAb = csb.ab(a, dqc.bf(emn.bb(wq.a)));
        akiVarAb.m(new us(24));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(wq.a, dexKitBridge, new us(25));
    }
}
