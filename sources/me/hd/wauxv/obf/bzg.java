package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzg implements Map, Serializable, bsz {
    public static final bzg a;
    public Object[] b;
    public Object[] c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public bzh k;
    public bzi l;
    public bzh m;
    public boolean n;

    static {
        bzg bzgVar = new bzg(0);
        bzgVar.n = true;
        a = bzgVar;
    }

    public bzg(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.b = objArr;
        this.c = null;
        this.d = iArr;
        this.e = new int[iHighestOneBit];
        this.f = 2;
        this.g = 0;
        this.h = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    @Override // java.util.Map
    public final void clear() {
        p();
        int i = this.g - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.d;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.e[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        bhu.az(this.b, 0, this.g);
        Object[] objArr = this.c;
        if (objArr != null) {
            bhu.az(objArr, 0, this.g);
        }
        this.j = 0;
        this.g = 0;
        this.i++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return u(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return v(obj) >= 0;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        bzh bzhVar = this.m;
        if (bzhVar != null) {
            return bzhVar;
        }
        bzh bzhVar2 = new bzh(this, 0);
        this.m = bzhVar2;
        return bzhVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.j == map.size() && r(map.entrySet());
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iU = u(obj);
        if (iU < 0) {
            return null;
        }
        Object[] objArr = this.c;
        throwIfVar1IsNull(objArr);
        return objArr[iU];
    }

    @Override // java.util.Map
    public final int hashCode() {
        bzd bzdVar = new bzd(this, 0);
        int i = 0;
        while (bzdVar.hasNext()) {
            int i2 = bzdVar.b;
            bzg bzgVar = (bzg) bzdVar.e;
            if (i2 >= bzgVar.g) {
                throw new NoSuchElementException();
            }
            bzdVar.b = i2 + 1;
            bzdVar.c = i2;
            Object obj = bzgVar.b[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = bzgVar.c;
            throwIfVar1IsNull(objArr);
            Object obj2 = objArr[bzdVar.c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            bzdVar.j();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.j == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        bzh bzhVar = this.k;
        if (bzhVar != null) {
            return bzhVar;
        }
        bzh bzhVar2 = new bzh(this, 1);
        this.k = bzhVar2;
        return bzhVar2;
    }

    public final int o(Object obj) {
        p();
        while (true) {
            int iW = w(obj);
            int i = this.f * 2;
            int length = this.e.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.e;
                int i3 = iArr[iW];
                if (i3 <= 0) {
                    int i4 = this.g;
                    Object[] objArr = this.b;
                    if (i4 >= objArr.length) {
                        t(1);
                        break;
                    }
                    int i5 = i4 + 1;
                    this.g = i5;
                    objArr[i4] = obj;
                    this.d[i4] = iW;
                    iArr[iW] = i5;
                    this.j++;
                    this.i++;
                    if (i2 > this.f) {
                        this.f = i2;
                    }
                    return i4;
                }
                if (nullSafeIsEqual(this.b[i3 - 1], obj)) {
                    return -i3;
                }
                i2++;
                if (i2 > i) {
                    x(this.e.length * 2);
                    break;
                }
                iW = iW == 0 ? this.e.length - 1 : iW - 1;
            }
        }
    }

    public final void p() {
        if (this.n) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        p();
        int iO = o(obj);
        Object[] objArr = this.c;
        if (objArr == null) {
            int length = this.b.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.c = objArr;
        }
        if (iO >= 0) {
            objArr[iO] = obj2;
            return null;
        }
        int i = (-iO) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throwIfVar1IsNull(map, "from");
        p();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        t(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iO = o(entry.getKey());
            Object[] objArr = this.c;
            if (objArr == null) {
                int length = this.b.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.c = objArr;
            }
            if (iO >= 0) {
                objArr[iO] = entry.getValue();
            } else {
                int i = (-iO) - 1;
                if (!nullSafeIsEqual(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    public final void q(boolean z) {
        int i;
        Object[] objArr = this.c;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.g;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.d;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.b;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.e[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        bhu.az(this.b, i3, i);
        if (objArr != null) {
            bhu.az(objArr, i3, this.g);
        }
        this.g = i3;
    }

    public final boolean r(Collection collection) {
        throwIfVar1IsNull(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!s((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        p();
        int iU = u(obj);
        if (iU < 0) {
            return null;
        }
        Object[] objArr = this.c;
        throwIfVar1IsNull(objArr);
        Object obj2 = objArr[iU];
        y(iU);
        return obj2;
    }

    public final boolean s(Map.Entry entry) {
        throwIfVar1IsNull(entry, "entry");
        int iU = u(entry.getKey());
        if (iU < 0) {
            return false;
        }
        Object[] objArr = this.c;
        throwIfVar1IsNull(objArr);
        return nullSafeIsEqual(objArr[iU], entry.getValue());
    }

    @Override // java.util.Map
    public final int size() {
        return this.j;
    }

    public final void t(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.b;
        int length = objArr.length;
        int i2 = this.g;
        int i3 = length - i2;
        int i4 = i2 - this.j;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            q(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i6);
            throwIfVar1IsNull(objArrCopyOf2, "copyOf(...)");
            this.b = objArrCopyOf2;
            Object[] objArr2 = this.c;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i6);
                throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.c = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.d, i6);
            throwIfVar1IsNull(iArrCopyOf, "copyOf(...)");
            this.d = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.e.length) {
                x(iHighestOneBit);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.j * 3) + 2);
        sb.append("{");
        int i = 0;
        bzd bzdVar = new bzd(this, 0);
        while (bzdVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = bzdVar.b;
            bzg bzgVar = (bzg) bzdVar.e;
            if (i2 >= bzgVar.g) {
                throw new NoSuchElementException();
            }
            bzdVar.b = i2 + 1;
            bzdVar.c = i2;
            Object obj = bzgVar.b[i2];
            if (obj == bzgVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append(SignatureVisitor.INSTANCEOF);
            Object[] objArr = bzgVar.c;
            throwIfVar1IsNull(objArr);
            Object obj2 = objArr[bzdVar.c];
            if (obj2 == bzgVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            bzdVar.j();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }

    public final int u(Object obj) {
        int iW = w(obj);
        int i = this.f;
        while (true) {
            int i2 = this.e[iW];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (nullSafeIsEqual(this.b[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iW = iW == 0 ? this.e.length - 1 : iW - 1;
        }
    }

    public final int v(Object obj) {
        int i = this.g;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.d[i] >= 0) {
                Object[] objArr = this.c;
                throwIfVar1IsNull(objArr);
                if (nullSafeIsEqual(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        bzi bziVar = this.l;
        if (bziVar != null) {
            return bziVar;
        }
        bzi bziVar2 = new bzi(this);
        this.l = bziVar2;
        return bziVar2;
    }

    public final int w(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.h;
    }

    public final void x(int i) {
        int[] iArr;
        this.i++;
        int i2 = 0;
        if (this.g > this.j) {
            q(false);
        }
        this.e = new int[i];
        this.h = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.g) {
            int i3 = i2 + 1;
            int iW = w(this.b[i2]);
            int i4 = this.f;
            while (true) {
                iArr = this.e;
                if (iArr[iW] == 0) {
                    break;
                }
                i4--;
                if (i4 < 0) {
                    throw new IllegalStateException(
                            "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
                iW = iW == 0 ? iArr.length - 1 : iW - 1;
            }
            iArr[iW] = i3;
            this.d[i2] = iW;
            i2 = i3;
        }
    }

    public final void y(int i) {
        Object[] objArr = this.b;
        throwIfVar1IsNull(objArr, "<this>");
        objArr[i] = null;
        Object[] objArr2 = this.c;
        if (objArr2 != null) {
            objArr2[i] = null;
        }
        int length = this.d[i];
        int i2 = this.f * 2;
        int length2 = this.e.length / 2;
        if (i2 > length2) {
            i2 = length2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = length;
        do {
            length = length == 0 ? this.e.length - 1 : length - 1;
            i4++;
            if (i4 > this.f) {
                this.e[i5] = 0;
            } else {
                int[] iArr = this.e;
                int i6 = iArr[length];
                if (i6 == 0) {
                    iArr[i5] = 0;
                } else {
                    if (i6 < 0) {
                        iArr[i5] = -1;
                    } else {
                        int i7 = i6 - 1;
                        int iW = w(this.b[i7]) - length;
                        int[] iArr2 = this.e;
                        if ((iW & (iArr2.length - 1)) >= i4) {
                            iArr2[i5] = i6;
                            this.d[i7] = i5;
                        }
                        i3--;
                    }
                    i5 = length;
                    i4 = 0;
                    i3--;
                }
            }
            this.d[i] = -1;
            this.j--;
            this.i++;
        } while (i3 >= 0);
        this.e[i5] = -1;
        this.d[i] = -1;
        this.j--;
        this.i++;
    }
}
