package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmx extends KotlinHelpers2 implements ajt, acm {
    public final brn ac;
    public final ewf ad;
    public final yi br;
    public final cbm bs;
    public int bt;
    public final brt bu;
    public final bsa bv;

    public dmx(brn brnVar, ewf ewfVar, yi yiVar, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ac = brnVar;
        this.ad = ewfVar;
        this.br = yiVar;
        this.bs = brnVar.c;
        this.bt = -1;
        brt brtVar = brnVar.b;
        this.bu = brtVar;
        this.bv = brtVar.a ? null : new bsa(dfxVar);
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.acm
    public final void _bp(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        int i = dfxVar.i();
        brn brnVar = this.ac;
        if (i == 0 && bmy.w(brnVar, dfxVar)) {
            while (f(dfxVar) != -1) {
            }
        }
        yi yiVar = this.br;
        if (yiVar.ai()) {
            brnVar.b.getClass();
            KotlinHelpers2.ay(yiVar, "");
            throw null;
        }
        yiVar.p(this.ad.h);
        ik ikVar = (ik) yiVar.c;
        int i2 = ikVar.b;
        int[] iArr = (int[]) ikVar.d;
        if (iArr[i2] == -2) {
            iArr[i2] = -1;
            ikVar.b = i2 - 1;
        }
        int i3 = ikVar.b;
        if (i3 != -1) {
            ikVar.b = i3 - 1;
        }
    }

    @Override // me.hd.wauxv.obf.acm
    public final cbm a() {
        return this.bs;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final float aa() {
        yi yiVar = this.br;
        String strS = yiVar.s();
        try {
            float f = Float.parseFloat(strS);
            this.ac.b.getClass();
            if (Math.abs(f) <= Float.MAX_VALUE) {
                return f;
            }
            KotlinHelpers2.bo(yiVar, Float.valueOf(f));
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, dkz.o('\'', "Failed to parse type 'float' for input '", strS), 0, null, 6);
            throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final double ab() {
        yi yiVar = this.br;
        String strS = yiVar.s();
        try {
            double d = Double.parseDouble(strS);
            this.ac.b.getClass();
            if (Math.abs(d) <= Double.MAX_VALUE) {
                return d;
            }
            KotlinHelpers2.bo(yiVar, Double.valueOf(d));
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, dkz.o('\'', "Failed to parse type 'double' for input '", strS), 0, null, 6);
            throw null;
        }
    }

    public final brx bw() {
        return new ek(this.ac.b, this.br).m();
    }

    @Override // me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        brn brnVar = this.ac;
        brt brtVar = brnVar.b;
        yi yiVar = this.br;
        ik ikVar = (ik) yiVar.c;
        String str = (String) yiVar.f;
        throwIfVar1IsNull(dfxVar, "descriptor");
        ewf ewfVar = this.ad;
        int iOrdinal = ewfVar.ordinal();
        char c = ':';
        boolean zAi = false;
        int iG = -1;
        if (iOrdinal == 0) {
            boolean zAi2 = yiVar.ai();
            while (true) {
                boolean zK = yiVar.k();
                bsa bsaVar = this.bv;
                if (!zK) {
                    if (!zAi2) {
                        if (bsaVar == null) {
                            break;
                        }
                        iG = bsaVar.a.g();
                        break;
                    }
                    brtVar.getClass();
                    KotlinHelpers2.ay(yiVar, "object");
                    throw null;
                }
                this.bu.getClass();
                String strM = yiVar.m();
                yiVar.p(c);
                int iU = bmy.u(dfxVar, brnVar, strM);
                if (iU != -3) {
                    if (bsaVar != null) {
                        bsaVar.a.f(iU);
                    }
                    iG = iU;
                    break;
                }
                if (!bmy.w(brnVar, dfxVar)) {
                    int i = ikVar.b;
                    int[] iArr = (int[]) ikVar.d;
                    if (iArr[i] == -2) {
                        iArr[i] = -1;
                        ikVar.b = i - 1;
                    }
                    int i2 = ikVar.b;
                    if (i2 != -1) {
                        ikVar.b = i2 - 1;
                    }
                    int iAl = dnj.al(6, str.subSequence(0, yiVar.b).toString(), strM);
                    throw new brv("Encountered an unknown key '" + strM + "' at offset " + iAl + " at path: "
                            + ikVar.p()
                            + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: "
                            + ((Object) KotlinHelpers2.ba(iAl, str)), 0);
                }
                ArrayList arrayList = new ArrayList();
                byte bAe = yiVar.ae();
                if (bAe == 8 || bAe == 6) {
                    while (true) {
                        byte bAe2 = yiVar.ae();
                        if (bAe2 == 1) {
                            yiVar.m();
                        } else {
                            if (bAe2 == 8 || bAe2 == 6) {
                                arrayList.add(Byte.valueOf(bAe2));
                            } else if (bAe2 == 9) {
                                if (((Number) aaz.l(arrayList)).byteValue() != 8) {
                                    throw KotlinHelpers2.ak(yiVar.b, "found ] instead of } at path: " + ikVar, str);
                                }
                                abf.ar(arrayList);
                            } else if (bAe2 == 7) {
                                if (((Number) aaz.l(arrayList)).byteValue() != 6) {
                                    throw KotlinHelpers2.ak(yiVar.b, "found } instead of ] at path: " + ikVar, str);
                                }
                                abf.ar(arrayList);
                            } else if (bAe2 == 10) {
                                yi.g(yiVar,
                                        "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0,
                                        null, 6);
                                throw null;
                            }
                            yiVar.n();
                            if (arrayList.size() == 0) {
                                break;
                            }
                        }
                    }
                } else {
                    yiVar.s();
                }
                zAi2 = yiVar.ai();
                c = ':';
            }
        } else if (iOrdinal != 2) {
            boolean zAi3 = yiVar.ai();
            if (yiVar.k()) {
                int i3 = this.bt;
                if (i3 != -1 && !zAi3) {
                    yi.g(yiVar, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                iG = i3 + 1;
                this.bt = iG;
            } else if (zAi3) {
                brtVar.getClass();
                KotlinHelpers2.ay(yiVar, "array");
                throw null;
            }
        } else {
            int i4 = this.bt;
            boolean z = i4 % 2 != 0;
            if (!z) {
                yiVar.p(':');
            } else if (i4 != -1) {
                zAi = yiVar.ai();
            }
            if (yiVar.k()) {
                if (z) {
                    if (this.bt == -1) {
                        int i5 = yiVar.b;
                        if (zAi) {
                            yi.g(yiVar, "Unexpected leading comma", i5, null, 4);
                            throw null;
                        }
                    } else {
                        int i6 = yiVar.b;
                        if (!zAi) {
                            yi.g(yiVar, "Expected comma after the key-value pair", i6, null, 4);
                            throw null;
                        }
                    }
                }
                iG = this.bt + 1;
                this.bt = iG;
            } else if (zAi) {
                brtVar.getClass();
                KotlinHelpers2.ay(yiVar, "object");
                throw null;
            }
        }
        if (ewfVar != ewf.c) {
            ((int[]) ikVar.d)[ikVar.b] = iG;
        }
        return iG;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.acm
    public final Object h(dfx dfxVar, int i, btd btdVar, Object obj) {
        ik ikVar = (ik) this.br.c;
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "deserializer");
        boolean z = this.ad == ewf.c && (i & 1) == 0;
        if (z) {
            int[] iArr = (int[]) ikVar.d;
            int i2 = ikVar.b;
            if (iArr[i2] == -2) {
                ((Object[]) ikVar.c)[i2] = arj.j;
            }
        }
        Object objH = super.h(dfxVar, i, btdVar, obj);
        if (z) {
            int[] iArr2 = (int[]) ikVar.d;
            int i3 = ikVar.b;
            if (iArr2[i3] != -2) {
                int i4 = i3 + 1;
                ikVar.b = i4;
                if (i4 == ((Object[]) ikVar.c).length) {
                    ikVar.ad();
                }
            }
            Object[] objArr = (Object[]) ikVar.c;
            int i5 = ikVar.b;
            objArr[i5] = objH;
            ((int[]) ikVar.d)[i5] = -2;
        }
        return objH;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final acm p(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        brn brnVar = this.ac;
        ewf ewfVarAp = KotlinHelpers.ap(brnVar, dfxVar);
        yi yiVar = this.br;
        ik ikVar = (ik) yiVar.c;
        int i = ikVar.b + 1;
        ikVar.b = i;
        if (i == ((Object[]) ikVar.c).length) {
            ikVar.ad();
        }
        ((Object[]) ikVar.c)[i] = dfxVar;
        yiVar.p(ewfVarAp.g);
        if (yiVar.ae() != 4) {
            int iOrdinal = ewfVarAp.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new dmx(brnVar, ewfVarAp, yiVar, dfxVar)
                    : (this.ad == ewfVarAp && brnVar.b.a) ? this : new dmx(brnVar, ewfVarAp, yiVar, dfxVar);
        }
        yi.g(yiVar, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final boolean q() {
        boolean z;
        boolean z2;
        yi yiVar = this.br;
        int iAh = yiVar.ah();
        String str = (String) yiVar.f;
        if (iAh == str.length()) {
            yi.g(yiVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iAh) == '\"') {
            iAh++;
            z = true;
        } else {
            z = false;
        }
        int iAg = yiVar.ag(iAh);
        if (iAg >= str.length() || iAg == -1) {
            yi.g(yiVar, "EOF", 0, null, 6);
            throw null;
        }
        int i = iAg + 1;
        int iCharAt = str.charAt(iAg) | ' ';
        if (iCharAt == 102) {
            yiVar.l(i, "alse");
            z2 = false;
        } else {
            if (iCharAt != 116) {
                yi.g(yiVar, "Expected valid boolean literal prefix, but had '" + yiVar.s() + '\'', 0, null, 6);
                throw null;
            }
            yiVar.l(i, "rue");
            z2 = true;
        }
        if (!z) {
            return z2;
        }
        if (yiVar.b == str.length()) {
            yi.g(yiVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(yiVar.b) == '\"') {
            yiVar.b++;
            return z2;
        }
        yi.g(yiVar, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final char r() {
        yi yiVar = this.br;
        String strS = yiVar.s();
        if (strS.length() == 1) {
            return strS.charAt(0);
        }
        yi.g(yiVar, dkz.o('\'', "Expected single char, but got '", strS), 0, null, 6);
        throw null;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final int s() {
        yi yiVar = this.br;
        long jQ = yiVar.q();
        int i = (int) jQ;
        if (jQ == i) {
            return i;
        }
        yi.g(yiVar, "Failed to parse int for input '" + jQ + '\'', 0, null, 6);
        throw null;
    }

    /* JADX WARN: Found duplicated region for block: B:39:0x0117 */
    /* JADX WARN: Found duplicated region for block: B:40:0x0118 */
    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final Object t(btd btdVar) {
        String message;
        String strC;
        brn brnVar = this.ac;
        yi yiVar = this.br;
        ik ikVar = (ik) yiVar.c;
        throwIfVar1IsNull(btdVar, "deserializer");
        try {
        } catch (cdl e) {
            message = e.getMessage();
            throwIfVar1IsNull(message);
            if (dnj.ab(message, "at path", false)) {
                throw e;
            }
            throw new cdl(e.a, e.getMessage() + " at path: " + ikVar.p(), e);
        }
        if (!(btdVar instanceof cus)) {
            return btdVar.a(this);
        }
        brnVar.b.getClass();
        String strU = bhv.u(brnVar, ((cus) btdVar).getDescriptor());
        this.bu.getClass();
        String strAd = yiVar.ad(strU);
        if (strAd != null) {
            try {
                bmy.o((cus) btdVar, this, strAd);
                throw null;
            } catch (dgb e2) {
                String message2 = e2.getMessage();
                throwIfVar1IsNull(message2);
                String strAp = dnj.ap(dnj.aw(message2, '\n'), ".");
                String message3 = e2.getMessage();
                throwIfVar1IsNull(message3);
                yi.g(yiVar, strAp, 0, dnj.at('\n', message3, ""), 2);
                throw null;
            }
        }
        if (!(btdVar instanceof cus)) {
            return btdVar.a(this);
        }
        brnVar.b.getClass();
        String strU2 = bhv.u(brnVar, ((cus) btdVar).getDescriptor());
        brx brxVarBw = bw();
        String strB = ((cus) btdVar).getDescriptor().b();
        if (!(brxVarBw instanceof bsl)) {
            throw KotlinHelpers2.ak(-1, "Expected " + dal.b(bsl.class).d() + ", but had " + dal.b(brxVarBw.getClass()).d()
                    + " as the serialized body of " + strB + " at element: " + ikVar.p(), brxVarBw.toString());
        }
        bsl bslVar = (bsl) brxVarBw;
        brx brxVar = (brx) bslVar.get(strU2);
        if (brxVar != null) {
            bsp bspVarB = bry.b(brxVar);
            strC = bspVarB instanceof bsi ? null : bspVarB.c();
        }
        try {
            bmy.o((cus) btdVar, this, strC);
            throw null;
        } catch (dgb e3) {
            String message4 = e3.getMessage();
            throwIfVar1IsNull(message4);
            throw KotlinHelpers2.ak(-1, message4, bslVar.toString());
        }
        message = e.getMessage();
        throwIfVar1IsNull(message);
        if (dnj.ab(message, "at path", false)) {
            throw e;
        }
        throw new cdl(e.a, e.getMessage() + " at path: " + ikVar.p(), e);
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final ajt u(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return dmz.b(dfxVar) ? new bru(this.br, this.ac) : this;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final String v() {
        this.bu.getClass();
        return this.br.r();
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final long w() {
        return this.br.q();
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final boolean x() {
        bsa bsaVar = this.bv;
        if (!(bsaVar != null ? bsaVar.b : false)) {
            yi yiVar = this.br;
            int iAg = yiVar.ag(yiVar.ah());
            String str = (String) yiVar.f;
            int length = str.length() - iAg;
            boolean z = false;
            if (length >= 4 && iAg != -1) {
                for (int i = 0; i < 4; i++) {
                    if ("null".charAt(i) == str.charAt(iAg + i)) {
                    }
                }
                if (length <= 4 || cnf.ap(str.charAt(iAg + 4)) != 0) {
                    z = true;
                    yiVar.b = iAg + 4;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final byte y() {
        yi yiVar = this.br;
        long jQ = yiVar.q();
        byte b = (byte) jQ;
        if (jQ == b) {
            return b;
        }
        yi.g(yiVar, "Failed to parse byte for input '" + jQ + '\'', 0, null, 6);
        throw null;
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final short z() {
        yi yiVar = this.br;
        long jQ = yiVar.q();
        short s = (short) jQ;
        if (jQ == s) {
            return s;
        }
        yi.g(yiVar, "Failed to parse short for input '" + jQ + '\'', 0, null, 6);
        throw null;
    }
}
