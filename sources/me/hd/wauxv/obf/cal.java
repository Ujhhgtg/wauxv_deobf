package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cal<S> extends cti {
    public int a;
    public st b;
    public cet c;
    public int d;
    public DefaultConfig l;
    public RecyclerView m;
    public RecyclerView n;
    public View o;
    public View p;
    public View q;
    public View r;

    @Override // me.hd.wauxv.obf.bdj
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle == null) {
            bundle = this.ax;
        }
        this.a = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.b = (st) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.c = (cet) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(cq(), this.a);
        this.l = new DefaultConfig((Context) contextThemeWrapper, 9);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        cet cetVar = this.b.a;
        if (cas.ec(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = me.hd.wauxv.R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = me.hd.wauxv.R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = dc().getResources();
        int dimensionPixelOffset = resources
                .getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_calendar_navigation_bottom_padding)
                + resources.getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_calendar_navigation_top_padding)
                + resources.getDimensionPixelSize(me.hd.wauxv.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(me.hd.wauxv.R.dimen.mtrl_calendar_days_of_week_height);
        int i3 = ceu.a;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize
                + (resources.getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_calendar_month_vertical_padding)
                        * (i3 - 1))
                + (resources.getDimensionPixelSize(me.hd.wauxv.R.dimen.mtrl_calendar_day_height) * i3)
                + resources.getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(me.hd.wauxv.R.id.mtrl_calendar_days_of_week);
        eqz.s(gridView, new cah(0));
        int i4 = this.b.e;
        gridView.setAdapter((ListAdapter) (i4 > 0 ? new ajl(i4) : new ajl()));
        gridView.setNumColumns(cetVar.d);
        gridView.setEnabled(false);
        this.n = (RecyclerView) viewInflate.findViewById(me.hd.wauxv.R.id.mtrl_calendar_months);
        this.n.setLayoutManager(new cai(this, i2, i2));
        this.n.setTag("MONTHS_VIEW_GROUP_TAG");
        com.google.android.material.datepicker.c cVar = new com.google.android.material.datepicker.c(
                contextThemeWrapper, this.b, new bmu(this));
        this.n.setAdapter(cVar);
        int integer = contextThemeWrapper.getResources()
                .getInteger(me.hd.wauxv.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate
                .findViewById(me.hd.wauxv.R.id.mtrl_calendar_year_selector_frame);
        this.m = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.m.setLayoutManager(new GridLayoutManager(integer));
            this.m.setAdapter(new ewt(this));
            RecyclerView recyclerView2 = this.m;
            caj cajVar = new caj();
            eoq.d(null);
            eoq.d(null);
            recyclerView2.cu(cajVar);
        }
        if (viewInflate.findViewById(me.hd.wauxv.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate
                    .findViewById(me.hd.wauxv.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            eqz.s(materialButton, new yb(this, 2));
            View viewFindViewById = viewInflate.findViewById(me.hd.wauxv.R.id.month_navigation_previous);
            this.o = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(me.hd.wauxv.R.id.month_navigation_next);
            this.p = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.q = viewInflate.findViewById(me.hd.wauxv.R.id.mtrl_calendar_year_selector_frame);
            this.r = viewInflate.findViewById(me.hd.wauxv.R.id.mtrl_calendar_day_selector_frame);
            t(1);
            materialButton.setText(this.c.j());
            this.n.cv(new cak(this, cVar, materialButton));
            materialButton.setOnClickListener(new ch(this, 3));
            this.p.setOnClickListener(new cag(this, cVar, 1));
            this.o.setOnClickListener(new cag(this, cVar, 0));
        }
        if (!cas.ec(contextThemeWrapper, R.attr.windowFullscreen)) {
            new csj().g(this.n);
        }
        this.n.eq(cVar.cachedConstructors.cachedConstructors.k(this.c));
        eqz.s(this.n, new cah(1));
        return viewInflate;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void j(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.a);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.b);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.c);
    }

    public final void s(cet cetVar) {
        com.google.android.material.datepicker.c cVar = (com.google.android.material.datepicker.c) this.n.getAdapter();
        int iK = cVar.cachedConstructors.cachedConstructors.k(cetVar);
        int iK2 = iK - cVar.cachedConstructors.cachedConstructors.k(this.c);
        boolean z = Math.abs(iK2) > 3;
        boolean z2 = iK2 > 0;
        this.c = cetVar;
        if (z && z2) {
            this.n.eq(iK - 3);
            this.n.post(new np(this, iK, 3));
        } else if (!z) {
            this.n.post(new np(this, iK, 3));
        } else {
            this.n.eq(iK + 3);
            this.n.post(new np(this, iK, 3));
        }
    }

    public final void t(int i) {
        this.d = i;
        if (i == 2) {
            this.m.getLayoutManager().ch(this.c.c - ((ewt) this.m.getAdapter()).a.b.a.c);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            s(this.c);
        }
    }
}
