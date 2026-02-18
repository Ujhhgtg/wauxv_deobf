package me.hd.wauxv.obf;

import bsh.ClassGeneratorUtil;
import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class za implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ za(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        bgs bgsVar;
        bgs bgsVar2;
        switch (this.a) {
            case 0:
                return ClassGeneratorUtil.lambda$checkAbstractMethodImplementation$2((Method) obj, (Method) obj2);
            case 1:
                aah aahVar = (aah) obj;
                aah aahVar2 = (aah) obj2;
                int iCompare = Integer.compare(aahVar.e, aahVar2.e);
                return iCompare == 0 ? Integer.compare(aahVar.f, aahVar2.f) : iCompare;
            case 2:
                aah aahVar3 = (aah) obj;
                aah aahVar4 = (aah) obj2;
                int iCompare2 = Integer.compare(aahVar3.c, aahVar4.c);
                return iCompare2 == 0 ? Integer.compare(aahVar3.d, aahVar4.d) : iCompare2;
            case 3:
                dhr dhrVar = (dhr) obj;
                dhr dhrVar2 = (dhr) obj2;
                throwIfVar1IsNull(dhrVar);
                throwIfVar1IsNull(dhrVar2);
                abu abuVar = dhrVar.d;
                abu abuVar2 = dhrVar2.d;
                if (abuVar != abuVar2) {
                    abu abuVar3 = abu.c;
                    if (abuVar != abuVar3) {
                        if (abuVar2 != abuVar3) {
                        }
                        return -1;
                    }
                    return 1;
                }
                dlb dlbVar = dhrVar.f;
                if (dlbVar == null) {
                    dlbVar = null;
                }
                int i = (dlbVar == null || (bgsVar2 = dlbVar.b) == null) ? 0 : bgsVar2.b;
                dlb dlbVar2 = dhrVar2.f;
                dlb dlbVar3 = dlbVar2 != null ? dlbVar2 : null;
                int i2 = (dlbVar3 == null || (bgsVar = dlbVar3.b) == null) ? 0 : bgsVar.b;
                if (i >= i2) {
                    if (i <= i2) {
                        String strAa = ewz.aa(dhrVar.b);
                        String strAa2 = ewz.aa(dhrVar2.b);
                        if (strAa.compareTo(strAa2) >= 0) {
                            if (strAa.compareTo(strAa2) <= 0) {
                                abu abuVar4 = dhrVar2.d;
                                int i3 = abuVar4 != null ? abuVar4.e : 0;
                                abu abuVar5 = dhrVar.d;
                                return i3 - (abuVar5 != null ? abuVar5.e : 0);
                            }
                        }
                    }
                    return -1;
                }
                return 1;
            case 4:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    byte b = bArr[i4];
                    byte b2 = bArr2[i4];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            default:
                dle dleVar = (dle) obj;
                dle dleVar2 = (dle) obj2;
                if (dleVar == null && dleVar2 == null) {
                    return 0;
                }
                if (dleVar == null) {
                    return -1;
                }
                if (dleVar2 == null) {
                    return 1;
                }
                return Integer.compare(dleVar.i(), dleVar2.i());
        }
    }
}
