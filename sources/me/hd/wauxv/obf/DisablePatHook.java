package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisablePatHook extends SwitchHook implements IDexFind {
    public static final DisablePatHook a = new DisablePatHook("DisablePatHook" /* "DisablePatHook" /* "DisablePatHook" /* "DisablePatHook" /* cnb.z(-447527002307370L)   */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* "聊天" /* cnb.z(-447819060083498L)   */;
    public static final String c = "禁用拍拍头像" /* "禁用拍拍头像" /* "禁用拍拍头像" /* "禁用拍拍头像" /* cnb.z(-447823355050794L)   */;
    public static final String i = "禁用聊天时双击头像触发的拍一拍功能" /* "禁用聊天时双击头像触发的拍一拍功能" /* "禁用聊天时双击头像触发的拍一拍功能" /* "禁用聊天时双击头像触发的拍一拍功能" /* cnb.z(-447793290279722L)   */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(anz.a));
        DisablePatHook aoaVar = a;
        aki akiVarAb = csb.ab(aoaVar, listBf);
        aoaVar.y(akiVarAb, new amb(9));
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
        emn.aj(anz.a, dexKitBridge, new amb(10));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
