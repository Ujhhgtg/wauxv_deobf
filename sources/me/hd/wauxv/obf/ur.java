package me.hd.wauxv.obf;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ur extends bws {
    public static final ur a = new ur();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        adt adtVarM = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-50749333568298L)   */)).m();
        adtVarM.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(Context.class), dal.getKClassFromClass(AttributeSet.class), dal.getKClassFromClass(Integer.TYPE) },
                3));
        HookManager hookManagerVarAd = createImmediateHook((ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a()), HookPriorityEnum.ENUM_DEFAULT);
        hookManagerVarAd.m(new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(27));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
    }
}
