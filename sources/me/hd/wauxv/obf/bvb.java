package me.hd.wauxv.obf;

import android.util.SparseArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvb extends y {
    public final AtomicInteger t;
    public pi u;
    public pi v;
    public dhs w;

    public bvb(CodeEditor codeEditor, aff affVar) {
        super(codeEditor, affVar);
        this.t = new AtomicInteger(0);
        dhs dhsVar = new dhs(codeEditor.getTabWidth());
        this.w = dhsVar;
        dhsVar.e = codeEditor.bg;
        this.u = new pi();
        pi piVar = new pi();
        this.v = piVar;
        y(this.u, piVar);
    }

    public static int x() {
        Iterator it = Collections.EMPTY_LIST.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        return (int) 0.0f;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        for (int i5 = i; i5 <= i3; i5++) {
            if (i5 != i) {
                this.u.l(i5, z(i5, true));
            } else if (i3 == i) {
                int iN = this.v.n(i5);
                d();
                List list = Collections.EMPTY_LIST;
                this.b.getTextPaint();
                int iX = x();
                this.v.p(i5, iX);
                pi piVar = this.u;
                int i6 = iX - iN;
                piVar.p(i5, i6 + piVar.n(i5) + ((int) this.w.g(this.c.y(i5), i2, i4, this.b.getTextPaint())));
            } else {
                this.u.p(i5, z(i5, false));
            }
        }
    }

    @Override // me.hd.wauxv.obf.afp
    public final void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        if (i < i3) {
            int i5 = i + 1;
            int i6 = i3 + 1;
            this.u.o(i5, i6);
            this.v.o(i5, i6);
        }
        if (i != i3) {
            this.u.p(i, z(i, false));
            return;
        }
        int iN = this.v.n(i);
        d();
        List list = Collections.EMPTY_LIST;
        this.b.getTextPaint();
        int iX = x();
        this.v.p(i, iX);
        pi piVar = this.u;
        piVar.p(i, (iX - iN) + (piVar.n(i) - ((int) this.w.g(sb, 0, i4 - i2, this.b.getTextPaint()))));
    }

    @Override // me.hd.wauxv.obf.btr
    public final int e() {
        return this.c.a.size();
    }

    @Override // me.hd.wauxv.obf.btr
    public final long f(float f, float f2) {
        int iMin = Math.min(this.c.a.size() - 1, Math.max((int) (f2 / this.b.getRowHeight()), 0));
        return KotlinHelpers.al(iMin, this.b.getRenderer().ao(iMin).v(f));
    }

    @Override // me.hd.wauxv.obf.btr
    public final int g() {
        return this.b.getRowHeight() * this.c.a.size();
    }

    @Override // me.hd.wauxv.obf.btr
    public final float[] h(int i, int i2, float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            fArr = new float[2];
        }
        fArr[0] = this.b.dt(i);
        fArr[1] = this.b.getRenderer().ao(i).u(i2);
        return fArr;
    }

    @Override // me.hd.wauxv.obf.btr
    public final ddo i(int i, SparseArray sparseArray) {
        return new bva(this, this.c, i, sparseArray);
    }

    @Override // me.hd.wauxv.obf.btr
    public final long j(int i, int i2) {
        int i3 = i + 1;
        if (i3 >= this.c.a.size()) {
            return KotlinHelpers.al(i, this.c.y(i).b);
        }
        int i4 = this.c.y(i3).b;
        if (i2 > i4) {
            i2 = i4;
        }
        return KotlinHelpers.al(i3, i2);
    }

    @Override // me.hd.wauxv.obf.btr
    public final int k(int i) {
        return 1;
    }

    @Override // me.hd.wauxv.obf.btr
    public final int l(int i) {
        return this.b.getText().x().n(i).b;
    }

    @Override // me.hd.wauxv.obf.btr
    public final void m() {
        this.b = null;
        this.c = null;
        this.u = null;
        this.v = null;
    }

    @Override // me.hd.wauxv.obf.btr
    public final long n(int i, int i2) {
        int i3 = i - 1;
        if (i3 < 0) {
            return KotlinHelpers.al(0, 0);
        }
        int i4 = this.c.y(i3).b;
        if (i2 > i4) {
            i2 = i4;
        }
        return KotlinHelpers.al(i3, i2);
    }

    @Override // me.hd.wauxv.obf.btr
    public final int o(int i) {
        return Math.max(0, Math.min(i, this.c.a.size() - 1));
    }

    @Override // me.hd.wauxv.obf.btr
    public final void p(SyntheticPileOfMess bmuVar) {
        int i;
        int i2;
        int[] iArr = (int[]) bmuVar.obj;
        int size = this.c.a.size() - 1;
        int i3 = 0;
        while (true) {
            if (!(i3 < iArr.length)) {
                return;
            }
            if (i3 < iArr.length) {
                i = i3 + 1;
                i2 = iArr[i3];
                if (i2 > size) {
                }
                this.u.p(i2, z(i2, false));
                i3 = i;
            } else {
                i = i3;
            }
            i2 = size;
            this.u.p(i2, z(i2, false));
            i3 = i;
        }
    }

    @Override // me.hd.wauxv.obf.btr
    public final ddm q(int i) {
        ddm ddmVar = new ddm();
        ddmVar.a = i;
        ddmVar.d = 0;
        ddmVar.b = true;
        ddmVar.c = true;
        ddmVar.e = this.c.y(i).b;
        d();
        ddmVar.f = Collections.EMPTY_LIST;
        return ddmVar;
    }

    @Override // me.hd.wauxv.obf.btr
    public final int s() {
        pi piVar = this.u;
        if (piVar.e == 0) {
            return 214748364;
        }
        int i = piVar.f;
        if (i != piVar.j) {
            piVar.j = i;
        }
        piVar.k = 0;
        for (pg pgVar = piVar.g; pgVar != null; pgVar = pgVar.d) {
            piVar.k = Math.max(piVar.k, pgVar.c);
        }
        return piVar.k;
    }

    public final void y(pi piVar, pi piVar2) {
        if (this.c == null) {
            return;
        }
        csk cskVar = new csk(this.b.bg);
        cskVar.set(this.b.getTextPaint());
        cskVar.d();
        int i = this.t.get();
        buz buzVar = new buz(this, new x(1, new bux(this, i)), piVar, this.w, cskVar, piVar2, i);
        this.b.setLayoutBusy(true);
        y.a.submit(buzVar);
    }

    public final int z(int i, boolean z) {
        afo afoVarY = this.c.y(i);
        d();
        List list = Collections.EMPTY_LIST;
        this.b.getTextPaint();
        int iX = x();
        if (z) {
            this.v.l(i, iX);
        } else {
            this.v.p(i, iX);
        }
        return ((int) this.w.g(afoVarY, 0, afoVarY.b, this.b.getTextPaint())) + iX;
    }
}
