package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import me.hd.wauxv.obf.ajh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ajh {
    public final ParcelFileDescriptorRewinder$InternalRewinder a;

    public a(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public final ParcelFileDescriptor b() {
        return this.a.rewind();
    }

    @Override // me.hd.wauxv.obf.ajh
    public final void c() {
    }

    @Override // me.hd.wauxv.obf.ajh
    public final Object d() {
        return this.a.rewind();
    }
}
