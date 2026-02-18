package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlv extends doo implements bng {
    public static final dlv a = new dlv("SportStepHook" /* cnb.z(-501102424357674L) */);
    public static final String b = "高危" /* cnb.z(-501136784096042L) */;
    public static final String c = "运动步数" /* cnb.z(-500522603772714L) */;
    public static final String i = "启用后需要多次打开微信运动使其变化" /* cnb.z(-500552668543786L) */;
    public static final dko j = new dko(4);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dlt.a));
        dlv dlvVar = a;
        aki akiVarAb = csb.ab(dlvVar, listBf);
        dlvVar.x(akiVarAb, new dko(5));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(dlt.a, dexKitBridge, new dko(6));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
