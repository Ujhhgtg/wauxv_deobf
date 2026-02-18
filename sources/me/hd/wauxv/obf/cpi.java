package me.hd.wauxv.obf;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cpi implements btj {
    public final Object a;

    public cpi(Object obj) {
        cmz.n(obj, "Argument must not be null");
        this.a = obj;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        messageDigest.update(this.a.toString().getBytes(btj.k));
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof cpi) {
            return this.a.equals(((cpi) obj).a);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.a + '}';
    }
}
