package me.hd.wauxv.obf;

import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ert {
    public final View a;
    public int b;
    public int c;
    public int d;

    public ert(View view) {
        this.a = view;
    }

    public final void e() {
        int i = this.d;
        View view = this.a;
        int top = i - (view.getTop() - this.b);
        WeakHashMap weakHashMap = ViewCompat.a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.c));
    }

    public final boolean f(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        e();
        return true;
    }
}
