package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Calendar;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.cas;
import me.hd.wauxv.obf.cet;
import me.hd.wauxv.obf.ceu;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.czx;
import me.hd.wauxv.obf.eoq;
import me.hd.wauxv.obf.st;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends cyw {
    public final st a;
    public final bmu b;
    public final int c;

    public c(ContextThemeWrapper contextThemeWrapper, st stVar, bmu bmuVar) {
        cet cetVar = stVar.a;
        cet cetVar2 = stVar.b;
        cet cetVar3 = stVar.d;
        if (cetVar.a.compareTo(cetVar3.a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (cetVar3.a.compareTo(cetVar2.a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.c = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * ceu.a) + (cas.ec(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.a = stVar;
        this.b = bmuVar;
        ag();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        return this.a.g;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final long e(int i) {
        Calendar calendarB = eoq.b(this.a.a.a);
        calendarB.add(2, i);
        calendarB.set(5, 1);
        Calendar calendarB2 = eoq.b(calendarB);
        calendarB2.get(2);
        calendarB2.get(1);
        calendarB2.getMaximum(7);
        calendarB2.getActualMaximum(5);
        calendarB2.getTimeInMillis();
        return calendarB2.getTimeInMillis();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(czx czxVar, int i) {
        b bVar = (b) czxVar;
        st stVar = this.a;
        Calendar calendarB = eoq.b(stVar.a.a);
        calendarB.add(2, i);
        cet cetVar = new cet(calendarB);
        bVar.a.setText(cetVar.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.b() == null || !cetVar.equals(materialCalendarGridView.b().c)) {
            new ceu(cetVar, stVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.b().getClass();
        throw null;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final czx g(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!cas.ec(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new czh(-1, this.c));
        return new b(linearLayout, true);
    }
}
