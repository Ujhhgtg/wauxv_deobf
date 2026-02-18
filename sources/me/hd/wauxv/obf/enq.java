package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enq extends enm {
    public static final Parcelable.Creator<enq> CREATOR = new cu(25);
    public eno f;
    public enn g;

    @Override // me.hd.wauxv.obf.enm
    public final boolean b(enm enmVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.enm
    public final void c(enm enmVar) {
        throw new UnsupportedOperationException();
    }

    @Override // me.hd.wauxv.obf.enm
    public final void d(aff affVar) {
        this.g.d(affVar);
        this.f.d(affVar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.enm
    public final void e(aff affVar) {
        this.f.e(affVar);
        this.g.e(affVar);
    }

    public final String toString() {
        return "ReplaceAction{insert=" + this.f + ", delete=" + this.g + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
    }
}
