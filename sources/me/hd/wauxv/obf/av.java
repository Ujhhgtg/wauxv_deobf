package me.hd.wauxv.obf;

import android.view.inputmethod.SurroundingText;
import android.view.inputmethod.TextSnapshot;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class av {
    public static /* synthetic */ TextSnapshot b(SurroundingText surroundingText, int i, int i2, int i3) {
        return new TextSnapshot(surroundingText, i, i2, i3);
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedCallback c(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher e(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }
}
