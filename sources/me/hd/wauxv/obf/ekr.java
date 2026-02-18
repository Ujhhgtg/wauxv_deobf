package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ekr extends n {
    public static final Parcelable.Creator<ekr> CREATOR = new m(11);
    public int a;
    public boolean b;

    public ekr(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = parcel.readInt();
        this.b = parcel.readInt() != 0;
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b ? 1 : 0);
    }
}
