package me.hd.wauxv.obf;

import android.database.Cursor;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgf extends bws {
    public static final cgf a = new cgf();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-66662187399978L)  */;
        methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(Cursor.class) }, 1));
        methodResolverVarT.enableSuperclass();
        HookManager hookManagerVarAd = createImmediateHook((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods()), HookPriorityEnum.ENUM_DEFAULT);
        hookManagerVarAd.m(new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(22));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
    }
}
