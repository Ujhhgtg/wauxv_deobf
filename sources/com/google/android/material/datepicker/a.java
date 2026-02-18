package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import me.hd.wauxv.obf.cal;
import me.hd.wauxv.obf.ceu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView a;
    public final /* synthetic */ c b;

    public a(c cVar, MaterialCalendarGridView materialCalendarGridView) {
        this.b = cVar;
        this.a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MaterialCalendarGridView materialCalendarGridView = this.a;
        ceu ceuVarB = materialCalendarGridView.b();
        if (i < ceuVarB.f() || i > ceuVarB.h()) {
            return;
        }
        if (materialCalendarGridView.b().getItem(i).longValue() >= ((cal) this.b.b.h).b.c.a) {
            throw null;
        }
    }
}
