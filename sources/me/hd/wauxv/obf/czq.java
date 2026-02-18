package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czq extends n {
    public static final Parcelable.Creator<czq> CREATOR = new m(8);
    public Parcelable a;

    public czq(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = parcel.readParcelable(classLoader == null ? czg.class.getClassLoader() : classLoader);
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, 0);
    }
}
