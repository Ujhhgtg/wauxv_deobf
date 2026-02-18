package me.hd.wauxv.obf;

import android.util.SparseArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewa extends y {
    public static final ArrayList t;
    public final int u;
    public final float v;
    public final boolean w;
    public List x;

    static {
        ArrayList arrayList = new ArrayList();
        t = arrayList;
        arrayList.add(ajn.aa(0, cmz.af(0, true, true, false)));
    }

    public ewa(CodeEditor codeEditor, aff affVar, boolean z, ewa ewaVar, boolean z2) {
        super(codeEditor, affVar);
        this.w = z;
        List arrayList = ewaVar != null ? ewaVar.x : new ArrayList();
        this.x = arrayList;
        if (z2) {
            arrayList.clear();
        }
        float fBg = (codeEditor.getNonPrintablePaintingFlags() & 128) != 0 ? codeEditor.getRenderer().bg() : 0.0f;
        this.v = fBg;
        this.u = (codeEditor.getWidth() - ((int) (codeEditor.getTextPaint().measureText(com.umeng.analytics.pro.bt.at) + codeEditor.eb()))) - (((int) fBg) * 2);
        int iMin = Math.min(8, (int) Math.ceil(this.c.a.size() / 3000.0f));
        int size = this.c.a.size() / iMin;
        x xVar = new x(iMin, new qp(this, 12));
        this.b.setLayoutBusy(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iMin) {
                return;
            }
            i = i2 + 1;
            y.a.submit(new evy(this, xVar, i2, size * i2, (i == iMin ? this.c.a.size() : size * i) - 1));
        }
    }

    public final int aa(int i) {
        int size = this.x.size();
        int iMax = 0;
        while (iMax <= size) {
            int i2 = (iMax + size) / 2;
            if (i2 >= 0 && i2 < this.x.size()) {
                int i3 = ((evx) this.x.get(i2)).d;
                if (i3 >= i) {
                    if (i3 <= i) {
                        iMax = i2;
                        break;
                    }
                    size = i2 - 1;
                } else {
                    iMax = i2 + 1;
                }
            } else {
                iMax = Math.max(0, Math.min(this.x.size() - 1, i2));
                break;
            }
        }
        while (iMax > 0 && ((evx) this.x.get(iMax)).a > 0) {
            iMax--;
        }
        return iMax;
    }

    public final int ab(int i, int i2) {
        int i3;
        int iAa = aa(i);
        while (((evx) this.x.get(iAa)).b <= i2 && (i3 = iAa + 1) < this.x.size() && ((evx) this.x.get(i3)).d == i) {
            iAa = i3;
        }
        return iAa;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i3 - i;
        if (i5 != 0) {
            for (int iAa = aa(i + 1); iAa < this.x.size(); iAa++) {
                ((evx) this.x.get(iAa)).d += i5;
            }
        }
        z(i, i3);
    }

    @Override // me.hd.wauxv.obf.afp
    public final void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        int i6 = i3 - i;
        if (i6 != 0) {
            int iAa = aa(i);
            while (iAa < this.x.size() && (i5 = ((evx) this.x.get(iAa)).d) >= i && i5 <= i3) {
                this.x.remove(iAa);
            }
            for (int iAa2 = aa(i3 + 1); iAa2 < this.x.size(); iAa2++) {
                evx evxVar = (evx) this.x.get(iAa2);
                int i7 = evxVar.d;
                if (i7 >= i3) {
                    evxVar.d = i7 - i6;
                }
            }
        }
        z(i, i);
    }

    @Override // me.hd.wauxv.obf.btr
    public final int e() {
        return this.x.isEmpty() ? this.c.a.size() : this.x.size();
    }

    @Override // me.hd.wauxv.obf.btr
    public final long f(float f, float f2) {
        if (this.x.isEmpty()) {
            int iMin = Math.min(this.c.a.size() - 1, Math.max((int) (f2 / this.b.getRowHeight()), 0));
            return KotlinHelpers.al(iMin, this.b.getRenderer().ao(iMin).v(f));
        }
        int iMax = Math.max(0, Math.min((int) (f2 / this.b.getRowHeight()), this.x.size() - 1));
        evx evxVar = (evx) this.x.get(iMax);
        if (evxVar.a != 0) {
            f -= this.v;
        }
        return KotlinHelpers.al(evxVar.d, this.b.getRenderer().ao(iMax).v(f - evxVar.g(this.u)));
    }

    @Override // me.hd.wauxv.obf.btr
    public final int g() {
        int size;
        int rowHeight;
        if (this.x.isEmpty()) {
            size = this.b.getRowHeight();
            rowHeight = this.c.a.size();
        } else {
            size = this.x.size();
            rowHeight = this.b.getRowHeight();
        }
        return rowHeight * size;
    }

    @Override // me.hd.wauxv.obf.btr
    public final float[] h(int i, int i2, float[] fArr) {
        int i3;
        if (fArr == null || fArr.length < 2) {
            fArr = new float[2];
        }
        if (this.x.isEmpty()) {
            fArr[0] = this.b.dt(i);
            fArr[1] = this.b.getRenderer().ao(i).u(i2);
            return fArr;
        }
        int iAa = aa(i);
        if (iAa >= this.x.size()) {
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            return fArr;
        }
        evx evxVar = (evx) this.x.get(iAa);
        if (evxVar.d != i) {
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            return fArr;
        }
        while (evxVar.a < i2 && (i3 = iAa + 1) < this.x.size()) {
            evxVar = (evx) this.x.get(i3);
            if (evxVar.d != i || evxVar.a > i2) {
                evxVar = (evx) this.x.get(iAa);
                break;
            }
            iAa = i3;
        }
        fArr[0] = this.b.dt(iAa);
        float fU = this.b.getRenderer().ao(iAa).u(i2);
        fArr[1] = fU;
        if (evxVar.a != 0) {
            fArr[1] = fU + this.v;
        }
        fArr[1] = evxVar.g(this.u) + fArr[1];
        return fArr;
    }

    @Override // me.hd.wauxv.obf.btr
    public final ddo i(int i, SparseArray sparseArray) {
        return this.x.isEmpty() ? new bva(this, this.c, i, sparseArray) : new avz(this, i);
    }

    @Override // me.hd.wauxv.obf.btr
    public final long j(int i, int i2) {
        if (this.x.isEmpty()) {
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
        int iAb = ab(i, i2);
        int i5 = iAb + 1;
        if (i5 >= this.x.size()) {
            return KotlinHelpers.al(i, this.c.y(i).b);
        }
        int i6 = i2 - ((evx) this.x.get(iAb)).a;
        evx evxVar = (evx) this.x.get(i5);
        int i7 = evxVar.b;
        int i8 = evxVar.a;
        return KotlinHelpers.al(evxVar.d, i8 + Math.min(i6, i7 - i8));
    }

    @Override // me.hd.wauxv.obf.btr
    public final int k(int i) {
        if (this.x.isEmpty()) {
            return 1;
        }
        int i2 = 0;
        for (int iAa = aa(i); iAa < this.x.size() && ((evx) this.x.get(iAa)).d == i; iAa++) {
            i2++;
        }
        return i2;
    }

    @Override // me.hd.wauxv.obf.btr
    public final int l(int i) {
        int i2;
        ud udVarN = this.b.getText().x().n(i);
        int i3 = udVarN.b;
        if (this.x.isEmpty()) {
            return i3;
        }
        int i4 = udVarN.c;
        int iAa = aa(i3);
        if (iAa >= this.x.size()) {
            return 0;
        }
        evx evxVar = (evx) this.x.get(iAa);
        if (evxVar.d != i3) {
            return 0;
        }
        while (evxVar.a < i4 && (i2 = iAa + 1) < this.x.size()) {
            evx evxVar2 = (evx) this.x.get(i2);
            if (evxVar2.d != i3 || evxVar2.a > i4) {
                break;
            }
            iAa = i2;
            evxVar = evxVar2;
        }
        return iAa;
    }

    @Override // me.hd.wauxv.obf.btr
    public final void m() {
        this.b = null;
        this.c = null;
        this.x = null;
    }

    @Override // me.hd.wauxv.obf.btr
    public final long n(int i, int i2) {
        long jAl = KotlinHelpers.al(0, 0);
        if (this.x.isEmpty()) {
            int i3 = i - 1;
            if (i3 < 0) {
                return jAl;
            }
            int i4 = this.c.y(i3).b;
            if (i2 > i4) {
                i2 = i4;
            }
            return KotlinHelpers.al(i3, i2);
        }
        int iAb = ab(i, i2);
        if (iAb <= 0) {
            return jAl;
        }
        int i5 = i2 - ((evx) this.x.get(iAb)).a;
        evx evxVar = (evx) this.x.get(iAb - 1);
        int i6 = evxVar.b;
        int i7 = evxVar.a;
        return KotlinHelpers.al(evxVar.d, i7 + Math.min(i5, i6 - i7));
    }

    @Override // me.hd.wauxv.obf.btr
    public final int o(int i) {
        if (this.x.isEmpty()) {
            return Math.max(0, Math.min(i, this.c.a.size() - 1));
        }
        if (i < this.x.size()) {
            return ((evx) this.x.get(i)).d;
        }
        return ((evx) this.x.get(r2.size() - 1)).d;
    }

    @Override // me.hd.wauxv.obf.btr
    public final void p(bmu bmuVar) {
        int i;
        int i2;
        int[] iArr = (int[]) bmuVar.h;
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
                z(i2, i2);
                i3 = i;
            } else {
                i = i3;
            }
            i2 = size;
            z(i2, i2);
            i3 = i;
        }
    }

    @Override // me.hd.wauxv.obf.btr
    public final ddm q(int i) {
        if (this.x.isEmpty()) {
            ddm ddmVar = new ddm();
            ddmVar.d = 0;
            ddmVar.e = this.c.y(i).b;
            ddmVar.b = true;
            ddmVar.c = true;
            ddmVar.a = i;
            d();
            ddmVar.f = Collections.EMPTY_LIST;
            return ddmVar;
        }
        evx evxVar = (evx) this.x.get(i);
        boolean z = i <= 0 || ((evx) this.x.get(i + (-1))).d != evxVar.d;
        int i2 = i + 1;
        boolean z2 = i2 >= this.x.size() || ((evx) this.x.get(i2)).d != evxVar.d;
        evx evxVar2 = (evx) this.x.get(i);
        float f = this.u;
        evxVar2.getClass();
        ddm ddmVar2 = new ddm();
        ddmVar2.b = z;
        ddmVar2.c = z2;
        ddmVar2.d = evxVar2.a;
        ddmVar2.e = evxVar2.b;
        ddmVar2.a = evxVar2.d;
        List list = evxVar2.c;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        ddmVar2.f = list;
        ddmVar2.g = evxVar2.g(f);
        return ddmVar2;
    }

    @Override // me.hd.wauxv.obf.btr
    public final int s() {
        return 0;
    }

    public final ArrayList y(int i, afo afoVar, csk cskVar) {
        if (cskVar == null) {
            cskVar = new csk(this.b.bg);
            cskVar.set(this.b.getTextPaint());
        }
        drd drdVar = new drd();
        anu anuVarZ = this.c.z(i);
        int i2 = afoVar.b;
        d();
        drdVar.ac(afoVar, 0, i2, t, Collections.EMPTY_LIST, anuVarZ, cskVar, null, this.b.getRenderer().ap());
        ArrayList<drc> arrayList = new ArrayList();
        dqw dqwVar = new dqw(drdVar, arrayList, this.u, this.w ? new but(drdVar.e) : arj.q);
        drdVar.aa(dqwVar, false);
        if (arrayList.isEmpty()) {
            drc drcVar = dqwVar.a;
            if (drcVar.a) {
                drcVar.a = false;
                drcVar.b = drdVar.g;
                drcVar.c = drdVar.h;
            }
        }
        if (!dqwVar.a.a) {
            dqwVar.h();
        }
        ArrayList arrayList2 = new ArrayList();
        for (drc drcVar2 : arrayList) {
            arrayList2.add(new evx(i, drcVar2.b, drcVar2.c, null, drcVar2.d, false));
        }
        return arrayList2;
    }

    public final void z(int i, int i2) {
        int i3;
        int i4 = 0;
        while (i4 < this.x.size() && ((evx) this.x.get(i4)).d < i) {
            i4++;
        }
        while (i4 < this.x.size() && (i3 = ((evx) this.x.get(i4)).d) >= i && i3 <= i2) {
            this.x.remove(i4);
        }
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            arrayList.addAll(y(i, this.c.y(i), null));
            i++;
        }
        this.x.addAll(i4, arrayList);
    }
}
