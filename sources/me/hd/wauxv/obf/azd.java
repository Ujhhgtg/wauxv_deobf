package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azd extends bws implements IDexFind {
    public static final azd a = new azd();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(azb.a));
        azd azdVar = a;
        aki akiVarAb = PackageParam.ab(azdVar, listBf);
        akiVarAb.n(new atn(29));
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(azdVar, dqc.toSingletonList(StaticHelpers7.bb(azc.a)));
        akiVarAb2.n(new ayz(0));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(azb.a, dexKitBridge, new ayz(2));
        StaticHelpers7.resolveDexAndCache(azc.a, dexKitBridge, new ayz(3));
    }
}
