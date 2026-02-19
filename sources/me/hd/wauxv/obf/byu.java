package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class byu extends cyw {
    public final bur a;
    public final beg b;
    public final byc c;
    public final byc h;
    public final byc o;
    public bfa p;
    public final erp q;
    public boolean r;
    public boolean s;
    public final ArrayList t;

    public byu(hb hbVar, ArrayList arrayList) {
        beg begVar = ((bdm) hbVar.c.v).g;
        bur burVar = hbVar.q;
        this.c = new byc();
        this.h = new byc();
        this.o = new byc();
        erp erpVar = new erp(26, false);
        erpVar.v = new CopyOnWriteArrayList();
        this.q = erpVar;
        this.r = false;
        this.s = false;
        this.b = begVar;
        this.a = burVar;
        ag();
        this.t = arrayList;
    }

    public static void u(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public final void aa(bff bffVar) {
        SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) this.c.f(bffVar.h);
        if (someFragmentManagerVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayout = (FrameLayout) bffVar.d;
        View view = someFragmentManagerVar.bz;
        if (!someFragmentManagerVar.cv() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        boolean zCv = someFragmentManagerVar.cv();
        beg begVar = this.b;
        if (zCv && view == null) {
            DefaultConfig ioVar = new DefaultConfig(this, someFragmentManagerVar, frameLayout);
            DefaultConfig ioVar2 = begVar.o;
            ioVar2.getClass();
            ((CopyOnWriteArrayList) ioVar2.d).add(new bdt(ioVar));
            return;
        }
        if (someFragmentManagerVar.cv() && view.getParent() != null) {
            if (view.getParent() != frameLayout) {
                u(view, frameLayout);
                return;
            }
            return;
        }
        if (someFragmentManagerVar.cv()) {
            u(view, frameLayout);
            return;
        }
        if (begVar.ci()) {
            if (begVar.aj) {
                return;
            }
            this.a.j(new akz(this, bffVar));
            return;
        }
        DefaultConfig ioVar3 = new DefaultConfig(this, someFragmentManagerVar, frameLayout);
        DefaultConfig ioVar4 = begVar.o;
        ioVar4.getClass();
        ((CopyOnWriteArrayList) ioVar4.d).add(new bdt(ioVar3));
        erp erpVar = this.q;
        erpVar.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((CopyOnWriteArrayList) erpVar.v).iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        try {
            if (someFragmentManagerVar.bw) {
                someFragmentManagerVar.bw = false;
            }
            mu muVar = new mu(begVar);
            muVar.ac(0, someFragmentManagerVar, "f" + bffVar.h, 1);
            muVar.af(someFragmentManagerVar, buh.d);
            muVar.ab();
            this.p.h(false);
        } finally {
            erp.w(arrayList);
        }
    }

    public final void ab(long j) {
        ViewParent parent;
        byc bycVar = this.c;
        SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) bycVar.f(j);
        if (someFragmentManagerVar == null) {
            return;
        }
        View view = someFragmentManagerVar.bz;
        if (view != null && (parent = view.getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        boolean zX = x(j);
        byc bycVar2 = this.h;
        if (!zX) {
            bycVar2.j(j);
        }
        if (!someFragmentManagerVar.cv()) {
            bycVar.j(j);
            return;
        }
        beg begVar = this.b;
        if (begVar.ci()) {
            this.s = true;
            return;
        }
        boolean zCv = someFragmentManagerVar.cv();
        erp erpVar = this.q;
        if (zCv && x(j)) {
            erpVar.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((CopyOnWriteArrayList) erpVar.v).iterator();
            if (it.hasNext()) {
                throw yg.d(it);
            }
            FragmentManager fragmentManagerVar = (FragmentManager) ((HashMap) begVar.c.d).get(someFragmentManagerVar.aw);
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                if (someFragmentManagerVar2.equals(someFragmentManagerVar)) {
                    bdi bdiVar = someFragmentManagerVar2.as > -1 ? new bdi(fragmentManagerVar.t()) : null;
                    erp.w(arrayList);
                    bycVar2.i(bdiVar, j);
                }
            }
            begVar.cy(new IllegalStateException(yg.l("Fragment ", someFragmentManagerVar, " is not currently in the FragmentManager")));
            throw null;
        }
        erpVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = ((CopyOnWriteArrayList) erpVar.v).iterator();
        if (it2.hasNext()) {
            throw yg.d(it2);
        }
        try {
            mu muVar = new mu(begVar);
            muVar.ae(someFragmentManagerVar);
            muVar.ab();
            bycVar.j(j);
        } finally {
            erp.w(arrayList2);
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        return this.t.size();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final long e(int i) {
        return i;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(SomeView someViewVar, int i) {
        Bundle bundle;
        bff bffVar = (bff) someViewVar;
        long j = bffVar.h;
        FrameLayout frameLayout = (FrameLayout) bffVar.d;
        int id = frameLayout.getId();
        Long lZ = z(id);
        byc bycVar = this.o;
        if (lZ != null && lZ.longValue() != j) {
            ab(lZ.longValue());
            bycVar.j(lZ.longValue());
        }
        bycVar.i(Integer.valueOf(id), j);
        long j2 = i;
        byc bycVar2 = this.c;
        if (bycVar2.g(j2) < 0) {
            SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) this.t.get(i);
            bdi bdiVar = (bdi) this.h.f(j2);
            if (someFragmentManagerVar.bm != null) {
                throw new IllegalStateException("Fragment already added");
            }
            if (bdiVar == null || (bundle = bdiVar.a) == null) {
                bundle = null;
            }
            someFragmentManagerVar.at = bundle;
            bycVar2.i(someFragmentManagerVar, j2);
        }
        if (frameLayout.isAttachedToWindow()) {
            aa(bffVar);
        }
        y();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final SomeView g(ViewGroup viewGroup, int i) {
        int i2 = bff.a;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new bff(frameLayout);
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void j(RecyclerView recyclerView) {
        if (this.p != null) {
            throw new IllegalArgumentException();
        }
        bfa bfaVar = new bfa(this);
        this.p = bfaVar;
        ViewPager2 viewPager2G = bfa.g(recyclerView);
        bfaVar.d = viewPager2G;
        aco acoVar = new aco(bfaVar);
        bfaVar.a = acoVar;
        ((ArrayList) viewPager2G.c.b).add(acoVar);
        bez bezVar = new bez(bfaVar, 0);
        bfaVar.b = bezVar;
        this.ac.registerObserver(bezVar);
        cyo cyoVar = new cyo(bfaVar, 6);
        bfaVar.c = cyoVar;
        this.a.j(cyoVar);
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void l(RecyclerView recyclerView) {
        bfa bfaVar = this.p;
        bfaVar.getClass();
        ViewPager2 viewPager2G = bfa.g(recyclerView);
        ((ArrayList) viewPager2G.c.b).remove(bfaVar.a);
        byu byuVar = bfaVar.f;
        byuVar.ac.unregisterObserver(bfaVar.b);
        byuVar.a.o(bfaVar.c);
        bfaVar.d = null;
        this.p = null;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void m(SomeView someViewVar) {
        aa((bff) someViewVar);
        y();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final /* bridge */ /* synthetic */ boolean v(SomeView someViewVar) {
        return true;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void w(SomeView someViewVar) {
        Long lZ = z(((FrameLayout) ((bff) someViewVar).d).getId());
        if (lZ != null) {
            ab(lZ.longValue());
            this.o.j(lZ.longValue());
        }
    }

    public final boolean x(long j) {
        return j >= 0 && j < ((long) this.t.size());
    }

    public final void y() {
        byc bycVar;
        byc bycVar2;
        SomeFragmentManager someFragmentManagerVar;
        View view;
        if (!this.s || this.b.ci()) {
            return;
        }
        kz kzVar = new kz(0);
        int i = 0;
        while (true) {
            bycVar = this.c;
            int iK = bycVar.k();
            bycVar2 = this.o;
            if (i >= iK) {
                break;
            }
            long jH = bycVar.h(i);
            if (!x(jH)) {
                kzVar.add(Long.valueOf(jH));
                bycVar2.j(jH);
            }
            i++;
        }
        if (!this.r) {
            this.s = false;
            for (int i2 = 0; i2 < bycVar.k(); i2++) {
                long jH2 = bycVar.h(i2);
                if (bycVar2.g(jH2) < 0 && ((someFragmentManagerVar = (SomeFragmentManager) bycVar.f(jH2)) == null || (view = someFragmentManagerVar.bz) == null || view.getParent() == null)) {
                    kzVar.add(Long.valueOf(jH2));
                }
            }
        }
        kq kqVar = new kq(kzVar);
        while (kqVar.hasNext()) {
            ab(((Long) kqVar.next()).longValue());
        }
    }

    public final Long z(int i) {
        Long lValueOf = null;
        int i2 = 0;
        while (true) {
            byc bycVar = this.o;
            if (i2 >= bycVar.k()) {
                return lValueOf;
            }
            if (((Integer) bycVar.l(i2)).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(bycVar.h(i2));
            }
            i2++;
        }
    }
}
