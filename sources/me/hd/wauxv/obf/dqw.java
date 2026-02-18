package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqw implements drb {
    public drc a = new drc();
    public float b = 0.0f;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ int d;
    public final /* synthetic */ evw f;
    public final /* synthetic */ drd g;

    public dqw(drd drdVar, ArrayList arrayList, int i, evw evwVar) {
        this.g = drdVar;
        this.c = arrayList;
        this.d = i;
        this.f = evwVar;
    }

    @Override // me.hd.wauxv.obf.drb
    public final boolean e(ArrayList arrayList, boolean z, cjn cjnVar) {
        int i;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ddn ddnVar = (ddn) it.next();
            ddnVar.getClass();
            float[] fArrB = dqd.b(ddnVar.b - ddnVar.a);
            int i2 = ddnVar.a;
            int i3 = ddnVar.b;
            boolean z2 = ddnVar.c;
            drd drdVar = this.g;
            char[] cArr = drdVar.e.a;
            float f = drdVar.k.a * drdVar.l.a;
            int i4 = i2;
            int i5 = i4;
            float fC = 0.0f;
            while (i4 <= i3) {
                if (i4 == i3 || cArr[i4] == '\t') {
                    if (i4 > i5) {
                        int i6 = i4;
                        i = i6;
                        fC += drdVar.l.c(cArr, i5, i6 - i5, i2, i3 - i2, z2, fArrB, i5 - i2);
                    } else {
                        i = i4;
                    }
                    if (i < i3) {
                        fC += f;
                        fArrB[i - i2] = f;
                    }
                    i5 = i + 1;
                } else {
                    i = i4;
                }
                i4 = i + 1;
            }
            float f2 = this.b;
            float f3 = f2 + fC;
            float f4 = this.d;
            if (f3 < f4) {
                drc drcVar = this.a;
                boolean z3 = drcVar.a;
                if (z3) {
                    int i7 = ddnVar.a;
                    int i8 = ddnVar.b;
                    drcVar.a = false;
                    drcVar.b = i7;
                    drcVar.c = i8;
                } else {
                    int i9 = ddnVar.b;
                    if (z3) {
                        throw new IllegalStateException();
                    }
                    drcVar.c = i9;
                }
                this.b = f2 + fC;
                dqd.c(fArrB);
            } else {
                int i10 = ddnVar.b - ddnVar.a;
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (int) (f4 - this.b);
                    float f5 = 0.0f;
                    int i13 = i11;
                    while (i13 < i10) {
                        float f6 = fArrB[i13];
                        if (f6 != 0.0f) {
                            f5 += f6;
                            if (f5 > i12) {
                                break;
                            }
                        }
                        i13++;
                    }
                    if (i13 == i11) {
                        if (this.a.a) {
                            i13++;
                        } else {
                            h();
                        }
                    }
                    int i14 = ddnVar.a;
                    int iAm = this.f.am(i14 + i11, i14 + i13) - ddnVar.a;
                    float f7 = 0.0f;
                    for (int i15 = i11; i15 < iAm; i15++) {
                        f7 += fArrB[i15];
                    }
                    drc drcVar2 = this.a;
                    boolean z4 = drcVar2.a;
                    if (z4) {
                        int i16 = ddnVar.a;
                        drcVar2.a = false;
                        drcVar2.b = i11 + i16;
                        drcVar2.c = i16 + iAm;
                    } else {
                        int i17 = ddnVar.a + iAm;
                        if (z4) {
                            throw new IllegalStateException();
                        }
                        drcVar2.c = i17;
                    }
                    this.b += f7;
                    if (i13 != iAm) {
                        h();
                    }
                    i11 = iAm;
                }
                dqd.c(fArrB);
            }
        }
        return true;
    }

    public final void h() {
        drc drcVar = this.a;
        drcVar.d = this.b;
        this.c.add(drcVar);
        this.b = 0.0f;
        this.a = new drc();
    }
}
