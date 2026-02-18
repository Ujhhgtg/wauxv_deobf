package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aog extends doo implements bng {
    public static final aog a = new aog("DisableSendStatusHook" /* cnb.z(-445950749309738L) */);
    public static final String b = "聊天" /* cnb.z(-445345158921002L) */;
    public static final String c = "禁止发送状态" /* cnb.z(-445349453888298L) */;
    public static final String i = "禁止聊天框文本改变时发送正在输入中" /* cnb.z(-445319389117226L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(aof.a));
        aog aogVar = a;
        aki akiVarAb = csb.ab(aogVar, listBf);
        aogVar.y(akiVarAb, new amb(16));
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
        emn.aj(aof.a, dexKitBridge, new amb(17));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
