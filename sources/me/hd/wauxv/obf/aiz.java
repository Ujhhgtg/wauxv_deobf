package me.hd.wauxv.obf;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aiz implements btj {
    public final btj a;
    public final btj b;

    public aiz(btj btjVar, btj btjVar2) {
        this.a = btjVar;
        this.b = btjVar2;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        this.a.d(messageDigest);
        this.b.d(messageDigest);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof aiz) {
            aiz aizVar = (aiz) obj;
            if (this.a.equals(aizVar.a) && this.b.equals(aizVar.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.a + ", signature=" + this.b + '}';
    }
}
