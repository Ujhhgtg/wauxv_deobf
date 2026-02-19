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
        KClass zcVarB = dal.getKClassFromClass(String.class);
        KClass zcVarB2 = dal.getKClassFromClass(String.class);
        KClass zcVarB3 = dal.getKClassFromClass(ContentValues.class);
        Class cls = Integer.TYPE;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.n(new Object[] { zcVarB, zcVarB2, zcVarB3, dal.getKClassFromClass(cls) }, 4, methodResolverVarT);
        dly dlyVar = a;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        HookManager hookManagerVarAd = dlyVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        hookManagerVarAd.n(new SyntheticMessOfLambdas(10));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "updateWithOnConflict" /* "updateWithOnConflict" /* "updateWithOnConflict" /* cnb.z(-52909702118186L)  */;
        HookManager hookManagerVarAd2 = dlyVar.createImmediateHook((MethodHookWrapper) StaticHelpers6.n(
                new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(String.class),
                        Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.getKClassFromClass(String.class)), 0).getClass(), dal.getKClassFromClass(cls) },
                5, methodResolverVarT2), hookPriorityEnumVar);
        hookManagerVarAd2.n(new SyntheticMessOfLambdas(11));
        hookManagerVarAd2.initInstantCollectionAndApplyHooks();
        MethodResolver methodResolverVarT3 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT3.name = "rawQueryWithFactory" /* "rawQueryWithFactory" /* "rawQueryWithFactory" /* cnb.z(-52802327935786L)  */;
        HookManager hookManagerVarAd3 = dlyVar
                .createImmediateHook((MethodHookWrapper) StaticHelpers6.n(
                        new Object[] {
                                "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* "com.tencent.wcdb.database.SQLiteDatabase$CursorFactory" /* cnb.z(-53231824665386L)  */,
                                dal.getKClassFromClass(String.class),
                                Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.getKClassFromClass(Object.class)), 0).getClass(), dal
                                        .getKClassFromClass(String.class),
                                "com.tencent.wcdb.support.CancellationSignal" /* "com.tencent.wcdb.support.CancellationSignal" /* "com.tencent.wcdb.support.CancellationSignal" /* cnb.z(-54696408513322L)  */ },
                        5, methodResolverVarT3), hookPriorityEnumVar);
        hookManagerVarAd3.n(new SyntheticMessOfLambdas(12));
        hookManagerVarAd3.initInstantCollectionAndApplyHooks();
        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            SyntheticPileOfMess bmuVarS2 = yg.s(-54473070213930L);
            MethodResolver methodResolverVarT4 = bmuVarS2.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT4.name = "updateWithOnConflict" /* "updateWithOnConflict" /* "updateWithOnConflict" /* cnb.z(-54855322303274L)  */;
            HookManager hookManagerVarAd4 = dlyVar.createImmediateHook((MethodHookWrapper) StaticHelpers6.n(
                    new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(String.class),
                            Array.newInstance((Class<?>) HugeSyntheticPileOfHelpers.getJavaClass(dal.getKClassFromClass(String.class)), 0).getClass(), dal.getKClassFromClass(cls) },
                    5, methodResolverVarT4), hookPriorityEnumVar);
            hookManagerVarAd4.n(new SyntheticMessOfLambdas(13));
            hookManagerVarAd4.initInstantCollectionAndApplyHooks();
            MethodResolver methodResolverVarT5 = bmuVarS2.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT5.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-54799487728426L)  */;
            HookManager hookManagerVarAd5 = dlyVar.createImmediateHook((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT5.findMethods()), hookPriorityEnumVar);
            hookManagerVarAd5.n(new SyntheticMessOfLambdas(14));
            hookManagerVarAd5.initInstantCollectionAndApplyHooks();
        }
    }
}
