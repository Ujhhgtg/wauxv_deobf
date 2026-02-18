package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class akf {
    public final String b;
    public final Set c;
    public final boolean d;
    public final int e;
    public final float f;
    public final long g;
    public final dov h;

    public akf(String str, String str2, Set set, boolean z, int i, float f, long j, int i2) {
        str2 = (i2 & 2) != 0 ? cnb.z(-5514738006826L) : str2;
        set = (i2 & 4) != 0 ? new LinkedHashSet() : set;
        z = (i2 & 8) != 0 ? false : z;
        i = (i2 & 16) != 0 ? 0 : i;
        f = (i2 & 32) != 0 ? 0.0f : f;
        j = (i2 & 64) != 0 ? 0L : j;
        this.b = str2;
        this.c = set;
        this.d = z;
        this.e = i;
        this.f = f;
        this.g = j;
        this.h = new dov(new ake(str, 0));
    }

    public final boolean i() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.ah(strM, this.d);
        }
        throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
    }

    public final float j() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.aj().getFloat(strM, this.f);
        }
        throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
    }

    public final int k() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.aj().getInt(strM, this.e);
        }
        throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
    }

    public final long l() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.aj().getLong(strM, this.g);
        }
        throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
    }

    public final String m() {
        return (String) this.h.getValue();
    }

    public final Set n() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        Set stringSet = ioVar.aj().getStringSet(strM, this.c);
        bzo.n(stringSet);
        return stringSet;
    }

    public final String o() {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        String string = ioVar.aj().getString(strM, this.b);
        bzo.n(string);
        return string;
    }

    public final void p(boolean z) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.at(strM, z);
    }

    public final void q(float f) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.aj().putFloat(strM, f);
    }

    public final void r(int i) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.aj().putInt(strM, i);
    }

    public final void s(long j) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.aj().putLong(strM, j);
    }

    public final void t(Set set) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.aj().putStringSet(strM, set);
    }

    public final void u(String str) {
        String strM = m();
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.aj().putString(strM, str);
    }
}
