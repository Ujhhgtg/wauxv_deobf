package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aoa extends BaseHook implements IRequiresDexLocate {
    public static final aoa a = new aoa("DisablePatHook" /* cnb.z(-447527002307370L) */);
    public static final String b = "聊天" /* cnb.z(-447819060083498L) */;
    public static final String c = "禁用拍拍头像" /* cnb.z(-447823355050794L) */;
    public static final String i = "禁用聊天时双击头像触发的拍一拍功能" /* cnb.z(-447793290279722L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(anz.a));
        aoa aoaVar = a;
        aki akiVarAb = csb.ab(aoaVar, listBf);
        aoaVar.y(akiVarAb, new amb(9));
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
        emn.aj(anz.a, dexKitBridge, new amb(10));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return i;
    }
}
