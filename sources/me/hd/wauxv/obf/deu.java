package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class deu extends SwitchHook {
    public static final deu a;
    public static final List b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final dbj j;

    static {
        "${time} ${nick}" /* "${time} ${nick}" /* "${time} ${nick}" /* cnb.z(-514820549901098L)  */;
        "yyyy-MM-dd" /* "yyyy-MM-dd" /* "yyyy-MM-dd" /* cnb.z(-514751830424362L)  */;
        a = new deu("SayHiAutoRemarkNameHook" /* "SayHiAutoRemarkNameHook" /* "SayHiAutoRemarkNameHook" /* cnb.z(-518411142560554L)  */);
        b = OtherStaticHelpers.argsToList("${nick}" /* "${nick}" /* "${nick}" /* cnb.z(-514721765653290L)  */, "${time}" /* "${time}" /* "${time}" /* cnb.z(-514687405914922L)  */);
        c = "杂项" /* "杂项" /* "杂项" /* cnb.z(-514653046176554L)  */;
        h = "添加自动备注" /* "添加自动备注" /* "添加自动备注" /* cnb.z(-514674521013034L)  */;
        i = "添加好友时将备注进行自定义格式处理" /* "添加好友时将备注进行自定义格式处理" /* "添加好友时将备注进行自定义格式处理" /* cnb.z(-514627276372778L)  */;
        j = new dbj(18);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i2 = 0;
        MethodResolver methodResolverVarT = yg.s(-518239343868714L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "initView" /* "initView" /* "initView" /* cnb.z(-515258636565290L)  */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) bjs.h(methodResolverVarT);
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        deu deuVar = a;
        HookManager hookManagerVarAd = deuVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        deuVar.hookBefore(hookManagerVarAd, new dbj(19));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return j;
    }
}
