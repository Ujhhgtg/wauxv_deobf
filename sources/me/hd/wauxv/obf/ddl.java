package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddl extends pb {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(btj.k);
    public final int e;

    public ddl(int i) {
        cmz.k("roundingRadius must be greater than 0.", i > 0);
        this.e = i;
    }

    @Override // me.hd.wauxv.obf.pb
    public final Bitmap b(oz ozVar, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapX;
        Paint paint = ele.a;
        int i3 = this.e;
        cmz.k("roundingRadius must be greater than 0.", i3 > 0);
        Lock lock = ele.b;
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        Bitmap.Config config2 = config.equals(bitmap.getConfig()) ? config : Bitmap.Config.ARGB_8888;
        if (!config.equals(bitmap.getConfig())) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (config.equals(bitmap.getConfig())) {
            bitmapX = bitmap;
        } else {
            bitmapX = ozVar.x(bitmap.getWidth(), bitmap.getHeight(), config);
            new Canvas(bitmapX).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        Bitmap bitmapX2 = ozVar.x(bitmapX.getWidth(), bitmapX.getHeight(), config2);
        bitmapX2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapX, tileMode, tileMode);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapX2.getWidth(), bitmapX2.getHeight());
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapX2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i3;
            canvas.drawRoundRect(rectF, f, f, paint2);
            canvas.setBitmap(null);
            lock.unlock();
            if (!bitmapX.equals(bitmap)) {
                ozVar.p(bitmapX);
            }
            return bitmapX2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.e).array());
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        return (obj instanceof ddl) && this.e == ((ddl) obj).e;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return eot.j(-569625254, eot.j(this.e, 17));
    }
}
