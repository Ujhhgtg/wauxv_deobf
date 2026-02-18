package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eqz {
    public static WeakHashMap a;
    public static Field b;
    public static boolean c;
    public static final int[] d = { R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1,
            R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4,
            R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7,
            R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10,
            R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12,
            R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14,
            R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16,
            R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18,
            R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20,
            R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22,
            R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24,
            R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26,
            R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28,
            R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30,
            R.id.accessibility_custom_action_31 };
    public static final eql e = new eql();
    public static final eqn f = new eqn();

    public static esg g(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        esg esgVar = (esg) a.get(view);
        if (esgVar != null) {
            return esgVar;
        }
        esg esgVar2 = new esg(view);
        a.put(view, esgVar2);
        return esgVar2;
    }

    public static void h(View view, evr evrVar) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsI = evrVar.i();
        if (windowInsetsI != null) {
            WindowInsets windowInsetsA = i >= 30 ? eqw.a(view, windowInsetsI) : eqo.a(view, windowInsetsI);
            if (windowInsetsA.equals(windowInsetsI)) {
                return;
            }
            evr.d(view, windowInsetsA);
        }
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = eqy.a;
        eqy eqyVar = (eqy) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (eqyVar == null) {
            eqyVar = new eqy();
            eqyVar.b = null;
            eqyVar.c = null;
            eqyVar.d = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, eqyVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = eqyVar.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = eqy.a;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (eqyVar.b == null) {
                            eqyVar.b = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = eqy.a;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                eqyVar.b.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent
                                        .getParent()) {
                                    eqyVar.b.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewE = eqyVar.e(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewE != null && !KeyEvent.isModifierKey(keyCode)) {
                if (eqyVar.c == null) {
                    eqyVar.c = new SparseArray();
                }
                eqyVar.c.put(keyCode, new WeakReference(viewE));
            }
        }
        return viewE != null;
    }

    public static View.AccessibilityDelegate j(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return eqv.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence k(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = equ.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList l(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] m(ih ihVar) {
        return Build.VERSION.SDK_INT >= 31 ? eqx.a(ihVar)
                : (String[]) ihVar.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void n(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext()
                .getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = k(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(k(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName()
                                .concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(k(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static afm o(View view, afm afmVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + afmVar + ", view=" + view.getClass().getSimpleName() + "["
                    + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return eqx.tryGetClassByName(view, afmVar);
        }
        dri driVar = (dri) view.getTag(R.id.tag_on_receive_content_listener);
        crb crbVar = e;
        if (driVar == null) {
            if (view instanceof crb) {
                crbVar = (crb) view;
            }
            return crbVar.i(afmVar);
        }
        afm afmVarA = dri.a(view, afmVar);
        if (afmVarA == null) {
            return null;
        }
        if (view instanceof crb) {
            crbVar = (crb) view;
        }
        return crbVar.i(afmVarA);
    }

    public static void p(View view, int i) {
        ArrayList arrayListL = l(view);
        for (int i2 = 0; i2 < arrayListL.size(); i2++) {
            if (((ax) arrayListL.get(i2)).p() == i) {
                arrayListL.remove(i2);
                return;
            }
        }
    }

    public static void q(View view, ax axVar, bm bmVar) {
        ax axVar2 = new ax(null, axVar.m, null, bmVar, axVar.n);
        View.AccessibilityDelegate accessibilityDelegateJ = j(view);
        aq aqVar = accessibilityDelegateJ == null ? null
                : accessibilityDelegateJ instanceof ap ? ((ap) accessibilityDelegateJ).a
                        : new aq(accessibilityDelegateJ);
        if (aqVar == null) {
            aqVar = new aq();
        }
        s(view, aqVar);
        p(view, axVar2.p());
        l(view).add(axVar2);
        n(view, 0);
    }

    public static void r(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray,
            int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            eqv.b(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void s(View view, aq aqVar) {
        if (aqVar == null && (j(view) instanceof ap)) {
            aqVar = new aq();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(aqVar == null ? null : aqVar.h);
    }

    public static void t(View view, CharSequence charSequence) {
        new eqm(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).k(view, charSequence);
        eqn eqnVar = f;
        if (charSequence == null) {
            eqnVar.a.remove(view);
            view.removeOnAttachStateChangeListener(eqnVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(eqnVar);
        } else {
            eqnVar.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(eqnVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(eqnVar);
            }
        }
    }

    public static void u(View view, ua uaVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new eux(uaVar));
            return;
        }
        PathInterpolator pathInterpolator = euw.a;
        View.OnApplyWindowInsetsListener euvVar = new euv(view, uaVar);
        view.setTag(R.id.tag_window_insets_animation_callback, euvVar);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null
                && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(euvVar);
        }
    }
}
