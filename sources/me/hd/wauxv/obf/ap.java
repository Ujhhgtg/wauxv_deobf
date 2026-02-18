package me.hd.wauxv.obf;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ap extends View.AccessibilityDelegate {
    public final aq a;

    public ap(aq aqVar) {
        this.a = aqVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.i(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        erp erpVarJ = this.a.j(view);
        if (erpVarJ != null) {
            return (AccessibilityNodeProvider) erpVarJ.v;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.k(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        bd bdVar = new bd(accessibilityNodeInfo);
        WeakHashMap weakHashMap = eqz.a;
        Object objB = null;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(equ.c(view));
        } else {
            tag = view.getTag(R.id.tag_screen_reader_focusable);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        boolean z = bool != null && bool.booleanValue();
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z);
        } else {
            bdVar.j(1, z);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(equ.b(view));
        } else {
            tag2 = view.getTag(R.id.tag_accessibility_heading);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z2 = bool2 != null && bool2.booleanValue();
        if (i >= 28) {
            accessibilityNodeInfo.setHeading(z2);
        } else {
            bdVar.j(2, z2);
        }
        CharSequence charSequenceK = eqz.k(view);
        if (i >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequenceK);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequenceK);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            objB = eqw.b(view);
        } else {
            Object tag3 = view.getTag(R.id.tag_state_description);
            if (CharSequence.class.isInstance(tag3)) {
                objB = tag3;
            }
        }
        CharSequence charSequence = (CharSequence) objB;
        if (i >= 30) {
            ay.f(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.a.d(view, bdVar);
        accessibilityNodeInfo.getText();
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            bdVar.e((ax) list.get(i2));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.l(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.m(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.a.e(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i) {
        this.a.n(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.a.o(view, accessibilityEvent);
    }
}
