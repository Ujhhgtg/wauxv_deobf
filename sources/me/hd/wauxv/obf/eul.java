package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eul extends bws {
    public static final eul a = new eul();
    public static final List b = dqc.toSingletonList(new euk("WAuxiliary_setting_pref" /* "WAuxiliary_setting_pref" /* "WAuxiliary_setting_pref" /* cnb.z(-58884001626922L)  */,
            "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-59330678225706L)  */, new epy(16)));

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        SyntheticPileOfMess bmuVarS = yg.s(-57591216470826L);
        MethodResolver methodResolverVarT = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-59051505351466L)  */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.b(Bundle.class) }, 1, methodResolverVarT);
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_HIGHEST;
        eul eulVar = a;
        aki akiVarAd = eulVar.ad(methodHookWrapperVar, hookPriorityEnumVar);
        akiVarAd.m(new epy(17));
        akiVarAd.o();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* cnb.z(-59030030514986L)  */;
        aki akiVarAd2 = eulVar.ad((MethodHookWrapper) StaticHelpers6.n(new Object[] { eoz.a, cvh.a.b() }, 2, methodResolverVarT2), HookPriorityEnum.ENUM_DEFAULT);
        akiVarAd2.n(new epy(18));
        akiVarAd2.o();
    }
}
