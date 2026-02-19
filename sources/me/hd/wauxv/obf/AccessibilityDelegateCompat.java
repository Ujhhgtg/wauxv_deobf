package me.hd.wauxv.obf;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    public static final View.AccessibilityDelegate INSTANCE = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate accessibilityDelegate;
    public final AccessibilityDelegateCompat$AccessibilityDelegateAdapter h;

    public AccessibilityDelegateCompat() {
        this(INSTANCE);
    }

    public void onInitializeAccessibilityNodeInfo(View view, bd bdVar) {
        this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, bdVar.a);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < list.size()) {
                ax axVar = (ax) list.get(i2);
                if (axVar.p() == i) {
                    Class cls = axVar.n;
                    IHandlesSwipeDismiss bmVar = axVar.o;
                    if (bmVar != null) {
                        if (cls != null) {
                            try {
                                if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                    throw null;
                                }
                                throw new ClassCastException();
                            } catch (Exception e) {
                                Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e);
                            }
                        }
                        zPerformAccessibilityAction = bmVar.handleSwipeDismiss(view);
                        break;
                    }
                } else {
                    i2++;
                }
            }
            zPerformAccessibilityAction = false;
            break;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
        if (zPerformAccessibilityAction || i != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i3)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i4 = 0; clickableSpanArr != null && i4 < clickableSpanArr.length; i4++) {
                if (clickableSpan.equals(clickableSpanArr[i4])) {
                    clickableSpan.onClick(view);
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public boolean i(View view, AccessibilityEvent accessibilityEvent) {
        return this.accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public erp j(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.accessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new erp(accessibilityNodeProvider, 1);
        }
        return null;
    }

    public void initializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void populateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean requestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.accessibilityDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.accessibilityDelegate = accessibilityDelegate;
        this.h = new AccessibilityDelegateCompat$AccessibilityDelegateAdapter(this);
    }
}
