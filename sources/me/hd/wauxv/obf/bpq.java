package me.hd.wauxv.obf;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpq {
    public static final bpq[] a = new bpq[8];
    public int b;
    public int c;
    public int d;
    public Object e;

    public void f(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.d;
        int i4 = i3 * 2;
        int[] iArr = (int[]) this.e;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.e = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.e = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.e;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.d++;
    }

    public void g(RecyclerView recyclerView, boolean z) {
        this.d = 0;
        int[] iArr = (int[]) this.e;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        czg czgVar = recyclerView.x;
        if (recyclerView.w == null || czgVar == null || !czgVar.dw) {
            return;
        }
        if (z) {
            if (!recyclerView.o.s()) {
                czgVar.bx(recyclerView.w.d(), this);
            }
        } else if (!recyclerView.dx()) {
            czgVar.bw(this.b, this.c, recyclerView.bo, this);
        }
        int i = this.d;
        if (i > czgVar.dx) {
            czgVar.dx = i;
            czgVar.dy = z;
            recyclerView.m.u();
        }
    }

    public int h() {
        char cCharAt;
        int i = this.c;
        this.b = i;
        if (i == this.d) {
            return 2;
        }
        char cCharAt2 = ((CharSequence) this.e).charAt(i);
        if (cCharAt2 == '\n') {
            this.c = this.b + 1;
            return 1;
        }
        if (cCharAt2 == '\r') {
            int i2 = this.b;
            if (i2 + 1 >= this.d || ((CharSequence) this.e).charAt(i2 + 1) != '\n') {
                this.c = this.b + 1;
            } else {
                this.c = this.b + 2;
            }
            return 1;
        }
        this.c = this.b + 1;
        while (true) {
            int i3 = this.c;
            if (i3 >= this.d || (cCharAt = ((CharSequence) this.e).charAt(i3)) == '\n' || cCharAt == '\r') {
                return 0;
            }
            this.c++;
        }
    }
}
