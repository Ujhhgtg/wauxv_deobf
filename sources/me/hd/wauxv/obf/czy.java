package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czy extends AccessibilityDelegateCompat {
    public final czz a;
    public final WeakHashMap b = new WeakHashMap();

    public czy(czz czzVar) {
        this.a = czzVar;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void onInitializeAccessibilityNodeInfo(View view, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        czz czzVar = this.a;
        androidx.recyclerview.widget.RecyclerView recyclerView = czzVar.a;
        androidx.recyclerview.widget.RecyclerView recyclerView2 = czzVar.a;
        boolean zDx = recyclerView.dx();
        View.AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        if (zDx || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().ez(view, bdVar);
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            aqVar.onInitializeAccessibilityNodeInfo(view, bdVar);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        czz czzVar = this.a;
        androidx.recyclerview.widget.RecyclerView recyclerView = czzVar.a;
        androidx.recyclerview.widget.RecyclerView recyclerView2 = czzVar.a;
        if (recyclerView.dx() || recyclerView2.getLayoutManager() == null) {
            return super.performAccessibilityAction(view, i, bundle);
        }
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            if (aqVar.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
        } else if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerViewVar = recyclerView2.getLayoutManager().dp.m;
        return false;
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean i(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        return aqVar != null ? aqVar.i(view, accessibilityEvent) : this.accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // me.hd.wauxv.obf.aq
    public final erp j(View view) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        return aqVar != null ? aqVar.j(view) : super.j(view);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void initializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            aqVar.initializeAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.initializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final void populateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            aqVar.populateAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.populateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean requestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(viewGroup);
        return aqVar != null ? aqVar.requestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : this.accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void sendAccessibilityEvent(View view, int i) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            aqVar.sendAccessibilityEvent(view, i);
        } else {
            super.sendAccessibilityEvent(view, i);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat aqVar = (AccessibilityDelegateCompat) this.b.get(view);
        if (aqVar != null) {
            aqVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        } else {
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
}
