package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yx {
    public final amk a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;

    public yx(amk amkVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = amkVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
    }

    public final String toString() {
        int i = this.c;
        int i2 = this.e;
        amk amkVar = this.a;
        if (amkVar == null) {
            return i + " " + i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) amkVar.g.get(i));
        if (i2 != -1) {
            sb.append(" extends ");
            sb.append((String) amkVar.g.get(i2));
        }
        return sb.toString();
    }
}
