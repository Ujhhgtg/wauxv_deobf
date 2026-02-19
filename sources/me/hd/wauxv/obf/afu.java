package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afu extends bws implements IDexFind {
    public static final afu a = new afu();
    public static final LinkedHashSet b = new LinkedHashSet();
    public static final String[] c = { ewi.a.e, ewi.b.e, ewi.c.e };

    @Override // me.hd.wauxv.obf.bws, me.hd.wauxv.obf.SwitchHook
    public final String[] _aa() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        HookManager hookManagerVarAb = PackageParam.createHook(a, dqc.toSingletonList(StaticHelpers7.toDexMethod(aft.a)));
        hookManagerVarAb.n(new act(23));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(aft.a, dexKitBridge, new act(24));
    }
}
