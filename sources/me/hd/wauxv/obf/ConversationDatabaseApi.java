package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConversationDatabaseApi extends ApiHookItem implements IDexFind {
    public static final ConversationDatabaseApi a = new ConversationDatabaseApi();

    public static void b() throws IOException {
        Cursor cursorAc = arj.ac("SELECT username FROM rconversation WHERE unReadCount>0 OR unReadMuteCount>0");
        while (cursorAc.moveToNext()) {
            try {
                String string = cursorAc.getString(0);
                Method methodBb = StaticHelpers7.toDexMethod(ConversationStorage$MethodUpdateUnreadByTalker.INSTANCE);
                methodBb.invoke(dmu.b(), string);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cursorAc, th);
                    throw th2;
                }
            }
        }
        cursorAc.close();
    }

    public static void c(ConversationDatabaseApi conversationDatabaseApiVar, Object obj, String str) {
        conversationDatabaseApiVar.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dmu.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = dal.getKClassFromClass(Integer.TYPE);
        Class<?> declaringClass = StaticHelpers7.toDexMethod(Conversation$MethodParseMsgInfo.INSTANCE).getDeclaringClass();
        Class cls = Boolean.TYPE;
        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { declaringClass, String.class, dal.getKClassFromClass(cls), dal.getKClassFromClass(cls) }, 4, methodResolverVarT)).invoke(obj,
                str, false, true);
        ((Number) objJ).intValue();
    }

    public static void d(String str, String[] strArr) {
        Method methodBb = StaticHelpers7.toDexMethod(ConversationStorage$MethodHiddenConvParent.INSTANCE);
        if (methodBb.getParameterCount() == 4) {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str, Boolean.TRUE, Boolean.FALSE);
        } else {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ConversationStorage$ClassConversationStorage.INSTANCE, dexKitBridge,
                (obj -> {
                    ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                        DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj1;
                        String[] strArr3 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-372523988417322L)  */ };
                        dexClassQueryBuilderVar.getClass();
                        dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr3);
                        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                        zbVar.usingEqStrings("PRAGMA table_info( rconversation)");
                        dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                    })
                }));
        StaticHelpers7.resolveDexAndCache(ConversationStorage$MethodUpdateUnreadByTalker.INSTANCE, dexKitBridge,
                (obj -> {
                    ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                        DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj1;
                        DexFinder cdjVar5 = new DexFinder();
                        cdjVar5.setDeclaredClassName(StaticHelpers7.toDexClass(ConversationStorage$ClassConversationStorage.INSTANCE));
                        cdjVar5.usingStrings("updateUnreadByTalker %s");
                        dexMethodQueryBuilderVar5.getClass();
                        dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                    })
                }));
        StaticHelpers7.resolveDexAndCache(ConversationStorage$MethodHiddenConvParent.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj1;
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.setDeclaredClassName(StaticHelpers7.toDexClass(ConversationStorage$ClassConversationStorage.INSTANCE));
                cdjVar6.p(new IntRange(2, 4, 1));
                cdjVar6.v("Update ", "rconversation", " set ", "parentRef", " = '");
                cdjVar6.n("' where 1 != 1 ");
                cdjVar6.n("rconversation");
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
            })
        }));
        StaticHelpers7.resolveDexAndCache(ConversationStorage$MethodGetConvByName.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj1;
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.setDeclaredClassName(StaticHelpers7.toDexClass(ConversationStorage$ClassConversationStorage.INSTANCE));
                cdjVar4.usingStrings("MicroMsg.ConversationStorage", "get null with username:");
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
            })
        }));
    }
}
