package me.hd.wauxv.obf;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class XposedMethodHookParamWrapper implements IFunction0 {
    public final /* synthetic */ int switchKey0IsMethod1IsThisObjectElseIsArgs;
    public final /* synthetic */ XC_MethodHook.MethodHookParam b;

    public /* synthetic */ XposedMethodHookParamWrapper(XC_MethodHook.MethodHookParam methodHookParam, int i) {
        this.switchKey0IsMethod1IsThisObjectElseIsArgs = i;
        this.b = methodHookParam;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.switchKey0IsMethod1IsThisObjectElseIsArgs) {
            case 0:
                return this.b.method;
            case 1:
                return this.b.thisObject;
            default:
                return this.b.args;
        }
    }
}
