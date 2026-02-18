package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pr extends cjv {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pr(int i, boolean z) {
        super(z);
        this.a = i;
    }

    public static float[] _aw(String str) {
        bzo.q(str, "value");
        return new float[]{((Number) cjv.r.i(str)).floatValue()};
    }

    public static int[] c(String str) {
        bzo.q(str, "value");
        return new int[]{((Number) cjv.k.i(str)).intValue()};
    }

    public static long[] d(String str) {
        bzo.q(str, "value");
        return new long[]{((Number) cjv.o.i(str)).longValue()};
    }

    public static boolean[] e(String str) {
        bzo.q(str, "value");
        return new boolean[]{((Boolean) cjv.u.i(str)).booleanValue()};
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        switch (this.a) {
            case 0:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                boolean[] booleanArray = bundle.getBooleanArray(str);
                if (booleanArray != null) {
                    return booleanArray;
                }
                cmz.ad(str);
                throw null;
            case 1:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                boolean[] booleanArray2 = bundle.getBooleanArray(str);
                if (booleanArray2 != null) {
                    return la.ac(booleanArray2);
                }
                cmz.ad(str);
                throw null;
            case 2:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                float[] floatArray = bundle.getFloatArray(str);
                if (floatArray != null) {
                    return floatArray;
                }
                cmz.ad(str);
                throw null;
            case 3:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                float[] floatArray2 = bundle.getFloatArray(str);
                if (floatArray2 != null) {
                    return la.y(floatArray2);
                }
                cmz.ad(str);
                throw null;
            case 4:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                int[] intArray = bundle.getIntArray(str);
                if (intArray != null) {
                    return intArray;
                }
                cmz.ad(str);
                throw null;
            case 5:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                int[] intArray2 = bundle.getIntArray(str);
                if (intArray2 != null) {
                    return la.z(intArray2);
                }
                cmz.ad(str);
                throw null;
            case 6:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                long[] longArray = bundle.getLongArray(str);
                if (longArray != null) {
                    return longArray;
                }
                cmz.ad(str);
                throw null;
            case 7:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                long[] longArray2 = bundle.getLongArray(str);
                if (longArray2 != null) {
                    return la.aa(longArray2);
                }
                cmz.ad(str);
                throw null;
            case 8:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                String[] stringArray = bundle.getStringArray(str);
                if (stringArray != null) {
                    return stringArray;
                }
                cmz.ad(str);
                throw null;
            default:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                String[] stringArray2 = bundle.getStringArray(str);
                if (stringArray2 != null) {
                    return la.ab(stringArray2);
                }
                cmz.ad(str);
                throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final String g() {
        switch (this.a) {
            case 0:
                return "boolean[]";
            case 1:
                return "List<Boolean>";
            case 2:
                return "float[]";
            case 3:
                return "List<Float>";
            case 4:
                return "integer[]";
            case 5:
                return "List<Int>";
            case 6:
                return "long[]";
            case 7:
                return "List<Long>";
            case 8:
                return "string[]";
            default:
                return "List<String>";
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object h(Object obj, String str) {
        switch (this.a) {
            case 0:
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null) {
                    return e(str);
                }
                boolean[] zArrE = e(str);
                int length = zArr.length;
                boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
                System.arraycopy(zArrE, 0, zArrCopyOf, length, 1);
                bzo.n(zArrCopyOf);
                return zArrCopyOf;
            case 1:
                List list = (List) obj;
                ps psVar = cjv.u;
                return list != null ? aaz.o(list, dqc.bf(psVar.i(str))) : dqc.bf(psVar.i(str));
            case 2:
                float[] fArr = (float[]) obj;
                if (fArr == null) {
                    return _aw(str);
                }
                float[] fArr_aw = _aw(str);
                int length2 = fArr.length;
                float[] fArrCopyOf = Arrays.copyOf(fArr, length2 + 1);
                System.arraycopy(fArr_aw, 0, fArrCopyOf, length2, 1);
                bzo.n(fArrCopyOf);
                return fArrCopyOf;
            case 3:
                List list2 = (List) obj;
                ps psVar2 = cjv.r;
                return list2 != null ? aaz.o(list2, dqc.bf(psVar2.i(str))) : dqc.bf(psVar2.i(str));
            case 4:
                int[] iArr = (int[]) obj;
                if (iArr == null) {
                    return c(str);
                }
                int[] iArrC = c(str);
                int length3 = iArr.length;
                int[] iArrCopyOf = Arrays.copyOf(iArr, length3 + 1);
                System.arraycopy(iArrC, 0, iArrCopyOf, length3, 1);
                bzo.n(iArrCopyOf);
                return iArrCopyOf;
            case 5:
                List list3 = (List) obj;
                ps psVar3 = cjv.k;
                return list3 != null ? aaz.o(list3, dqc.bf(psVar3.i(str))) : dqc.bf(psVar3.i(str));
            case 6:
                long[] jArr = (long[]) obj;
                if (jArr == null) {
                    return d(str);
                }
                long[] jArrD = d(str);
                int length4 = jArr.length;
                long[] jArrCopyOf = Arrays.copyOf(jArr, length4 + 1);
                System.arraycopy(jArrD, 0, jArrCopyOf, length4, 1);
                bzo.n(jArrCopyOf);
                return jArrCopyOf;
            case 7:
                List list4 = (List) obj;
                ps psVar4 = cjv.o;
                return list4 != null ? aaz.o(list4, dqc.bf(psVar4.i(str))) : dqc.bf(psVar4.i(str));
            case 8:
                String[] strArr = (String[]) obj;
                if (strArr == null) {
                    return new String[]{str};
                }
                int length5 = strArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(strArr, length5 + 1);
                System.arraycopy(new String[]{str}, 0, objArrCopyOf, length5, 1);
                bzo.n(objArrCopyOf);
                return (String[]) objArrCopyOf;
            default:
                List list5 = (List) obj;
                return list5 != null ? aaz.o(list5, dqc.bf(str)) : dqc.bf(str);
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object i(String str) {
        switch (this.a) {
            case 0:
                return e(str);
            case 1:
                bzo.q(str, "value");
                return dqc.bf(cjv.u.i(str));
            case 2:
                return _aw(str);
            case 3:
                bzo.q(str, "value");
                return dqc.bf(cjv.r.i(str));
            case 4:
                return c(str);
            case 5:
                bzo.q(str, "value");
                return dqc.bf(cjv.k.i(str));
            case 6:
                return d(str);
            case 7:
                bzo.q(str, "value");
                return dqc.bf(cjv.o.i(str));
            case 8:
                bzo.q(str, "value");
                return new String[]{str};
            default:
                bzo.q(str, "value");
                return dqc.bf(str);
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        switch (this.a) {
            case 0:
                boolean[] zArr = (boolean[]) obj;
                bzo.q(str, "key");
                if (zArr == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putBooleanArray(str, zArr);
                }
                break;
            case 1:
                List list = (List) obj;
                bzo.q(str, "key");
                if (list == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putBooleanArray(str, aaz.v(list));
                }
                break;
            case 2:
                float[] fArr = (float[]) obj;
                bzo.q(str, "key");
                if (fArr == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putFloatArray(str, fArr);
                }
                break;
            case 3:
                List list2 = (List) obj;
                bzo.q(str, "key");
                if (list2 == null) {
                    cnb.af(str, bundle);
                } else {
                    float[] fArr2 = new float[list2.size()];
                    Iterator it = list2.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        fArr2[i] = ((Number) it.next()).floatValue();
                        i++;
                    }
                    bundle.putFloatArray(str, fArr2);
                }
                break;
            case 4:
                int[] iArr = (int[]) obj;
                bzo.q(str, "key");
                if (iArr == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putIntArray(str, iArr);
                }
                break;
            case 5:
                List list3 = (List) obj;
                bzo.q(str, "key");
                if (list3 != null) {
                    bundle.putIntArray(str, aaz.y(list3));
                }
                break;
            case 6:
                long[] jArr = (long[]) obj;
                bzo.q(str, "key");
                if (jArr == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putLongArray(str, jArr);
                }
                break;
            case 7:
                List list4 = (List) obj;
                bzo.q(str, "key");
                if (list4 == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putLongArray(str, aaz.aa(list4));
                }
                break;
            case 8:
                String[] strArr = (String[]) obj;
                bzo.q(str, "key");
                if (strArr == null) {
                    cnb.af(str, bundle);
                } else {
                    bundle.putStringArray(str, strArr);
                }
                break;
            default:
                List list5 = (List) obj;
                bzo.q(str, "key");
                if (list5 == null) {
                    cnb.af(str, bundle);
                } else {
                    String[] strArr2 = (String[]) list5.toArray(new String[0]);
                    bzo.q(strArr2, "value");
                    bundle.putStringArray(str, strArr2);
                }
                break;
        }
    }
}
