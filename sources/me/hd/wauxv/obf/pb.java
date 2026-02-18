package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pb implements elc {
    @Override // me.hd.wauxv.obf.elc
    public final dcg a(Context context, dcg dcgVar, int i, int i2) {
        if (!eot.l(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        oz ozVar = com.bumptech.glide.a.j(context).c;
        Bitmap bitmap = (Bitmap) dcgVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapB = b(ozVar, bitmap, i, i2);
        return bitmap.equals(bitmapB) ? dcgVar : pa.g(bitmapB, ozVar);
    }

    public abstract Bitmap b(oz ozVar, Bitmap bitmap, int i, int i2);
}
