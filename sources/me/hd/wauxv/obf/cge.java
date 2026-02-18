package me.hd.wauxv.obf;

import android.database.Cursor;
import java.util.Arrays;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cge extends bws implements bng {
    public static final cge a = new cge();

    public static Object b(Cursor cursor) {
        Object objC = zf.c(emn.az(cgd.a), new Object[0]);
        int i = bte.a;
        cde cdeVarT = dqc.bi(objC).t();
        cdeVarT.ab = cnb.z(-75604309310250L);
        cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(Cursor.class)}, 1));
        cdeVarT.ah();
        ((cdk) aaz.e(cdeVarT.aj())).e(cursor);
        return objC;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(cgd.a, dexKitBridge, new bzk(20));
    }
}
