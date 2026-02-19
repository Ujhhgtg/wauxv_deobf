package me.hd.wauxv.obf;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aeq extends bws {
    public static final aeq a = new aeq();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        SyntheticPileOfMess bmuVarS = yg.s(-38001870633770L);
        MethodResolver methodResolverVarT = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "initView" /* "initView" /* "initView" /* "initView" /* cnb.z(-38332583115562L)   */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        aeq aeqVar = a;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        aki akiVarAd = aeqVar.ad(methodHookWrapperVar, hookPriorityEnumVar);
        akiVarAd.m(new act(21));
        akiVarAd.o();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* cnb.z(-38311108279082L)   */;
        aki akiVarAd2 = aeqVar.ad((MethodHookWrapper) StaticHelpers6.n(new Object[] { eoz.a, cvh.a.b() }, 2, methodResolverVarT2), hookPriorityEnumVar);
        akiVarAd2.n(new act(22));
        akiVarAd2.o();
    }
}
