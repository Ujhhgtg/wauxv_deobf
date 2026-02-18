package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dha extends doo implements bng {
    public static final dha a = new dha("ShareSignatureHook" /* cnb.z(-514932219050794L) */);
    public static final String b = "杂项" /* cnb.z(-516723220413226L) */;
    public static final String c = "分享签名校验" /* cnb.z(-516675975772970L) */;
    public static final String i = "绕过第三方应用分享到微信的签名校验" /* cnb.z(-516697450609450L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dgz.a));
        dha dhaVar = a;
        aki akiVarAb = csb.ab(dhaVar, listBf);
        dhaVar.y(akiVarAb, new dbj(27));
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
        emn.aj(dgz.a, dexKitBridge, new dbj(28));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
