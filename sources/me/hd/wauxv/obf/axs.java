package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class axs extends aq {
    public static final Rect t = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final awp u = new awp(1);
    public static final awp v = new awp(2);
    public final AccessibilityManager aa;
    public final View ab;
    public axr ac;
    public final Rect w = new Rect();
    public final Rect x = new Rect();
    public final Rect y = new Rect();
    public final int[] z = new int[2];
    public int ad = Integer.MIN_VALUE;
    public int ae = Integer.MIN_VALUE;
    public int af = Integer.MIN_VALUE;

    public axs(View view) {
        this.ab = view;
        this.aa = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = eqz.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public void _au(bd bdVar) {
    }

    public final boolean ag(int i) {
        if (this.ae != i) {
            return false;
        }
        this.ae = Integer.MIN_VALUE;
        s(i, false);
        ao(i, 8);
        return true;
    }

    public final AccessibilityEvent ah(int i, int i2) {
        View view = this.ab;
        if (i == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i2);
        bd bdVarAm = am(i);
        accessibilityEventObtain2.getText().add(bdVarAm.i());
        AccessibilityNodeInfo accessibilityNodeInfo = bdVarAm.a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        accessibilityEventObtain2.setSource(view, i);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final bd ai(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        bd bdVar = new bd(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        bdVar.k("android.view.View");
        Rect rect = t;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        View view = this.ab;
        accessibilityNodeInfoObtain.setParent(view);
        r(i, bdVar);
        if (bdVar.i() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.x;
        bdVar.h(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        bdVar.b = i;
        accessibilityNodeInfoObtain.setSource(view, i);
        if (this.ad == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            bdVar.d(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            bdVar.d(64);
        }
        boolean z = this.ae == i;
        if (z) {
            bdVar.d(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            bdVar.d(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.z;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.w;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            bdVar.h(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.y;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (parent instanceof View) {
                        View view2 = (View) parent;
                        if (view2.getAlpha() > 0.0f && view2.getVisibility() == 0) {
                            parent = view2.getParent();
                        }
                    }
                    if (parent != null) {
                        accessibilityNodeInfoObtain.setVisibleToUser(true);
                    }
                }
            }
        }
        return bdVar;
    }

    public final boolean aj(MotionEvent motionEvent) {
        int i;
        AccessibilityManager accessibilityManager = this.aa;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iC = c(motionEvent.getX(), motionEvent.getY());
            int i2 = this.af;
            if (i2 != iC) {
                this.af = iC;
                ao(iC, 128);
                ao(i2, 256);
            }
            if (iC == Integer.MIN_VALUE) {
                return false;
            }
        } else {
            if (action != 10 || (i = this.af) == Integer.MIN_VALUE) {
                return false;
            }
            if (i != Integer.MIN_VALUE) {
                this.af = Integer.MIN_VALUE;
                ao(Integer.MIN_VALUE, 128);
                ao(i, 256);
                return true;
            }
        }
        return true;
    }

    public final void ak(int i) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.aa.isEnabled() || (parent = (view = this.ab).getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventAh = ah(i, 2048);
        accessibilityEventAh.setContentChangeTypes(0);
        parent.requestSendAccessibilityEvent(view, accessibilityEventAh);
    }

    /* JADX WARN: Found duplicated region for block: B:118:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:119:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:120:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:121:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:40:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:41:0x00be A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:42:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Found duplicated region for block: B:44:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00d4  */
    /* JADX WARN: Found duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Found duplicated region for block: B:48:0x00eb  */
    /* JADX WARN: Found duplicated region for block: B:51:0x0106  */
    /* JADX WARN: Found duplicated region for block: B:54:0x010f  */
    /* JADX WARN: Found duplicated region for block: B:57:0x011c  */
    /* JADX WARN: Found duplicated region for block: B:66:0x0131  */
    /* JADX WARN: Found duplicated region for block: B:68:0x014f  */
    /* JADX WARN: Found duplicated region for block: B:89:0x01a9  */
    public final boolean al(int i, Rect rect) {
        int i2;
        int i3;
        Object obj;
        bd bdVar;
        int i4;
        int iG;
        int i5;
        Rect rect2;
        int i6;
        Rect rect3;
        int i7;
        bd bdVar2;
        int i8;
        int iAg;
        int iAj;
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        dlo dloVar = new dlo(0);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            dloVar.h(((Integer) arrayList.get(i9)).intValue(), ai(((Integer) arrayList.get(i9)).intValue()));
        }
        int i10 = this.ae;
        bd bdVar3 = i10 == Integer.MIN_VALUE ? null : (bd) dloVar.f(i10);
        awp awpVar = u;
        awp awpVar2 = v;
        View view = this.ab;
        if (i == 1 || i == 2) {
            i2 = 0;
            i3 = -1;
            WeakHashMap weakHashMap = eqz.a;
            boolean z = view.getLayoutDirection() == 1;
            awpVar2.getClass();
            int i11 = dloVar.i();
            ArrayList arrayList2 = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList2.add((bd) dloVar.j(i12));
            }
            Collections.sort(arrayList2, new bbq(z, awpVar));
            if (i == 1) {
                int size = arrayList2.size();
                if (bdVar3 != null) {
                    size = arrayList2.indexOf(bdVar3);
                }
                int i13 = size - 1;
                if (i13 >= 0) {
                    obj = arrayList2.get(i13);
                }
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int size2 = arrayList2.size();
                int iLastIndexOf = (bdVar3 == null ? -1 : arrayList2.lastIndexOf(bdVar3)) + 1;
                obj = iLastIndexOf < size2 ? arrayList2.get(iLastIndexOf) : null;
            }
            bdVar = (bd) obj;
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect4 = new Rect();
            int i14 = this.ae;
            if (i14 != Integer.MIN_VALUE) {
                am(i14).h(rect4);
            } else {
                if (rect != null) {
                    rect4.set(rect);
                } else {
                    int width = view.getWidth();
                    int height = view.getHeight();
                    if (i == 17) {
                        i5 = -1;
                        rect4.set(width, 0, width, height);
                    } else if (i == 33) {
                        i5 = -1;
                        rect4.set(0, height, width, height);
                    } else if (i == 66) {
                        i5 = -1;
                        rect4.set(-1, 0, -1, height);
                    } else {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        i5 = -1;
                        rect4.set(0, -1, width, -1);
                    }
                }
                rect2 = new Rect(rect4);
                if (i != 17) {
                    i2 = 0;
                    rect2.offset(rect4.width() + 1, 0);
                } else if (i != 33) {
                    i2 = 0;
                    rect2.offset(0, rect4.height() + 1);
                } else if (i != 66) {
                    i2 = 0;
                    rect2.offset(-(rect4.width() + 1), 0);
                } else {
                    if (i == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i2 = 0;
                    rect2.offset(0, -(rect4.height() + 1));
                }
                awpVar2.getClass();
                i6 = dloVar.i();
                rect3 = new Rect();
                bdVar = null;
                for (i7 = i2; i7 < i6; i7++) {
                    bdVar2 = (bd) dloVar.j(i7);
                    if (bdVar2 == bdVar3) {
                        awpVar.getClass();
                        bdVar2.h(rect3);
                        if (bzo.ac(i, rect4, rect3)) {
                            if (bzo.ac(i, rect4, rect2) || bzo.g(i, rect4, rect3, rect2)) {
                                rect2.set(rect3);
                                bdVar = bdVar2;
                            } else if (bzo.g(i, rect4, rect2, rect3)) {
                                int iAg2 = bzo.ag(i, rect4, rect3);
                                int iAj2 = bzo.aj(i, rect4, rect3);
                                i8 = (iAj2 * iAj2) + (iAg2 * 13 * iAg2);
                                iAg = bzo.ag(i, rect4, rect2);
                                iAj = bzo.aj(i, rect4, rect2);
                                if (i8 < (iAj * iAj) + (iAg * 13 * iAg)) {
                                    rect2.set(rect3);
                                    bdVar = bdVar2;
                                }
                            }
                        }
                    }
                }
                i3 = i5;
            }
            i5 = -1;
            rect2 = new Rect(rect4);
            if (i != 17) {
                i2 = 0;
                rect2.offset(rect4.width() + 1, 0);
            } else if (i != 33) {
                i2 = 0;
                rect2.offset(0, rect4.height() + 1);
            } else if (i != 66) {
                i2 = 0;
                rect2.offset(-(rect4.width() + 1), 0);
            } else {
                if (i == 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                i2 = 0;
                rect2.offset(0, -(rect4.height() + 1));
            }
            awpVar2.getClass();
            i6 = dloVar.i();
            rect3 = new Rect();
            bdVar = null;
            while (i7 < i6) {
                bdVar2 = (bd) dloVar.j(i7);
                if (bdVar2 == bdVar3) {
                    awpVar.getClass();
                    bdVar2.h(rect3);
                    if (bzo.ac(i, rect4, rect3)) {
                        if (bzo.ac(i, rect4, rect2)) {
                            rect2.set(rect3);
                            bdVar = bdVar2;
                        } else if (bzo.g(i, rect4, rect2, rect3)) {
                            int iAg22 = bzo.ag(i, rect4, rect3);
                            int iAj22 = bzo.aj(i, rect4, rect3);
                            i8 = (iAj22 * iAj22) + (iAg22 * 13 * iAg22);
                            iAg = bzo.ag(i, rect4, rect2);
                            iAj = bzo.aj(i, rect4, rect2);
                            if (i8 < (iAj * iAj) + (iAg * 13 * iAg)) {
                                rect2.set(rect3);
                                bdVar = bdVar2;
                            }
                        }
                    }
                }
            }
            i3 = i5;
        }
        bd bdVar4 = bdVar;
        if (bdVar4 == null) {
            iG = Integer.MIN_VALUE;
        } else {
            if (dloVar.a) {
                bht.q(dloVar);
            }
            int i15 = dloVar.d;
            int i16 = i2;
            while (true) {
                if (i16 >= i15) {
                    i4 = i3;
                    break;
                }
                if (dloVar.c[i16] == bdVar4) {
                    i4 = i16;
                    break;
                }
                i16++;
            }
            iG = dloVar.g(i4);
        }
        return an(iG);
    }

    public final bd am(int i) {
        if (i != -1) {
            return ai(i);
        }
        View view = this.ab;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        bd bdVar = new bd(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = eqz.a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            bdVar.a.addChild(view, ((Integer) arrayList.get(i2)).intValue());
        }
        return bdVar;
    }

    public final boolean an(int i) {
        int i2;
        View view = this.ab;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.ae) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            ag(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.ae = i;
        s(i, true);
        ao(i, 8);
        return true;
    }

    public final void ao(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.aa.isEnabled() || (parent = (view = this.ab).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, ah(i, i2));
    }

    public abstract int c(float f, float f2);

    @Override // me.hd.wauxv.obf.aq
    public final void d(View view, bd bdVar) {
        this.g.onInitializeAccessibilityNodeInfo(view, bdVar.a);
        _au(bdVar);
    }

    @Override // me.hd.wauxv.obf.aq
    public final erp j(View view) {
        if (this.ac == null) {
            this.ac = new axr(this);
        }
        return this.ac;
    }

    public abstract void p(ArrayList arrayList);

    public abstract boolean q(int i, int i2, Bundle bundle);

    public abstract void r(int i, bd bdVar);

    public void s(int i, boolean z) {
    }
}
