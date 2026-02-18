package me.hd.wauxv.obf;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tf implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ tf(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        switch (this.a) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.b;
                if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
                    view.post(new dh(carouselLayoutManager, 1));
                }
                break;
            default:
                ase aseVar = (ase) this.b;
                if (aseVar.z.isShowing()) {
                    aseVar.an(false);
                }
                break;
        }
    }
}
