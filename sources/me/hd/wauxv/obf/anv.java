package me.hd.wauxv.obf;

import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class anv extends doo {
    public static final anv a = new anv("DisableBrightnessHook" /* cnb.z(-511367396195114L) */);
    public static final String b = "杂项" /* cnb.z(-511556374756138L) */;
    public static final String c = "禁止屏幕高亮" /* cnb.z(-511560669723434L) */;
    public static final String h = "屏蔽深夜点击收付款后的屏幕强制亮度" /* cnb.z(-517577918905130L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-511805482859306L).t();
        cdeVarT.ab = "setAttributes" /* cnb.z(-511633684167466L) */;
        cdk cdkVar = (cdk) dkz.n(new Object[]{dal.b(WindowManager.LayoutParams.class)}, 1, cdeVarT);
        exg exgVar = exg.a;
        anv anvVar = a;
        aki akiVarAd = anvVar.ad(cdkVar, exgVar);
        anvVar.y(akiVarAd, new amb(4));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }
}
