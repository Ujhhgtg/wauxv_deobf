package me.hd.wauxv.obf;

import android.database.Cursor;
import java.util.Arrays;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cge extends bws implements IDexFind {
    public static final cge a = new cge();

    public static Object b(Cursor cursor) {
        Object objC = ReflectionWrapper.createInstanceWithArgs(emn.az(cgd.a), new Object[0]);
        int i = 0;
        cde cdeVarT = dqc.bi(objC).t();
        cdeVarT.ab = "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-75604309310250L)  */;
        cdeVarT.z(Arrays.copyOf(new Object[] { dal.b(Cursor.class) }, 1));
        cdeVarT.ah();
        ((MethodHookWrapper) aaz.e(cdeVarT.aj())).e(cursor);
        return objC;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(cgd.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(20));
    }
}
