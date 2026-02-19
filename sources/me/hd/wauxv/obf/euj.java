package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euj extends bws {
    public static final euj a = new euj();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (cnb.ab(ewk.o) || cnb.ac(ewh.r)) {
            int i = 0;
            MethodResolver methodResolverVarT = yg.s(-57896159148842L).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-58119497448234L)  */;
            HookManager hookManagerVarAd = a.createImmediateHook((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.getKClassFromClass(Bundle.class) }, 1, methodResolverVarT), HookPriorityEnum.ENUM_LOWEST);
            hookManagerVarAd.m(new epy(15));
            hookManagerVarAd.initInstantCollectionAndApplyHooks();
        }
    }
}
