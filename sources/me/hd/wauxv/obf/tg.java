package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tg extends bvl {
    public final /* synthetic */ int a = 1;

    public /* synthetic */ tg(Context context) {
        super(context);
    }

    @Override // me.hd.wauxv.obf.bvl
    public int b(View view, int i) {
        switch (this.a) {
            case 0:
                return 0;
            default:
                return super.tryGetClassByName(view, i);
        }
    }

    @Override // me.hd.wauxv.obf.bvl
    public int c(View view, int i) {
        switch (this.a) {
            case 0:
                return 0;
            default:
                return super.createInstanceWithArgs(view, i);
        }
    }

    @Override // me.hd.wauxv.obf.bvl
    public float d(DisplayMetrics displayMetrics) {
        switch (this.a) {
            case 1:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // me.hd.wauxv.obf.bvl
    public PointF e(int i) {
        switch (this.a) {
            case 0:
                return null;
            default:
                return super.e(i);
        }
    }

    public tg(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
    }
}
