package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aeg extends bws implements IRequiresDexLocate {
    public static final aeg a = new aeg();

    public static List b(String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method methodBb = emn.bb(aef.a);
        aec.a.getClass();
        Object objInvoke = methodBb.invoke(aec.b(), str);
        List list = objInvoke instanceof List ? (List) objInvoke : null;
        return list == null ? avd.a : list;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(aee.a, dexKitBridge, new act(10));
        emn.aj(aed.a, dexKitBridge, new act(11));
        emn.aj(aef.a, dexKitBridge, new act(12));
    }
}
