package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tn extends pb {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(btj.k);

    @Override // me.hd.wauxv.obf.pb
    public final Bitmap b(oz ozVar, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        Paint paint = ele.a;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapX = ozVar.x(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapX.setHasAlpha(bitmap.hasAlpha());
        ele.c(bitmap, bitmapX, matrix);
        return bitmapX;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        messageDigest.update(c);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        return obj instanceof tn;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return -599754482;
    }
}
