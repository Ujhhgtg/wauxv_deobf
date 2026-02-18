package me.hd.wauxv.obf;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.android.dx.io.Opcodes;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cu implements Parcelable.Creator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                cv cvVar = new cv();
                cvVar.a = parcel.readInt();
                return cvVar;
            case 1:
                bzo.q(parcel, "parcel");
                return new dp(parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
            case 2:
                jc jcVar = new jc(parcel);
                jcVar.a = parcel.readByte() != 0;
                return jcVar;
            case 3:
                return new mv(parcel);
            case 4:
                return new mw(parcel);
            case 5:
                my myVar = new my();
                myVar.i = Opcodes.CONST_METHOD_TYPE;
                myVar.k = -2;
                myVar.l = -2;
                myVar.m = -2;
                myVar.t = Boolean.TRUE;
                myVar.a = parcel.readInt();
                myVar.b = (Integer) parcel.readSerializable();
                myVar.c = (Integer) parcel.readSerializable();
                myVar.d = (Integer) parcel.readSerializable();
                myVar.e = (Integer) parcel.readSerializable();
                myVar.f = (Integer) parcel.readSerializable();
                myVar.g = (Integer) parcel.readSerializable();
                myVar.h = (Integer) parcel.readSerializable();
                myVar.i = parcel.readInt();
                myVar.j = parcel.readString();
                myVar.k = parcel.readInt();
                myVar.l = parcel.readInt();
                myVar.m = parcel.readInt();
                myVar.o = parcel.readString();
                myVar.p = parcel.readString();
                myVar.q = parcel.readInt();
                myVar.s = (Integer) parcel.readSerializable();
                myVar.u = (Integer) parcel.readSerializable();
                myVar.v = (Integer) parcel.readSerializable();
                myVar.w = (Integer) parcel.readSerializable();
                myVar.x = (Integer) parcel.readSerializable();
                myVar.y = (Integer) parcel.readSerializable();
                myVar.z = (Integer) parcel.readSerializable();
                myVar.ac = (Integer) parcel.readSerializable();
                myVar.aa = (Integer) parcel.readSerializable();
                myVar.ab = (Integer) parcel.readSerializable();
                myVar.t = (Boolean) parcel.readSerializable();
                myVar.n = (Locale) parcel.readSerializable();
                myVar.ad = (Boolean) parcel.readSerializable();
                return myVar;
            case 6:
                nr nrVar = new nr(parcel);
                nrVar.a = parcel.readFloat();
                nrVar.b = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                nrVar.c = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                nrVar.d = parcel.readFloat();
                nrVar.e = parcel.createBooleanArray()[0];
                return nrVar;
            case 7:
                return new st((cet) parcel.readParcelable(cet.class.getClassLoader()), (cet) parcel.readParcelable(cet.class.getClassLoader()), (ajk) parcel.readParcelable(ajk.class.getClassLoader()), (cet) parcel.readParcelable(cet.class.getClassLoader()), parcel.readInt());
            case 8:
                return new ajk(parcel.readLong());
            case 9:
                beb bebVar = new beb();
                bebVar.a = parcel.readString();
                bebVar.b = parcel.readInt();
                return bebVar;
            case 10:
                beh behVar = new beh();
                behVar.e = null;
                behVar.f = new ArrayList();
                behVar.g = new ArrayList();
                behVar.a = parcel.createStringArrayList();
                behVar.b = parcel.createStringArrayList();
                behVar.c = (mv[]) parcel.createTypedArray(mv.CREATOR);
                behVar.d = parcel.readInt();
                behVar.e = parcel.readString();
                behVar.f = parcel.createStringArrayList();
                behVar.g = parcel.createTypedArrayList(mw.CREATOR);
                behVar.h = parcel.createTypedArrayList(beb.CREATOR);
                return behVar;
            case 11:
                return new bey(parcel);
            case 12:
                bzo.q(parcel, "inParcel");
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                bzo.n(parcelable);
                return new bql((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 13:
                bvk bvkVar = new bvk();
                bvkVar.a = parcel.readInt();
                bvkVar.b = parcel.readInt();
                bvkVar.c = parcel.readInt() == 1;
                return bvkVar;
            case 14:
                caq caqVar = new caq(parcel);
                caqVar.a = ((Integer) parcel.readValue(caq.class.getClassLoader())).intValue();
                return caqVar;
            case 15:
                return cet.h(parcel.readInt(), parcel.readInt());
            case 16:
                ckb ckbVar = new ckb();
                ckbVar.a = parcel.readInt();
                ckbVar.b = (csw) parcel.readParcelable(ckb.class.getClassLoader());
                return ckbVar;
            case 17:
                ckq ckqVar = new ckq(parcel);
                ckqVar.a = parcel.readInt();
                return ckqVar;
            case 18:
                return new ParcelImpl(parcel);
            case 19:
                dmc dmcVar = new dmc();
                dmcVar.a = parcel.readInt();
                dmcVar.b = parcel.readInt();
                dmcVar.d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    dmcVar.c = iArr;
                    parcel.readIntArray(iArr);
                }
                return dmcVar;
            case 20:
                dmd dmdVar = new dmd();
                dmdVar.a = parcel.readInt();
                dmdVar.b = parcel.readInt();
                int i2 = parcel.readInt();
                dmdVar.c = i2;
                if (i2 > 0) {
                    int[] iArr2 = new int[i2];
                    dmdVar.d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i3 = parcel.readInt();
                dmdVar.e = i3;
                if (i3 > 0) {
                    int[] iArr3 = new int[i3];
                    dmdVar.f = iArr3;
                    parcel.readIntArray(iArr3);
                }
                dmdVar.h = parcel.readInt() == 1;
                dmdVar.i = parcel.readInt() == 1;
                dmdVar.j = parcel.readInt() == 1;
                dmdVar.g = parcel.readArrayList(dmc.class.getClassLoader());
                return dmdVar;
            case 21:
                enr enrVar = new enr();
                enrVar.c = parcel.readInt();
                enrVar.g = parcel.readInt();
                enrVar.b = parcel.readInt() > 0;
                for (int i4 = parcel.readInt(); i4 > 0; i4--) {
                    enrVar.a.add((enm) parcel.readParcelable(enr.class.getClassLoader()));
                }
                return enrVar;
            case 22:
                enn ennVar = new enn();
                ennVar.f = parcel.readInt();
                ennVar.h = parcel.readInt();
                ennVar.g = parcel.readInt();
                ennVar.i = parcel.readInt();
                ennVar.k = parcel.readString();
                return ennVar;
            case 23:
                eno enoVar = new eno();
                enoVar.f = parcel.readInt();
                enoVar.h = parcel.readInt();
                enoVar.g = parcel.readInt();
                enoVar.i = parcel.readInt();
                enoVar.k = parcel.readString();
                return enoVar;
            case 24:
                enp enpVar = new enp();
                for (int i5 = parcel.readInt(); i5 > 0; i5--) {
                    enpVar.f.add((enm) parcel.readParcelable(enp.class.getClassLoader()));
                }
                return enpVar;
            default:
                enq enqVar = new enq();
                enqVar.f = (eno) parcel.readParcelable(enq.class.getClassLoader());
                enqVar.g = (enn) parcel.readParcelable(enq.class.getClassLoader());
                return enqVar;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new cv[i];
            case 1:
                return new dp[i];
            case 2:
                return new jc[i];
            case 3:
                return new mv[i];
            case 4:
                return new mw[i];
            case 5:
                return new my[i];
            case 6:
                return new nr[i];
            case 7:
                return new st[i];
            case 8:
                return new ajk[i];
            case 9:
                return new beb[i];
            case 10:
                return new beh[i];
            case 11:
                return new bey[i];
            case 12:
                return new bql[i];
            case 13:
                return new bvk[i];
            case 14:
                return new caq[i];
            case 15:
                return new cet[i];
            case 16:
                return new ckb[i];
            case 17:
                return new ckq[i];
            case 18:
                return new ParcelImpl[i];
            case 19:
                return new dmc[i];
            case 20:
                return new dmd[i];
            case 21:
                return new enr[i];
            case 22:
                return new enn[i];
            case 23:
                return new eno[i];
            case 24:
                return new enp[i];
            default:
                return new enq[i];
        }
    }
}
