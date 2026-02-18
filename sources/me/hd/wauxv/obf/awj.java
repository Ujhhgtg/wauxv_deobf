package me.hd.wauxv.obf;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awj implements btj {
    public final Object a;
    public final int b;
    public final int c;
    public final Class e;
    public final Class f;
    public final btj g;
    public final Map h;
    public final crw i;
    public int j;

    public awj(Object obj, btj btjVar, int i, int i2, Map map, Class cls, Class cls2, crw crwVar) {
        cmz.n(obj, "Argument must not be null");
        this.a = obj;
        this.g = btjVar;
        this.b = i;
        this.c = i2;
        cmz.n(map, "Argument must not be null");
        this.h = map;
        cmz.n(cls, "Resource class must not be null");
        this.e = cls;
        cmz.n(cls2, "Transcode class must not be null");
        this.f = cls2;
        cmz.n(crwVar, "Argument must not be null");
        this.i = crwVar;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof awj) {
            awj awjVar = (awj) obj;
            if (this.a.equals(awjVar.a) && this.g.equals(awjVar.g) && this.c == awjVar.c && this.b == awjVar.b && this.h.equals(awjVar.h) && this.e.equals(awjVar.e) && this.f.equals(awjVar.f) && this.i.equals(awjVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.a.hashCode();
            this.j = iHashCode;
            int iHashCode2 = ((((this.g.hashCode() + (iHashCode * 31)) * 31) + this.b) * 31) + this.c;
            this.j = iHashCode2;
            int iHashCode3 = this.h.hashCode() + (iHashCode2 * 31);
            this.j = iHashCode3;
            int iHashCode4 = this.e.hashCode() + (iHashCode3 * 31);
            this.j = iHashCode4;
            int iHashCode5 = this.f.hashCode() + (iHashCode4 * 31);
            this.j = iHashCode5;
            this.j = this.i.a.hashCode() + (iHashCode5 * 31);
        }
        return this.j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.a + ", width=" + this.b + ", height=" + this.c + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
