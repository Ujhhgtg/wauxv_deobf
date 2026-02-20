package me.hd.wauxv.obf;

import android.database.Cursor;
import java.util.Arrays;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MicroMsgMsgInfoDexClassFind extends bws implements IDexFind {
    public static final MicroMsgMsgInfoDexClassFind INSTANCE = new MicroMsgMsgInfoDexClassFind();

    public static Object createMsgInfoFromCursor(Cursor cursor) {
        Object objC = ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE), new Object[0]);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-75604309310250L)  */;
        methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(Cursor.class) }, 1));
        methodResolverVarT.enableSuperclass();
        ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(cursor);
        return objC;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(MsgInfo$ClassMsgInfo.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) ->{
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.storage" };
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar6 = new DexMethodGroupMatcher();
                zbVar6.usingEqStrings("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar6;
            }
        });
    }
}
