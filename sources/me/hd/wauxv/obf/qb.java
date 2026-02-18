package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qb extends ckg {
    @Override // me.hd.wauxv.obf.ckg
    public final cka a(Context context) {
        return new py(context);
    }

    @Override // me.hd.wauxv.obf.ckg
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i2) != 1073741824 && suggestedMinimumHeight > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        py pyVar = (py) getMenuView();
        if (pyVar.f != z) {
            pyVar.setItemHorizontalTranslationEnabled(z);
            getPresenter().ac(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(pz pzVar) {
        setOnItemReselectedListener(pzVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(qa qaVar) {
        setOnItemSelectedListener(qaVar);
    }
}
