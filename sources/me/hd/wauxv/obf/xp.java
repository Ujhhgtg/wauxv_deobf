package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xp extends bws implements bng {
    public static final xp a = new xp();

    public static Object b(String str) {
        int i = bte.a;
        xn.a.getClass();
        cde cdeVarT = dqc.bi(xn.b()).t();
        wv.a.getClass();
        cdeVarT.a = emn.az(wt.a);
        return ((cdk) dkz.n(new Object[]{dal.b(String.class)}, 1, cdeVarT)).e(str);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(xo.a, dexKitBridge, new ws(12));
    }
}
