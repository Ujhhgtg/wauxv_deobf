package me.hd.wauxv.obf;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bmg implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ XC_MethodHook.Unhook b;

    public /* synthetic */ bmg(XC_MethodHook.Unhook unhook, int i) {
        this.a = i;
        this.b = unhook;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                return this.b.getHookedMethod();
            default:
                this.b.unhook();
                return ens.a;
        }
    }
}
