package me.hd.wauxv.obf;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmj extends XC_MethodHook {
    public final /* synthetic */ nh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bmj(nh nhVar, int i) {
        super(i);
        this.a = nhVar;
    }

    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (methodHookParam == null) {
            return;
        }
        this.a.c(arj.r(methodHookParam));
    }

    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (methodHookParam == null) {
            return;
        }
        blq blqVarR = arj.r(methodHookParam);
        nh nhVar = this.a;
        if (!(nhVar instanceof kf)) {
            nhVar.d(blqVarR);
        } else {
            ((bmi) blqVarR.d).g(((kf) nhVar).f(blqVarR), Boolean.TRUE);
        }
    }
}
