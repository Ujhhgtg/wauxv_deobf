package me.hd.wauxv.obf;

import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dop implements cdw, ahw, ero, btg {
    public static dop c;
    public static dop d;
    public static dop f;
    public final /* synthetic */ int g;

    public /* synthetic */ dop(int i) {
        this.g = i;
    }

    public static RectF h(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.af || !(view instanceof dpn)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        dpn dpnVar = (dpn) view;
        int contentWidth = dpnVar.getContentWidth();
        int contentHeight = dpnVar.getContentHeight();
        int iAg = (int) ewz.ag(dpnVar.getContext(), 24);
        if (contentWidth < iAg) {
            contentWidth = iAg;
        }
        int right = (dpnVar.getRight() + dpnVar.getLeft()) / 2;
        int bottom = (dpnVar.getBottom() + dpnVar.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    public static dop i() {
        if (c == null) {
            c = new dop(13);
        }
        return c;
    }

    public static Path j(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }

    public void _bg(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF rectFH = h(tabLayout, view);
        RectF rectFH2 = h(tabLayout, view2);
        drawable.setBounds(ff.h((int) rectFH.left, f2, (int) rectFH2.left), drawable.getBounds().top, ff.h((int) rectFH.right, f2, (int) rectFH2.right), drawable.getBounds().bottom);
    }

    @Override // me.hd.wauxv.obf.ero
    public erk _bh(zc zcVar, chq chqVar) {
        return l(cnf.getJavaClass(zcVar), chqVar);
    }

    @Override // me.hd.wauxv.obf.ero
    public erk b(Class cls) {
        return cnh.q(cls);
    }

    @Override // me.hd.wauxv.obf.btg
    public void debug(String str) {
        ArrayList arrayList = ewq.a;
        ewq.d(12, String.valueOf(str));
    }

    @Override // me.hd.wauxv.obf.btg
    public void e(Object obj, Throwable th) {
        ArrayList arrayList = ewq.a;
        ewq.i(ewp.a, new ewr(cna.d, "W", String.valueOf(obj), th, 51), false);
    }

    public boolean k(CharSequence charSequence) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ero
    public erk l(Class cls, chq chqVar) {
        return b(cls);
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        switch (this.g) {
            case 11:
                return new dnd(chmVar.w(bid.class, InputStream.class), 1);
            default:
                return new eok(chmVar.w(bid.class, InputStream.class));
        }
    }
}
