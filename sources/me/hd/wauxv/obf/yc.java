package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yc extends n {
    public static final Parcelable.Creator<yc> CREATOR = new m(2);
    public boolean a;

    public yc(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = parcel.readInt() == 1;
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a ? 1 : 0);
    }
}
