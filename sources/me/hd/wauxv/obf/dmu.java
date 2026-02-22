package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmu extends ApiHookItem implements IDexFind {
    public static final dmu a = new dmu();

    public static Object b() {
        ServiceManagerDexFinder.INSTANCE.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ServiceManagerDexFinder.getServiceByClass(StaticHelpers7.toDexClass(StorageFeatureService$ClassStorageFeatureService.INSTANCE))).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(ConversationStorage$ClassConversationStorage.INSTANCE);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ContactStorage$ClassContactStorage.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj1;
                String[] strArr7 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-366897581259562L)   */ };
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr7);
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* cnb.z(-366798797011754L)   */);
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
            })
        }));
        StaticHelpers7.resolveDexAndCache(MsgInfoStorage$ClassMsgInfoStorage.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj1;
                String[] strArr9 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-367206818904874L)   */ };
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr9);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* cnb.z(-367108034657066L)   */,
                        "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* cnb.z(-367004955441962L)   */);
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
            })
        }));
        StaticHelpers7.resolveDexAndCache(ConversationStorage$ClassConversationStorage_.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj1;
                String[] strArr8 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-366373595249450L)   */ };
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.strings = SomeStaticHelpers.arrayToList(strArr8);
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* cnb.z(-366274811001642L)   */);
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
            })
        }));
        StaticHelpers7.resolveDexAndCache(StorageFeatureService$ClassStorageFeatureService.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar5 = (DexClassQueryBuilder) obj1;
                String[] strArr10 = { "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* cnb.z(-366626998319914L)   */ };
                dexClassQueryBuilderVar5.getClass();
                dexClassQueryBuilderVar5.strings = SomeStaticHelpers.arrayToList(strArr10);
                DexMethodGroupMatcher zbVar5 = new DexMethodGroupMatcher();
                azl azlVar = new azl();
                azlVar.f(StaticHelpers7.toDexClass(ContactStorage$ClassContactStorage.INSTANCE));
                azlVar.f(StaticHelpers7.toDexClass(MsgInfoStorage$ClassMsgInfoStorage.INSTANCE));
                azlVar.f(StaticHelpers7.toDexClass(ConversationStorage$ClassConversationStorage_.INSTANCE));
                zbVar5.e = azlVar;
                dexClassQueryBuilderVar5.methodGroupMatcher = zbVar5;
            })
        }));
    }
}
