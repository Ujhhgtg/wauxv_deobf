package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mv implements Parcelable {
    public static final Parcelable.Creator<mv> CREATOR = new cu(3);
    public final int[] a;
    public final ArrayList b;
    public final int[] c;
    public final int[] d;
    public final int e;
    public final String f;
    public final int g;
    public final int h;
    public final CharSequence i;
    public final int j;
    public final CharSequence k;
    public final ArrayList l;
    public final ArrayList m;
    public final boolean n;

    public mv(mu muVar) {
        int size = muVar.a.size();
        this.a = new int[size * 6];
        if (!muVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList(size);
        this.c = new int[size];
        this.d = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            bfe bfeVar = (bfe) muVar.a.get(i2);
            int i3 = i + 1;
            this.a[i] = bfeVar.a;
            ArrayList arrayList = this.b;
            bdj bdjVar = bfeVar.b;
            arrayList.add(bdjVar != null ? bdjVar.aw : null);
            int[] iArr = this.a;
            iArr[i3] = bfeVar.c ? 1 : 0;
            iArr[i + 2] = bfeVar.d;
            iArr[i + 3] = bfeVar.e;
            int i4 = i + 5;
            iArr[i + 4] = bfeVar.f;
            i += 6;
            iArr[i4] = bfeVar.g;
            this.c[i2] = bfeVar.h.ordinal();
            this.d[i2] = bfeVar.i.ordinal();
        }
        this.e = muVar.f;
        this.f = muVar.i;
        this.g = muVar.t;
        this.h = muVar.j;
        this.i = muVar.k;
        this.j = muVar.l;
        this.k = muVar.m;
        this.l = muVar.n;
        this.m = muVar.o;
        this.n = muVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void o(mu muVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            boolean z = true;
            if (i >= iArr.length) {
                muVar.f = this.e;
                muVar.i = this.f;
                muVar.g = true;
                muVar.j = this.h;
                muVar.k = this.i;
                muVar.l = this.j;
                muVar.m = this.k;
                muVar.n = this.l;
                muVar.o = this.m;
                muVar.p = this.n;
                return;
            }
            bfe bfeVar = new bfe();
            int i3 = i + 1;
            bfeVar.a = iArr[i];
            if (beg.ar(2)) {
                Log.v("FragmentManager", "Instantiate " + muVar + " op #" + i2 + " base fragment #" + iArr[i3]);
            }
            bfeVar.h = buh.values()[this.c[i2]];
            bfeVar.i = buh.values()[this.d[i2]];
            int i4 = i + 2;
            if (iArr[i3] == 0) {
                z = false;
            }
            bfeVar.c = z;
            int i5 = iArr[i4];
            bfeVar.d = i5;
            int i6 = iArr[i + 3];
            bfeVar.e = i6;
            int i7 = i + 5;
            int i8 = iArr[i + 4];
            bfeVar.f = i8;
            i += 6;
            int i9 = iArr[i7];
            bfeVar.g = i9;
            muVar.b = i5;
            muVar.c = i6;
            muVar.d = i8;
            muVar.e = i9;
            muVar.w(bfeVar);
            i2++;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.b);
        parcel.writeIntArray(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeStringList(this.l);
        parcel.writeStringList(this.m);
        parcel.writeInt(this.n ? 1 : 0);
    }

    public mv(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createIntArray();
        this.d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.i = (CharSequence) creator.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.k = (CharSequence) creator.createFromParcel(parcel);
        this.l = parcel.createStringArrayList();
        this.m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }
}
