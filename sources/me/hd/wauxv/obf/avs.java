package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avs {
    public final sg a;
    public int b;
    public int c;
    public int d;

    public avs(avr avrVar, int i) {
        this(new ek(avrVar.a), i);
    }

    public final void e(int i) {
        if (f() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i), Integer.valueOf(f())));
        }
    }

    public final int f() {
        if (this.b == -1) {
            byte b = this.a.readByte();
            this.b = b & 31;
            this.d = (b & 224) >> 5;
        }
        return this.b;
    }

    public final int g() {
        e(29);
        this.b = -1;
        sg sgVar = this.a;
        this.c = ajn.ac(sgVar);
        return ajn.ac(sgVar);
    }

    public final double h() {
        e(17);
        this.b = -1;
        long j = 0;
        for (int i = this.d; i >= 0; i--) {
            j = (j >>> 8) | ((((long) this.a.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final long i() {
        e(6);
        this.b = -1;
        int i = this.d;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) this.a.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final int j() {
        e(23);
        this.b = -1;
        return emn.aw(this.a, this.d, false);
    }

    public final void k() {
        int iF = f();
        sg sgVar = this.a;
        int i = 0;
        if (iF == 0) {
            e(0);
            this.b = -1;
            emn.au(sgVar, this.d);
            return;
        }
        if (iF == 6) {
            i();
            return;
        }
        if (iF == 2) {
            e(2);
            this.b = -1;
            emn.au(sgVar, this.d);
            return;
        }
        if (iF == 3) {
            e(3);
            this.b = -1;
            emn.aw(sgVar, this.d, false);
            return;
        }
        if (iF == 4) {
            e(4);
            this.b = -1;
            emn.au(sgVar, this.d);
            return;
        }
        if (iF == 16) {
            e(16);
            this.b = -1;
            Float.intBitsToFloat(emn.aw(sgVar, this.d, true));
            return;
        }
        if (iF == 17) {
            h();
            return;
        }
        switch (iF) {
            case 21:
                e(21);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 22:
                e(22);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 23:
                j();
                return;
            case 24:
                e(24);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 25:
                e(25);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 26:
                e(26);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 27:
                e(27);
                this.b = -1;
                emn.aw(sgVar, this.d, false);
                return;
            case 28:
                e(28);
                this.b = -1;
                int iAc = ajn.ac(sgVar);
                while (i < iAc) {
                    k();
                    i++;
                }
                return;
            case 29:
                int iG = g();
                while (i < iG) {
                    ajn.ac(sgVar);
                    k();
                    i++;
                }
                return;
            case 30:
                e(30);
                this.b = -1;
                return;
            case 31:
                e(31);
                this.b = -1;
                return;
            default:
                throw new amo("Unexpected type: " + Integer.toHexString(this.b), null);
        }
    }

    public avs(sg sgVar) {
        this.b = -1;
        this.a = sgVar;
    }

    public avs(sg sgVar, int i) {
        this.a = sgVar;
        this.b = i;
    }
}
