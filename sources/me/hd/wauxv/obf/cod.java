package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cod {
    public final int a;
    public final int b;

    public cod(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cod)) {
            return false;
        }
        cod codVar = (cod) obj;
        return this.a == codVar.a && this.b == codVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Range(start=" /* "Range(start=" /* "Range(start=" /* cnb.z(-428526066989866L)  */);
        StaticHelpers6.ac(sb, this.a, -428435872676650L);
        return StaticHelpers6.concatFromSb(sb, this.b, ')');
    }
}
