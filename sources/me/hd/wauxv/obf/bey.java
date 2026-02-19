package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bey implements Parcelable {
    public static final Parcelable.Creator<bey> CREATOR = new cu(11);
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final String m;
    public final int n;
    public final boolean o;

    public bey(SomeFragmentManager someFragmentManagerVar) {
        this.a = someFragmentManagerVar.getClass().getName();
        this.b = someFragmentManagerVar.aw;
        this.c = someFragmentManagerVar.bg;
        this.d = someFragmentManagerVar.bi;
        this.e = someFragmentManagerVar.bq;
        this.f = someFragmentManagerVar.br;
        this.g = someFragmentManagerVar.bs;
        this.h = someFragmentManagerVar.bv;
        this.i = someFragmentManagerVar.bd;
        this.j = someFragmentManagerVar.bu;
        this.k = someFragmentManagerVar.bt;
        this.l = someFragmentManagerVar.cg.ordinal();
        this.m = someFragmentManagerVar.az;
        this.n = someFragmentManagerVar.ba;
        this.o = someFragmentManagerVar.cb;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final SomeFragmentManager p(bdz bdzVar) {
        SomeFragmentManager someFragmentManagerVarE = bdzVar.e(this.a);
        someFragmentManagerVarE.aw = this.b;
        someFragmentManagerVarE.bg = this.c;
        someFragmentManagerVarE.bi = this.d;
        someFragmentManagerVarE.bj = true;
        someFragmentManagerVarE.bq = this.e;
        someFragmentManagerVarE.br = this.f;
        someFragmentManagerVarE.bs = this.g;
        someFragmentManagerVarE.bv = this.h;
        someFragmentManagerVarE.bd = this.i;
        someFragmentManagerVarE.bu = this.j;
        someFragmentManagerVarE.bt = this.k;
        someFragmentManagerVarE.cg = buh.values()[this.l];
        someFragmentManagerVarE.az = this.m;
        someFragmentManagerVarE.ba = this.n;
        someFragmentManagerVarE.cb = this.o;
        return someFragmentManagerVarE;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.b);
        sb.append(")}:");
        if (this.c) {
            sb.append(" fromLayout");
        }
        if (this.d) {
            sb.append(" dynamicContainer");
        }
        int i = this.f;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        String str2 = this.m;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.n);
        }
        if (this.o) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public bey(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt() != 0;
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt() != 0;
    }
}
