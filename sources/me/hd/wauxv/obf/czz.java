package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czz extends AccessibilityDelegateCompat {
    public final RecyclerView a;
    public final czy b;

    public czz(RecyclerView recyclerView) {
        this.a = recyclerView;
        czy czyVar = this.b;
        if (czyVar != null) {
            this.b = czyVar;
        } else {
            this.b = new czy(this);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final void onInitializeAccessibilityNodeInfo(View view, bd bdVar) {
        this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, bdVar.a);
        RecyclerView recyclerView = this.a;
        if (recyclerView.dx() || recyclerView.getLayoutManager() == null) {
            return;
        }
        czg layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.dp;
        layoutManager.x(recyclerView2.m, recyclerView2.bo, bdVar);
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.a;
        if (recyclerView.dx() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().ag(i, bundle);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void initializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.initializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.a.dx()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().ce(accessibilityEvent);
        }
    }
}
