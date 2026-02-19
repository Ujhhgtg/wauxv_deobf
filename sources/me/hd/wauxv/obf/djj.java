package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djj extends bws implements IDexFind {
    public static final djj a = new djj();

    public static Object b(String str) {
        dji djiVar = dji.a;
        Method methodBb = emn.bb(djiVar);
        dis.a.getClass();
        int i = 0;
        cde cdeVarT = dqc.bh(emn.az(dir.a)).t();
        cdeVarT.ak(cdy.c);
        a.getClass();
        cdeVarT.a = emn.bb(djiVar).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        Object objInvoke = methodBb.invoke(objE, str);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(dji.a, dexKitBridge, new dhg(25));
    }
}
