package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlx extends bws implements IDexFind {
    public static final dlx a = new dlx();

    public static Object b() {
        int i = 0;
        ahd.a.getClass();
        byr.a.getClass();
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(byr.b()).r();
        a.getClass();
        fieldResolverVarR.fieldType = StaticHelpers7.toDexClass(dlw.a);
        Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
        throwIfVar1IsNull(objD);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = "com.tencent.wcdb.database.SQLiteDatabase" /* "com.tencent.wcdb.database.SQLiteDatabase" /* "com.tencent.wcdb.database.SQLiteDatabase" /* "com.tencent.wcdb.database.SQLiteDatabase" /* cnb.z(-102542344190762L)   */;
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(dlw.a, dexKitBridge, new SyntheticMessOfLambdas(8));
    }
}
