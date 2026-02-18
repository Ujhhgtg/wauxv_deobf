package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqb extends bws implements bng {
    public static final eqb a = new eqb();

    public static String b(String str) {
        Method methodBb = emn.bb(eqa.a);
        epx.a.getClass();
        Object objInvoke = methodBb.invoke(epx.b(), str);
        bzo.o(objInvoke, "null cannot be cast to non-null type kotlin.String" /* cnb.z(-377235567541034L) */);
        return (String) objInvoke;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(eqa.a, dexKitBridge, new dos(28));
        emn.aj(epz.a, dexKitBridge, new dos(29));
    }
}
