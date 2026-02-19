package me.hd.wauxv.obf;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rz implements dcj {
    public final /* synthetic */ int a;
    public final BitmapImageDecoder b;

    public rz(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new BitmapImageDecoder();
                break;
            default:
                this.b = new BitmapImageDecoder();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                return this.b.e(ImageDecoder.createSource((ByteBuffer) obj), i, i2, crwVar);
            default:
                return this.b.e(ImageDecoder.createSource(sf.c((InputStream) obj)), i, i2, crwVar);
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final /* bridge */ /* synthetic */ boolean d(Object obj, crw crwVar) {
        switch (this.a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
