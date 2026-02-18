package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fu extends BaseHook implements IRequiresDexLocate {
    public static final fu a = new fu("AntiRevoke1Hook" /* cnb.z(-457298052905770L) */);
    public static final String b = "聊天" /* cnb.z(-456533548727082L) */;
    public static final String c = "阻止消息撤回1" /* cnb.z(-456486304086826L) */;
    public static final String d = "消息无撤回提示，流畅款，三款选一款" /* cnb.z(-456451944348458L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(ft.a));
        fu fuVar = a;
        aki akiVarAb = csb.ab(fuVar, listBf);
        fuVar.y(akiVarAb, new bn(11));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(ft.a, dexKitBridge, new bn(12));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return d;
    }
}
