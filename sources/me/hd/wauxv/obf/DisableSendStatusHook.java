package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisableSendStatusHook extends SwitchHook implements IDexFind {
    public static final DisableSendStatusHook a = new DisableSendStatusHook("DisableSendStatusHook" /*
                                                                                                     * cnb.z(-
                                                                                                     * 445950749309738L)
                                                                                                     */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-445345158921002L)  */;
    public static final String c = "禁止发送状态" /* "禁止发送状态" /* "禁止发送状态" /* cnb.z(-445349453888298L)  */;
    public static final String i = "禁止聊天框文本改变时发送正在输入中" /* "禁止聊天框文本改变时发送正在输入中" /* "禁止聊天框文本改变时发送正在输入中" /* cnb.z(-445319389117226L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(aof.a));
        DisableSendStatusHook aogVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(aogVar, listBf);
        aogVar.hookBefore(hookManagerVarAb, new amb(16));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(aof.a, dexKitBridge, new amb(17));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
