package me.hd.wauxv.obf;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class byc implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ long[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public byc() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.b = new long[i4];
        this.c = new Object[i4];
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        bzo.o(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        byc bycVar = (byc) objClone;
        bycVar.b = (long[]) this.b.clone();
        bycVar.c = (Object[]) this.c.clone();
        return bycVar;
    }

    public final void e() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.a = false;
    }

    public final Object f(long j) {
        Object obj;
        int iJ = bzo.j(this.b, this.d, j);
        if (iJ < 0 || (obj = this.c[iJ]) == bzo.c) {
            return null;
        }
        return obj;
    }

    public final int g(long j) {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != bzo.c) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return bzo.j(this.b, this.d, j);
    }

    public final long h(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.d)) {
            bhv.ai("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != bzo.c) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.b[i];
    }

    public final void i(Object obj, long j) {
        Object obj2 = bzo.c;
        int iJ = bzo.j(this.b, this.d, j);
        if (iJ >= 0) {
            this.c[iJ] = obj;
            return;
        }
        int i = ~iJ;
        int i2 = this.d;
        if (i < i2) {
            Object[] objArr = this.c;
            if (objArr[i] == obj2) {
                this.b[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.a) {
            long[] jArr = this.b;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.c;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.a = false;
                this.d = i3;
                i = ~bzo.j(this.b, i3, j);
            }
        }
        int i5 = this.d;
        if (i5 >= this.b.length) {
            int i6 = (i5 + 1) * 8;
            for (int i7 = 4; i7 < 32; i7++) {
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
            }
            int i9 = i6 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.b, i9);
            bzo.p(jArrCopyOf, "copyOf(...)");
            this.b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, i9);
            bzo.p(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        int i10 = this.d - i;
        if (i10 != 0) {
            long[] jArr2 = this.b;
            int i11 = i + 1;
            bzo.q(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.c;
            la._aj(i11, i, objArr3, this.d, objArr3);
        }
        this.b[i] = j;
        this.c[i] = obj;
        this.d++;
    }

    public final void j(long j) {
        int iJ = bzo.j(this.b, this.d, j);
        if (iJ >= 0) {
            Object[] objArr = this.c;
            Object obj = objArr[iJ];
            Object obj2 = bzo.c;
            if (obj != obj2) {
                objArr[iJ] = obj2;
                this.a = true;
            }
        }
    }

    public final int k() {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != bzo.c) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return this.d;
    }

    public final Object l(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.d)) {
            bhv.ai("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != bzo.c) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.c[i];
    }

    public final String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(h(i2));
            sb.append(SignatureVisitor.INSTANCEOF);
            Object objL = l(i2);
            if (objL != sb) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }
}
