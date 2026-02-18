package me.hd.wauxv.obf;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csi extends bvl {
    public final /* synthetic */ csj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public csi(csj csjVar, Context context) {
        super(context);
        this.a = csjVar;
    }

    @Override // me.hd.wauxv.obf.bvl
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // me.hd.wauxv.obf.bvl
    public final int w(int i) {
        return Math.min(100, super.w(i));
    }

    @Override // me.hd.wauxv.obf.bvl
    public final void y(View view, czr czrVar) {
        csj csjVar = this.a;
        int[] iArrH = csjVar.h(csjVar.a.getLayoutManager(), view);
        int i = iArrH[0];
        int i2 = iArrH[1];
        int iCeil = (int) Math.ceil(((double) w(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            czrVar.a = i;
            czrVar.b = i2;
            czrVar.c = iCeil;
            czrVar.e = this.o;
            czrVar.f = true;
        }
    }
}
