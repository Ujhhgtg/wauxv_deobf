package me.hd.wauxv.obf;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgy extends ViewOutlineProvider {
    public final Rect a = new Rect();
    public final /* synthetic */ ShapeableImageView b;

    public dgy(ShapeableImageView shapeableImageView) {
        this.b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.b;
        if (shapeableImageView.i == null) {
            return;
        }
        if (shapeableImageView.h == null) {
            shapeableImageView.h = new cau(shapeableImageView.i);
        }
        RectF rectF = shapeableImageView.b;
        Rect rect = this.a;
        rectF.round(rect);
        shapeableImageView.h.setBounds(rect);
        shapeableImageView.h.getOutline(outline);
    }
}
