package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class abl extends doo implements bng {
    public static final abl a = new abl("CommandProcessorHook" /* cnb.z(-633563510733610L) */);
    public static final String b = "测试-杂项" /* cnb.z(-635212778175274L) */;
    public static final String c = "强开更多命令处理" /* cnb.z(-635238547979050L) */;
    public static final String d = "输入框点击发送时处理隐藏的其他命令" /* cnb.z(-635148353665834L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(abk.a));
        abl ablVar = a;
        aki akiVarAb = csb.ab(ablVar, listBf);
        ablVar.y(akiVarAb, new ws(26));
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
        emn.aj(abk.a, dexKitBridge, new ws(27));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
