package me.hd.wauxv.obf;

import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfa {
    public aco a;
    public bez b;
    public cyo c;
    public ViewPager2 d;
    public long e = -1;
    public final /* synthetic */ byu f;

    public bfa(byu byuVar) {
        this.f = byuVar;
    }

    public static ViewPager2 g(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    public final void h(boolean z) {
        int currentItem;
        SomeFragmentManager someFragmentManagerVar;
        byu byuVar = this.f;
        ArrayList arrayList = byuVar.t;
        erp erpVar = byuVar.q;
        byc bycVar = byuVar.c;
        beg begVar = byuVar.b;
        if (begVar.ci() || this.d.getScrollState() != 0 || bycVar.k() == 0 || arrayList.size() == 0 || (currentItem = this.d.getCurrentItem()) >= arrayList.size()) {
            return;
        }
        long j = currentItem;
        if ((j != this.e || z) && (someFragmentManagerVar = (SomeFragmentManager) bycVar.f(j)) != null && someFragmentManagerVar.cv()) {
            this.e = j;
            begVar.getClass();
            mu muVar = new mu(begVar);
            ArrayList<List> arrayList2 = new ArrayList();
            SomeFragmentManager someFragmentManagerVar2 = null;
            for (int i = 0; i < bycVar.k(); i++) {
                long jH = bycVar.h(i);
                SomeFragmentManager someFragmentManagerVar3 = (SomeFragmentManager) bycVar.l(i);
                if (someFragmentManagerVar3.cv()) {
                    if (jH != this.e) {
                        muVar.af(someFragmentManagerVar3, buh.d);
                        erpVar.getClass();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = ((CopyOnWriteArrayList) erpVar.v).iterator();
                        if (it.hasNext()) {
                            throw yg.d(it);
                        }
                        arrayList2.add(arrayList3);
                    } else {
                        someFragmentManagerVar2 = someFragmentManagerVar3;
                    }
                    boolean z2 = jH == this.e;
                    if (someFragmentManagerVar3.bw != z2) {
                        someFragmentManagerVar3.bw = z2;
                    }
                }
            }
            if (someFragmentManagerVar2 != null) {
                muVar.af(someFragmentManagerVar2, buh.e);
                erpVar.getClass();
                ArrayList arrayList4 = new ArrayList();
                Iterator it2 = ((CopyOnWriteArrayList) erpVar.v).iterator();
                if (it2.hasNext()) {
                    throw yg.d(it2);
                }
                arrayList2.add(arrayList4);
            }
            if (muVar.a.isEmpty()) {
                return;
            }
            muVar.ab();
            Collections.reverse(arrayList2);
            for (List list : arrayList2) {
                erpVar.getClass();
                erp.w(list);
            }
        }
    }
}
