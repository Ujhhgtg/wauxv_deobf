package me.hd.wauxv.obf;

import android.text.GetChars;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afo implements CharSequence, GetChars, Cloneable {
    public char[] a;
    public int b;
    public int c;
    public bvd d;

    public afo(afo afoVar) {
        this(afoVar.b + 16);
        int i = afoVar.b;
        this.b = i;
        this.c = afoVar.c;
        this.d = afoVar.d;
        System.arraycopy(afoVar.a, 0, this.a, 0, i);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (i < this.b) {
            return this.a[i];
        }
        if (g().g > 0) {
            return g().f.charAt(i - this.b);
        }
        return '\n';
    }

    public final void e(int i) {
        if (i < 0 || i > this.b) {
            StringBuilder sbR = yg.r(i, "index = ", ", length = ");
            sbR.append(this.b);
            throw new StringIndexOutOfBoundsException(sbR.toString());
        }
    }

    public final void f(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i3 = this.b;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException();
        }
        int i4 = i2 - i;
        if (i4 > 0) {
            for (int i5 = i; i5 < i2; i5++) {
                if (bmy.l(this.a[i5])) {
                    this.c--;
                }
            }
            char[] cArr = this.a;
            System.arraycopy(cArr, i + i4, cArr, i, this.b - i2);
            this.b -= i4;
        }
    }

    public final bvd g() {
        bvd bvdVar = this.d;
        return bvdVar == null ? bvd.NONE : bvdVar;
    }

    @Override // android.text.GetChars
    public final void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 > this.b) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("srcBegin > srcEnd");
        }
        System.arraycopy(this.a, i, cArr, i3, i2 - i);
    }

    public final void h(int i, int i2, int i3, CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (i < 0 || i > this.b) {
            throw new IndexOutOfBoundsException(bjs.i(i, "dstOffset "));
        }
        if (i2 < 0 || i3 < 0 || i2 > i3 || i3 > charSequence.length()) {
            StringBuilder sbQ = yg.q(i2, i3, "start ", ", end ", ", s.length() ");
            sbQ.append(charSequence.length());
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        int i4 = i3 - i2;
        int i5 = this.b;
        int i6 = i5 + i4;
        char[] cArr = this.a;
        if (cArr.length < i6) {
            char[] cArr2 = new char[cArr.length * 2 < i6 ? i6 + 2 : cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i5);
            this.a = cArr2;
        }
        char[] cArr3 = this.a;
        System.arraycopy(cArr3, i, cArr3, i + i4, this.b - i);
        while (i2 < i3) {
            char cCharAt = charSequence.charAt(i2);
            int i7 = i + 1;
            this.a[i] = cCharAt;
            if (bmy.l(cCharAt)) {
                this.c++;
            }
            i2++;
            i = i7;
        }
        this.b += i4;
    }

    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final afo subSequence(int i, int i2) {
        e(i);
        e(i2);
        if (i2 < i) {
            throw new StringIndexOutOfBoundsException("start is greater than end");
        }
        int i3 = i2 - i;
        char[] cArr = new char[i3 + 16];
        System.arraycopy(this.a, i, cArr, 0, i3);
        afo afoVar = new afo();
        afoVar.a = cArr;
        afoVar.b = i3;
        if (this.c > 0) {
            for (int i4 = 0; i4 < afoVar.b; i4++) {
                if (bmy.l(cArr[i4])) {
                    afoVar.c++;
                }
            }
        }
        return afoVar;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.b;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    public afo(int i) {
        this.b = 0;
        this.a = new char[i];
    }

    public afo(Object obj) {
        this.b = 0;
        this.a = new char[32];
    }
}
