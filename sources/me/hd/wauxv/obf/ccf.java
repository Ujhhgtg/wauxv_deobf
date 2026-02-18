package me.hd.wauxv.obf;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccf implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ccg a;

    public ccf(ccg ccgVar) {
        this.a = ccgVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.c();
    }
}
