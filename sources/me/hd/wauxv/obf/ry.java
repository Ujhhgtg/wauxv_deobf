package me.hd.wauxv.obf;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ry implements dcj {
    public final /* synthetic */ int a;
    public final apq b;

    public /* synthetic */ ry(apq apqVar, int i) {
        this.a = i;
        this.b = apqVar;
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                apq apqVar = this.b;
                return apqVar.o(new FactoryPools((ByteBuffer) obj, apqVar.j, apqVar.i, 11), i, i2, crwVar, apq.e);
            default:
                apq apqVar2 = this.b;
                return apqVar2.o(new FactoryPools((ParcelFileDescriptor) obj, apqVar2.j, apqVar2.i), i, i2, crwVar, apq.e);
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final boolean d(Object obj, crw crwVar) {
        switch (this.a) {
            case 0:
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }
}
