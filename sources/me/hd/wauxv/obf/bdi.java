package me.hd.wauxv.obf;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdi implements Parcelable {
    public static final Parcelable.Creator<bdi> CREATOR = new m(4);
    public final Bundle a;

    public bdi(Bundle bundle) {
        this.a = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    public bdi(Parcel parcel, ClassLoader classLoader) {
        Bundle bundle = parcel.readBundle();
        this.a = bundle;
        if (classLoader == null || bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
    }
}
