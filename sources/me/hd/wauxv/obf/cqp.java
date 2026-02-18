package me.hd.wauxv.obf;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqp {
    public static final cqp a = new cqp();

    public final OnBackInvokedCallback b(IHasInvokeMethod bgfVar, IHasInvokeMethod bgfVar2, bfu bfuVar, bfu bfuVar2) {
        throwIfVar1IsNull(bgfVar, "onBackStarted");
        throwIfVar1IsNull(bgfVar2, "onBackProgressed");
        throwIfVar1IsNull(bfuVar, "onBackInvoked");
        throwIfVar1IsNull(bfuVar2, "onBackCancelled");
        return new cqo(bgfVar, bgfVar2, bfuVar, bfuVar2);
    }
}
