package me.hd.wauxv.obf;

import java.util.HashMap;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cly extends bws implements IRequiresDexLocate {
    public static final cly a = new cly();

    public static Object b(String str, String str2, int i, boolean z, List list) {
        HashMap map;
        if (z) {
            String strZ = "atuserlist" /* cnb.z(-111759344007978L) */;
            StringBuilder sb = new StringBuilder();
            sb.append("<![CDATA[" /* cnb.z(-111677739629354L) */);
            Pair[] pairVarArr = { new Pair(strZ, yg.n(sb,
                    aaz.k(list, "," /* cnb.z(-111651969825578L) */, null, null, null, 62), -111660559760170L)) };
            map = new HashMap(KotlinHelpers.ah(1));
            KotlinHelpers.am(map, pairVarArr);
        } else {
            map = null;
        }
        return emn.ba(clx.a).newInstance(str, str2, Integer.valueOf(i), Integer.valueOf(z ? 1 : 0), map);
    }

    public static Object c(cly clyVar, String str, String str2, int i, int i2) {
        clyVar.getClass();
        return b(str, str2, i, false, avd.a);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(clx.a, dexKitBridge, new clo(11));
    }
}
