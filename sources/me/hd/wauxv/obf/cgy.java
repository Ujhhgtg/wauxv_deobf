package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgy extends ApiHookItem implements IDexFind {
    public static final cgy a = new cgy();

    public static Object b(long j) throws IOException {
        String strZ = "SELECT * FROM message WHERE msgId = ?" /* "SELECT * FROM message WHERE msgId = ?" /* "SELECT * FROM message WHERE msgId = ?" /* cnb.z(-369534691179306L)  */;
        Object[] objArr = { Long.valueOf(j) };
        ClassSqliteDBDexFind.INSTANCE.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ClassSqliteDBDexFind.getDb()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "rawQuery";
        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) }, 2, methodResolverVarT)).invoke(strZ,
                objArr);
        throwIfVar1IsNull(objJ);
        Cursor cursor = (Cursor) objJ;
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
                return ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE), new Object[0]);
            }
            MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
            Object objB = MicroMsgMsgInfoDexClassFind.createMsgInfoFromCursor(cursor);
            cursor.close();
            return objB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(cursor, th);
                throw th2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(MsgInfoStorage$ClassMsgInfoStorage_.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj1;
                String[] strArr = { "com.tencent.mm.storage" };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d");
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
            })
        }));
        StaticHelpers7.resolveDexAndCache(cgx.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(28));
        StaticHelpers7.resolveDexAndCache(MsgInfoStorage$MethodInsertMessage.INSTANCE, dexKitBridge,
                (obj -> {
                    ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                        DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj1;
                        DexFinder cdjVar = new DexFinder();
                        cdjVar.setDeclaredClass(StaticHelpers7.toDexClass(MsgInfoStorage$ClassMsgInfoStorage_.INSTANCE));
                        cdjVar.usingStrings("MsgInfo processAddMsg insert db error");
                        dexMethodQueryBuilderVar.getClass();
                        dexMethodQueryBuilderVar.dexFinder = cdjVar;
                    })
                }));
    }
}
