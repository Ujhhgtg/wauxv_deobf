package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etu extends bws implements bng {
    public static final etu a = new etu();

    public static String b(etu etuVar, String str) {
        Object objInvoke;
        etuVar.getClass();
        Method methodBb = emn.bb(ett.a);
        if (Modifier.isStatic(methodBb.getModifiers())) {
            objInvoke = methodBb.invoke(null, str, true);
        } else {
            dgf dgfVar = dgf.a;
            Class<?> declaringClass = methodBb.getDeclaringClass();
            dgfVar.getClass();
            objInvoke = methodBb.invoke(dgf.b(declaringClass), null, str, true);
        }
        bzo.o(objInvoke, cnb.z(-105643310578474L));
        return (String) objInvoke;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(ets.a, dexKitBridge, new epy(9));
        emn.aj(ett.a, dexKitBridge, new epy(10));
    }
}
