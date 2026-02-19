package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chs {
    public int[] a = new int[16];
    public int b;

    public final void c(int i) {
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
            throwIfVar1IsNull(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
    }

    public final int d(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException("Index must be between 0 and size");
        }
        return this.a[i];
    }

    public final void e(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this.b) || i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("Index must be between 0 and size");
        }
        if (i2 < i) {
            bhv.ai("The end index must be < start index");
            throw null;
        }
        if (i2 != i) {
            if (i2 < i3) {
                int[] iArr = this.a;
                SomeStaticHelpers._al(iArr, i, i2, i3, iArr);
            }
            this.b -= i2 - i;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof chs) {
            chs chsVar = (chs) obj;
            int i = chsVar.b;
            int i2 = this.b;
            if (i == i2) {
                int[] iArr = this.a;
                int[] iArr2 = chsVar.a;
                IntRange intRangeVarBm = dqc.bm(0, i2);
                int i3 = intRangeVarBm.first;
                int i4 = intRangeVarBm.last;
                if (i3 > i4) {
                    return true;
                }
                while (iArr[i3] == iArr2[i3]) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.a;
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Integer.hashCode(iArr[i2]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int[] iArr = this.a;
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                String string = sb.toString();
                throwIfVar1IsNull(string, "toString(...)");
                return string;
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(i3);
        }
        sb.append((CharSequence) "]");
        String string2 = sb.toString();
        throwIfVar1IsNull(string2, "toString(...)");
        return string2;
    }
}
