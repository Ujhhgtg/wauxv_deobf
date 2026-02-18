package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azn implements dcj {
    public final /* synthetic */ int a;

    public /* synthetic */ azn(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                return new ez((File) obj);
            case 1:
                return new ez((Bitmap) obj, 3);
            default:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new bhb(drawable, 1);
                }
                return null;
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final /* bridge */ /* synthetic */ boolean d(Object obj, crw crwVar) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }
}
