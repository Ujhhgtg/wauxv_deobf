package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjn {
    public int a;
    public int b;

    public /* synthetic */ cjn(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public void c(czx czxVar) {
        View view = czxVar.d;
        this.a = view.getLeft();
        this.b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
