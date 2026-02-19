package me.hd.wauxv.obf;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cyw {
    public final cyx ac = new cyx();
    public boolean ad = false;
    public final int ae = 1;

    public final void af() {
        this.ac.b();
    }

    public final void ag() {
        if (this.ac.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.ad = true;
    }

    public abstract int d();

    public long e(int i) {
        return -1L;
    }

    public abstract void f(SomeView someViewVar, int i);

    public abstract SomeView g(ViewGroup viewGroup, int i);

    public int i(int i) {
        return 0;
    }

    public void j(RecyclerView recyclerView) {
    }

    public void k(SomeView someViewVar, int i, List list) {
        f(someViewVar, i);
    }

    public void l(RecyclerView recyclerView) {
    }

    public void m(SomeView someViewVar) {
    }

    public void n(SomeView someViewVar) {
    }

    public boolean v(SomeView someViewVar) {
        return false;
    }

    public void w(SomeView someViewVar) {
    }
}
