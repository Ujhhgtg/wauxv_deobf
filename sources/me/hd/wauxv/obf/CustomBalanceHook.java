package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomBalanceHook extends BaseHook {
    public static final CustomBalanceHook a = new CustomBalanceHook("CustomBalanceHook" /* cnb.z(-429612693715754L) */);
    public static final String b = "美化" /* cnb.z(-429045758032682L) */;
    public static final String c = "自定义余额" /* cnb.z(-428998513392426L) */;
    public static final String d = "可动态替换真实余额为指定的金额数值" /* cnb.z(-428955563719466L) */;
    public static final age h = new age(21);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-429552564173610L).t();
        cdeVarT.d = new age(22);
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        CustomBalanceHook aioVar = a;
        aki akiVarAd = aioVar.ad(cdkVar, exgVar);
        aioVar.y(akiVarAd, new age(23));
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
