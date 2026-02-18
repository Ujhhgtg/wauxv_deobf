package me.hd.wauxv.obf;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eko implements ccm {
    public cbw a;
    public cbz b;
    public final /* synthetic */ Toolbar c;

    public eko(Toolbar toolbar) {
        this.c = toolbar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ab(cbz cbzVar) {
        Toolbar toolbar = this.c;
        toolbar.ax();
        ViewParent parent = toolbar.h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.h);
            }
            toolbar.addView(toolbar.h);
        }
        View actionView = cbzVar.getActionView();
        toolbar.i = actionView;
        this.b = cbzVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.i);
            }
            ekp ekpVarAr = Toolbar.ar();
            ekpVarAr.a = (toolbar.n & 112) | 8388611;
            ekpVarAr.b = 2;
            toolbar.i.setLayoutParams(ekpVarAr);
            toolbar.addView(toolbar.i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((ekp) childAt.getLayoutParams()).b != 2 && childAt != toolbar.a) {
                toolbar.removeViewAt(childCount);
                toolbar.ae.add(childAt);
            }
        }
        toolbar.requestLayout();
        cbzVar.ae = true;
        cbzVar.n.ao(false);
        KeyEvent.Callback callback = toolbar.i;
        if (callback instanceof aar) {
            ((ccb) ((aar) callback)).a.onActionViewExpanded();
        }
        toolbar.bl();
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        if (this.b != null) {
            cbw cbwVar = this.a;
            if (cbwVar != null) {
                int size = cbwVar.g.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        return;
                    }
                }
            }
            ae(this.b);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ad() {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ae(cbz cbzVar) {
        Toolbar toolbar = this.c;
        KeyEvent.Callback callback = toolbar.i;
        if (callback instanceof aar) {
            ((ccb) ((aar) callback)).a.onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.i);
        toolbar.removeView(toolbar.h);
        toolbar.i = null;
        ArrayList arrayList = toolbar.ae;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.b = null;
        toolbar.requestLayout();
        cbzVar.ae = false;
        cbzVar.n.ao(false);
        toolbar.bl();
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void af(Context context, cbw cbwVar) {
        cbz cbzVar;
        cbw cbwVar2 = this.a;
        if (cbwVar2 != null && (cbzVar = this.b) != null) {
            cbwVar2.ac(cbzVar);
        }
        this.a = cbwVar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        return null;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final int getId() {
        return 0;
    }
}
