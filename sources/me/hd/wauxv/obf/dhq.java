package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dhq {
    public int[] j;
    public Object[] k;
    public int l;

    public dhq(int i) {
        this.j = i == 0 ? bzo.a : new int[i];
        this.k = i == 0 ? bzo.b : new Object[i << 1];
    }

    public void clear() {
        if (this.l > 0) {
            this.j = bzo.a;
            this.k = bzo.b;
            this.l = 0;
        }
        if (this.l > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return p(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof dhq) {
                int i = this.l;
                if (i != ((dhq) obj).l) {
                    return false;
                }
                dhq dhqVar = (dhq) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objR = r(i2);
                    Object objS = s(i2);
                    Object obj2 = dhqVar.get(objR);
                    if (objS == null) {
                        if (obj2 != null || !dhqVar.containsKey(objR)) {
                            return false;
                        }
                    } else if (!objS.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.l != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.l;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objR2 = r(i4);
                Object objS2 = s(i4);
                Object obj3 = ((Map) obj).get(objR2);
                if (objS2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objR2)) {
                        return false;
                    }
                } else if (!objS2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public void g(ku kuVar) {
        int i = kuVar.l;
        n(this.l + i);
        if (this.l != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(kuVar.r(i2), kuVar.s(i2));
            }
        } else if (i > 0) {
            la._al(kuVar.j, 0, 0, i, this.j);
            la._aj(0, 0, kuVar.k, i << 1, this.k);
            this.l = i;
        }
    }

    public Object get(Object obj) {
        int iP = p(obj);
        if (iP >= 0) {
            return this.k[(iP << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iP = p(obj);
        return iP >= 0 ? this.k[(iP << 1) + 1] : obj2;
    }

    public Object h(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.l)) {
            bhv.ai("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        Object[] objArr = this.k;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i4 = i2 - 1;
        int[] iArr = this.j;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                la._al(iArr, i, i5, i2, iArr);
                Object[] objArr2 = this.k;
                la._aj(i3, i5 << 1, objArr2, i2 << 1, objArr2);
            }
            Object[] objArr3 = this.k;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            bzo.p(iArrCopyOf, "copyOf(...)");
            this.j = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.k, i7 << 1);
            bzo.p(objArrCopyOf, "copyOf(...)");
            this.k = objArrCopyOf;
            if (i2 != this.l) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                la._al(iArr, 0, 0, i, this.j);
                la._aj(0, 0, objArr, i3, this.k);
            }
            if (i < i4) {
                int i8 = i + 1;
                la._al(iArr, i, i8, i2, this.j);
                la._aj(i3, i8 << 1, objArr, i2 << 1, this.k);
            }
        }
        if (i2 != this.l) {
            throw new ConcurrentModificationException();
        }
        this.l = i4;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.j;
        Object[] objArr = this.k;
        int i = this.l;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public Object i(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.l) {
            z = true;
        }
        if (!z) {
            bhv.ai("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.k;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.l <= 0;
    }

    public final int m(Object obj) {
        int i = this.l * 2;
        Object[] objArr = this.k;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void n(int i) {
        int i2 = this.l;
        int[] iArr = this.j;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            bzo.p(iArrCopyOf, "copyOf(...)");
            this.j = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.k, i * 2);
            bzo.p(objArrCopyOf, "copyOf(...)");
            this.k = objArrCopyOf;
        }
        if (this.l != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int o(int i, Object obj) {
        int i2 = this.l;
        if (i2 == 0) {
            return -1;
        }
        int i3 = bzo.i(this.j, i2, i);
        if (i3 < 0 || bzo.f(obj, this.k[i3 << 1])) {
            return i3;
        }
        int i4 = i3 + 1;
        while (i4 < i2 && this.j[i4] == i) {
            if (bzo.f(obj, this.k[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = i3 - 1; i5 >= 0 && this.j[i5] == i; i5--) {
            if (bzo.f(obj, this.k[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public final int p(Object obj) {
        return obj == null ? q() : o(obj.hashCode(), obj);
    }

    public Object put(Object obj, Object obj2) {
        int i = this.l;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iO = obj != null ? o(iHashCode, obj) : q();
        if (iO >= 0) {
            int i2 = (iO << 1) + 1;
            Object[] objArr = this.k;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iO;
        int[] iArr = this.j;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            bzo.p(iArrCopyOf, "copyOf(...)");
            this.j = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.k, i4 << 1);
            bzo.p(objArrCopyOf, "copyOf(...)");
            this.k = objArrCopyOf;
            if (i != this.l) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.j;
            int i5 = i3 + 1;
            la._al(iArr2, i5, i3, i, iArr2);
            Object[] objArr2 = this.k;
            la._aj(i5 << 1, i3 << 1, objArr2, this.l << 1, objArr2);
        }
        int i6 = this.l;
        if (i == i6) {
            int[] iArr3 = this.j;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.k;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.l = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public final int q() {
        int i = this.l;
        if (i == 0) {
            return -1;
        }
        int i2 = bzo.i(this.j, i, 0);
        if (i2 < 0 || this.k[i2 << 1] == null) {
            return i2;
        }
        int i3 = i2 + 1;
        while (i3 < i && this.j[i3] == 0) {
            if (this.k[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = i2 - 1; i4 >= 0 && this.j[i4] == 0; i4--) {
            if (this.k[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public final Object r(int i) {
        boolean z = false;
        if (i >= 0 && i < this.l) {
            z = true;
        }
        if (z) {
            return this.k[i << 1];
        }
        bhv.ai("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public Object remove(Object obj) {
        int iP = p(obj);
        if (iP >= 0) {
            return h(iP);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iP = p(obj);
        if (iP >= 0) {
            return i(iP, obj2);
        }
        return null;
    }

    public final Object s(int i) {
        boolean z = false;
        if (i >= 0 && i < this.l) {
            z = true;
        }
        if (z) {
            return this.k[(i << 1) + 1];
        }
        bhv.ai("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public final int size() {
        return this.l;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.l * 28);
        sb.append('{');
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objR = r(i2);
            if (objR != sb) {
                sb.append(objR);
            } else {
                sb.append("(this Map)");
            }
            sb.append(SignatureVisitor.INSTANCEOF);
            Object objS = s(i2);
            if (objS != sb) {
                sb.append(objS);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iP = p(obj);
        if (iP < 0 || !bzo.f(obj2, s(iP))) {
            return false;
        }
        h(iP);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iP = p(obj);
        if (iP < 0 || !bzo.f(obj2, s(iP))) {
            return false;
        }
        i(iP, obj3);
        return true;
    }
}
