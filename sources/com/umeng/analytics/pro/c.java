package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.b;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a implements c {
        @Override // com.umeng.analytics.pro.c
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.c
        public void b(com.umeng.analytics.pro.b bVar) {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(com.umeng.analytics.pro.b bVar) {
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(com.umeng.analytics.pro.b bVar);

    void b(com.umeng.analytics.pro.b bVar);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class b extends Binder implements c {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class a implements c {
            public static c a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            public String a() {
                return b.d;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.c
            public void b(com.umeng.analytics.pro.b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.a().b(bVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i, long j, boolean z, float f, double d, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.a().a(i, j, z, f, d, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(com.umeng.analytics.pro.b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && b.a() != null) {
                        b.a().a(bVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, d);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(d);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(d);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                a(b.AbstractBinderC0005b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(d);
                return true;
            }
            parcel.enforceInterface(d);
            b(b.AbstractBinderC0005b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(c cVar) {
            if (a.a != null || cVar == null) {
                return false;
            }
            a.a = cVar;
            return true;
        }

        public static c a() {
            return a.a;
        }
    }
}
