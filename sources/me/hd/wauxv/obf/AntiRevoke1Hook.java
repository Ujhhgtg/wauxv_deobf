package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AntiRevoke1Hook extends SwitchHook implements IDexFind {
    public static final AntiRevoke1Hook a = new AntiRevoke1Hook("AntiRevoke1Hook" /* "AntiRevoke1Hook" /* "AntiRevoke1Hook" /* cnb.z(-457298052905770L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-456533548727082L)  */;
    public static final String c = "阻止消息撤回1" /* "阻止消息撤回1" /* "阻止消息撤回1" /* cnb.z(-456486304086826L)  */;
    public static final String d = "消息无撤回提示，流畅款，三款选一款" /* "消息无撤回提示，流畅款，三款选一款" /* "消息无撤回提示，流畅款，三款选一款" /* cnb.z(-456451944348458L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(ft.a));
        AntiRevoke1Hook fuVar = a;
        aki akiVarAb = PackageParam.ab(fuVar, listBf);
        fuVar.y(akiVarAb, new bn(11));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ft.a, dexKitBridge, new bn(12));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
