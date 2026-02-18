package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import me.hd.wauxv.obf.n;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends n {
    public static final Parcelable.Creator<d> CREATOR = new c();
    public boolean a;
    public boolean b;
    public int c;
    public float d;
    public boolean e;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = parcel.readByte() != 0;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readInt();
        this.d = parcel.readFloat();
        this.e = parcel.readByte() != 0;
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.c);
        parcel.writeFloat(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }
}
