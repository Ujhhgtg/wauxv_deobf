package me.hd.wauxv.obf;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvj {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public List k;
    public boolean l;

    public final void m(View view) {
        int iZ;
        int size = this.k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((czx) this.k.get(i2)).d;
            czh czhVar = (czh) view3.getLayoutParams();
            if (view3 != view && !czhVar.c.af() && (iZ = (czhVar.c.z() - this.d) * this.e) >= 0 && iZ < i) {
                view2 = view3;
                if (iZ == 0) {
                    break;
                } else {
                    i = iZ;
                }
            }
        }
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((czh) view2.getLayoutParams()).c.z();
        }
    }

    public final View n(czo czoVar) {
        List list = this.k;
        if (list == null) {
            View view = czoVar.s(this.d, Long.MAX_VALUE).d;
            this.d += this.e;
            return view;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view2 = ((czx) this.k.get(i)).d;
            czh czhVar = (czh) view2.getLayoutParams();
            if (!czhVar.c.af() && this.d == czhVar.c.z()) {
                m(view2);
                return view2;
            }
        }
        return null;
    }
}
