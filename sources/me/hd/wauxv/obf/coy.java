package me.hd.wauxv.obf;

import android.app.Notification;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class coy {
    public final String a;
    public final String b;
    public final Notification c;

    public coy(String str, String str2, Notification notification) {
        this.a = str;
        this.b = str2;
        this.c = notification;
    }

    public final void d(bnw bnwVar) {
        String str = this.a;
        String str2 = this.b;
        bnu bnuVar = (bnu) bnwVar;
        bnuVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(bnw.b);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(0);
            parcelObtain.writeString(str2);
            Notification notification = this.c;
            if (notification != null) {
                parcelObtain.writeInt(1);
                notification.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            bnuVar.a.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.a);
        sb.append(", id:0, tag:");
        return yg.concatToVar1(sb, this.b, "]");
    }
}
