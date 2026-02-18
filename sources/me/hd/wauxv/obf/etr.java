package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etr extends doo implements bng {
    public static final etr a = new etr("VoiceLengthHook" /* cnb.z(-500123171814186L) */);
    public static final String b = "辅助" /* cnb.z(-499264178354986L) */;
    public static final String c = "语音时长" /* cnb.z(-499268473322282L) */;
    public static final String i = "可自定义修改发送的语音消息显示时长" /* cnb.z(-499229818616618L) */;
    public static final epy j = new epy(4);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(etp.a));
        etr etrVar = a;
        aki akiVarAb = csb.ab(etrVar, listBf);
        etrVar.y(akiVarAb, new epy(6));
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
        emn.aj(etp.a, dexKitBridge, new epy(5));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
