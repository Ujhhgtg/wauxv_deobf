package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nr extends View.BaseSavedState {
    public static final Parcelable.Creator<nr> CREATOR = new cu(6);
    public float a;
    public float b;
    public ArrayList c;
    public float d;
    public boolean e;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeList(this.c);
        parcel.writeFloat(this.d);
        parcel.writeBooleanArray(new boolean[]{this.e});
    }
}
