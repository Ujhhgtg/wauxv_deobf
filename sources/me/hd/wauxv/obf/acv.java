package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acv extends bws implements IRequiresDexLocate {
    public static final acv a = new acv();

    public static Object b(acv acvVar, int i) {
        acvVar.getClass();
        int i2 = bte.a;
        ahd.a.getClass();
        byr.a.getClass();
        cde cdeVarT = dqc.bi(byr.b()).t();
        a.getClass();
        cdeVarT.a = emn.az(acu.a);
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        cde cdeVarT2 = dqc.bi(objE).t();
        cdeVarT2.a = dal.b(Object.class);
        return ((cdk) dkz.n(new Object[] { dal.b(Integer.TYPE), dal.b(Object.class) }, 2, cdeVarT2))
                .e(Integer.valueOf(i), null);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(acu.a, dexKitBridge, new act(0));
    }
}
