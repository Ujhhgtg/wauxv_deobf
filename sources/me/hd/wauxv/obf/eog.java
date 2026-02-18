package me.hd.wauxv.obf;

import de.robv.android.xposed.XposedBridge;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eog extends bws implements bng {
    public static final eog a = new eog();

    public static void b(Object obj) {
        XposedBridge.invokeOriginalMethod(emn.bb(eob.a), obj, new Object[0]);
    }

    public static Object c(eog eogVar, int i) {
        eogVar.getClass();
        return emn.ba(eoa.a).newInstance(Integer.valueOf(i), null);
    }

    public static void d(Object obj, String str) {
        emn.bb(eoc.a).invoke(obj, str);
    }

    public static void g(Object obj, String str) {
        emn.bb(eod.a).invoke(obj, str);
    }

    public static void i(Object obj, String str) {
        emn.bb(eoe.a).invoke(obj, str);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(eoa.a, dexKitBridge, new dos(11));
        emn.aj(eoc.a, dexKitBridge, new dos(14));
        emn.aj(eof.a, dexKitBridge, new dos(15));
        emn.aj(eoe.a, dexKitBridge, new dos(16));
        emn.aj(eod.a, dexKitBridge, new dos(17));
        emn.aj(eob.a, dexKitBridge, new dos(18));
    }
}
