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
        int i = 0;
        SyntheticPileOfMess bmuVarS = yg.s(-53674206296874L);
        MethodResolver methodResolverVarT = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "insertWithOnConflict" /* "insertWithOnConflict" /* "insertWithOnConflict" /* cnb.z(-52965536693034L)  */;
        zc zcVarB = dal.b(String.class);
        zc zcVarB2 = dal.b(String.class);
        zc zcVarB3 = dal.b(ContentValues.class);
        Class cls = Integer.TYPE;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.n(new Object[] { zcVarB, zcVarB2, zcVarB3, dal.b(cls) }, 4, methodResolverVarT);
        dly dlyVar = a;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        aki akiVarAd = dlyVar.ad(methodHookWrapperVar, hookPriorityEnumVar);
        akiVarAd.n(new SyntheticMessOfLambdas(10));
        akiVarAd.o();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "updateWithOnConflict" /* "updateWithOnConflict" /* "updateWithOnConflict" /* cnb.z(-52909702118186L)  */;
        aki akiVarAd2 = dlyVar.ad((MethodHookWrapper) StaticHelpers6.n(
                new Object[] { dal.b(String.class), dal.b(ContentValues.class), dal.b(String.class),
                        Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.b(String.class)), 0).getClass(), dal.b(cls) },
                5, methodResolverVarT2), hookPriorityEnumVar);
        akiVarAd2.n(new SyntheticMessOfLambdas(11));
        akiVarAd2.o();
        MethodResolver methodResolverVarT3 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT3.name = "rawQueryWithFactory" /* "rawQueryWithFactory" /* "rawQueryWithFactory" /* cnb.z(-52802327935786L)  */;
        aki akiVarAd3 = dlyVar
                .ad((MethodHookWrapper) StaticHelpers6.n(
                        new Object[] {
                                "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* cnb.z(-53231824665386L)  */,
                                dal.b(String.class),
                                Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.b(Object.class)), 0).getClass(), dal
                                        .b(String.class),
                                "com.tencent.wcdb.support.CancellationSignal" /* "com.tencent.wcdb.support.CancellationSignal" /* "com.tencent.wcdb.support.CancellationSignal" /* cnb.z(-54696408513322L)  */ },
                        5, methodResolverVarT3), hookPriorityEnumVar);
        akiVarAd3.n(new SyntheticMessOfLambdas(12));
        akiVarAd3.o();
        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            SyntheticPileOfMess bmuVarS2 = yg.s(-54473070213930L);
            MethodResolver methodResolverVarT4 = bmuVarS2.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT4.name = "updateWithOnConflict" /* "updateWithOnConflict" /* "updateWithOnConflict" /* cnb.z(-54855322303274L)  */;
            aki akiVarAd4 = dlyVar.ad((MethodHookWrapper) StaticHelpers6.n(
                    new Object[] { dal.b(String.class), dal.b(ContentValues.class), dal.b(String.class),
                            Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.b(String.class)), 0).getClass(), dal.b(cls) },
                    5, methodResolverVarT4), hookPriorityEnumVar);
            akiVarAd4.n(new SyntheticMessOfLambdas(13));
            akiVarAd4.o();
            MethodResolver methodResolverVarT5 = bmuVarS2.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT5.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-54799487728426L)  */;
            aki akiVarAd5 = dlyVar.ad((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT5.findMethods()), hookPriorityEnumVar);
            akiVarAd5.n(new SyntheticMessOfLambdas(14));
            akiVarAd5.o();
        }
    }
}
