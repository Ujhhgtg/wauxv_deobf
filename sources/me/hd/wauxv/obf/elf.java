package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elf implements Iterator, IEmpty {
    public final /* synthetic */ int a;
    public Iterator b;
    public final Object c;

    public elf(z zVar) {
        this.a = 1;
        this.c = new ArrayList();
        this.b = zVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                return ((dpu) this.c).c.invoke(this.b.next());
            default:
                Object next = this.b.next();
                ArrayList arrayList = (ArrayList) this.c;
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                z zVar = viewGroup != null ? new z(viewGroup, 8) : null;
                if (zVar == null || !zVar.hasNext()) {
                    while (!this.b.hasNext() && !arrayList.isEmpty()) {
                        this.b = (Iterator) aaz.l(arrayList);
                        abf.ar(arrayList);
                    }
                } else {
                    arrayList.add(this.b);
                    this.b = zVar;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public elf(dpu dpuVar) {
        this.a = 0;
        this.c = dpuVar;
        this.b = dpuVar.b.iterator();
    }
}
