package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import me.hd.wauxv.obf.epp;
import me.hd.wauxv.obf.epq;
import me.hd.wauxv.obf.epr;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(epp eppVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        epr eprVarJ = remoteActionCompat.a;
        boolean z = true;
        if (eppVar.h(1)) {
            eprVarJ = eppVar.j();
        }
        remoteActionCompat.a = (IconCompat) eprVarJ;
        CharSequence charSequence = remoteActionCompat.b;
        if (eppVar.h(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((epq) eppVar).n);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (eppVar.h(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((epq) eppVar).n);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) eppVar.i(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.e;
        if (eppVar.h(5)) {
            z2 = ((epq) eppVar).n.readInt() != 0;
        }
        remoteActionCompat.e = z2;
        boolean z3 = remoteActionCompat.f;
        if (!eppVar.h(6)) {
            z = z3;
        } else if (((epq) eppVar).n.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, epp eppVar) {
        eppVar.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        eppVar.k(1);
        eppVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        eppVar.k(2);
        Parcel parcel = ((epq) eppVar).n;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        eppVar.k(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        eppVar.k(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.e;
        eppVar.k(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        eppVar.k(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
