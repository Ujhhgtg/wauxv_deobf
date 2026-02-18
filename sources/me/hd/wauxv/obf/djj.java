package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djj extends bws implements IRequiresDexLocate {
    public static final djj a = new djj();

    public static Object b(String str) {
        dji djiVar = dji.a;
        Method methodBb = emn.bb(djiVar);
        dis.a.getClass();
        int i = bte.a;
        cde cdeVarT = dqc.bh(emn.az(dir.a)).t();
        cdeVarT.ak(cdy.c);
        a.getClass();
        cdeVarT.a = emn.bb(djiVar).getDeclaringClass();
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        Object objInvoke = methodBb.invoke(objE, str);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(dji.a, dexKitBridge, new dhg(25));
    }
}
