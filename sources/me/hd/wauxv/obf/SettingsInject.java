package me.hd.wauxv.obf;

import android.os.Bundle;
import me.hd.wauxv.R;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsInject extends bws {
    public static final SettingsInject INSTANCE = new SettingsInject();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (cnb.ab(ewk.o) || cnb.ac(ewh.r)) {
            MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.plugin.setting.ui.setting_new.base.BaseSettingPrefUI")).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "onCreate";
            HookManager hookManagerVarAd = INSTANCE.createImmediateHook((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(Bundle.class) }, 1, methodResolverVarT), HookPriorityEnum.ENUM_LOWEST);
            hookManagerVarAd.m((obj -> {
                HookParam hookParam3 = (HookParam) obj;
                Object obj6 = ((XposedMethodHookParamWrapper) hookParam3.b.b).b.thisObject;
                if (nullSafeIsEqual(obj6 != null ? obj6.getClass() : null, ajn.tryGetClassByClassName(
                        "com.tencent.mm.plugin.setting.ui.setting_new.MainSettingsUI"))) {
                    Object objE5 = hookParam3.getThisObject();
                    Activity activity = (Activity) (objE5 instanceof Activity ? objE5 : null);
                    ars arsVar = new ars(activity, 2);
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(activity).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.name = "addTextOptionMenu";
                    methodResolverVarT2.setParams(Arrays.copyOf(
                            new Object[] { dal.getKClassFromClass(Integer.TYPE), dal.getKClassFromClass(String.class), dal.getKClassFromClass(MenuItem.OnMenuItemClickListener.class) },
                            3));
                    methodResolverVarT2.enableSuperclass();
                    ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(R.id.Wauxv_Entry_Item), "WA", () -> {
                        // open dialog here
                    });
                }
            }));
            hookManagerVarAd.initInstantCollectionAndApplyHooks();
        }
    }
}
