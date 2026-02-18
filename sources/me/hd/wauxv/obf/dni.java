package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dni {
    public static final dni a = new dni();

    public final LinkedHashSet b(int i, int i2, byte[] bArr) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            ik ikVar = new ik(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = ikVar.b;
                if (i3 >= i4) {
                    break;
                }
                byte[] bArr2 = (byte[]) ikVar.d;
                int i5 = i3 + 1;
                ikVar.b = i5;
                int i6 = bArr2[i3];
                if ((i6 >> 7) != 0) {
                    int i7 = i3 + 2;
                    ikVar.b = i7;
                    i6 = (i6 & 127) | (bArr2[i5] << 7);
                    if ((i6 >> 14) != 0) {
                        int i8 = i6 & 16383;
                        int i9 = i3 + 3;
                        ikVar.b = i9;
                        int i10 = i8 | (bArr2[i7] << 14);
                        if ((i10 >> 21) == 0) {
                            i6 = i10;
                        } else {
                            int i11 = i3 + 4;
                            ikVar.b = i11;
                            i6 = (bArr2[i9] << 21) | (i10 & 2097151);
                            if ((i6 >> 28) != 0) {
                                ikVar.b = i3 + 5;
                                i6 = (268435455 & i6) | (bArr2[i11] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(ikVar.r(i6));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    public final byte[] c(Object obj) {
        Set<String> set = (Set) obj;
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int iF = ik.f(str);
                strArr[i2] = str;
                iArr[i2] = iF;
                i = ((iF >> 7) == 0 ? 1 : (iF >> 14) == 0 ? 2 : (iF >> 21) == 0 ? 3 : (iF >> 28) == 0 ? 4 : 5) + iF + i;
            }
            i2++;
        }
        ik ikVar = new ik(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            int i5 = ikVar.b;
            int i6 = i4;
            while ((i6 & (-128)) != 0) {
                ((byte[]) ikVar.d)[i5] = (byte) ((i6 & 127) | 128);
                i6 >>>= 7;
                i5++;
            }
            ((byte[]) ikVar.d)[i5] = (byte) i6;
            ikVar.b = i5 + 1;
            if (i4 >= 0) {
                ikVar.ab(strArr[i3]);
            }
        }
        return (byte[]) ikVar.d;
    }
}
