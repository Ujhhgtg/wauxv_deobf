package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epx extends bws implements IRequiresDexLocate {
    public static final epx a = new epx();

    public static Object b() {
        int i = bte.a;
        cde cdeVarT = dqc.bh(emn.az(epw.a)).t();
        cdeVarT.ak(cdy.c);
        eqb.a.getClass();
        cdeVarT.a = emn.bb(eqa.a).getDeclaringClass();
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(epw.a, dexKitBridge, new dos(26));
    }
}
