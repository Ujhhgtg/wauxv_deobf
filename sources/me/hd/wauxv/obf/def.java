package me.hd.wauxv.obf;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class def implements axw {
    public final MessageDigest a;
    public final dmn b = new dmn();

    public def(MessageDigest messageDigest) {
        this.a = messageDigest;
    }

    @Override // me.hd.wauxv.obf.axw
    public final dmn al() {
        return this.b;
    }
}
