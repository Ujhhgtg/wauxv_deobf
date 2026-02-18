package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esu extends est {
    @Override // me.hd.wauxv.obf.bhs
    public final float ab(View view) {
        return view.getTransitionAlpha();
    }

    @Override // me.hd.wauxv.obf.bhs
    public final void af(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // me.hd.wauxv.obf.est, me.hd.wauxv.obf.bhs
    public final void ag(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // me.hd.wauxv.obf.est
    public final void ak(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // me.hd.wauxv.obf.est
    public final void al(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // me.hd.wauxv.obf.est
    public final void am(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
