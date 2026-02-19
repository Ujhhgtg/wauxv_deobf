package me.hd.wauxv.obf;

import java.util.HashMap;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cly extends bws implements IDexFind {
    public static final cly a = new cly();

    public static Object b(String str, String str2, int i, boolean z, List list) {
        HashMap map;
        if (z) {
            String strZ = "atuserlist" /* "atuserlist" /* "atuserlist" /* "atuserlist" /* cnb.z(-111759344007978L)   */;
            StringBuilder sb = new StringBuilder();
            sb.append("<![CDATA[" /* "<![CDATA[" /* "<![CDATA[" /* "<![CDATA[" /* cnb.z(-111677739629354L)   */);
            Pair[] pairVarArr = { new Pair(strZ, yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                    StaticHelpers5.k(list, "," /* "," /* "," /* "," /* cnb.z(-111651969825578L)   */, null, null, null, 62), -111660559760170L)) };
            map = new HashMap(KotlinHelpers.calcHashMapCapacity(1));
            KotlinHelpers.addVar2PairArrayToVar1Map(map, pairVarArr);
        } else {
            map = null;
        }
        return StaticHelpers7.ba(clx.a).newInstance(str, str2, Integer.valueOf(i), Integer.valueOf(z ? 1 : 0), map);
    }

    public static Object c(cly clyVar, String str, String str2, int i, int i2) {
        clyVar.getClass();
        return b(str, str2, i, false, EmptyReadonlyList.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(clx.a, dexKitBridge, new clo(11));
    }
}
