package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blh extends SwitchHook {
    public static final blh a = new blh("HideMeAccountInfoHook" /* cnb.z(-486529600322346L) */);
    public static final String b = "净化" /* cnb.z(-487641996852010L) */;
    public static final String c = "隐藏微信号" /* cnb.z(-487646291819306L) */;
    public static final String h = "隐藏我界面微信号，与资料卡居中冲突" /* cnb.z(-488153097960234L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = bte.a;
        cdk cdkVar = (cdk) dkz.n(new Object[] { dal.b(View.class) }, 1, yg.s(-486417931172650L).t());
        exg exgVar = exg.a;
        blh blhVar = a;
        aki akiVarAd = blhVar.ad(cdkVar, exgVar);
        blhVar.x(akiVarAd, new bep(16));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
