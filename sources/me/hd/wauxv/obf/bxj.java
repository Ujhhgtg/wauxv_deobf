package me.hd.wauxv.obf;

import android.content.Intent;
import java.util.Iterator;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxj extends BaseHook implements IRequiresDexLocate {
    public static final bxj a;
    public static final /* synthetic */ btc[] b;
    public static cem c;
    public static final jx i;
    public static final String j;
    public static final String l;
    public static final String m;
    public static final bty n;
    public static final String[] r;
    public static final boolean s;

    static {
        cwb cwbVar = new cwb(bxj.class, "RedirectUIClass" /* cnb.z(-493818159823658L) */,
                "getRedirectUIClass()Ljava/lang/Class;" /* cnb.z(-493749440346922L) */);
        dal.a.getClass();
        b = new btc[] { cwbVar };
        a = new bxj("LocationHook" /* cnb.z(-496816046996266L) */);
        i = ReflectionWrapper.h("com.tencent.mm.plugin.location.ui.RedirectUI" /* cnb.z(-494118807534378L) */,
                new amd(3), 2);
        j = "辅助" /* cnb.z(-499938488220458L) */;
        l = "虚拟定位" /* cnb.z(-499959963056938L) */;
        m = "将腾讯定位SDK结果虚拟为指定经纬度" /* cnb.z(-499904128482090L) */;
        n = new bty(1);
        r = new String[] { ewi.a.e, ewi.b.e };
        s = true;
    }

    @Override // me.hd.wauxv.obf.BaseHook, me.hd.wauxv.obf.bmf
    public final String[] _aa() {
        return r;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i2 = bte.a;
        btc btcVar = b[0];
        cde cdeVarT = dqc.bh(i.w()).t();
        cdeVarT.ab = "onActivityResult" /* cnb.z(-496794572159786L) */;
        Class cls = Integer.TYPE;
        aki akiVarAd = ad((cdk) dkz.n(new Object[] { dal.b(cls), dal.b(cls), dal.b(Intent.class) }, 3, cdeVarT), exg.a);
        a.x(akiVarAd, new bty(11));
        akiVarAd.o();
        Iterator it = aba.ag(bxc.a, bxd.a, bxb.a).iterator();
        while (it.hasNext()) {
            emn.bc((amn) it.next(), new bty(12));
        }
        emn.bc(bxe.a, new bty(13));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return l;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return j;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(bxc.a, dexKitBridge, new bty(14));
        emn.aj(bxd.a, dexKitBridge, new bty(15));
        emn.aj(bxb.a, dexKitBridge, new bty(2));
        emn.aj(bxe.a, dexKitBridge, new bty(3));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return m;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final IHasInvokeMethod p() {
        return n;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final boolean q() {
        return s;
    }
}
