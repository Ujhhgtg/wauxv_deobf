package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhm implements Serializable {
    public final String a;
    public final int b;
    public final String c;

    public bhm(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bhm)) {
            return false;
        }
        bhm bhmVar = (bhm) obj;
        return bzo.f(this.a, bhmVar.a) && this.b == bhmVar.b && bzo.f(this.c, bhmVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + dts.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-45346264709930L));
        yg.u(sb, this.a, -45221710658346L);
        dkz.ac(sb, this.b, -45217415691050L);
        return bjs.q(sb, this.c, ')');
    }
}
