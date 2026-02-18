package me.hd.wauxv.obf;

import android.app.ActivityOptions;
import android.app.Notification;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bb {
    public static int a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getChecked();
    }

    public static int b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExpandedState();
    }

    public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getSupplementalDescription();
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isFieldRequired();
    }

    public static void e(ActivityOptions activityOptions, boolean z) {
        activityOptions.setAllowPassThroughOnTouchOutside(z);
    }

    public static void f(Notification.Builder builder) {
        builder.setShortCriticalText(null);
    }
}
