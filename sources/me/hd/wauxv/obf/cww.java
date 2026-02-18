package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cww extends doo implements bng {
    public static final cww a = new cww("QuickClearQuoteHook" /* cnb.z(-472137164913450L) */);
    public static final String b = "聊天" /* cnb.z(-460557933083434L) */;
    public static final String c = "快捷清空引用" /* cnb.z(-460493508573994L) */;
    public static final String i = "输入框无内容时监听键盘删除清空引用" /* cnb.z(-460463443802922L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(cwv.a));
        cww cwwVar = a;
        aki akiVarAb = csb.ab(cwwVar, listBf);
        cwwVar.y(akiVarAb, new cvc(1));
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
        emn.aj(cwv.a, dexKitBridge, new cvc(2));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
