package me.hd.wauxv.obf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ud {
    public int a;
    public int b;
    public int c;

    public ud(int i, int i2, int i3) {
        this.a = i3;
        this.b = i;
        this.c = i2;
    }

    public final ud d() {
        ud udVar = new ud();
        udVar.a = this.a;
        udVar.b = this.b;
        udVar.c = this.c;
        return udVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ud) {
            ud udVar = (ud) obj;
            if (udVar.c == this.c && udVar.b == this.b && udVar.a == this.a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CharPosition(line = ");
        sb.append(this.b);
        sb.append(",column = ");
        sb.append(this.c);
        sb.append(",index = ");
        return yg.m(sb, ")", this.a);
    }
}
