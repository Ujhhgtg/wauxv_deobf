package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etr extends SwitchHook implements IDexFind {
    public static final etr a = new etr("VoiceLengthHook" /* cnb.z(-500123171814186L) */);
    public static final String b = "辅助" /* cnb.z(-499264178354986L) */;
    public static final String c = "语音时长" /* cnb.z(-499268473322282L) */;
    public static final String i = "可自定义修改发送的语音消息显示时长" /* cnb.z(-499229818616618L) */;
    public static final epy j = new epy(4);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(etp.a));
        etr etrVar = a;
        aki akiVarAb = csb.ab(etrVar, listBf);
        etrVar.y(akiVarAb, new epy(6));
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
        emn.aj(etp.a, dexKitBridge, new epy(5));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IHasInvokeMethod p() {
        return j;
    }
}
