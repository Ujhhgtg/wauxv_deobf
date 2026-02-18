package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afu extends bws implements bng {
    public static final afu a = new afu();
    public static final LinkedHashSet b = new LinkedHashSet();
    public static final String[] c = {ewi.a.e, ewi.b.e, ewi.c.e};

    @Override // me.hd.wauxv.obf.bws, me.hd.wauxv.obf.bmf
    public final String[] _aa() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() throws NoSuchMethodException {
        aki akiVarAb = csb.ab(a, dqc.bf(emn.bb(aft.a)));
        akiVarAb.n(new act(23));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(aft.a, dexKitBridge, new act(24));
    }
}
