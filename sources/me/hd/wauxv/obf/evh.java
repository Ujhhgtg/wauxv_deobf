package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class evh extends evo {
    public static boolean a;
    public static Method b;
    public static Class c;
    public static Field d;
    public static Field e;
    public final WindowInsets f;
    public bps[] g;
    public bps h;
    public evr i;
    public bps j;
    public int k;

    public evh(evr evrVar, WindowInsets windowInsets) {
        super(evrVar);
        this.h = null;
        this.f = windowInsets;
    }

    private bps ag() {
        evr evrVar = this.i;
        return evrVar != null ? evrVar.b.ab() : bps.a;
    }

    private bps ah(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!a) {
            ai();
        }
        Method method = b;
        if (method != null && c != null && d != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) d.get(e.get(objInvoke));
                if (rect != null) {
                    return bps.g(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
        }
        return null;
    }

    private static void ai() {
        try {
            b = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            c = cls;
            d = cls.getDeclaredField("mVisibleInsets");
            e = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            d.setAccessible(true);
            e.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
        }
        a = true;
    }

    public static boolean l(int i, int i2) {
        return (i & 6) == (i2 & 6);
    }

    private bps y(int i, boolean z) {
        bps bpsVarF = bps.a;
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                bpsVarF = bps.f(bpsVarF, v(i2, z));
            }
        }
        return bpsVarF;
    }

    @Override // me.hd.wauxv.obf.evo
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        evh evhVar = (evh) obj;
        return Objects.equals(this.j, evhVar.j) && l(this.k, evhVar.k);
    }

    @Override // me.hd.wauxv.obf.evo
    public void m(View view) {
        bps bpsVarAh = ah(view);
        if (bpsVarAh == null) {
            bpsVarAh = bps.a;
        }
        x(bpsVarAh);
    }

    @Override // me.hd.wauxv.obf.evo
    public bps n(int i) {
        return y(i, false);
    }

    @Override // me.hd.wauxv.obf.evo
    public final bps o() {
        if (this.h == null) {
            WindowInsets windowInsets = this.f;
            this.h = bps.g(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.h;
    }

    @Override // me.hd.wauxv.obf.evo
    public evr p(int i, int i2, int i3, int i4) {
        evr evrVarD = evr.d(null, this.f);
        int i5 = Build.VERSION.SDK_INT;
        evg evfVar = i5 >= 34 ? new evf(evrVarD) : i5 >= 31 ? new eve(evrVarD) : i5 >= 30 ? new evd(evrVarD) : i5 >= 29 ? new evc(evrVarD) : new evb(evrVarD);
        evfVar.i(evr.c(o(), i, i2, i3, i4));
        evfVar.h(evr.c(ab(), i, i2, i3, i4));
        return evfVar.g();
    }

    @Override // me.hd.wauxv.obf.evo
    public boolean q() {
        return this.f.isRound();
    }

    @Override // me.hd.wauxv.obf.evo
    public boolean r(int i) {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0 && !w(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.evo
    public void s(bps[] bpsVarArr) {
        this.g = bpsVarArr;
    }

    @Override // me.hd.wauxv.obf.evo
    public void t(evr evrVar) {
        this.i = evrVar;
    }

    @Override // me.hd.wauxv.obf.evo
    public void u(int i) {
        this.k = i;
    }

    public bps v(int i, boolean z) {
        bps bpsVarAb;
        int i2;
        bps bpsVar = bps.a;
        if (i != 1) {
            if (i != 2) {
                if (i == 8) {
                    bps[] bpsVarArr = this.g;
                    bpsVarAb = bpsVarArr != null ? bpsVarArr[FastKV.ag(8)] : null;
                    if (bpsVarAb != null) {
                        return bpsVarAb;
                    }
                    bps bpsVarO = o();
                    bps bpsVarAg = ag();
                    int i3 = bpsVarO.e;
                    if (i3 > bpsVarAg.e) {
                        return bps.g(0, 0, 0, i3);
                    }
                    bps bpsVar2 = this.j;
                    if (bpsVar2 != null && !bpsVar2.equals(bpsVar) && (i2 = this.j.e) > bpsVarAg.e) {
                        return bps.g(0, 0, 0, i2);
                    }
                } else {
                    if (i == 16) {
                        return ak();
                    }
                    if (i == 32) {
                        return aj();
                    }
                    if (i == 64) {
                        return al();
                    }
                    if (i == 128) {
                        evr evrVar = this.i;
                        aow aowVarAf = evrVar != null ? evrVar.b.af() : af();
                        if (aowVarAf != null) {
                            int i4 = Build.VERSION.SDK_INT;
                            return bps.g(i4 >= 28 ? aov.d(aowVarAf.a) : 0, i4 >= 28 ? aov.f(aowVarAf.a) : 0, i4 >= 28 ? aov.e(aowVarAf.a) : 0, i4 >= 28 ? aov.c(aowVarAf.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    bps bpsVarAg2 = ag();
                    bps bpsVarAb2 = ab();
                    return bps.g(Math.max(bpsVarAg2.b, bpsVarAb2.b), 0, Math.max(bpsVarAg2.d, bpsVarAb2.d), Math.max(bpsVarAg2.e, bpsVarAb2.e));
                }
                if ((this.k & 2) == 0) {
                    bps bpsVarO2 = o();
                    evr evrVar2 = this.i;
                    bpsVarAb = evrVar2 != null ? evrVar2.b.ab() : null;
                    int iMin = bpsVarO2.e;
                    if (bpsVarAb != null) {
                        iMin = Math.min(iMin, bpsVarAb.e);
                    }
                    return bps.g(bpsVarO2.b, 0, bpsVarO2.d, iMin);
                }
            }
        } else {
            if (z) {
                return bps.g(0, Math.max(ag().c, o().c), 0, 0);
            }
            if ((this.k & 4) == 0) {
                return bps.g(0, o().c, 0, 0);
            }
        }
        return bpsVar;
    }

    public boolean w(int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return false;
            }
            if (i != 8 && i != 128) {
                return true;
            }
        }
        return !v(i, false).equals(bps.a);
    }

    public void x(bps bpsVar) {
        this.j = bpsVar;
    }
}
