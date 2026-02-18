package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cwn extends ua implements avt, acn {
    public cwp ak;
    public final cwd al;
    public final bmu am;
    public final dfx an;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public cwn(cwd cwdVar, bmu bmuVar, dfx dfxVar) {
        super(2, false);
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "writer");
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ak = cwp.e;
        this.al = cwdVar;
        this.am = bmuVar;
        this.an = dfxVar;
    }

    @Override // me.hd.wauxv.obf.acn
    public final void _bz(dfx dfxVar, int i, boolean z) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        aq(z ? 1 : 0, ae(dfxVar, i));
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x0045 */
    @Override // me.hd.wauxv.obf.acn
    public final void _ca(dfx dfxVar, int i, btd btdVar, Object obj) {
        cwp cwpVar;
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "serializer");
        if (dfxVar.m(i)) {
            cwpVar = cwp.b;
        } else {
            dfx dfxVarL = dfxVar.l(i);
            if (dfxVarL.f()) {
                emc emcVarH = dfxVarL.h();
                if (!nullSafeIsEqual(emcVarH, dnt.c)) {
                    dnt dntVar = dnt.b;
                    cwpVar = nullSafeIsEqual(emcVarH, dntVar) ? cwp.c
                            : nullSafeIsEqual(dfxVar.h(), dntVar) ? cwp.d : cwp.a;
                }
            } else {
                cwpVar = cwp.e;
            }
        }
        this.ak = cwpVar;
        _by(ae(dfxVar, i));
        x(btdVar, obj);
    }

    public void _cb(long j, String str) {
        throwIfVar1IsNull(str, "value");
        bmu bmuVar = this.am;
        if (j == 19500) {
            bmuVar.getClass();
            bmuVar.w(dnr.bh(str));
            return;
        }
        bmuVar.getClass();
        byte[] bArrBh = dnr.bh(str);
        bmuVar.n((rw) bmuVar.h, cwk.f.k((int) (j & 2147483647L)), cwf.DEFAULT);
        bmuVar.w(bArrBh);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void a(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        if (this.b >= 0) {
            _bw();
        }
        aj(dfxVar);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void aa(int i) {
        aq(i, _bx());
    }

    @Override // me.hd.wauxv.obf.avt
    public final void ab(long j) {
        ar(_bx(), j);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void ad(String str) {
        throwIfVar1IsNull(str, "value");
        _cb(_bx(), str);
    }

    public long ae(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        return ajn.n(dfxVar, i);
    }

    public void aj(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
    }

    public final void ao(long j, double d) {
        bmu bmuVar = this.am;
        if (j == 19500) {
            ((rw) bmuVar.h).g(Long.reverseBytes(Double.doubleToRawLongBits(d)));
            return;
        }
        bmuVar.n((rw) bmuVar.h, cwk.e.k((int) (j & 2147483647L)), cwf.DEFAULT);
        ((rw) bmuVar.h).g(Long.reverseBytes(Double.doubleToRawLongBits(d)));
    }

    public final void ap(long j, float f) {
        bmu bmuVar = this.am;
        if (j == 19500) {
            ((rw) bmuVar.h).f(Integer.reverseBytes(Float.floatToRawIntBits(f)));
            return;
        }
        bmuVar.n((rw) bmuVar.h, cwk.g.k((int) (j & 2147483647L)), cwf.DEFAULT);
        ((rw) bmuVar.h).f(Integer.reverseBytes(Float.floatToRawIntBits(f)));
    }

    public final void aq(int i, long j) {
        bmu bmuVar = this.am;
        if (j == 19500) {
            bmuVar.n((rw) bmuVar.h, i, cwf.DEFAULT);
            return;
        }
        int i2 = (int) (2147483647L & j);
        cwf cwfVarR = ajn.r(j);
        rw rwVar = (rw) bmuVar.h;
        bmuVar.n(rwVar, (cwfVarR == cwf.FIXED ? cwk.g : cwk.d).k(i2), cwf.DEFAULT);
        bmuVar.n(rwVar, i, cwfVarR);
    }

    public final void ar(long j, long j2) {
        cwf cwfVar = cwf.DEFAULT;
        bmu bmuVar = this.am;
        if (j == 19500) {
            bmuVar.o((rw) bmuVar.h, j2, cwfVar);
            return;
        }
        int i = (int) (2147483647L & j);
        cwf cwfVarR = ajn.r(j);
        bmuVar.getClass();
        rw rwVar = (rw) bmuVar.h;
        bmuVar.n(rwVar, (cwfVarR == cwf.FIXED ? cwk.e : cwk.d).k(i), cwfVar);
        bmuVar.o(rwVar, j2, cwfVarR);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void d(cvk cvkVar, int i, char c) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        aq(c, ae(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acn
    public final void e(cvk cvkVar, int i, float f) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        ap(ae(cvkVar, i), f);
    }

    @Override // me.hd.wauxv.obf.acn
    public final boolean f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.al.getClass();
        return false;
    }

    @Override // me.hd.wauxv.obf.acn
    public final void g(cvk cvkVar, int i, short s) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        aq(s, ae(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acn
    public final avt h(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        long jAe = ae(cvkVar, i);
        throwIfVar1IsNull(cvkVar.l(i), "inlineDescriptor");
        _by(jAe);
        return this;
    }

    @Override // me.hd.wauxv.obf.acn
    public final void i(cvk cvkVar, int i, long j) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        ar(ae(cvkVar, i), j);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void j(cvk cvkVar, int i, double d) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        ao(ae(cvkVar, i), d);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void k(int i, int i2, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        aq(i2, ae(dfxVar, i));
    }

    @Override // me.hd.wauxv.obf.acn
    public final void l(dfx dfxVar, int i, String str) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(str, "value");
        _cb(ae(dfxVar, i), str);
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x003c */
    @Override // me.hd.wauxv.obf.acn
    public final void m(dfx dfxVar, int i, btd btdVar, Object obj) {
        cwp cwpVar;
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "serializer");
        if (dfxVar.m(i)) {
            cwpVar = cwp.b;
        } else {
            emc emcVarH = dfxVar.l(i).h();
            if (!nullSafeIsEqual(emcVarH, dnt.c)) {
                dnt dntVar = dnt.b;
                cwpVar = nullSafeIsEqual(emcVarH, dntVar) ? cwp.c : nullSafeIsEqual(dfxVar.h(), dntVar) ? cwp.d : cwp.a;
            }
        }
        this.ak = cwpVar;
        _by(ae(dfxVar, i));
        super.ac(btdVar, obj);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void n(cvk cvkVar, int i, byte b) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        aq(b, ae(cvkVar, i));
    }

    public acn o(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        emc emcVarH = dfxVar.h();
        if (nullSafeIsEqual(emcVarH, dnt.b)) {
            if (!ajn.x(dfxVar.l(0)) || (_br() & 4294967296L) == 0) {
                return new dbn(_br(), this.am, this.al, dfxVar);
            }
            return new csf(_br(), this.am, this.al, dfxVar);
        }
        if (nullSafeIsEqual(emcVarH, dnt.a) || nullSafeIsEqual(emcVarH, dnt.n) || (emcVarH instanceof cur)) {
            long j_br = _br();
            return (j_br == 19500 && dfxVar.equals(this.an)) ? this
                    : ajn.w(j_br) ? new crf(this.al, this.am, dfxVar) : new ckn(_br(), this.am, this.al, dfxVar);
        }
        if (nullSafeIsEqual(emcVarH, dnt.c)) {
            return new bzn(_br(), this.am, this.al, dfxVar);
        }
        throw new dgb("This serial kind is not supported as structure: " + dfxVar);
    }

    @Override // me.hd.wauxv.obf.avt
    public final cbm p() {
        return this.al.b;
    }

    @Override // me.hd.wauxv.obf.avt
    public final void q() {
        cwp cwpVar = this.ak;
        if (cwpVar != cwp.a) {
            int iOrdinal = cwpVar.ordinal();
            throw new dgb(iOrdinal != 1
                    ? iOrdinal != 2
                            ? iOrdinal != 3
                                    ? iOrdinal != 4 ? "'null' is not supported in ProtoBuf"
                                            : "'null' is not allowed for not-null properties"
                                    : "'null' is not supported as the value of a list element in ProtoBuf"
                            : "'null' is not supported as the value of collection types in ProtoBuf"
                    : "'null' is not supported for optional properties in ProtoBuf");
        }
    }

    public avt r(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        _by(_bw());
        return this;
    }

    @Override // me.hd.wauxv.obf.avt
    public final void s(double d) {
        ao(_bx(), d);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void t(short s) {
        aq(s, _bx());
    }

    @Override // me.hd.wauxv.obf.avt
    public final void u(byte b) {
        aq(b, _bx());
    }

    public acn v(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        emc emcVarH = dfxVar.h();
        dnt dntVar = dnt.b;
        if (!nullSafeIsEqual(emcVarH, dntVar)) {
            if (nullSafeIsEqual(emcVarH, dnt.c)) {
                return new bzn(((long[]) this.c)[this.b], this.am, this.al, dfxVar);
            }
            throw new dgb("This serial kind is not supported as collection: " + dfxVar);
        }
        long j_br = _br();
        if ((4294967296L & j_br) != 0 && ajn.x(dfxVar.l(0))) {
            return new csf(_br(), this.am, this.al, dfxVar);
        }
        if (j_br == 19500) {
            bmu bmuVar = this.am;
            bmuVar.n((rw) bmuVar.h, i, cwf.DEFAULT);
        }
        dfx dfxVar2 = this.an;
        if (!nullSafeIsEqual(dfxVar2.h(), dntVar) || j_br == 19500 || dfxVar2.equals(dfxVar)) {
            return new dbn(j_br, this.am, this.al, dfxVar);
        }
        return new ckn(this.al, this.am, j_br, dfxVar, new rw());
    }

    @Override // me.hd.wauxv.obf.avt
    public final void w(boolean z) {
        aq(z ? 1 : 0, _bx());
    }

    @Override // me.hd.wauxv.obf.avt
    public final void x(btd btdVar, Object obj) {
        throwIfVar1IsNull(btdVar, "serializer");
        if (!(btdVar instanceof bvt)) {
            if (!nullSafeIsEqual(btdVar.getDescriptor(), rx.j.o)) {
                btdVar.c(this, obj);
                return;
            }
            throwIfVar1IsNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr = (byte[]) obj;
            long j_bx = _bx();
            bmu bmuVar = this.am;
            if (j_bx == 19500) {
                bmuVar.w(bArr);
                return;
            }
            bmuVar.getClass();
            bmuVar.n((rw) bmuVar.h, cwk.f.k((int) (j_bx & 2147483647L)), cwf.DEFAULT);
            bmuVar.w(bArr);
            return;
        }
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        bzm bzmVar = new bzm(0);
        dfz dfzVar = (dfz) bzmVar.d;
        throwIfVar1IsNull(dfzVar, "elementDesc");
        kl klVar = new kl(dfzVar, 2);
        throwIfVar1IsNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Set setEntrySet = ((Map) obj).entrySet();
        throwIfVar1IsNull(setEntrySet, "<this>");
        int size = setEntrySet.size();
        acn acnVarV = v(klVar, size);
        throwIfVar1IsNull(setEntrySet, "<this>");
        Iterator it = setEntrySet.iterator();
        for (int i = 0; i < size; i++) {
            acnVarV._ca(klVar, i, bzmVar, it.next());
        }
        acnVarV.a(klVar);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void y(float f) {
        ap(_bx(), f);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void z(char c) {
        aq(c, _bx());
    }
}
