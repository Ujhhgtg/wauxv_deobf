package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import me.hd.wauxv.obf.epp;
import me.hd.wauxv.obf.epq;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(epp eppVar) {
        IconCompat iconCompat = new IconCompat();
        int i = iconCompat.b;
        if (eppVar.h(1)) {
            i = ((epq) eppVar).n.readInt();
        }
        iconCompat.b = i;
        byte[] bArr = iconCompat.d;
        if (eppVar.h(2)) {
            Parcel parcel = ((epq) eppVar).n;
            int i2 = parcel.readInt();
            if (i2 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i2];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.d = bArr;
        iconCompat.e = eppVar.i(iconCompat.e, 3);
        int i3 = iconCompat.f;
        if (eppVar.h(4)) {
            i3 = ((epq) eppVar).n.readInt();
        }
        iconCompat.f = i3;
        int i4 = iconCompat.g;
        if (eppVar.h(5)) {
            i4 = ((epq) eppVar).n.readInt();
        }
        iconCompat.g = i4;
        iconCompat.h = (ColorStateList) eppVar.i(iconCompat.h, 6);
        String string = iconCompat.j;
        if (eppVar.h(7)) {
            string = ((epq) eppVar).n.readString();
        }
        iconCompat.j = string;
        String string2 = iconCompat.k;
        if (eppVar.h(8)) {
            string2 = ((epq) eppVar).n.readString();
        }
        iconCompat.k = string2;
        iconCompat.i = PorterDuff.Mode.valueOf(iconCompat.j);
        switch (iconCompat.b) {
            case -1:
                Parcelable parcelable = iconCompat.e;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.c = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.e;
                if (parcelable2 != null) {
                    iconCompat.c = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.d;
                iconCompat.c = bArr3;
                iconCompat.b = 3;
                iconCompat.f = 0;
                iconCompat.g = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.d, Charset.forName("UTF-16"));
                iconCompat.c = str;
                if (iconCompat.b == 2 && iconCompat.k == null) {
                    iconCompat.k = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.c = iconCompat.d;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, epp eppVar) {
        eppVar.getClass();
        iconCompat.j = iconCompat.i.name();
        switch (iconCompat.b) {
            case -1:
                iconCompat.e = (Parcelable) iconCompat.c;
                break;
            case 1:
            case 5:
                iconCompat.e = (Parcelable) iconCompat.c;
                break;
            case 2:
                iconCompat.d = ((String) iconCompat.c).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.d = (byte[]) iconCompat.c;
                break;
            case 4:
            case 6:
                iconCompat.d = iconCompat.c.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.b;
        if (-1 != i) {
            eppVar.k(1);
            ((epq) eppVar).n.writeInt(i);
        }
        byte[] bArr = iconCompat.d;
        if (bArr != null) {
            eppVar.k(2);
            Parcel parcel = ((epq) eppVar).n;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.e;
        if (parcelable != null) {
            eppVar.k(3);
            ((epq) eppVar).n.writeParcelable(parcelable, 0);
        }
        int i2 = iconCompat.f;
        if (i2 != 0) {
            eppVar.k(4);
            ((epq) eppVar).n.writeInt(i2);
        }
        int i3 = iconCompat.g;
        if (i3 != 0) {
            eppVar.k(5);
            ((epq) eppVar).n.writeInt(i3);
        }
        ColorStateList colorStateList = iconCompat.h;
        if (colorStateList != null) {
            eppVar.k(6);
            ((epq) eppVar).n.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.j;
        if (str != null) {
            eppVar.k(7);
            ((epq) eppVar).n.writeString(str);
        }
        String str2 = iconCompat.k;
        if (str2 != null) {
            eppVar.k(8);
            ((epq) eppVar).n.writeString(str2);
        }
    }
}
