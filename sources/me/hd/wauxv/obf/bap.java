package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bap extends bws implements IDexFind {
    public static final bap a = new bap();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(ban.a));
        bap bapVar = a;
        aki akiVarAb = PackageParam.ab(bapVar, listBf);
        akiVarAb.n(new ayz(18));
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(bapVar, dqc.toSingletonList(StaticHelpers7.bb(bao.a)));
        akiVarAb2.n(new ayz(19));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ban.a, dexKitBridge, new ayz(20));
        StaticHelpers7.resolveDexAndCache(bao.a, dexKitBridge, new ayz(21));
    }
}
