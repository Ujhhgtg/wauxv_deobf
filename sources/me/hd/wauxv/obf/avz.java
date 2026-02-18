package me.hd.wauxv.obf;

import android.content.res.TypedArray;
import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avz implements ddo {
    public final int a;
    public int b;
    public final Object c;
    public final Object d;

    public avz(ewa ewaVar, int i) {
        this.d = ewaVar;
        this.b = i;
        this.a = i;
        this.c = new ddm();
    }

    @Override // me.hd.wauxv.obf.ddo
    public boolean hasNext() {
        int i = this.b;
        return i >= 0 && i < ((ewa) this.d).x.size();
    }

    @Override // me.hd.wauxv.obf.ddo
    public ddm next() {
        ddm ddmVar = (ddm) this.c;
        ewa ewaVar = (ewa) this.d;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        evx evxVar = (evx) ewaVar.x.get(this.b);
        ddmVar.a = evxVar.d;
        ddmVar.d = evxVar.a;
        ddmVar.e = evxVar.b;
        List list = evxVar.c;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        ddmVar.f = list;
        int i = this.b;
        ddmVar.b = i <= 0 || ((evx) ewaVar.x.get(i - 1)).d != evxVar.d;
        ddmVar.c = this.b + 1 >= ewaVar.x.size() || ((evx) ewaVar.x.get(this.b + 1)).d != evxVar.d;
        ddmVar.g = evxVar.g(ewaVar.u);
        this.b++;
        return ddmVar;
    }

    @Override // me.hd.wauxv.obf.ddo
    public void reset() {
        this.b = this.a;
    }

    public avz(awa awaVar, jx jxVar) {
        this.c = new SparseArray();
        this.d = awaVar;
        TypedArray typedArray = (TypedArray) jxVar.e;
        this.a = typedArray.getResourceId(28, 0);
        this.b = typedArray.getResourceId(52, 0);
    }
}
