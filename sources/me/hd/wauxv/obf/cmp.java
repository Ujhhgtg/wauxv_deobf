package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cmp extends bws implements IDexFind {
    public static final cmp a = new cmp();

    public static Object b(cmp cmpVar, String str, String str2, String str3, String str4, int i)
            throws NoSuchMethodException {
        String strZ = "" /* cnb.z(-138821932940074L) */;
        String strZ2 = "" /* cnb.z(-138817637972778L) */;
        String strZ3 = "" /* cnb.z(-138830522874666L) */;
        String strZ4 = "" /* cnb.z(-138826227907370L) */;
        cmpVar.getClass();
        Constructor constructorBa = emn.ba(cmo.a);
        switch (constructorBa.getParameterCount()) {
            case 10:
                return constructorBa.newInstance(str, str2, 0, str3, str4, Integer.valueOf(i), strZ, null, 1, null);
            case 11:
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("With " /* cnb.z(-138959371893546L) */);
                sb.append(constructorBa.getParameterCount());
                throw new NoSuchMethodException(yg.h(-138985141697322L, sb));
            case 12:
                return constructorBa.newInstance(str, str2, 0, str3, str4, Integer.valueOf(i), strZ, null, 1, null, 0L,
                        strZ3);
            case 13:
                return constructorBa.newInstance(str, str2, 0, str3, str4, Integer.valueOf(i), strZ, null, 1, null, 0L,
                        strZ3, strZ4);
            case 14:
                return constructorBa.newInstance(str, str2, 0, str3, str4, Integer.valueOf(i), strZ, null, 1, strZ2,
                        null, 0L, strZ3, strZ4);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(cmo.a, dexKitBridge, new cml(3));
    }
}
