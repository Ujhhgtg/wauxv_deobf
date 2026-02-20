package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassSqliteDBDexFind extends bws implements IDexFind {
    public static final ClassSqliteDBDexFind INSTANCE = new ClassSqliteDBDexFind();

    public static Object getDb() {
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(MMKernelDexFind.getCoreStorage()).r();
        fieldResolverVarR.fieldType = StaticHelpers7.toDexClass(SqliteDB$ClassSqliteDB.INSTANCE);
        Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
        throwIfVar1IsNull(objD);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = "com.tencent.wcdb.database.SQLiteDatabase";
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(SqliteDB$ClassSqliteDB.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj2;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ");
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
            }
        });
    }
}
