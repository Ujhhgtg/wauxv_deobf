package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwo {
    public final ru a;
    public int b = -1;
    public cwk c = cwk.c;
    public boolean d;
    public int e;

    public cwo(ru ruVar) {
        this.a = ruVar;
    }

    public static void f(int i) {
        if (i < 0) {
            throw new cwm(bjs.i(i, "Unexpected negative length: "), null);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Found duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0058 A[LOOP:0: B:22:0x003c->B:29:0x0058, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:37:0x004c A[SYNTHETIC] */
    public final int g(cwf cwfVar) {
        int i;
        int iE;
        int iOrdinal = cwfVar.ordinal();
        ru ruVar = this.a;
        if (iOrdinal == 0) {
            return (int) ruVar.g(false);
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return p();
            }
            throw new abt();
        }
        int i2 = ruVar.b;
        int i3 = ruVar.a;
        if (i2 == i3) {
            throw new dgb("Unexpected EOF");
        }
        byte[] bArr = ruVar.c;
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 >= 0) {
            ruVar.b = i4;
        } else {
            if (i3 - i2 <= 1) {
                i = 0;
                for (int i6 = 0; i6 < 32; i6 += 7) {
                    iE = ruVar.e();
                    i |= (iE & 127) << i6;
                    if ((iE & 128) == 0) {
                        i5 = i;
                    }
                }
                throw new dgb("Input stream is malformed: Varint too long (exceeded 32 bits)");
            }
            int i7 = i2 + 2;
            int i8 = (bArr[i4] << 7) ^ i5;
            if (i8 >= 0) {
                i = 0;
                while (i6 < 32) {
                    iE = ruVar.e();
                    i |= (iE & 127) << i6;
                    if ((iE & 128) == 0) {
                        i5 = i;
                    }
                }
                throw new dgb("Input stream is malformed: Varint too long (exceeded 32 bits)");
            }
            ruVar.b = i7;
            i5 = i8 ^ (-128);
        }
        return ((((i5 << 31) >> 31) ^ i5) >> 1) ^ (Integer.MIN_VALUE & i5);
    }

    public final long h(cwf cwfVar) {
        int iOrdinal = cwfVar.ordinal();
        ru ruVar = this.a;
        if (iOrdinal == 0) {
            return ruVar.g(false);
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return r();
            }
            throw new abt();
        }
        long jG = ruVar.g(false);
        return (jG & Long.MIN_VALUE) ^ ((((jG << 63) >> 63) ^ jG) >> 1);
    }

    public final ru i() {
        cwk cwkVar = cwk.f;
        if (this.c == cwkVar) {
            return j();
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final ru j() {
        int iG = g(cwf.DEFAULT);
        f(iG);
        ru ruVar = this.a;
        ruVar.d(iG);
        ru ruVar2 = new ru(ruVar.c, ruVar.b + iG);
        ruVar2.b = ruVar.b;
        ruVar.b += iG;
        return ruVar2;
    }

    public final byte[] k() {
        cwk cwkVar = cwk.f;
        if (this.c == cwkVar) {
            return l();
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final byte[] l() {
        int iG = g(cwf.DEFAULT);
        f(iG);
        ru ruVar = this.a;
        ruVar.d(iG);
        byte[] bArr = new byte[iG];
        int i = ruVar.a;
        int i2 = ruVar.b;
        int i3 = i - i2;
        if (i3 < iG) {
            iG = i3;
        }
        la._ak(ruVar.c, 0, i2, bArr, i2 + iG);
        ruVar.b += iG;
        return bArr;
    }

    public final double m() {
        cwk cwkVar = cwk.e;
        if (this.c == cwkVar) {
            return Double.longBitsToDouble(r());
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final float n() {
        cwk cwkVar = cwk.g;
        if (this.c == cwkVar) {
            return Float.intBitsToFloat(p());
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final int o(cwf cwfVar) {
        cwk cwkVar = cwfVar == cwf.FIXED ? cwk.g : cwk.d;
        if (this.c == cwkVar) {
            return g(cwfVar);
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final int p() {
        int iE = 0;
        for (int i = 0; i < 4; i++) {
            iE |= (this.a.e() & Opcodes.CONST_METHOD_TYPE) << (i * 8);
        }
        return iE;
    }

    public final long q(cwf cwfVar) {
        cwk cwkVar = cwfVar == cwf.FIXED ? cwk.e : cwk.d;
        if (this.c == cwkVar) {
            return h(cwfVar);
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final long r() {
        long jE = 0;
        for (int i = 0; i < 8; i++) {
            jE |= ((long) (this.a.e() & Opcodes.CONST_METHOD_TYPE)) << (i * 8);
        }
        return jE;
    }

    public final String s() {
        cwk cwkVar = cwk.f;
        if (this.c == cwkVar) {
            int iG = g(cwf.DEFAULT);
            f(iG);
            return this.a.f(iG);
        }
        throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
    }

    public final int t() {
        if (!this.d) {
            this.e = (this.b << 3) | this.c.j;
            return v((int) this.a.g(true));
        }
        this.d = false;
        int i = (this.b << 3) | this.c.j;
        int iV = v(this.e);
        this.e = i;
        return iV;
    }

    public final void u() {
        int iOrdinal = this.c.ordinal();
        cwf cwfVar = cwf.DEFAULT;
        if (iOrdinal == 1) {
            o(cwfVar);
            return;
        }
        cwf cwfVar2 = cwf.FIXED;
        if (iOrdinal == 2) {
            q(cwfVar2);
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4) {
                o(cwfVar2);
                return;
            } else {
                throw new cwm("Unsupported start group or end group wire type: " + this.c, null);
            }
        }
        cwk cwkVar = cwk.f;
        if (this.c != cwkVar) {
            throw new cwm("Expected wire type " + cwkVar + ", but found " + this.c, null);
        }
        int iG = g(cwfVar);
        f(iG);
        ru ruVar = this.a;
        ruVar.d(iG);
        ruVar.b += iG;
    }

    public final int v(int i) {
        if (i == -1) {
            this.b = -1;
            this.c = cwk.c;
            return -1;
        }
        this.b = i >>> 3;
        cwk.a.getClass();
        this.c = cwk.b[i & 7];
        return this.b;
    }
}
