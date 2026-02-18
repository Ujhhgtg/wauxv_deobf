package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class re {
    public static final Matrix a = new Matrix();

    public static void b(Path path, float f, float f2, float f3, float f4, float f5) {
        path.arcTo(f - f3, f2 - f3, f + f3, f2 + f3, f4, f5, false);
    }
}
