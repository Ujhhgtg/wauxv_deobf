package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqb extends bws implements IDexFind {
    public static final eqb a = new eqb();

    public static String b(String str) {
        Method methodBb = StaticHelpers7.bb(eqa.a);
        epx.a.getClass();
        Object objInvoke = methodBb.invoke(epx.b(), str);
        throwIfVar1IsNull(objInvoke,
                "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-377235567541034L)  */);
        return (String) objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(eqa.a, dexKitBridge, new dos(28));
        StaticHelpers7.resolveDexAndCache(epz.a, dexKitBridge, new dos(29));
    }
}
