package me.hd.wauxv.obf;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ar implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final qp a;

    public ar(qp qpVar) {
        this.a = qpVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ar) {
            return this.a.equals(((ar) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        aql aqlVar = (aql) this.a.c;
        AutoCompleteTextView autoCompleteTextView = aqlVar.d;
        if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
            return;
        }
        CheckableImageButton checkableImageButton = aqlVar.ai;
        int i = z ? 2 : 1;
        WeakHashMap weakHashMap = ViewCompat.a;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
