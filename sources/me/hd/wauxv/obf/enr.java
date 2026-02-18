package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enr implements afp, Parcelable {
    public static final Parcelable.Creator<enr> CREATOR = new cu(21);
    public boolean b;
    public int c;
    public aff e;
    public boolean i;
    public dqs j;
    public final ArrayList a = new ArrayList();
    public boolean f = false;
    public enn d = null;
    public int g = 0;
    public boolean h = false;

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
        if (this.h) {
            return;
        }
        this.f = true;
        this.e = affVar;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        enn ennVar;
        if (this.h) {
            return;
        }
        eno enoVar = new eno();
        enoVar.f = i;
        enoVar.h = i2;
        enoVar.g = i3;
        enoVar.i = i4;
        enoVar.k = charSequence;
        if (!this.f || (ennVar = this.d) == null) {
            enoVar.a = this.j;
            l(affVar, enoVar);
        } else {
            enq enqVar = new enq();
            enqVar.g = ennVar;
            enqVar.f = enoVar;
            enqVar.a = this.j;
            l(affVar, enqVar);
        }
        this.d = null;
        this.f = false;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void da(aff affVar) {
        if (!this.b || affVar.j == null) {
            return;
        }
        if (!this.f || this.d == null) {
            ahy ahyVarW = affVar.w();
            this.j = new dqs(ahyVarW.c.d(), ahyVarW.d.d());
        }
    }

    @Override // me.hd.wauxv.obf.afp
    public final void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        if (this.h) {
            return;
        }
        enn ennVar = new enn();
        this.d = ennVar;
        ennVar.i = i4;
        ennVar.h = i2;
        ennVar.g = i3;
        ennVar.f = i;
        ennVar.k = sb;
        ennVar.a = this.j;
        if (this.f) {
            return;
        }
        l(affVar, ennVar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void k() {
        boolean z = this.b;
        ArrayList arrayList = this.a;
        if (!z) {
            arrayList.clear();
            this.g = 0;
        } else {
            while (this.g > 1 && arrayList.size() > this.c) {
                arrayList.remove(0);
                this.g--;
            }
        }
    }

    public final void l(aff affVar, enm enmVar) {
        ArrayList arrayList;
        if (this.b) {
            while (true) {
                int i = this.g;
                arrayList = this.a;
                if (i >= arrayList.size()) {
                    break;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            if (affVar.e > 0) {
                if (arrayList.isEmpty()) {
                    enp enpVar = new enp();
                    enpVar.g(enmVar);
                    enpVar.a = enmVar.a;
                    arrayList.add(enpVar);
                    this.g++;
                } else {
                    enm enmVar2 = (enm) dkz.l(1, arrayList);
                    if (!(enmVar2 instanceof enp) || this.i) {
                        enp enpVar2 = new enp();
                        enpVar2.g(enmVar);
                        enpVar2.a = enmVar.a;
                        arrayList.add(enpVar2);
                        this.g++;
                    } else {
                        ((enp) enmVar2).g(enmVar);
                    }
                }
            } else if (arrayList.isEmpty()) {
                arrayList.add(enmVar);
                this.g++;
            } else {
                enm enmVar3 = (enm) dkz.l(1, arrayList);
                if (enmVar3.b(enmVar)) {
                    enmVar3.c(enmVar);
                } else {
                    arrayList.add(enmVar);
                    this.g++;
                }
            }
            this.i = false;
            k();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.g);
        parcel.writeInt(this.b ? 1 : 0);
        ArrayList arrayList = this.a;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((enm) it.next(), i);
        }
    }
}
