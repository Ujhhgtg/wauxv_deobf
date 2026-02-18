package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.agu;
import me.hd.wauxv.obf.cxs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends agr {
    public FloatingActionButton$BaseBehavior() {
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean a(View view) {
        throw new ClassCastException();
    }

    @Override // me.hd.wauxv.obf.agr
    public final void bu(agu aguVar) {
        if (aguVar.h == 0) {
            aguVar.h = 80;
        }
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        throw new ClassCastException();
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        throw new ClassCastException();
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.n);
        typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
