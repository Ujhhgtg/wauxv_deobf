package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xj extends bws implements IDexFind {
    public static final xj a = new xj();

    public static String b(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = StaticHelpers7.toDexMethod(xi.a).invoke(null, str, str2);
        throwIfVar1IsNull(objInvoke,
                "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-99454262704938L)  */);
        return (String) objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(xi.a, dexKitBridge, new ws(8));
    }
}
