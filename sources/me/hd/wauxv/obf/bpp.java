package me.hd.wauxv.obf;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpp implements ajg {
    public final bva a;

    public bpp(bva bvaVar) {
        this.a = bvaVar;
    }

    @Override // me.hd.wauxv.obf.ajg
    public final Class b() {
        return InputStream.class;
    }

    @Override // me.hd.wauxv.obf.ajg
    public final ajh c(Object obj) {
        return new SyntheticPileOfMess((InputStream) obj, this.a);
    }
}
