package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ox implements dcj {
    public final /* synthetic */ int a;
    public final oz b;

    public ox() {
        this.a = 0;
        this.b = new nu(2);
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                return e(as.e(obj), i, i2, crwVar);
            default:
                return pa.g(((dmg) obj).v(), this.b);
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final /* bridge */ /* synthetic */ boolean d(Object obj, crw crwVar) {
        switch (this.a) {
            case 0:
                as.v(obj);
                break;
            default:
                break;
        }
        return true;
    }

    public pa e(ImageDecoder.Source source, int i, int i2, crw crwVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new alb(i, i2, crwVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new pa(bitmapDecodeBitmap, (nu) this.b);
    }

    public ox(oz ozVar) {
        this.a = 1;
        this.b = ozVar;
    }
}
