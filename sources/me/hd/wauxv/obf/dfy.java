package me.hd.wauxv.obf;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfy implements dfx, sr {
    public final dfx c;
    public final String e;
    public final Set n;

    public dfy(dfx dfxVar) {
        bzo.q(dfxVar, "original");
        this.c = dfxVar;
        this.e = dfxVar.b() + '?';
        this.n = cnh.i(dfxVar);
    }

    @Override // me.hd.wauxv.obf.sr
    public final Set a() {
        return this.n;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return this.e;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return this.c.d();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof dfy) {
            return bzo.f(this.c, ((dfy) obj).c);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return true;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        bzo.q(str, "name");
        return this.c.g(str);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return this.c.getAnnotations();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return this.c.h();
    }

    public final int hashCode() {
        return this.c.hashCode() * 31;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return this.c.i();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return this.c.j(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        return this.c.k(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        return this.c.l(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        return this.c.m(i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append('?');
        return sb.toString();
    }
}
