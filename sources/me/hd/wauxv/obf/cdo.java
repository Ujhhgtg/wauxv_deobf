package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdo extends BaseHook implements IRequiresDexLocate {
    public static final cdo a = new cdo("MockScanHook" /* cnb.z(-517736832695082L) */);
    public static final String b = "杂项" /* cnb.z(-516933673810730L) */;
    public static final String c = "模拟相机扫码" /* cnb.z(-516937968778026L) */;
    public static final String i = "将二维码识别方式模拟成微信相机扫码" /* cnb.z(-516907904006954L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(cdm.a));
        cdo cdoVar = a;
        aki akiVarAb = csb.ab(cdoVar, listBf);
        cdoVar.y(akiVarAb, new bzk(1));
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
        emn.aj(cdm.a, dexKitBridge, new bzk(2));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return i;
    }
}
