package me.hd.wauxv.obf;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqo implements OnBackAnimationCallback {
    public final /* synthetic */ IInvokable a;
    public final /* synthetic */ IInvokable b;
    public final /* synthetic */ IFunction0 c;
    public final /* synthetic */ IFunction0 d;

    public cqo(IInvokable bgfVar, IInvokable bgfVar2, IFunction0 bfuVar, IFunction0 bfuVar2) {
        this.a = bgfVar;
        this.b = bgfVar2;
        this.c = bfuVar;
        this.d = bfuVar2;
    }

    public final void onBackCancelled() {
        this.d.invoke();
    }

    public final void onBackInvoked() {
        this.c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        this.b.invoke(new mt(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        this.a.invoke(new mt(backEvent));
    }
}
