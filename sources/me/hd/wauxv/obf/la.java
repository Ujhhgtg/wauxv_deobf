package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class la extends cnf {
    public static boolean _ai(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            Object obj2 = objArr2[i];
            if (obj != obj2) {
                if (obj == null || obj2 == null) {
                    return false;
                }
                if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                    if (!_ai((Object[]) obj, (Object[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                    if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                    if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                    if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                    if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                    if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                    if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof emq) && (obj2 instanceof emq)) {
                    byte[] bArr = ((emq) obj).a;
                    byte[] bArr2 = ((emq) obj2).a;
                    if (bArr == null) {
                        bArr = null;
                    }
                    if (!Arrays.equals(bArr, bArr2 != null ? bArr2 : null)) {
                        return false;
                    }
                } else if ((obj instanceof enf) && (obj2 instanceof enf)) {
                    short[] sArr = ((enf) obj).a;
                    short[] sArr2 = ((enf) obj2).a;
                    if (sArr == null) {
                        sArr = null;
                    }
                    if (!Arrays.equals(sArr, sArr2 != null ? sArr2 : null)) {
                        return false;
                    }
                } else if ((obj instanceof emv) && (obj2 instanceof emv)) {
                    int[] iArr = ((emv) obj).a;
                    int[] iArr2 = ((emv) obj2).a;
                    if (iArr == null) {
                        iArr = null;
                    }
                    if (!Arrays.equals(iArr, iArr2 != null ? iArr2 : null)) {
                        return false;
                    }
                } else if ((obj instanceof ena) && (obj2 instanceof ena)) {
                    long[] jArr = ((ena) obj).a;
                    long[] jArr2 = ((ena) obj2).a;
                    if (jArr == null) {
                        jArr = null;
                    }
                    if (!Arrays.equals(jArr, jArr2 != null ? jArr2 : null)) {
                        return false;
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void _aj(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        bzo.q(objArr, "<this>");
        bzo.q(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static void _ak(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        bzo.q(bArr, "<this>");
        bzo.q(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
    }

    public static void _al(int[] iArr, int i, int i2, int i3, int[] iArr2) {
        bzo.q(iArr, "<this>");
        bzo.q(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static /* synthetic */ void _am(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        _aj(0, i, objArr, i2, objArr2);
    }

    public static /* synthetic */ void _an(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        _ak(bArr, 0, i, bArr2, i2);
    }

    public static /* synthetic */ void _ao(int[] iArr, int i, int i2, int i3, int[] iArr2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = iArr.length;
        }
        _al(iArr, i, 0, i2, iArr2);
    }

    public static byte[] _ap(int i, int i2, byte[] bArr) {
        bzo.q(bArr, "<this>");
        cnf.ax(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        bzo.p(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static List a(Object[] objArr) {
        bzo.q(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        bzo.p(listAsList, "asList(...)");
        return listAsList;
    }

    public static List aa(long[] jArr) {
        bzo.q(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return avd.a;
        }
        if (length == 1) {
            return dqc.bf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List ab(Object[] objArr) {
        bzo.q(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new kk(objArr, false)) : dqc.bf(objArr[0]) : avd.a;
    }

    public static List ac(boolean[] zArr) {
        bzo.q(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return avd.a;
        }
        if (length == 1) {
            return dqc.bf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static ArrayList ad(int[] iArr) {
        bzo.q(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static dft b(Object[] objArr) {
        bzo.q(objArr, "<this>");
        return objArr.length == 0 ? avg.a : new lb(objArr, 0);
    }

    public static Object[] k(Object[] objArr, int i, int i2) {
        bzo.q(objArr, "<this>");
        cnf.ax(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        bzo.p(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void l(Object[] objArr, int i, int i2) {
        bzo.q(objArr, "<this>");
        Arrays.fill(objArr, i, i2, (Object) null);
    }

    public static void m(int[] iArr) {
        int length = iArr.length;
        bzo.q(iArr, "<this>");
        Arrays.fill(iArr, 0, length, 0);
    }

    public static void n(long[] jArr) {
        int length = jArr.length;
        bzo.q(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static ArrayList o(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object p(Object[] objArr) {
        bzo.q(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object q(Object[] objArr, int i) {
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int r(byte[] bArr, byte b) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int s(Object[] objArr, Object obj) {
        bzo.q(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void t(Object[] objArr, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, bgf bgfVar) {
        bzo.q(objArr, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            aye.k(sb, obj, bgfVar);
        }
        sb.append(charSequence3);
    }

    public static String u(Object[] objArr, String str, String str2, String str3, bgf bgfVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            bgfVar = null;
        }
        bzo.q(objArr, "<this>");
        bzo.q(str4, "separator");
        bzo.q(str5, "prefix");
        StringBuilder sb = new StringBuilder();
        t(objArr, sb, str4, str5, str6, "...", bgfVar);
        return sb.toString();
    }

    public static byte[] v(byte[] bArr, byte[] bArr2) {
        bzo.q(bArr, "<this>");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        bzo.n(bArrCopyOf);
        return bArrCopyOf;
    }

    public static char w(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static byte[] x(byte[] bArr, bqi bqiVar) {
        bzo.q(bqiVar, "indices");
        return bqiVar.isEmpty() ? new byte[0] : _ap(bqiVar.a, bqiVar.b + 1, bArr);
    }

    public static List y(float[] fArr) {
        bzo.q(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return avd.a;
        }
        if (length == 1) {
            return dqc.bf(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static List z(int[] iArr) {
        bzo.q(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? ad(iArr) : dqc.bf(Integer.valueOf(iArr[0])) : avd.a;
    }
}
