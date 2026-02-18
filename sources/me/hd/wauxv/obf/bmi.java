package me.hd.wauxv.obf;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bmi implements bgj {
    public final /* synthetic */ int a;
    public final /* synthetic */ XC_MethodHook.MethodHookParam b;

    public /* synthetic */ bmi(XC_MethodHook.MethodHookParam methodHookParam, int i) {
        this.a = i;
        this.b = methodHookParam;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                XC_MethodHook.MethodHookParam methodHookParam = this.b;
                if (zBooleanValue) {
                    methodHookParam.setResult(obj);
                }
                return methodHookParam.getResult();
            default:
                Throwable th = (Throwable) obj;
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                XC_MethodHook.MethodHookParam methodHookParam2 = this.b;
                if (zBooleanValue2) {
                    methodHookParam2.setThrowable(th);
                }
                return methodHookParam2.getThrowable();
        }
    }
}
