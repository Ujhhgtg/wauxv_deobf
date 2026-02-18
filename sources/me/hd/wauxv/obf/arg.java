package me.hd.wauxv.obf;

import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class arg extends arf {
    @Override // me.hd.wauxv.obf.arf
    public void a(Window window) {
        throwIfVar1IsNull(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 1;
    }
}
