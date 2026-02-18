package me.hd.wauxv.obf;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asw extends dop {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ asw(int i) {
        super(7);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.dop
    public final void _bg(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.a) {
            case 0:
                RectF rectFH = dop.h(tabLayout, view);
                RectF rectFH2 = dop.h(tabLayout, view2);
                if (rectFH.left < rectFH2.left) {
                    double d = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d));
                    fCos = (float) Math.sin(d);
                } else {
                    double d2 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d2);
                    fCos = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(ff.h((int) rectFH.left, fSin, (int) rectFH2.left), drawable.getBounds().top, ff.h((int) rectFH.right, fCos, (int) rectFH2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFH3 = dop.h(tabLayout, view);
                float fG = f < 0.5f ? ff.g(1.0f, 0.0f, 0.0f, 0.5f, f) : ff.g(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFH3.left, drawable.getBounds().top, (int) rectFH3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fG * 255.0f));
                break;
        }
    }
}
