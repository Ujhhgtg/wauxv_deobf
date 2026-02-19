package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cah extends AccessibilityDelegateCompat {
    public final /* synthetic */ int a;

    public /* synthetic */ cah(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void onInitializeAccessibilityNodeInfo(View view, bd bdVar) {
        int scrollRange;
        switch (this.a) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
                this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
                break;
            case 1:
                this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, bdVar.a);
                bdVar.m(false);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = bdVar.a;
                this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCollectionInfo(null);
                break;
            default:
                this.accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, bdVar.a);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                bdVar.k(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    bdVar.m(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bdVar.e(ax.c);
                        bdVar.e(ax.h);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        bdVar.e(ax.b);
                        bdVar.e(ax.i);
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Found duplicated region for block: B:31:0x0092  */
    @Override // me.hd.wauxv.obf.aq
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        int iMin;
        switch (this.a) {
            case 3:
                if (super.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                if (nestedScrollView.isEnabled()) {
                    int height = nestedScrollView.getHeight();
                    Rect rect = new Rect();
                    if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                        height = rect.height();
                    }
                    if (i == 4096) {
                        iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                        if (iMin != nestedScrollView.getScrollY()) {
                            nestedScrollView.az(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    } else if (i == 8192 || i == 16908344) {
                        int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                        if (iMax != nestedScrollView.getScrollY()) {
                            nestedScrollView.az(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    } else if (i == 16908346) {
                        iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                        if (iMin != nestedScrollView.getScrollY()) {
                            nestedScrollView.az(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    }
                }
                return false;
            default:
                return super.performAccessibilityAction(view, i, bundle);
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public void initializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.a) {
            case 3:
                super.initializeAccessibilityEvent(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
                break;
            default:
                super.initializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }
}
