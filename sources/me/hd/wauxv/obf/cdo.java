package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdo extends SwitchHook implements IDexFind {
    public static final cdo a = new cdo("MockScanHook" /* "MockScanHook" /* "MockScanHook" /* cnb.z(-517736832695082L)  */);
    public static final String b = "杂项" /* "杂项" /* "杂项" /* cnb.z(-516933673810730L)  */;
    public static final String c = "模拟相机扫码" /* "模拟相机扫码" /* "模拟相机扫码" /* cnb.z(-516937968778026L)  */;
    public static final String i = "将二维码识别方式模拟成微信相机扫码" /* "将二维码识别方式模拟成微信相机扫码" /* "将二维码识别方式模拟成微信相机扫码" /* cnb.z(-516907904006954L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(cdm.a));
        cdo cdoVar = a;
        aki akiVarAb = PackageParam.ab(cdoVar, listBf);
        cdoVar.y(akiVarAb, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(1));
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
        StaticHelpers7.resolveDexAndCache(cdm.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(2));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
