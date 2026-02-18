package me.hd.wauxv.obf;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class csj extends czj {
    public RecyclerView a;
    public final dii b = new dii(this);
    public crz c;
    public crz d;

    public static int e(View view, atb atbVar) {
        return ((atbVar.f(view) / 2) + atbVar.h(view)) - ((atbVar.o() / 2) + atbVar.n());
    }

    public static View f(czg czgVar, atb atbVar) {
        int iEs = czgVar.es();
        View view = null;
        if (iEs == 0) {
            return null;
        }
        int iO = (atbVar.o() / 2) + atbVar.n();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iEs; i2++) {
            View viewEr = czgVar.er(i2);
            int iAbs = Math.abs(((atbVar.f(viewEr) / 2) + atbVar.h(viewEr)) - iO);
            if (iAbs < i) {
                view = viewEr;
                i = iAbs;
            }
        }
        return view;
    }

    public final void g(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        dii diiVar = this.b;
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.bq;
            if (arrayList != null) {
                arrayList.remove(diiVar);
            }
            this.a.setOnFlingListener(null);
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.a.cv(diiVar);
            this.a.setOnFlingListener(this);
            new Scroller(this.a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public final int[] h(czg czgVar, View view) {
        int[] iArr = new int[2];
        if (czgVar.bu()) {
            iArr[0] = e(view, j(czgVar));
        } else {
            iArr[0] = 0;
        }
        if (czgVar.bv()) {
            iArr[1] = e(view, k(czgVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public View i(czg czgVar) {
        if (czgVar.bv()) {
            return f(czgVar, k(czgVar));
        }
        if (czgVar.bu()) {
            return f(czgVar, j(czgVar));
        }
        return null;
    }

    public final atb j(czg czgVar) {
        crz crzVar = this.d;
        if (crzVar == null || ((czg) crzVar.b) != czgVar) {
            this.d = new crz(czgVar, 0);
        }
        return this.d;
    }

    public final atb k(czg czgVar) {
        crz crzVar = this.c;
        if (crzVar == null || ((czg) crzVar.b) != czgVar) {
            this.c = new crz(czgVar, 1);
        }
        return this.c;
    }

    public final void l() {
        czg layoutManager;
        View viewI;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewI = i(layoutManager)) == null) {
            return;
        }
        int[] iArrH = h(layoutManager, viewI);
        int i = iArrH[0];
        if (i == 0 && iArrH[1] == 0) {
            return;
        }
        this.a.es(i, iArrH[1], false);
    }
}
