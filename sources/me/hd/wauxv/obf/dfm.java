package me.hd.wauxv.obf;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfm extends sj {
    public final transient byte[][] p;
    public final transient int[] q;

    public dfm(byte[][] bArr, int[] iArr) {
        super(sj.a.b);
        this.p = bArr;
        this.q = iArr;
    }

    @Override // me.hd.wauxv.obf.sj
    public final String e() {
        return new sj(r()).e();
    }

    @Override // me.hd.wauxv.obf.sj
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sj)) {
            return false;
        }
        sj sjVar = (sj) obj;
        return sjVar.g() == g() && k(sjVar, g());
    }

    @Override // me.hd.wauxv.obf.sj
    public final sj f(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.p;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.q;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        throwIfVar1IsNull(bArrDigest);
        return new sj(bArrDigest);
    }

    @Override // me.hd.wauxv.obf.sj
    public final int g() {
        return this.q[this.p.length - 1];
    }

    @Override // me.hd.wauxv.obf.sj
    public final String h() {
        return new sj(r()).h();
    }

    @Override // me.hd.wauxv.obf.sj
    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.p;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.q;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.c = i3;
        return i3;
    }

    @Override // me.hd.wauxv.obf.sj
    public final byte[] i() {
        return r();
    }

    @Override // me.hd.wauxv.obf.sj
    public final byte j(int i) {
        byte[][] bArr = this.p;
        int length = bArr.length - 1;
        int[] iArr = this.q;
        aye.n(iArr[length], i, 1L);
        int iAl = cnb.al(this, i);
        return bArr[iAl][(i - (iAl == 0 ? 0 : iArr[iAl - 1])) + iArr[bArr.length + iAl]];
    }

    @Override // me.hd.wauxv.obf.sj
    public final boolean k(sj sjVar, int i) {
        throwIfVar1IsNull(sjVar, "other");
        if (g() - i >= 0) {
            int iAl = cnb.al(this, 0);
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int[] iArr = this.q;
                int i4 = iAl == 0 ? 0 : iArr[iAl - 1];
                int i5 = iArr[iAl] - i4;
                byte[][] bArr = this.p;
                int i6 = iArr[bArr.length + iAl];
                int iMin = Math.min(i, i5 + i4) - i2;
                if (sjVar.l(bArr[iAl], i3, (i2 - i4) + i6, iMin)) {
                    i3 += iMin;
                    i2 += iMin;
                    iAl++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.sj
    public final boolean l(byte[] bArr, int i, int i2, int i3) {
        throwIfVar1IsNull(bArr, "other");
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iAl = cnb.al(this, i);
        while (i < i4) {
            int[] iArr = this.q;
            int i5 = iAl == 0 ? 0 : iArr[iAl - 1];
            int i6 = iArr[iAl] - i5;
            byte[][] bArr2 = this.p;
            int i7 = iArr[bArr2.length + iAl];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!aye.l(bArr2[iAl], (i - i5) + i7, i2, bArr, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iAl++;
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.sj
    public final sj m() {
        return new sj(r()).m();
    }

    @Override // me.hd.wauxv.obf.sj
    public final void o(int i, rh rhVar) {
        int iAl = cnb.al(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.q;
            int i3 = iAl == 0 ? 0 : iArr[iAl - 1];
            int i4 = iArr[iAl] - i3;
            byte[][] bArr = this.p;
            int i5 = iArr[bArr.length + iAl];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            dfj dfjVar = new dfj(bArr[iAl], i6, i6 + iMin, true, false);
            dfj dfjVar2 = rhVar.a;
            if (dfjVar2 == null) {
                dfjVar.g = dfjVar;
                dfjVar.f = dfjVar;
                rhVar.a = dfjVar;
            } else {
                dfj dfjVar3 = dfjVar2.g;
                throwIfVar1IsNull(dfjVar3);
                dfjVar3.i(dfjVar);
            }
            i2 += iMin;
            iAl++;
        }
        rhVar.b += (long) i;
    }

    public final byte[] r() {
        byte[] bArr = new byte[g()];
        byte[][] bArr2 = this.p;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.q;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            la._ak(bArr2[i], i3, i4, bArr, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // me.hd.wauxv.obf.sj
    public final String toString() {
        return new sj(r()).toString();
    }
}
