package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tx implements Serializable {
    public final String a;
    public final boolean b;
    public final int c;
    public final int d;
    public final tw e;

    public tx(String str, boolean z, int i, int i2, tw twVar) {
        this.a = str;
        this.b = z;
        this.c = i;
        this.d = i2;
        this.e = twVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tx)) {
            return false;
        }
        tx txVar = (tx) obj;
        return bzo.f(this.a, txVar.a) && this.b == txVar.b && this.c == txVar.c && this.d == txVar.d && bzo.f(this.e, txVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + dts.a(this.d, dts.a(this.c, (Boolean.hashCode(this.b) + (this.a.hashCode() * 31)) * 31, 31), 31);
    }

    public final String toString() {
        return "ChannelDataWrapper(wrapperId=" + this.a + ", isSegmentsType=" + this.b + ", segmentsSize=" + this.c + ", segmentsIndex=" + this.d + ", instance=" + this.e + ")";
    }
}
