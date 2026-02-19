package me.hd.wauxv.obf;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sd implements ajg {
    public final /* synthetic */ int a;

    public /* synthetic */ sd(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.ajg
    public final Class b() {
        switch (this.a) {
            case 0:
                return ByteBuffer.class;
            case 1:
                throw new UnsupportedOperationException("Not implemented");
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // me.hd.wauxv.obf.ajg
    public final ajh c(Object obj) {
        switch (this.a) {
            case 0:
                return new ri(1, (ByteBuffer) obj);
            case 1:
                return new LateinitProperty(obj, 3);
            default:
                return new com.bumptech.glide.load.data.a((ParcelFileDescriptor) obj);
        }
    }
}
