package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.dx.io.Opcodes;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class my implements Parcelable {
    public static final Parcelable.Creator<my> CREATOR = new cu(5);
    public int a;
    public Integer aa;
    public Integer ab;
    public Integer ac;
    public Boolean ad;
    public Integer b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Integer h;
    public String j;
    public Locale n;
    public CharSequence o;
    public CharSequence p;
    public int q;
    public int r;
    public Integer s;
    public Integer u;
    public Integer v;
    public Integer w;
    public Integer x;
    public Integer y;
    public Integer z;
    public int i = Opcodes.CONST_METHOD_TYPE;
    public int k = -2;
    public int l = -2;
    public int m = -2;
    public Boolean t = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeSerializable(this.b);
        parcel.writeSerializable(this.c);
        parcel.writeSerializable(this.d);
        parcel.writeSerializable(this.e);
        parcel.writeSerializable(this.f);
        parcel.writeSerializable(this.g);
        parcel.writeSerializable(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        CharSequence charSequence = this.o;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.p;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.q);
        parcel.writeSerializable(this.s);
        parcel.writeSerializable(this.u);
        parcel.writeSerializable(this.v);
        parcel.writeSerializable(this.w);
        parcel.writeSerializable(this.x);
        parcel.writeSerializable(this.y);
        parcel.writeSerializable(this.z);
        parcel.writeSerializable(this.ac);
        parcel.writeSerializable(this.aa);
        parcel.writeSerializable(this.ab);
        parcel.writeSerializable(this.t);
        parcel.writeSerializable(this.n);
        parcel.writeSerializable(this.ad);
    }
}
