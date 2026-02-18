package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class th extends czd {
    public final Paint a;
    public final List b;

    public th() {
        Paint paint = new Paint();
        this.a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // me.hd.wauxv.obf.czd
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        int iEv;
        int iEw;
        int iEx;
        int iEu;
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((btn) it.next()).getClass();
            paint.setColor(abi.c(-65281, 0.0f, -16776961));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).f()) {
                ti tiVar = ((CarouselLayoutManager) recyclerView.getLayoutManager()).b;
                switch (tiVar.b) {
                    case 0:
                        iEx = 0;
                        break;
                    default:
                        iEx = tiVar.c.ex();
                        break;
                }
                float f = iEx;
                ti tiVar2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).b;
                switch (tiVar2.b) {
                    case 0:
                        iEu = tiVar2.c.ec;
                        break;
                    default:
                        CarouselLayoutManager carouselLayoutManager = tiVar2.c;
                        iEu = carouselLayoutManager.ec - carouselLayoutManager.eu();
                        break;
                }
                canvas2 = canvas;
                canvas2.drawLine(0.0f, f, 0.0f, iEu, paint);
            } else {
                canvas2 = canvas;
                ti tiVar3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).b;
                switch (tiVar3.b) {
                    case 0:
                        iEv = tiVar3.c.ev();
                        break;
                    default:
                        iEv = 0;
                        break;
                }
                float f2 = iEv;
                ti tiVar4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).b;
                switch (tiVar4.b) {
                    case 0:
                        CarouselLayoutManager carouselLayoutManager2 = tiVar4.c;
                        iEw = carouselLayoutManager2.eb - carouselLayoutManager2.ew();
                        break;
                    default:
                        iEw = tiVar4.c.eb;
                        break;
                }
                canvas2.drawLine(f2, 0.0f, iEw, 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
