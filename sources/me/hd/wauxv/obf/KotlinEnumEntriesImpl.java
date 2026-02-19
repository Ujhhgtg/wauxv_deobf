package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class KotlinEnumEntriesImpl extends KotlinAbstractReadonlyList implements awm, Serializable {
    public final Enum[] entries;

    public KotlinEnumEntriesImpl(Enum[] enumArr) {
        this.entries = enumArr;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        return this.entries.length;
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r4 = (Enum) obj;
        return ((Enum) SomeStaticHelpers.q(this.entries, r4.ordinal())) == r4;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.entries;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", length));
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
        if (((Enum) SomeStaticHelpers.q(this.entries, iOrdinal)) == r4) {
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
        if (((Enum) SomeStaticHelpers.q(this.entries, iOrdinal)) == r4) {
            return iOrdinal;
        }
        return -1;
    }
}
