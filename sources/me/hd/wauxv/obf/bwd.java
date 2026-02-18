package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bwd implements dfx {
    public final dfx c;

    public bwd(dfx dfxVar) {
        this.c = dfxVar;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bwd)) {
            return false;
        }
        bwd bwdVar = (bwd) obj;
        return bzo.f(this.c, bwdVar.c) && bzo.f(b(), bwdVar.b());
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        bzo.q(str, "name");
        Integer numBf = dnq.bf(str);
        if (numBf != null) {
            return numBf.intValue();
        }
        throw new IllegalArgumentException(str.concat(" is not a valid list index"));
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return dnt.b;
    }

    public final int hashCode() {
        return b().hashCode() + (this.c.hashCode() * 31);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return String.valueOf(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        if (i >= 0) {
            return avd.a;
        }
        StringBuilder sbR = yg.r(i, "Illegal index ", ", ");
        sbR.append(b());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        if (i >= 0) {
            return this.c;
        }
        StringBuilder sbR = yg.r(i, "Illegal index ", ", ");
        sbR.append(b());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        if (i >= 0) {
            return false;
        }
        StringBuilder sbR = yg.r(i, "Illegal index ", ", ");
        sbR.append(b());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public final String toString() {
        return b() + '(' + this.c + ')';
    }
}
