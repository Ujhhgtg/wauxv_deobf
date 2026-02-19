package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gd extends SwitchHook implements IDexFind {
    public static final gd a = new gd("AntiRevoke3Hook" /* "AntiRevoke3Hook" /* "AntiRevoke3Hook" /* cnb.z(-454368885209898L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-442089573710634L)  */;
    public static final String c = "阻止消息撤回3" /* "阻止消息撤回3" /* "阻止消息撤回3" /* cnb.z(-442093868677930L)  */;
    public static final String d = "消息有撤回提示，微叉款，三款选一款" /* "消息有撤回提示，微叉款，三款选一款" /* "消息有撤回提示，微叉款，三款选一款" /* cnb.z(-442059508939562L)  */;
    public static final bn i = new bn(22);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(gb.a));
        gd gdVar = a;
        aki akiVarAb = PackageParam.ab(gdVar, listBf);
        gdVar.x(akiVarAb, new bn(24));
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
        StaticHelpers7.resolveDexAndCache(gb.a, dexKitBridge, new bn(23));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return i;
    }
}
