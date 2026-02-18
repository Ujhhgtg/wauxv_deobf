package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nj implements Cloneable {
    public int a;
    public boolean h;
    public boolean l;
    public boolean m;
    public boolean o;
    public aoi b = aoi.c;
    public cvq c = cvq.c;
    public boolean d = true;
    public int e = -1;
    public int f = -1;
    public btj g = avi.a;
    public crw i = new crw();
    public sp j = new sp(0);
    public Class k = Object.class;
    public boolean n = true;

    public static boolean p(int i, int i2) {
        return (i & i2) != 0;
    }

    public final nj aa(cpi cpiVar) {
        if (this.m) {
            return clone().aa(cpiVar);
        }
        this.g = cpiVar;
        this.a |= 1024;
        y();
        return this;
    }

    public final nj ab() {
        if (this.m) {
            return clone().ab();
        }
        this.d = false;
        this.a |= 256;
        y();
        return this;
    }

    public final nj ac(Class cls, elc elcVar, boolean z) {
        if (this.m) {
            return clone().ac(cls, elcVar, z);
        }
        cmz.m(elcVar);
        this.j.put(cls, elcVar);
        int i = this.a;
        this.a = 67584 | i;
        this.n = false;
        if (z) {
            this.a = i | 198656;
            this.h = true;
        }
        y();
        return this;
    }

    public final nj ad(elc elcVar, boolean z) {
        if (this.m) {
            return clone().ad(elcVar, z);
        }
        apt aptVar = new apt(elcVar, z);
        ac(Bitmap.class, elcVar, z);
        ac(Drawable.class, aptVar, z);
        ac(BitmapDrawable.class, aptVar, z);
        ac(bha.class, new bhc(elcVar), z);
        y();
        return this;
    }

    public final nj ae() {
        if (this.m) {
            return clone().ae();
        }
        this.o = true;
        this.a |= 1048576;
        y();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof nj) {
            return u((nj) obj);
        }
        return false;
    }

    public int hashCode() {
        char[] cArr = eot.a;
        return eot.k(eot.k(eot.k(eot.k(eot.k(eot.k(eot.k(eot.j(0, eot.j(0, eot.j(1, eot.j(this.h ? 1 : 0, eot.j(this.f, eot.j(this.e, eot.j(this.d ? 1 : 0, eot.k(eot.j(0, eot.k(eot.j(0, eot.k(eot.j(0, eot.j(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.b), this.c), this.i), this.j), this.k), this.g), null);
    }

    public nj q(nj njVar) {
        if (this.m) {
            return clone().q(njVar);
        }
        int i = njVar.a;
        if (p(njVar.a, 1048576)) {
            this.o = njVar.o;
        }
        if (p(njVar.a, 4)) {
            this.b = njVar.b;
        }
        if (p(njVar.a, 8)) {
            this.c = njVar.c;
        }
        if (p(njVar.a, 16)) {
            this.a &= -33;
        }
        if (p(njVar.a, 32)) {
            this.a &= -17;
        }
        if (p(njVar.a, 64)) {
            this.a &= -129;
        }
        if (p(njVar.a, 128)) {
            this.a &= -65;
        }
        if (p(njVar.a, 256)) {
            this.d = njVar.d;
        }
        if (p(njVar.a, 512)) {
            this.f = njVar.f;
            this.e = njVar.e;
        }
        if (p(njVar.a, 1024)) {
            this.g = njVar.g;
        }
        if (p(njVar.a, 4096)) {
            this.k = njVar.k;
        }
        if (p(njVar.a, 8192)) {
            this.a &= -16385;
        }
        if (p(njVar.a, 16384)) {
            this.a &= -8193;
        }
        if (p(njVar.a, 131072)) {
            this.h = njVar.h;
        }
        if (p(njVar.a, 2048)) {
            this.j.putAll(njVar.j);
            this.n = njVar.n;
        }
        this.a |= njVar.a;
        this.i.a.g(njVar.i.a);
        y();
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public nj clone() {
        try {
            nj njVar = (nj) super.clone();
            crw crwVar = new crw();
            njVar.i = crwVar;
            crwVar.a.g(this.i.a);
            sp spVar = new sp(0);
            njVar.j = spVar;
            spVar.putAll(this.j);
            njVar.l = false;
            njVar.m = false;
            return njVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final nj s(Class cls) {
        if (this.m) {
            return clone().s(cls);
        }
        this.k = cls;
        this.a |= 4096;
        y();
        return this;
    }

    public final nj t(aoi aoiVar) {
        if (this.m) {
            return clone().t(aoiVar);
        }
        this.b = aoiVar;
        this.a |= 4;
        y();
        return this;
    }

    public final boolean u(nj njVar) {
        njVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0) {
            return false;
        }
        char[] cArr = eot.a;
        return this.d == njVar.d && this.e == njVar.e && this.f == njVar.f && this.h == njVar.h && this.b.equals(njVar.b) && this.c == njVar.c && this.i.equals(njVar.i) && this.j.equals(njVar.j) && this.k.equals(njVar.k) && this.g.equals(njVar.g);
    }

    public final nj v(apo apoVar, pb pbVar) {
        if (this.m) {
            return clone().v(apoVar, pbVar);
        }
        z(apo.f, apoVar);
        return ad(pbVar, false);
    }

    public final nj w(int i, int i2) {
        if (this.m) {
            return clone().w(i, i2);
        }
        this.f = i;
        this.e = i2;
        this.a |= 512;
        y();
        return this;
    }

    public final nj x() {
        if (this.m) {
            return clone().x();
        }
        this.c = cvq.d;
        this.a |= 8;
        y();
        return this;
    }

    public final void y() {
        if (this.l) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final nj z(cru cruVar, apo apoVar) {
        if (this.m) {
            return clone().z(cruVar, apoVar);
        }
        cmz.m(cruVar);
        this.i.a.put(cruVar, apoVar);
        y();
        return this;
    }
}
