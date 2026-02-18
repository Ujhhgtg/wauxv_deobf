package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import me.hd.wauxv.obf.cah;
import me.hd.wauxv.obf.cas;
import me.hd.wauxv.obf.ceu;
import me.hd.wauxv.obf.eoq;
import me.hd.wauxv.obf.eqz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final boolean a;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        eoq.d(null);
        if (cas.ec(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(me.hd.wauxv.R.id.cancel_button);
            setNextFocusRightId(me.hd.wauxv.R.id.confirm_button);
        }
        this.a = cas.ec(getContext(), me.hd.wauxv.R.attr.nestedScrollable);
        eqz.s(this, new cah(2));
    }

    public final ceu b() {
        return (ceu) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (ceu) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((ceu) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ceu ceuVar = (ceu) super.getAdapter();
        ceuVar.getClass();
        int iMax = Math.max(ceuVar.f(), getFirstVisiblePosition());
        int iMin = Math.min(ceuVar.h(), getLastVisiblePosition());
        ceuVar.getItem(iMax);
        ceuVar.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((ceu) super.getAdapter()).h());
        } else if (i == 130) {
            setSelection(((ceu) super.getAdapter()).f());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((ceu) super.getAdapter()).f()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((ceu) super.getAdapter()).f());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.a) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((ceu) super.getAdapter()).f()) {
            super.setSelection(((ceu) super.getAdapter()).f());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (ceu) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof ceu)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), ceu.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
