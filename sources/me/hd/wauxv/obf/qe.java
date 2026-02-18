package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qe extends n {
    public static final Parcelable.Creator<qe> CREATOR = new m(1);
    public final int a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public qe(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt() == 1;
        this.d = parcel.readInt() == 1;
        this.e = parcel.readInt() == 1;
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
    }

    public qe(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.a = bottomSheetBehavior.az;
        this.b = bottomSheetBehavior.q;
        this.c = bottomSheetBehavior.f;
        this.d = bottomSheetBehavior.aw;
        this.e = bottomSheetBehavior.ax;
    }
}
