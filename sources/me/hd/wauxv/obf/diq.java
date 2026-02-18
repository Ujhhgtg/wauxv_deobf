package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class diq extends doo {
    public static final diq a = new diq(cnb.z(-541410692430634L));
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final dhg j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c(cnb.z(-46304042416938L), cnb.z(-46282567580458L));
        c = cnb.z(-530548720139050L);
        h = cnb.z(-531046936345386L);
        i = cnb.z(-531012576607018L);
        j = new dhg(10);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        for (String str : aba.ag(cnb.z(-541311908182826L), cnb.z(-542737837325098L), cnb.z(-542995535362858L))) {
            int i2 = bte.a;
            cde cdeVarT = dqc.bh(ajn.ag(str)).t();
            cdeVarT.ab = cnb.z(-542183786543914L);
            cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
            exg exgVar = exg.a;
            diq diqVar = a;
            aki akiVarAd = diqVar.ad(cdkVar, exgVar);
            diqVar.x(akiVarAd, new dhg(11));
            akiVarAd.o();
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
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
