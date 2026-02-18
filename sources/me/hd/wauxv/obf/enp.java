package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enp extends enm {
    public static final Parcelable.Creator<enp> CREATOR = new cu(24);
    public final ArrayList f = new ArrayList();

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
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i >= arrayList.size()) {
                return;
            }
            ((enm) arrayList.get(i)).d(affVar);
            i++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.enm
    public final void e(aff affVar) {
        ArrayList arrayList = this.f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((enm) arrayList.get(size)).e(affVar);
        }
    }

    public final void g(enm enmVar) {
        ArrayList arrayList = this.f;
        if (arrayList.isEmpty()) {
            arrayList.add(enmVar);
            return;
        }
        enm enmVar2 = (enm) dkz.l(1, arrayList);
        if (enmVar2.b(enmVar)) {
            enmVar2.c(enmVar);
        } else {
            arrayList.add(enmVar);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ArrayList arrayList = this.f;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((enm) it.next(), i);
        }
    }
}
