package me.hd.wauxv.obf;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axm implements bog {
    @Override // me.hd.wauxv.obf.bog
    public final ImageHeaderParser$ImageType j(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // me.hd.wauxv.obf.bog
    public final int k(InputStream inputStream, bva bvaVar) throws Throwable {
        int i;
        axl axlVar = new axl(inputStream);
        axh axhVarAt = axlVar.at("Orientation");
        if (axhVarAt == null) {
            i = 1;
        } else {
            try {
                i = axhVarAt.i(axlVar.ak);
            } catch (NumberFormatException unused) {
                i = 1;
            }
        }
        if (i == 0) {
            return -1;
        }
        return i;
    }

    @Override // me.hd.wauxv.obf.bog
    public final ImageHeaderParser$ImageType l(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // me.hd.wauxv.obf.bog
    public final int m(ByteBuffer byteBuffer, bva bvaVar) {
        AtomicReference atomicReference = sf.a;
        return k(new se(byteBuffer), bvaVar);
    }

    @Override // me.hd.wauxv.obf.bog
    public final boolean n(ByteBuffer byteBuffer, bva bvaVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.bog
    public final boolean o(InputStream inputStream, bva bvaVar) {
        return false;
    }
}
