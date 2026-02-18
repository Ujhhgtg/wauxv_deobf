package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgt extends dgu {
    public float a;
    public float b;

    @Override // me.hd.wauxv.obf.dgu
    public final void h(Matrix matrix, Path path) {
        Matrix matrix2 = this.i;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.a, this.b);
        path.transform(matrix);
    }
}
