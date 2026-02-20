package me.hd.wauxv.obf;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hu implements OnBackInvokedCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ hu(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public final void onBackInvoked() {
        switch (this.a) {
            case 0:
                ((AppCompatDelegate) this.b).cm();
                break;
            case 1:
                IFunction0 bfuVar = (IFunction0) this.b;
                throwIfVar1IsNull(bfuVar, "$onBackInvoked");
                bfuVar.invoke();
                break;
            default:
                ((Runnable) this.b).run();
                break;
        }
    }
}
