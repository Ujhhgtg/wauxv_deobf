package me.hd.wauxv.obf;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface bog {
    ImageHeaderParser$ImageType j(ByteBuffer byteBuffer);

    int k(InputStream inputStream, bva bvaVar);

    ImageHeaderParser$ImageType l(InputStream inputStream);

    int m(ByteBuffer byteBuffer, bva bvaVar);

    boolean n(ByteBuffer byteBuffer, bva bvaVar);

    boolean o(InputStream inputStream, bva bvaVar);
}
