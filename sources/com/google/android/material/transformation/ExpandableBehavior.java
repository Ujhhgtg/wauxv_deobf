package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.eqz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends agr {
    public ExpandableBehavior() {
    }

    @Override // me.hd.wauxv.obf.agr
    public abstract boolean b(View view, View view2);

    @Override // me.hd.wauxv.obf.agr
    public final boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        view2.getClass();
        throw new ClassCastException();
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = eqz.a;
        if (!view.isLaidOut()) {
            List listAf = coordinatorLayout.af(view);
            int size = listAf.size();
            for (int i2 = 0; i2 < size; i2++) {
                b(view, (View) listAf.get(i2));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
