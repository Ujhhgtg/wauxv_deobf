package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n implements Parcelable {
    public final Parcelable g;
    public static final l f = new l();
    public static final Parcelable.Creator<n> CREATOR = new m(0);

    public n() {
        this.g = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.g, i);
    }

    public n(Parcelable parcelable) {
        if (parcelable != null) {
            this.g = parcelable == f ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public n(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.g = parcelable == null ? f : parcelable;
    }
}
