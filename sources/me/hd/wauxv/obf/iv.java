package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class iv implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ iv(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.a) {
            case 0:
                je jeVar = (je) this.b;
                if (!jeVar.getInternalPopup().e()) {
                    jeVar.g.n(jeVar.getTextDirection(), jeVar.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = jeVar.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            case 1:
                jb jbVar = (jb) this.b;
                je jeVar2 = jbVar.q;
                jbVar.getClass();
                if (jeVar2.isAttachedToWindow() && jeVar2.getGlobalVisibleRect(jbVar.c)) {
                    jbVar.r();
                    jbVar.ag();
                } else {
                    jbVar.dismiss();
                }
                break;
            case 2:
                tm tmVar = (tm) this.b;
                ArrayList arrayList = tmVar.h;
                if (tmVar.initOnce() && arrayList.size() > 0 && !((tl) arrayList.get(0)).a.au) {
                    View view = tmVar.o;
                    if (view != null && view.isShown()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((tl) it.next()).a.ag();
                        }
                    } else {
                        tmVar.dismiss();
                    }
                    break;
                }
                break;
            default:
                dmh dmhVar = (dmh) this.b;
                cck cckVar = dmhVar.h;
                if (dmhVar.initOnce() && !cckVar.au) {
                    View view2 = dmhVar.m;
                    if (view2 != null && view2.isShown()) {
                        cckVar.ag();
                    } else {
                        dmhVar.dismiss();
                    }
                    break;
                }
                break;
        }
    }
}
