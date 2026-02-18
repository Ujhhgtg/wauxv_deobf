package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgs extends dgu {
    public static final RectF a = new RectF();
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public float f;
    public float g;

    public dgs(float f, float f2, float f3, float f4) {
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    @Override // me.hd.wauxv.obf.dgu
    public final void h(Matrix matrix, Path path) {
        Matrix matrix2 = this.i;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f = this.d;
        float f2 = this.e;
        RectF rectF = a;
        rectF.set(this.b, this.c, f, f2);
        path.arcTo(rectF, this.f, this.g, false);
        path.transform(matrix);
    }
}
