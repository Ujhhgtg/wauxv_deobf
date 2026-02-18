package me.hd.wauxv.obf;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crw implements btj {
    public final sp a = new sp(0);

    public final Object b(cru cruVar) {
        sp spVar = this.a;
        return spVar.containsKey(cruVar) ? spVar.get(cruVar) : cruVar.b;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            sp spVar = this.a;
            if (i >= spVar.l) {
                return;
            }
            cru cruVar = (cru) spVar.r(i);
            Object objS = this.a.s(i);
            crt crtVar = cruVar.c;
            if (cruVar.e == null) {
                cruVar.e = cruVar.d.getBytes(btj.k);
            }
            crtVar.e(cruVar.e, objS, messageDigest);
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof crw) {
            return this.a.equals(((crw) obj).a);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.a + '}';
    }
}
