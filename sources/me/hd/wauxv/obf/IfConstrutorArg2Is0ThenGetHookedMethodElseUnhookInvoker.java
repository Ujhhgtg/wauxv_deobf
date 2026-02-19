package me.hd.wauxv.obf;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IfConstrutorArg2Is0ThenGetHookedMethodElseUnhookInvoker implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ XC_MethodHook.Unhook xposedUnhook;

    public /* synthetic */ IfConstrutorArg2Is0ThenGetHookedMethodElseUnhookInvoker(XC_MethodHook.Unhook unhook, int i) {
        this.a = i;
        this.xposedUnhook = unhook;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                return this.xposedUnhook.getHookedMethod();
            default:
                this.xposedUnhook.unhook();
                return Kotlin$Unit.INSTANCE;
        }
    }
}
