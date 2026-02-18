package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.util.Arrays;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agc extends bws implements IDexFind {
    public static final agc a = new agc();

    public final Object b(ContentValues contentValues) {
        Object objC = ReflectionWrapper.createInstanceWithArgs(emn.bb(agb.a).getDeclaringClass(), new Object[0]);
        int i = bte.a;
        cde cdeVarT = dqc.bi(objC).t();
        cdeVarT.ab = "convertFrom" /* cnb.z(-79005923408682L) */;
        cdeVarT.z(Arrays.copyOf(new Object[] { dal.b(ContentValues.class), dal.b(Boolean.TYPE) }, 2));
        cdeVarT.ah();
        ((cdk) aaz.e(cdeVarT.aj())).e(contentValues, Boolean.TRUE);
        return objC;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(agb.a, dexKitBridge, new act(28));
    }
}
