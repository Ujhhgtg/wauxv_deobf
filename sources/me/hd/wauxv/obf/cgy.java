package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgy extends bws implements IDexFind {
    public static final cgy a = new cgy();

    public static Object b(long j) throws IOException {
        String strZ = "SELECT * FROM message WHERE msgId = ?" /* "SELECT * FROM message WHERE msgId = ?" /* "SELECT * FROM message WHERE msgId = ?" /* cnb.z(-369534691179306L)  */;
        Object[] objArr = { Long.valueOf(j) };
        int i = 0;
        dlx.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dlx.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-103246718827306L)  */;
        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) }, 2, methodResolverVarT)).j(strZ,
                objArr);
        throwIfVar1IsNull(objJ);
        Cursor cursor = (Cursor) objJ;
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                cge.a.getClass();
                return ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.az(cgd.a), new Object[0]);
            }
            cge.a.getClass();
            Object objB = cge.b(cursor);
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
        StaticHelpers7.resolveDexAndCache(cgv.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(27));
        StaticHelpers7.resolveDexAndCache(cgx.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(28));
        StaticHelpers7.resolveDexAndCache(cgw.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(29));
    }
}
