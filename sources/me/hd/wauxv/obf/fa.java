package me.hd.wauxv.obf;

import android.graphics.ImageDecoder;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fa implements dcj {
    public final /* synthetic */ int a;
    public final DefaultConfig b;

    public /* synthetic */ fa(DefaultConfig ioVar, int i) {
        this.a = i;
        this.b = ioVar;
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                return DefaultConfig.e(ImageDecoder.createSource((ByteBuffer) obj), i, i2, crwVar);
            default:
                return DefaultConfig.e(ImageDecoder.createSource(sf.c((InputStream) obj)), i, i2, crwVar);
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final boolean d(Object obj, crw crwVar) throws IOException {
        switch (this.a) {
            case 0:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeAa = bhv.aa((ArrayList) this.b.c, (ByteBuffer) obj);
                return imageHeaderParser$ImageTypeAa == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeAa == ImageHeaderParser$ImageType.ANIMATED_AVIF);
            default:
                DefaultConfig ioVar = this.b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeZ = bhv.z((ArrayList) ioVar.c, (InputStream) obj, (bva) ioVar.d);
                return imageHeaderParser$ImageTypeZ == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeZ == ImageHeaderParser$ImageType.ANIMATED_AVIF);
        }
    }
}
