package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awn extends ac implements awm, Serializable {
    public final Enum[] b;

    public awn(Enum[] enumArr) {
        this.b = enumArr;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        return this.b.length;
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r4 = (Enum) obj;
        return ((Enum) la.q(this.b, r4.ordinal())) == r4;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.b;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", length));
        }
        return enumArr[i];
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (((Enum) la.q(this.b, iOrdinal)) == r4) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (((Enum) la.q(this.b, iOrdinal)) == r4) {
            return iOrdinal;
        }
        return -1;
    }
}
