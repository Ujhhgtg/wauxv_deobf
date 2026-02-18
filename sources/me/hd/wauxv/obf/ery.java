package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ery extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ery(ViewPager2 viewPager2) {
        super(1);
        this.a = viewPager2;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean _g(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void ck(czt cztVar, int[] iArr) {
        ViewPager2 viewPager2 = this.a;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.ck(cztVar, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean fa(czo czoVar, czt cztVar, int i, Bundle bundle) {
        this.a.t.getClass();
        return super.fa(czoVar, cztVar, i, bundle);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void x(czo czoVar, czt cztVar, bd bdVar) {
        super.x(czoVar, cztVar, bdVar);
        this.a.t.getClass();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void y(czo czoVar, czt cztVar, View view, bd bdVar) {
        int iEl;
        int iEl2;
        ViewPager2 viewPager2 = (ViewPager2) this.a.t.f;
        if (viewPager2.getOrientation() == 1) {
            viewPager2.g.getClass();
            iEl = czg.el(view);
        } else {
            iEl = 0;
        }
        if (viewPager2.getOrientation() == 0) {
            viewPager2.g.getClass();
            iEl2 = czg.el(view);
        } else {
            iEl2 = 0;
        }
        bdVar.l(bc.g(iEl, 1, iEl2, 1, false));
    }
}
