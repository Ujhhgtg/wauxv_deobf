package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgw {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();

    public dgw() {
        l(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void i(float f) {
        float f2 = this.e;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.c;
        float f5 = this.d;
        dgs dgsVar = new dgs(f4, f5, f4, f5);
        dgsVar.f = this.e;
        dgsVar.g = f3;
        this.h.add(new dgq(dgsVar));
        this.e = f;
    }

    public final void j(Matrix matrix, Path path) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((dgu) arrayList.get(i)).h(matrix, path);
        }
    }

    public final void k(float f, float f2) {
        dgt dgtVar = new dgt();
        dgtVar.a = f;
        dgtVar.b = f2;
        this.g.add(dgtVar);
        dgr dgrVar = new dgr(dgtVar, this.c, this.d);
        float fE = dgrVar.e() + 270.0f;
        float fE2 = dgrVar.e() + 270.0f;
        i(fE);
        this.h.add(dgrVar);
        this.e = fE2;
        this.c = f;
        this.d = f2;
    }

    public final void l(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = (f3 + f4) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
