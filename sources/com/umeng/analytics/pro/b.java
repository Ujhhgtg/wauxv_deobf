package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i, Bundle bundle) {
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);

    /* JADX INFO: renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractBinderC0005b extends Binder implements b {
        static final int a = 1;
        static final int b = 2;
        private static final String c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* JADX INFO: renamed from: com.umeng.analytics.pro.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class a implements b {
            public static b a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            public String a() {
                return AbstractBinderC0005b.c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i, long j, boolean z, float f, double d, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0005b.c);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0005b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0005b.a().a(i, j, z, f, d, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0005b.c);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0005b.a() != null) {
                        AbstractBinderC0005b.a().a(i, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0005b() {
            attachInterface(this, c);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(c);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(c);
                return true;
            }
            parcel.enforceInterface(c);
            a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(b bVar) {
            if (a.a != null || bVar == null) {
                return false;
            }
            a.a = bVar;
            return true;
        }

        public static b a() {
            return a.a;
        }
    }
}
