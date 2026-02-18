package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmy implements avt, acn {
    public final cxc ae;
    public final brn af;
    public final ewf ag;
    public final dmy[] ah;
    public final cbm ai;
    public final brt aj;
    public boolean ak;
    public String al;
    public String am;

    public dmy(cxc cxcVar, brn brnVar, ewf ewfVar, dmy[] dmyVarArr) {
        throwIfVar1IsNull(cxcVar, "composer");
        this.ae = cxcVar;
        this.af = brnVar;
        this.ag = ewfVar;
        this.ah = dmyVarArr;
        this.ai = brnVar.c;
        this.aj = brnVar.b;
        int iOrdinal = ewfVar.ordinal();
        if (dmyVarArr != null) {
            dmy dmyVar = dmyVarArr[iOrdinal];
            if (dmyVar == null && dmyVar == this) {
                return;
            }
            dmyVarArr[iOrdinal] = this;
        }
    }

    @Override // me.hd.wauxv.obf.acn
    public final void _bz(dfx dfxVar, int i, boolean z) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        an(dfxVar, i);
        w(z);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void _ca(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "serializer");
        an(dfxVar, i);
        x(btdVar, obj);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void a(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        cxc cxcVar = this.ae;
        cxcVar.getClass();
        cxcVar.h = false;
        cxcVar.m(this.ag.h);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void aa(int i) {
        if (this.ak) {
            ad(String.valueOf(i));
        } else {
            this.ae.d(i);
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final void ab(long j) {
        if (this.ak) {
            ad(String.valueOf(j));
        } else {
            this.ae.e(j);
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final void ad(String str) {
        throwIfVar1IsNull(str, "value");
        this.ae.b(str);
    }

    public final void an(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        int iOrdinal = this.ag.ordinal();
        cxc cxcVar = this.ae;
        boolean z = true;
        if (iOrdinal == 1) {
            if (!cxcVar.h) {
                cxcVar.m(',');
            }
            cxcVar.l();
            return;
        }
        if (iOrdinal == 2) {
            if (cxcVar.h) {
                this.ak = true;
                cxcVar.l();
                return;
            }
            if (i % 2 == 0) {
                cxcVar.m(',');
                cxcVar.l();
            } else {
                cxcVar.m(':');
                cxcVar.p();
                z = false;
            }
            this.ak = z;
            return;
        }
        if (iOrdinal != 3) {
            if (!cxcVar.h) {
                cxcVar.m(',');
            }
            cxcVar.l();
            bmy.y(this.af, dfxVar);
            ad(dfxVar.j(i));
            cxcVar.m(':');
            cxcVar.p();
            return;
        }
        if (i == 0) {
            this.ak = true;
        }
        if (i == 1) {
            cxcVar.m(',');
            cxcVar.p();
            this.ak = false;
        }
    }

    @Override // me.hd.wauxv.obf.acn
    public final void d(cvk cvkVar, int i, char c) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        z(c);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void e(cvk cvkVar, int i, float f) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        y(f);
    }

    @Override // me.hd.wauxv.obf.acn
    public final boolean f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.aj.getClass();
        return false;
    }

    @Override // me.hd.wauxv.obf.acn
    public final void g(cvk cvkVar, int i, short s) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        t(s);
    }

    @Override // me.hd.wauxv.obf.acn
    public final avt h(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        return r(cvkVar.l(i));
    }

    @Override // me.hd.wauxv.obf.acn
    public final void i(cvk cvkVar, int i, long j) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        ab(j);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void j(cvk cvkVar, int i, double d) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        s(d);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void k(int i, int i2, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        an(dfxVar, i);
        aa(i2);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void l(dfx dfxVar, int i, String str) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(str, "value");
        an(dfxVar, i);
        ad(str);
    }

    @Override // me.hd.wauxv.obf.acn
    public final void m(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "serializer");
        if (obj != null || this.aj.a) {
            throwIfVar1IsNull(dfxVar, "descriptor");
            throwIfVar1IsNull(btdVar, "serializer");
            an(dfxVar, i);
            super.ac(btdVar, obj);
        }
    }

    @Override // me.hd.wauxv.obf.acn
    public final void n(cvk cvkVar, int i, byte b) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        an(cvkVar, i);
        u(b);
    }

    @Override // me.hd.wauxv.obf.avt
    public final acn o(dfx dfxVar) {
        dmy dmyVar;
        throwIfVar1IsNull(dfxVar, "descriptor");
        brn brnVar = this.af;
        ewf ewfVarAp = KotlinHelpers.ap(brnVar, dfxVar);
        char c = ewfVarAp.g;
        cxc cxcVar = this.ae;
        cxcVar.m(c);
        cxcVar.h = true;
        String str = this.al;
        if (str != null) {
            String strB = this.am;
            if (strB == null) {
                strB = dfxVar.b();
            }
            cxcVar.l();
            ad(str);
            cxcVar.m(':');
            ad(strB);
            this.al = null;
            this.am = null;
        }
        if (this.ag == ewfVarAp) {
            return this;
        }
        dmy[] dmyVarArr = this.ah;
        return (dmyVarArr == null || (dmyVar = dmyVarArr[ewfVarAp.ordinal()]) == null)
                ? new dmy(cxcVar, brnVar, ewfVarAp, dmyVarArr)
                : dmyVar;
    }

    @Override // me.hd.wauxv.obf.avt
    public final cbm p() {
        return this.ai;
    }

    @Override // me.hd.wauxv.obf.avt
    public final void q() {
        this.ae.n("null");
    }

    @Override // me.hd.wauxv.obf.avt
    public final avt r(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        boolean zB = dmz.b(dfxVar);
        ewf ewfVar = this.ag;
        brn brnVar = this.af;
        cxc ackVar = this.ae;
        if (zB) {
            if (!(ackVar instanceof acl)) {
                ackVar = new acl((ek) ackVar.i, this.ak);
            }
            return new dmy(ackVar, brnVar, ewfVar, null);
        }
        if (dfxVar.d() && dfxVar.equals(bry.a)) {
            if (!(ackVar instanceof ack)) {
                ackVar = new ack((ek) ackVar.i, this.ak);
            }
            return new dmy(ackVar, brnVar, ewfVar, null);
        }
        if (this.al != null) {
            this.am = dfxVar.b();
        }
        return this;
    }

    @Override // me.hd.wauxv.obf.avt
    public final void s(double d) {
        boolean z = this.ak;
        cxc cxcVar = this.ae;
        if (z) {
            ad(String.valueOf(d));
        } else {
            ((ek) cxcVar.i).u(String.valueOf(d));
        }
        this.aj.getClass();
        if (Math.abs(d) > Double.MAX_VALUE) {
            throw cnd.ai(Double.valueOf(d), ((ek) cxcVar.i).toString());
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final void t(short s) {
        if (this.ak) {
            ad(String.valueOf((int) s));
        } else {
            this.ae.f(s);
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final void u(byte b) {
        if (this.ak) {
            ad(String.valueOf((int) b));
        } else {
            this.ae.c(b);
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final acn v(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return o(dfxVar);
    }

    @Override // me.hd.wauxv.obf.avt
    public final void w(boolean z) {
        if (this.ak) {
            ad(String.valueOf(z));
        } else {
            ((ek) this.ae.i).u(String.valueOf(z));
        }
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x0043 */
    @Override // me.hd.wauxv.obf.avt
    public final void x(btd btdVar, Object obj) {
        String strU;
        throwIfVar1IsNull(btdVar, "serializer");
        brn brnVar = this.af;
        brt brtVar = brnVar.b;
        brtVar.getClass();
        yy yyVar = brtVar.e;
        boolean z = btdVar instanceof cus;
        if (z) {
            strU = yyVar != yy.a ? bhv.u(brnVar, btdVar.getDescriptor()) : null;
        } else {
            int iOrdinal = yyVar.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    emc emcVarH = btdVar.getDescriptor().h();
                    if (nullSafeIsEqual(emcVarH, dnt.a) || nullSafeIsEqual(emcVarH, dnt.n)) {
                    }
                } else if (iOrdinal != 2) {
                    throw new QueryDidNotReturnUniqueResultRuntimeException();
                }
            }
        }
        if (!z) {
            if (strU != null) {
                String strB = btdVar.getDescriptor().b();
                this.al = strU;
                this.am = strB;
            }
            btdVar.c(this, obj);
            return;
        }
        cus cusVar = (cus) btdVar;
        if (obj != null) {
            bmy.p(cusVar, this, obj);
            throw null;
        }
        throw new IllegalArgumentException(("Value for serializer " + cusVar.getDescriptor()
                + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
    }

    @Override // me.hd.wauxv.obf.avt
    public final void y(float f) {
        boolean z = this.ak;
        cxc cxcVar = this.ae;
        if (z) {
            ad(String.valueOf(f));
        } else {
            ((ek) cxcVar.i).u(String.valueOf(f));
        }
        this.aj.getClass();
        if (Math.abs(f) > Float.MAX_VALUE) {
            throw cnd.ai(Float.valueOf(f), ((ek) cxcVar.i).toString());
        }
    }

    @Override // me.hd.wauxv.obf.avt
    public final void z(char c) {
        ad(String.valueOf(c));
    }
}
