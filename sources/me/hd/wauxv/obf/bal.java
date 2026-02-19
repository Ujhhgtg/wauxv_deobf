package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bal extends bws implements IDexFind {
    public static final bal a = new bal();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(baj.a));
        bal balVar = a;
        aki akiVarAb = PackageParam.ab(balVar, listBf);
        akiVarAb.n(new ayz(12));
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(balVar, dqc.toSingletonList(StaticHelpers7.bb(bak.a)));
        akiVarAb2.n(new ayz(11));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(baj.a, dexKitBridge, new ayz(13));
        StaticHelpers7.resolveDexAndCache(bak.a, dexKitBridge, new ayz(14));
    }
}
