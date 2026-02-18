package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqp extends n {
    public static final Parcelable.Creator<dqp> CREATOR = new m(10);
    public CharSequence a;
    public boolean b;

    public dqp(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.b = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.a) + "}";
    }

    @Override // me.hd.wauxv.obf.n, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.a, parcel, i);
        parcel.writeInt(this.b ? 1 : 0);
    }
}
