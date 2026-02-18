package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomContactCountHook extends BaseHook {
    public static final CustomContactCountHook a = new CustomContactCountHook("CustomContactCountHook" /*
                                                                                                        * cnb.z(-
                                                                                                        * 429140247313194L)
                                                                                                        */);
    public static final String b = "美化" /* cnb.z(-430450212338474L) */;
    public static final String c = "自定义数量" /* cnb.z(-430454507305770L) */;
    public static final String d = "自定义好友和群聊列表底部的显示数量" /* cnb.z(-430411557632810L) */;
    public static final age h = new age(24);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-430690730507050L).t();
        cdeVarT.ab = "onMeasure" /* cnb.z(-430523226782506L) */;
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        CustomContactCountHook airVar = a;
        aki akiVarAd = airVar.ad(cdkVar, exgVar);
        airVar.y(akiVarAd, new age(25));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final IHasInvokeMethod p() {
        return h;
    }
}
