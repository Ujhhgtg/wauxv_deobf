package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czy extends aq {
    public final czz a;
    public final WeakHashMap b = new WeakHashMap();

    public czy(czz czzVar) {
        this.a = czzVar;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void d(View view, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        czz czzVar = this.a;
        RecyclerView recyclerView = czzVar.a;
        RecyclerView recyclerView2 = czzVar.a;
        boolean zDx = recyclerView.dx();
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        if (zDx || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().ez(view, bdVar);
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            aqVar.d(view, bdVar);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean e(View view, int i, Bundle bundle) {
        czz czzVar = this.a;
        RecyclerView recyclerView = czzVar.a;
        RecyclerView recyclerView2 = czzVar.a;
        if (recyclerView.dx() || recyclerView2.getLayoutManager() == null) {
            return super.e(view, i, bundle);
        }
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            if (aqVar.e(view, i, bundle)) {
                return true;
            }
        } else if (super.e(view, i, bundle)) {
            return true;
        }
        czo czoVar = recyclerView2.getLayoutManager().dp.m;
        return false;
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean i(View view, AccessibilityEvent accessibilityEvent) {
        aq aqVar = (aq) this.b.get(view);
        return aqVar != null ? aqVar.i(view, accessibilityEvent) : this.g.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // me.hd.wauxv.obf.aq
    public final erp j(View view) {
        aq aqVar = (aq) this.b.get(view);
        return aqVar != null ? aqVar.j(view) : super.j(view);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void k(View view, AccessibilityEvent accessibilityEvent) {
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            aqVar.k(view, accessibilityEvent);
        } else {
            super.k(view, accessibilityEvent);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final void l(View view, AccessibilityEvent accessibilityEvent) {
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            aqVar.l(view, accessibilityEvent);
        } else {
            super.l(view, accessibilityEvent);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean m(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        aq aqVar = (aq) this.b.get(viewGroup);
        return aqVar != null ? aqVar.m(viewGroup, view, accessibilityEvent) : this.g.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void n(View view, int i) {
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            aqVar.n(view, i);
        } else {
            super.n(view, i);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final void o(View view, AccessibilityEvent accessibilityEvent) {
        aq aqVar = (aq) this.b.get(view);
        if (aqVar != null) {
            aqVar.o(view, accessibilityEvent);
        } else {
            super.o(view, accessibilityEvent);
        }
    }
}
