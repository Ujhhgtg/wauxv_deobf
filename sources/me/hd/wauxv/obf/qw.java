package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qw extends doo implements bnp {
    public static final qw a;
    public static final String b;
    public static final dov c;
    public static final dov d;
    public static final dov h;
    public static final dov i;
    public static final dov j;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final mj r;
    public static final boolean s;

    static {
        "#FFF7F7F7" /* cnb.z(-436961382759210L) */;
        "#FFCCE8E3" /* cnb.z(-436935612955434L) */;
        "#FF1E1E1E" /* cnb.z(-436909843151658L) */;
        "#FF1E1E1E" /* cnb.z(-436884073347882L) */;
        "#FF324B48" /* cnb.z(-436789584067370L) */;
        "#FFF7F7F7" /* cnb.z(-425218942171946L) */;
        a = new qw("BottomTabMaterialHook" /* cnb.z(-435664302635818L) */);
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* cnb.z(-46621869996842L) */, "BottomTab" /* cnb.z(-46531675683626L) */);
        c = new dov(new h(14));
        d = new dov(new h(15));
        h = new dov(new h(16));
        i = new dov(new h(17));
        j = new dov(new h(18));
        l = "美化" /* cnb.z(-425193172368170L) */;
        m = "底栏 Material You" /* cnb.z(-425197467335466L) */;
        n = "替换主页底部标签栏为 Material You 样式" /* cnb.z(-425128747858730L) */;
        r = new mj(13);
        s = true;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return m;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return l;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return n;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return r;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return s;
    }

    @Override // me.hd.wauxv.obf.bnp
    public final void t(Activity activity, ViewGroup viewGroup, Object obj) {
        if (z()) {
            qb qbVar = new qb(aqu.e(cnf.am(activity)), R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
            jx jxVarAo = bhu.ao(qbVar.getContext(), null, cxs.d, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView, new int[0]);
            TypedArray typedArray = (TypedArray) jxVarAo.e;
            qbVar.setItemHorizontalTranslationEnabled(typedArray.getBoolean(2, true));
            if (typedArray.hasValue(0)) {
                qbVar.setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
            }
            typedArray.getBoolean(1, true);
            jxVarAo.ae();
            ewz.af(qbVar, new nu(4));
            qbVar.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) cnh.r(56, qbVar.getContext())));
            qbVar.setLabelVisibilityMode(2);
            if (cnh.aa(qbVar.getContext())) {
                qbVar.setBackgroundColor(Color.parseColor(qq.a.o()));
                qbVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(qu.a.o())));
                qbVar.setItemIconTintList(emc.ai(Color.parseColor(qs.a.o())));
            } else {
                qbVar.setBackgroundColor(Color.parseColor(qr.a.o()));
                qbVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(qv.a.o())));
                qbVar.setItemIconTintList(emc.ai(Color.parseColor(qt.a.o())));
            }
            Menu menu = qbVar.getMenu();
            MenuItem menuItemAdd = menu.add(0, 0, 0, "" /* cnb.z(-435552633486122L) */);
            qw qwVar = a;
            qwVar.getClass();
            menuItemAdd.setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) d.getValue()));
            menu.add(0, 1, 1, "" /* cnb.z(-435548338518826L) */).setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) h.getValue()));
            menu.add(0, 2, 2, "" /* cnb.z(-435561223420714L) */).setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) i.getValue()));
            menu.add(0, 3, 3, "" /* cnb.z(-435556928453418L) */).setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) j.getValue()));
            qbVar.setOnItemSelectedListener(new qp(obj, 0));
            ViewParent parent = viewGroup.getParent();
            bzo.o(parent, "null cannot be cast to non-null type android.view.ViewGroup" /* cnb.z(-435569813355306L) */);
            View childAt = ((ViewGroup) parent).getChildAt(1);
            bzo.o(childAt, "null cannot be cast to non-null type android.view.ViewGroup" /* cnb.z(-435827511393066L) */);
            ((ViewGroup) childAt).addView(qbVar);
            int i2 = bte.a;
            cde cdeVarT = dqc.bi(obj).t();
            cdeVarT.ab = "onPageSelected" /* cnb.z(-437253440535338L) */;
            aki akiVarAd = ad((cdk) aaz.e(cdeVarT.aj()), exg.a);
            qwVar.x(akiVarAd, new q(qbVar, 1));
            akiVarAd.o();
        }
    }
}
