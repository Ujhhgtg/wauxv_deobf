package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mi extends ell {
    public int c;
    public ArrayList a = new ArrayList();
    public boolean b = true;
    public boolean d = false;
    public int e = 0;

    public mi() {
        _at(1);
        _ar(new axy(2));
        _ar(new tv());
        _ar(new axy(1));
    }

    public final void _ar(ell ellVar) {
        this.a.add(ellVar);
        ellVar.ao = this;
        long j = this.ai;
        if (j >= 0) {
            ellVar.r(j);
        }
        if ((this.e & 1) != 0) {
            ellVar.t(this.aj);
        }
        if ((this.e & 2) != 0) {
            ellVar.v();
        }
        if ((this.e & 4) != 0) {
            ellVar.u(this.bb);
        }
        if ((this.e & 8) != 0) {
            ellVar.s(null);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    /*
     * JADX INFO: renamed from: _as, reason: merged with bridge method
     * [inline-methods]
     */
    public final void t(TimeInterpolator timeInterpolator) {
        this.e |= 1;
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ell) this.a.get(i)).t(timeInterpolator);
            }
        }
        this.aj = timeInterpolator;
    }

    public final void _at(int i) {
        if (i == 0) {
            this.b = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException(concatVar2Var1(i, "Invalid parameter for TransitionSet ordering: "));
            }
            this.b = false;
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void cancel() {
        super.cancel();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).cancel();
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void f(elt eltVar) {
        View view = eltVar.b;
        if (bp(view)) {
            for (ell ellVar : this.a) {
                if (ellVar.bp(view)) {
                    ellVar.f(eltVar);
                    eltVar.c.add(ellVar);
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void g(elt eltVar) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).g(eltVar);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void h(elt eltVar) {
        View view = eltVar.b;
        if (bp(view)) {
            for (ell ellVar : this.a) {
                if (ellVar.bp(view)) {
                    ellVar.h(eltVar);
                    eltVar.c.add(ellVar);
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.ell
    /* JADX INFO: renamed from: i */
    public final ell clone() {
        mi miVar = (mi) super.clone();
        miVar.a = new ArrayList();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ell ellVarClone = ((ell) this.a.get(i)).clone();
            miVar.a.add(ellVarClone);
            ellVarClone.ao = miVar;
        }
        return miVar;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void j(ViewGroup viewGroup, chm chmVar, chm chmVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.ah;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ell ellVar = (ell) this.a.get(i);
            if (j > 0 && (this.b || i == 0)) {
                long j2 = ellVar.ah;
                if (j2 > 0) {
                    ellVar.w(j2 + j);
                } else {
                    ellVar.w(j);
                }
            }
            ellVar.j(viewGroup, chmVar, chmVar2, arrayList, arrayList2);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final boolean k() {
        for (int i = 0; i < this.a.size(); i++) {
            if (((ell) this.a.get(i)).k()) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void l(View view) {
        super.l(view);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).l(view);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void m() {
        this.bc = 0L;
        int i = 0;
        elq elqVar = new elq(this, i);
        while (i < this.a.size()) {
            ell ellVar = (ell) this.a.get(i);
            ellVar.bh(elqVar);
            ellVar.m();
            long j = ellVar.bc;
            if (this.b) {
                this.bc = Math.max(this.bc, j);
            } else {
                long j2 = this.bc;
                ellVar.bd = j2;
                this.bc = j2 + j;
            }
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final ell n(elk elkVar) {
        super.n(elkVar);
        return this;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void o(View view) {
        super.o(view);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).o(view);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void p() {
        if (this.a.isEmpty()) {
            br();
            bl();
            return;
        }
        elq elqVar = new elq();
        elqVar.b = this;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ell) it.next()).bh(elqVar);
        }
        this.c = this.a.size();
        if (this.b) {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((ell) it2.next()).p();
            }
            return;
        }
        for (int i = 1; i < this.a.size(); i++) {
            ((ell) this.a.get(i - 1)).bh(new elq((ell) this.a.get(i), 2));
        }
        ell ellVar = (ell) this.a.get(0);
        if (ellVar != null) {
            ellVar.p();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:55:0x00c9 */
    /* JADX WARN: Found duplicated region for block: B:63:0x00d9 */
    /* JADX WARN: Found duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // me.hd.wauxv.obf.ell
    public final void q(long j, long j2) {
        long j3;
        long j4 = this.bc;
        long j5 = 0;
        if (this.ao != null) {
            if (j < 0 && j2 < 0) {
                return;
            }
            if (j > j4 && j2 > j4) {
                return;
            }
        }
        boolean z = j < j2;
        if ((j >= 0 && j2 < 0) || (j <= j4 && j2 > j4)) {
            this.ax = false;
            bq(this, df.a, z);
        }
        if (!this.b) {
            int size = 1;
            while (true) {
                if (size >= this.a.size()) {
                    size = this.a.size();
                    break;
                } else if (((ell) this.a.get(size)).bd > j2) {
                    break;
                } else {
                    size++;
                }
            }
            int i = size - 1;
            if (j >= j2) {
                while (true) {
                    if (i < this.a.size()) {
                        ell ellVar = (ell) this.a.get(i);
                        long j6 = ellVar.bd;
                        j3 = j5;
                        long j7 = j - j6;
                        if (j7 < j3) {
                            break;
                        }
                        ellVar.q(j7, j2 - j6);
                        i++;
                        j5 = j3;
                    }
                }
            } else {
                j3 = 0;
                while (i >= 0) {
                    ell ellVar2 = (ell) this.a.get(i);
                    long j8 = ellVar2.bd;
                    long j9 = j - j8;
                    ellVar2.q(j9, j2 - j8);
                    if (j9 >= 0) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            if (this.ao != null) {
                if ((j > j4 || j2 > j4) && (j >= 0 || j2 < j3)) {
                    return;
                }
                if (j > j4) {
                    this.ax = true;
                }
                bq(this, df.b, z);
            }
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            ((ell) this.a.get(i2)).q(j, j2);
        }
        j3 = j5;
        if (this.ao != null) {
            if (j > j4) {
                return;
            } else {
                return;
            }
            if (j > j4) {
                this.ax = true;
            }
            bq(this, df.b, z);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void s(dqc dqcVar) {
        this.e |= 8;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).s(dqcVar);
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void u(dop dopVar) {
        super.u(dopVar);
        this.e |= 4;
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                ((ell) this.a.get(i)).u(dopVar);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void v() {
        this.e |= 2;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).v();
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void w(long j) {
        this.ah = j;
    }

    @Override // me.hd.wauxv.obf.ell
    public final String x(String str) {
        String strX = super.x(str);
        for (int i = 0; i < this.a.size(); i++) {
            StringBuilder sbR = concat(strX, "\n");
            sbR.append(((ell) this.a.get(i)).x(str + "  "));
            strX = sbR.toString();
        }
        return strX;
    }

    @Override // me.hd.wauxv.obf.ell
    /*
     * JADX INFO: renamed from: z, reason: merged with bridge method
     * [inline-methods]
     */
    public final void r(long j) {
        ArrayList arrayList;
        this.ai = j;
        if (j < 0 || (arrayList = this.a) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ell) this.a.get(i)).r(j);
        }
    }
}
