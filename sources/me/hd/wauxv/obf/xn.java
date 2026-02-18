package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xn extends bws implements bng {
    public static final xn a = new xn();

    public static Object b() throws IllegalAccessException, InvocationTargetException {
        int i = bte.a;
        byr byrVar = byr.a;
        Class cls = (Class) la.p(emn.az(xm.a).getInterfaces());
        byrVar.getClass();
        Object objInvoke = emn.bb(byq.a).invoke(null, cls);
        bzo.n(objInvoke);
        cde cdeVarT = dqc.bi(objInvoke).t();
        xp.a.getClass();
        cdeVarT.a = emn.bb(xo.a).getDeclaringClass();
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        bzo.n(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(xm.a, dexKitBridge, new ws(10));
    }
}
