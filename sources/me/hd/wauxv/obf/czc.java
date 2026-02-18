package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class czc {
    public long aa;
    public long ab;
    public long ac;
    public cyv x;
    public ArrayList y;
    public long z;

    public static void ad(czx czxVar) {
        int i = czxVar.m;
        if (!czxVar.ad() && (i & 4) == 0) {
            czxVar.x();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Found duplicated region for block: B:35:0x007e  */
    public final void ae(czx czxVar) {
        cyv cyvVar = this.x;
        if (cyvVar != null) {
            RecyclerView recyclerView = cyvVar.a;
            boolean z = true;
            czxVar.al(true);
            View view = czxVar.d;
            if (czxVar.k != null && czxVar.l == null) {
                czxVar.k = null;
            }
            czxVar.l = null;
            if ((czxVar.m & 16) != 0) {
                return;
            }
            czo czoVar = recyclerView.m;
            recyclerView.eu();
            yi yiVar = recyclerView.p;
            yh yhVar = (yh) yiVar.d;
            cyv cyvVar2 = (cyv) yiVar.c;
            int i = yiVar.b;
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
                }
                try {
                    yiVar.b = 2;
                    int iIndexOfChild = cyvVar2.a.indexOfChild(view);
                    if (iIndexOfChild == -1) {
                        yiVar.ak(view);
                    } else if (yhVar.f(iIndexOfChild)) {
                        yhVar.h(iIndexOfChild);
                        yiVar.ak(view);
                        cyvVar2.l(iIndexOfChild);
                    } else {
                        yiVar.b = 0;
                    }
                    yiVar.b = 0;
                    if (z) {
                        czx czxVarCs = RecyclerView.cs(view);
                        czoVar.t(czxVarCs);
                        czoVar.q(czxVarCs);
                        if (RecyclerView.b) {
                            Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                        }
                    }
                    recyclerView.ew(!z);
                    if (z && czxVar.ah()) {
                        recyclerView.removeDetachedView(view, false);
                        return;
                    }
                } catch (Throwable th) {
                    yiVar.b = 0;
                    throw th;
                }
            }
            if (((View) yiVar.f) != view) {
                throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
            }
            z = false;
            if (z) {
                czx czxVarCs2 = RecyclerView.cs(view);
                czoVar.t(czxVarCs2);
                czoVar.q(czxVarCs2);
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                }
            }
            recyclerView.ew(!z);
            if (z) {
            }
        }
    }

    public abstract boolean o(czx czxVar, czx czxVar2, cjn cjnVar, cjn cjnVar2);

    public abstract void p(czx czxVar);

    public abstract void q();

    public abstract boolean r();
}
