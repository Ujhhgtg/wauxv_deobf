package me.hd.wauxv.obf;

import android.os.Parcel;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epq extends epp {
    public final SparseIntArray m;
    public final Parcel n;
    public final int o;
    public final int p;
    public final String q;
    public int r;
    public int s;
    public int t;

    public epq(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ku(0), new ku(0), new ku(0));
    }

    @Override // me.hd.wauxv.obf.epp
    public final epq d() {
        Parcel parcel = this.n;
        int iDataPosition = parcel.dataPosition();
        int i = this.s;
        if (i == this.o) {
            i = this.p;
        }
        return new epq(parcel, iDataPosition, i, yg.o(new StringBuilder(), this.q, "  "), this.a, this.b, this.c);
    }

    @Override // me.hd.wauxv.obf.epp
    public final boolean h(int i) {
        while (this.s < this.p) {
            int i2 = this.t;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i3 = this.s;
            Parcel parcel = this.n;
            parcel.setDataPosition(i3);
            int i4 = parcel.readInt();
            this.t = parcel.readInt();
            this.s += i4;
        }
        return this.t == i;
    }

    @Override // me.hd.wauxv.obf.epp
    public final void k(int i) {
        int i2 = this.r;
        SparseIntArray sparseIntArray = this.m;
        Parcel parcel = this.n;
        if (i2 >= 0) {
            int i3 = sparseIntArray.get(i2);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i3);
            parcel.writeInt(iDataPosition - i3);
            parcel.setDataPosition(iDataPosition);
        }
        this.r = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public epq(Parcel parcel, int i, int i2, String str, ku kuVar, ku kuVar2, ku kuVar3) {
        super(kuVar, kuVar2, kuVar3);
        this.m = new SparseIntArray();
        this.r = -1;
        this.t = -1;
        this.n = parcel;
        this.o = i;
        this.p = i2;
        this.s = i;
        this.q = str;
    }
}
