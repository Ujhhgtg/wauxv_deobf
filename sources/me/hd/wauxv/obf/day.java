package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class day extends SwitchHook {
    public static final day a = new day("RemoveStatusInputLimitHook" /* cnb.z(-498688652737322L) */);
    public static final String b = "限制" /* cnb.z(-498319285549866L) */;
    public static final String c = "移除状态限制" /* cnb.z(-498254861040426L) */;
    public static final String h = "移除个人状态词最多输入10长度的限制" /* cnb.z(-498224796269354L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = bte.a;
        adt adtVarM = yg.s(-499139624303402L).m();
        adtVarM.y();
        adu aduVar = (adu) aaz.e(adtVarM.a());
        exg exgVar = exg.a;
        day dayVar = a;
        aki akiVarAd = dayVar.ad(aduVar, exgVar);
        dayVar.x(akiVarAd, new cvc(26));
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
