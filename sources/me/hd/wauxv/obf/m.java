package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return n.f;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new qe(parcel, null);
            case 2:
                return new yc(parcel, null);
            case 3:
                return new agw(parcel, null);
            case 4:
                return new bdi(parcel, null);
            case 5:
                return new cac(parcel, null);
            case 6:
                return new ckf(parcel, null);
            case 7:
                return new csw(parcel, null);
            case 8:
                return new czq(parcel, null);
            case 9:
                return new dhp(parcel, null);
            case 10:
                return new dqp(parcel, null);
            case 11:
                return new ekr(parcel, null);
            default:
                ese eseVar = new ese(parcel, null);
                eseVar.a = parcel.readInt();
                eseVar.b = parcel.readInt();
                eseVar.c = parcel.readParcelable(null);
                return eseVar;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new n[i];
            case 1:
                return new qe[i];
            case 2:
                return new yc[i];
            case 3:
                return new agw[i];
            case 4:
                return new bdi[i];
            case 5:
                return new cac[i];
            case 6:
                return new ckf[i];
            case 7:
                return new csw[i];
            case 8:
                return new czq[i];
            case 9:
                return new dhp[i];
            case 10:
                return new dqp[i];
            case 11:
                return new ekr[i];
            default:
                return new ese[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return n.f;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new qe(parcel, classLoader);
            case 2:
                return new yc(parcel, classLoader);
            case 3:
                return new agw(parcel, classLoader);
            case 4:
                return new bdi(parcel, classLoader);
            case 5:
                return new cac(parcel, classLoader);
            case 6:
                return new ckf(parcel, classLoader);
            case 7:
                return new csw(parcel, classLoader);
            case 8:
                return new czq(parcel, classLoader);
            case 9:
                return new dhp(parcel, classLoader);
            case 10:
                return new dqp(parcel, classLoader);
            case 11:
                return new ekr(parcel, classLoader);
            default:
                ese eseVar = new ese(parcel, classLoader);
                eseVar.a = parcel.readInt();
                eseVar.b = parcel.readInt();
                eseVar.c = parcel.readParcelable(classLoader);
                return eseVar;
        }
    }
}
