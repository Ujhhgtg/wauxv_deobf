package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class md extends doo {
    public static final md a = new md("AutoLoginWinHook" /* cnb.z(-510529877572394L) */);
    public static final String b = "杂项" /* cnb.z(-512265044359978L) */;
    public static final String c = "自动点击登录" /* cnb.z(-512217799719722L) */;
    public static final String d = "微信请求登录时自动勾选项及点击按钮" /* cnb.z(-512170555079466L) */;
    public static final gi h = new gi(27);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        bmu bmuVarS = yg.s(-510474042997546L);
        cde cdeVarT = bmuVarS.t();
        cdeVarT.ab = "onCreate" /* cnb.z(-511925741943594L) */;
        cdk cdkVar = (cdk) dkz.n(new Object[]{dal.b(Bundle.class)}, 1, cdeVarT);
        md mdVar = a;
        exg exgVar = exg.a;
        aki akiVarAd = mdVar.ad(cdkVar, exgVar);
        mdVar.y(akiVarAd, new gi(28));
        akiVarAd.o();
        cde cdeVarT2 = bmuVarS.t();
        cdeVarT2.ab = "initView" /* cnb.z(-511887087237930L) */;
        aki akiVarAd2 = mdVar.ad((cdk) bjs.h(cdeVarT2), exgVar);
        mdVar.x(akiVarAd2, new gi(29));
        akiVarAd2.o();
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
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return h;
    }
}
