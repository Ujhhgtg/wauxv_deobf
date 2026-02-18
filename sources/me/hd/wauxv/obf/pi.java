package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pi {
    public int h;
    public pg i;
    public int j;
    public int k;
    public final ReentrantLock a = new ReentrantLock();
    public final ArrayList c = new ArrayList();
    public final int b = 1000;
    public int e = 0;
    public int f = 0;
    public pg g = new pg(this);
    public final ArrayList d = new ArrayList(10);

    public final void l(int i, int i2) {
        int i3;
        int[] iArr;
        pg pgVar;
        if (i < 0 || i > this.e) {
            StringBuilder sbR = yg.r(i, "index = ", ", length = ");
            sbR.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbR.toString());
        }
        m(i);
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.d;
            if (i4 >= arrayList.size()) {
                break;
            }
            if (((ph) arrayList.get(i4)).b >= i) {
                arrayList.remove(i4);
                i4--;
            }
            i4++;
        }
        pg pgVar2 = this.i;
        int i5 = this.h;
        while (true) {
            i3 = pgVar2.b;
            iArr = pgVar2.a;
            if (i5 <= i3 || (pgVar = pgVar2.d) == null) {
                break;
            }
            i5 -= i3;
            pgVar2 = pgVar;
        }
        System.arraycopy(iArr, i5, iArr, i5 + 1, i3 - i5);
        iArr[i5] = i2;
        int i6 = pgVar2.b + 1;
        pgVar2.b = i6;
        if (i2 > pgVar2.c) {
            pgVar2.c = i2;
        }
        this.e++;
        if (i6 > this.b) {
            pg pgVar3 = pgVar2.d;
            pi piVar = pgVar2.e;
            ArrayList arrayList2 = piVar.c;
            pg pgVar4 = arrayList2.isEmpty() ? new pg(piVar) : (pg) arrayList2.remove(arrayList2.size() - 1);
            int i7 = (piVar.b * 3) / 4;
            System.arraycopy(iArr, i7, pgVar4.a, 0, pgVar2.b - i7);
            pgVar4.b = pgVar2.b - i7;
            pgVar2.b = i7;
            pgVar2.d = pgVar4;
            pgVar4.d = pgVar3;
        }
        this.f++;
    }

    public final void m(int i) {
        ArrayList arrayList;
        pg pgVar;
        int i2;
        pg pgVar2 = this.g;
        int i3 = 0;
        int i4 = i;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            arrayList = this.d;
            if (i6 >= arrayList.size()) {
                break;
            }
            ph phVar = (ph) arrayList.get(i6);
            int i7 = phVar.b;
            if (i7 < i && (i2 = i - i7) < i4) {
                pgVar2 = phVar.a;
                i5 = i6;
                i4 = i2;
            }
            i6++;
        }
        if (i5 != -1) {
            Collections.swap(arrayList, 0, i5);
        }
        while (true) {
            int i8 = pgVar2.b;
            if (i4 < i8 || (pgVar = pgVar2.d) == null) {
                break;
            }
            i4 -= i8;
            i3++;
            pgVar2 = pgVar;
        }
        if (i3 >= 30) {
            ph phVar2 = new ph();
            phVar2.b = i - i4;
            phVar2.a = pgVar2;
            arrayList.add(phVar2);
        }
        if (arrayList.size() > 8) {
            arrayList.remove(arrayList.size() - 1);
        }
        this.h = i4;
        this.i = pgVar2;
    }

    public final int n(int i) {
        if (i < 0 || i >= this.e) {
            StringBuilder sbR = yg.r(i, "index = ", ", length = ");
            sbR.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbR.toString());
        }
        m(i);
        pg pgVar = this.i;
        return pgVar.a[this.h];
    }

    public final void o(int i, int i2) {
        if (i2 > this.e || i < 0 || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        pg pgVar = this.g;
        pg pgVar2 = null;
        while (true) {
            int i3 = pgVar.b;
            if (i < i3) {
                break;
            }
            i -= i3;
            i2 -= i3;
            pgVar2 = pgVar;
            pgVar = pgVar.d;
        }
        int i4 = i2 - i;
        int i5 = i4;
        while (i5 > 0) {
            if (i != 0 || i5 < pgVar.b) {
                int i6 = pgVar.b;
                int[] iArr = pgVar.a;
                int iMin = Math.min(i6, i5);
                System.arraycopy(iArr, iMin, iArr, 0, pgVar.b - iMin);
                pgVar.b -= iMin;
                pgVar.c = 0;
                for (int i7 = 0; i7 < pgVar.b; i7++) {
                    pgVar.c = Math.max(pgVar.c, iArr[i7]);
                }
                i5 -= iMin;
                pgVar2 = pgVar;
                pgVar = pgVar.d;
                i = 0;
            } else {
                if (pgVar2 != null) {
                    pgVar2.d = pgVar.d;
                    this.c.add(pgVar);
                }
                i5 -= pgVar.b;
                pgVar.b = 0;
                pgVar = pgVar.d;
            }
        }
        this.e -= i4;
    }

    public final void p(int i, int i2) {
        if (i < 0 || i >= this.e) {
            StringBuilder sbR = yg.r(i, "index = ", ", length = ");
            sbR.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbR.toString());
        }
        m(i);
        pg pgVar = this.i;
        int i3 = this.h;
        int[] iArr = pgVar.a;
        int i4 = iArr[i3];
        iArr[i3] = i2;
        int i5 = pgVar.c;
        if (i4 == i5) {
            if (i2 >= i4) {
                pgVar.c = i2;
            } else {
                pgVar.c = 0;
                for (int i6 = 0; i6 < pgVar.b; i6++) {
                    pgVar.c = Math.max(pgVar.c, pgVar.a[i6]);
                }
            }
        } else if (i2 > i5) {
            pgVar.c = i2;
        }
        this.f++;
    }
}
