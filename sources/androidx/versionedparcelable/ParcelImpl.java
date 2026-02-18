package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import me.hd.wauxv.obf.cu;
import me.hd.wauxv.obf.epq;
import me.hd.wauxv.obf.epr;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new cu(18);
    public final epr a;

    public ParcelImpl(Parcel parcel) {
        this.a = new epq(parcel).j();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new epq(parcel).l(this.a);
    }
}
