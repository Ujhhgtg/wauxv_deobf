package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgf extends bws implements IDexFind {
    public static final dgf a = new dgf();

    public static Object b(Class cls) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = emn.bb(dge.a).invoke(null, cls);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(dge.a, dexKitBridge, new dbj(25));
    }
}
