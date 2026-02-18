package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.lang.reflect.Array;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dly extends bws {
    public static final dly a = new dly();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = bte.a;
        bmu bmuVarS = yg.s(-53674206296874L);
        cde cdeVarT = bmuVarS.t();
        cdeVarT.ab = "insertWithOnConflict" /* cnb.z(-52965536693034L) */;
        zc zcVarB = dal.b(String.class);
        zc zcVarB2 = dal.b(String.class);
        zc zcVarB3 = dal.b(ContentValues.class);
        Class cls = Integer.TYPE;
        cdk cdkVar = (cdk) dkz.n(new Object[] { zcVarB, zcVarB2, zcVarB3, dal.b(cls) }, 4, cdeVarT);
        dly dlyVar = a;
        exg exgVar = exg.a;
        aki akiVarAd = dlyVar.ad(cdkVar, exgVar);
        akiVarAd.n(new dko(10));
        akiVarAd.o();
        cde cdeVarT2 = bmuVarS.t();
        cdeVarT2.ab = "updateWithOnConflict" /* cnb.z(-52909702118186L) */;
        aki akiVarAd2 = dlyVar.ad((cdk) dkz.n(
                new Object[] { dal.b(String.class), dal.b(ContentValues.class), dal.b(String.class),
                        Array.newInstance((Class<?>) cnf.bd(dal.b(String.class)), 0).getClass(), dal.b(cls) },
                5, cdeVarT2), exgVar);
        akiVarAd2.n(new dko(11));
        akiVarAd2.o();
        cde cdeVarT3 = bmuVarS.t();
        cdeVarT3.ab = "rawQueryWithFactory" /* cnb.z(-52802327935786L) */;
        aki akiVarAd3 = dlyVar
                .ad((cdk) dkz.n(
                        new Object[] {
                                "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* cnb.z(-53231824665386L) */,
                                dal.b(String.class),
                                Array.newInstance((Class<?>) cnf.bd(dal.b(Object.class)), 0).getClass(), dal
                                        .b(String.class),
                                "com.tencent.wcdb.support.CancellationSignal" /* cnb.z(-54696408513322L) */ },
                        5, cdeVarT3), exgVar);
        akiVarAd3.n(new dko(12));
        akiVarAd3.o();
        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            bmu bmuVarS2 = yg.s(-54473070213930L);
            cde cdeVarT4 = bmuVarS2.t();
            cdeVarT4.ab = "updateWithOnConflict" /* cnb.z(-54855322303274L) */;
            aki akiVarAd4 = dlyVar.ad((cdk) dkz.n(
                    new Object[] { dal.b(String.class), dal.b(ContentValues.class), dal.b(String.class),
                            Array.newInstance((Class<?>) cnf.bd(dal.b(String.class)), 0).getClass(), dal.b(cls) },
                    5, cdeVarT4), exgVar);
            akiVarAd4.n(new dko(13));
            akiVarAd4.o();
            cde cdeVarT5 = bmuVarS2.t();
            cdeVarT5.ab = "rawQuery" /* cnb.z(-54799487728426L) */;
            aki akiVarAd5 = dlyVar.ad((cdk) aaz.e(cdeVarT5.aj()), exgVar);
            akiVarAd5.n(new dko(14));
            akiVarAd5.o();
        }
    }
}
