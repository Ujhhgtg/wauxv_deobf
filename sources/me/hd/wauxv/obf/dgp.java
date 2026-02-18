package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgp extends dgv {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ Matrix b;

    public dgp(ArrayList arrayList, Matrix matrix) {
        this.a = arrayList;
        this.b = matrix;
    }

    @Override // me.hd.wauxv.obf.dgv
    public final void c(Matrix matrix, dgk dgkVar, int i, Canvas canvas) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((dgv) it.next()).c(this.b, dgkVar, i, canvas);
        }
    }
}
