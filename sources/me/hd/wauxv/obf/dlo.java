package me.hd.wauxv.obf;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlo implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ int[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public dlo(int i) {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.b = new int[i5];
        this.c = new Object[i5];
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        throwIfVar1IsNull(objClone,
                "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        dlo dloVar = (dlo) objClone;
        dloVar.b = (int[]) this.b.clone();
        dloVar.c = (Object[]) this.c.clone();
        return dloVar;
    }

    public final void e(int i, Object obj) {
        int i2 = this.d;
        if (i2 != 0 && i <= this.b[i2 - 1]) {
            h(i, obj);
            return;
        }
        if (this.a && i2 >= this.b.length) {
            bht.q(this);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int i4 = (i3 + 1) * 4;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.b, i7);
            throwIfVar1IsNull(iArrCopyOf, "copyOf(...)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, i7);
            throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        this.b[i3] = i;
        this.c[i3] = obj;
        this.d = i3 + 1;
    }

    public final Object f(int i) {
        Object obj;
        int i2 = KotlinHelpers.i(this.b, this.d, i);
        if (i2 < 0 || (obj = this.c[i2]) == bht.p) {
            return null;
        }
        return obj;
    }

    public final int g(int i) {
        if (this.a) {
            bht.q(this);
        }
        return this.b[i];
    }

    public final void h(int i, Object obj) {
        int i2 = KotlinHelpers.i(this.b, this.d, i);
        if (i2 >= 0) {
            this.c[i2] = obj;
            return;
        }
        int i3 = ~i2;
        int i4 = this.d;
        if (i3 < i4) {
            Object[] objArr = this.c;
            if (objArr[i3] == bht.p) {
                this.b[i3] = i;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.a && i4 >= this.b.length) {
            bht.q(this);
            i3 = ~KotlinHelpers.i(this.b, this.d, i);
        }
        int i5 = this.d;
        if (i5 >= this.b.length) {
            int i6 = (i5 + 1) * 4;
            for (int i7 = 4; i7 < 32; i7++) {
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
            }
            int i9 = i6 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.b, i9);
            throwIfVar1IsNull(iArrCopyOf, "copyOf(...)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, i9);
            throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        int i10 = this.d;
        if (i10 - i3 != 0) {
            int[] iArr = this.b;
            int i11 = i3 + 1;
            la._al(iArr, i11, i3, i10, iArr);
            Object[] objArr2 = this.c;
            la._aj(i11, i3, objArr2, this.d, objArr2);
        }
        this.b[i3] = i;
        this.c[i3] = obj;
        this.d++;
    }

    public final int i() {
        if (this.a) {
            bht.q(this);
        }
        return this.d;
    }

    public final Object j(int i) {
        if (this.a) {
            bht.q(this);
        }
        Object[] objArr = this.c;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append(SignatureVisitor.INSTANCEOF);
            Object objJ = j(i2);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
