package me.hd.wauxv.obf;

import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkh implements Runnable {
    public final /* synthetic */ int a = 1;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ bkh() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        OverScroller overScroller;
        switch (this.a) {
            case 0:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
                bki bkiVar = (bki) this.d;
                View view = (View) this.c;
                if (view != null && (overScroller = bkiVar.x) != null) {
                    if (!overScroller.computeScrollOffset()) {
                        AppBarLayout appBarLayout = (AppBarLayout) view;
                        ((AppBarLayout.BaseBehavior) bkiVar).v(coordinatorLayout, appBarLayout);
                        if (appBarLayout.m) {
                            appBarLayout.af(appBarLayout.ag(AppBarLayout.BaseBehavior.g(coordinatorLayout)));
                        }
                    } else {
                        bkiVar.ad(coordinatorLayout, view, bkiVar.x.getCurrY());
                        view.postOnAnimation(this);
                    }
                    break;
                }
                break;
            default:
                try {
                    objCall = ((bbw) this.b).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.d).post(new cs((bbx) this.c, objCall, 9, false));
                break;
        }
    }

    public bkh(bki bkiVar, CoordinatorLayout coordinatorLayout, View view) {
        this.d = bkiVar;
        this.b = coordinatorLayout;
        this.c = view;
    }
}
