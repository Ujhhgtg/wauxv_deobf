package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlx extends bws implements IRequiresDexLocate {
    public static final dlx a = new dlx();

    public static Object b() {
        int i = bte.a;
        ahd.a.getClass();
        byr.a.getClass();
        azg azgVarR = dqc.bi(byr.b()).r();
        a.getClass();
        azgVarR.a = emn.az(dlw.a);
        Object objD = ((azk) aaz.e(azgVarR.c())).d();
        throwIfVar1IsNull(objD);
        cde cdeVarT = dqc.bi(objD).t();
        cdeVarT.a = "com.tencent.wcdb.database.SQLiteDatabase" /* cnb.z(-102542344190762L) */;
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(dlw.a, dexKitBridge, new dko(8));
    }
}
