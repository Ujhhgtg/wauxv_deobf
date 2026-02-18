package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gp extends bws implements IRequiresDexLocate {
    public static final gp a = new gp();

    public static Object b(Class cls, Object obj) {
        Object objInvoke = emn.bb(go.a).invoke(obj, cls);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(go.a, dexKitBridge, new gi(9));
    }
}
