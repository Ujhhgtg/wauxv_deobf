package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class st implements Parcelable {
    public static final Parcelable.Creator<st> CREATOR = new cu(7);
    public final cet a;
    public final cet b;
    public final ajk c;
    public final cet d;
    public final int e;
    public final int f;
    public final int g;

    public st(cet cetVar, cet cetVar2, ajk ajkVar, cet cetVar3, int i) {
        Objects.requireNonNull(cetVar, "start cannot be null");
        Objects.requireNonNull(cetVar2, "end cannot be null");
        Objects.requireNonNull(ajkVar, "validator cannot be null");
        this.a = cetVar;
        this.b = cetVar2;
        this.d = cetVar3;
        this.e = i;
        this.c = ajkVar;
        if (cetVar3 != null && cetVar.a.compareTo(cetVar3.a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (cetVar3 != null && cetVar3.a.compareTo(cetVar2.a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > eoq.d(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.g = cetVar.k(cetVar2) + 1;
        this.f = (cetVar2.c - cetVar.c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof st)) {
            return false;
        }
        st stVar = (st) obj;
        return this.a.equals(stVar.a) && this.b.equals(stVar.b) && Objects.equals(this.d, stVar.d) && this.e == stVar.e && this.c.equals(stVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, Integer.valueOf(this.e), this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeInt(this.e);
    }
}
