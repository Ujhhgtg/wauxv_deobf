package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eso {
    public static final est a;
    public static final tr b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new esu();
        } else {
            a = new est();
        }
        b = new tr("translationAlpha", 6, Float.class);
        new tr("clipBounds", 7, Rect.class);
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        a.ak(view, i, i2, i3, i4);
    }

    public static void d(View view, int i) {
        a.ag(view, i);
    }
}
