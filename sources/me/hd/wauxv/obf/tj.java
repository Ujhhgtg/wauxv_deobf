package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tj implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ tj(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void c(View view) {
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                break;
            case 1:
                awa awaVar = (awa) obj;
                AccessibilityManager accessibilityManager = awaVar.t;
                if (awaVar.u != null && accessibilityManager != null) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    if (awaVar.isAttachedToWindow()) {
                        accessibilityManager.addTouchExplorationStateChangeListener(new ar(awaVar.u));
                    }
                    break;
                }
                break;
            case 2:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap2 = ViewCompat.a;
                eqo.c(view2);
                break;
            case 3:
                break;
            default:
                dbs dbsVarO = ((oy) obj).o();
                if (dbsVarO != null && dbsVarO.m()) {
                    dbsVarO.n();
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.a) {
            case 0:
                tm tmVar = (tm) this.b;
                ViewTreeObserver viewTreeObserver = tmVar.x;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        tmVar.x = view.getViewTreeObserver();
                    }
                    tmVar.x.removeGlobalOnLayoutListener(tmVar.i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                awa awaVar = (awa) this.b;
                qp qpVar = awaVar.u;
                if (qpVar != null && (accessibilityManager = awaVar.t) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new ar(qpVar));
                    break;
                }
                break;
            case 2:
                break;
            case 3:
                dmh dmhVar = (dmh) this.b;
                ViewTreeObserver viewTreeObserver2 = dmhVar.o;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        dmhVar.o = view.getViewTreeObserver();
                    }
                    dmhVar.o.removeGlobalOnLayoutListener(dmhVar.i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                oy oyVar = (oy) this.b;
                dbs dbsVarO = oyVar.o();
                if (dbsVarO != null) {
                    oyVar.d = true;
                    dbsVarO.clear();
                    oyVar.d = false;
                }
                break;
        }
    }
}
