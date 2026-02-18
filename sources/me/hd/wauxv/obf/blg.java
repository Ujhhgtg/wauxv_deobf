package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blg extends doo implements bng {
    public static final blg a = new blg("HideDividerLineHook" /* cnb.z(-486722873850666L) */);
    public static final String b = "净化" /* cnb.z(-486078628756266L) */;
    public static final String c = "隐藏分割线" /* cnb.z(-486082923723562L) */;
    public static final String i = "隐藏主界面聊天消息列表的灰色分割线" /* cnb.z(-486039974050602L) */;
    public static final boolean j = true;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(blf.a));
        blg blgVar = a;
        aki akiVarAb = csb.ab(blgVar, listBf);
        blgVar.x(akiVarAb, new bep(13));
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
        emn.aj(blf.a, dexKitBridge, new bep(14));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return j;
    }
}
