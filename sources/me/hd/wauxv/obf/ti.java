package me.hd.wauxv.obf;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ti {
    public final int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CarouselLayoutManager c;

    public ti(int i) {
        this.a = i;
    }

    public final int d() {
        switch (this.b) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.c;
                if (carouselLayoutManager.g()) {
                    return carouselLayoutManager.eb;
                }
                return 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ti(CarouselLayoutManager carouselLayoutManager, int i) {
        this(1);
        this.b = i;
        switch (i) {
            case 1:
                this.c = carouselLayoutManager;
                this(0);
                break;
            default:
                this.c = carouselLayoutManager;
                break;
        }
    }
}
