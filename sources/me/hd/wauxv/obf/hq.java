package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hq implements cqk, afi, ccl {
    public final /* synthetic */ int a;
    public final /* synthetic */ ic b;

    public /* synthetic */ hq(ic icVar, int i) {
        this.a = i;
        this.b = icVar;
    }

    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        int i;
        boolean z;
        evr evrVarG;
        boolean z2;
        int iH = evrVar.h();
        ic icVar = this.b;
        Context context = icVar.x;
        int iH2 = evrVar.h();
        ActionBarContextView actionBarContextView = icVar.ai;
        if (actionBarContextView == null
                || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = 0;
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) icVar.ai.getLayoutParams();
            if (icVar.ai.isShown()) {
                if (icVar.bp == null) {
                    icVar.bp = new Rect();
                    icVar.bq = new Rect();
                }
                Rect rect = icVar.bp;
                Rect rect2 = icVar.bq;
                rect.set(evrVar.f(), evrVar.h(), evrVar.g(), evrVar.e());
                ViewGroup viewGroup = icVar.an;
                if (Build.VERSION.SDK_INT >= 29) {
                    esm.a(viewGroup, rect, rect2);
                } else {
                    if (!aye.g) {
                        aye.g = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class,
                                    Rect.class);
                            aye.h = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                aye.h.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = aye.h;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i2 = rect.top;
                int i3 = rect.left;
                int i4 = rect.right;
                ViewGroup viewGroup2 = icVar.an;
                WeakHashMap weakHashMap = eqz.a;
                evr evrVarA = eqr.a(viewGroup2);
                int iF = evrVarA == null ? 0 : evrVarA.f();
                int iG = evrVarA == null ? 0 : evrVarA.g();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3
                        && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || icVar.ap != null) {
                    View view2 = icVar.ap;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2
                                .getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != iF || marginLayoutParams2.rightMargin != iG) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = iF;
                            marginLayoutParams2.rightMargin = iG;
                            icVar.ap.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    icVar.ap = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1,
                            marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iF;
                    layoutParams.rightMargin = iG;
                    icVar.an.addView(icVar.ap, -1, layoutParams);
                }
                View view4 = icVar.ap;
                z = view4 != null;
                if (z && view4.getVisibility() != 0) {
                    View view5 = icVar.ap;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0
                            ? context.getColor(R.color.abc_decor_view_status_guard_light)
                            : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!icVar.au && z) {
                    iH2 = 0;
                }
                z = z;
                i = 0;
                z = z2;
            } else {
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z = false;
                    z = false;
                }
            }
            if (z) {
                icVar.ai.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = icVar.ap;
        if (view6 != null) {
            view6.setVisibility(z ? i : 8);
        }
        if (iH != iH2) {
            int iF2 = evrVar.f();
            int iG2 = evrVar.g();
            int iE = evrVar.e();
            int i7 = Build.VERSION.SDK_INT;
            evg evfVar = i7 >= 34 ? new evf(evrVar)
                    : i7 >= 31 ? new eve(evrVar)
                            : i7 >= 30 ? new evd(evrVar) : i7 >= 29 ? new evc(evrVar) : new evb(evrVar);
            evfVar.i(bps.g(iF2, iH2, iG2, iE));
            evrVarG = evfVar.g();
        } else {
            evrVarG = evrVar;
        }
        WeakHashMap weakHashMap2 = eqz.a;
        WindowInsets windowInsetsI = evrVarG.i();
        if (windowInsetsI == null) {
            return evrVarG;
        }
        WindowInsets windowInsetsB = eqo.tryGetClassByName(view, windowInsetsI);
        return !windowInsetsB.equals(windowInsetsI) ? evr.d(view, windowInsetsB) : evrVarG;
    }

    @Override // me.hd.wauxv.obf.ccl
    public void c(cbw cbwVar, boolean z) {
        ib ibVar;
        switch (this.a) {
            case 2:
                this.b.cb(cbwVar);
                break;
            default:
                cbw cbwVarAj = cbwVar.aj();
                int i = 0;
                boolean z2 = cbwVarAj != cbwVar;
                if (z2) {
                    cbwVar = cbwVarAj;
                }
                ic icVar = this.b;
                ib[] ibVarArr = icVar.ay;
                int length = ibVarArr != null ? ibVarArr.length : 0;
                while (true) {
                    if (i >= length) {
                        ibVar = null;
                    } else {
                        ibVar = ibVarArr[i];
                        if (ibVar == null || ibVar.h != cbwVar) {
                            i++;
                        }
                    }
                }
                if (ibVar != null) {
                    if (!z2) {
                        icVar.cc(ibVar, z);
                    } else {
                        icVar.ca(ibVar.a, ibVar, cbwVarAj);
                        icVar.cc(ibVar, true);
                    }
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.ccl
    public boolean d(cbw cbwVar) {
        Window.Callback callback;
        switch (this.a) {
            case 2:
                Window.Callback callback2 = this.b.y.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, cbwVar);
                }
                break;
            default:
                if (cbwVar == cbwVar.aj()) {
                    ic icVar = this.b;
                    if (icVar.as && (callback = icVar.y.getCallback()) != null && !icVar.bd) {
                        callback.onMenuOpened(108, cbwVar);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
