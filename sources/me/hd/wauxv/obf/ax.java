package me.hd.wauxv.obf;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ax {
    public static final ax a;
    public static final ax b;
    public static final ax c;
    public static final ax d;
    public static final ax e;
    public static final ax f;
    public static final ax g;
    public static final ax h;
    public static final ax i;
    public static final ax j;
    public static final ax k;
    public final Object l;
    public final int m;
    public final Class n;
    public final bm o;

    static {
        new ax(1);
        new ax(2);
        new ax(4);
        new ax(8);
        a = new ax(16);
        new ax(32);
        new ax(64);
        new ax(128);
        new ax(256, bf.class);
        new ax(512, bf.class);
        new ax(1024, bg.class);
        new ax(2048, bg.class);
        b = new ax(4096);
        c = new ax(8192);
        new ax(16384);
        new ax(32768);
        new ax(65536);
        new ax(131072, bk.class);
        d = new ax(262144);
        e = new ax(Opcodes.ASM8);
        f = new ax(1048576);
        new ax(2097152, bl.class);
        int i2 = Build.VERSION.SDK_INT;
        new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        g = new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, bi.class);
        h = new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        i = new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new ax(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new ax(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new ax(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new ax(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        j = new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, bj.class);
        new ax(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, bh.class);
        new ax(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new ax(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new ax(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new ax(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new ax(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new ax(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new ax(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new ax(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        k = new ax(i2 >= 34 ? ba.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public ax(int i2) {
        this(null, i2, null, null, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ax)) {
            return false;
        }
        Object obj2 = ((ax) obj).l;
        Object obj3 = this.l;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.l;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final int p() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.l).getId();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strC = bd.c(this.m);
        if (strC.equals("ACTION_UNKNOWN")) {
            Object obj = this.l;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strC = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strC);
        return sb.toString();
    }

    public ax(int i2, Class cls) {
        this(null, i2, null, null, cls);
    }

    public ax(Object obj, int i2, String str, bm bmVar, Class cls) {
        this.m = i2;
        this.o = bmVar;
        if (obj == null) {
            this.l = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
        } else {
            this.l = obj;
        }
        this.n = cls;
    }
}
