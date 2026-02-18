package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hw implements Window.Callback {
    public final Window.Callback a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ ic e;

    public hw(ic icVar, Window.Callback callback) {
        this.e = icVar;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.a = callback;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.c;
        Window.Callback callback = this.a;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.e.cd(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Found duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Found duplicated region for block: B:27:0x0056  */
    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        ib ibVar;
        boolean z;
        boolean zCo;
        cbw cbwVar;
        boolean zPerformShortcut;
        if (!this.a.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            ic icVar = this.e;
            icVar.cj();
            eut eutVar = icVar.ab;
            if (eutVar == null) {
                ibVar = icVar.az;
                if (ibVar == null && icVar.co(ibVar, keyEvent.getKeyCode(), keyEvent)) {
                    ib ibVar2 = icVar.az;
                    if (ibVar2 != null) {
                        ibVar2.l = true;
                    }
                } else {
                    if (icVar.az == null) {
                        ib ibVarCi = icVar.ci(0);
                        icVar.cp(ibVarCi, keyEvent);
                        zCo = icVar.co(ibVarCi, keyEvent.getKeyCode(), keyEvent);
                        ibVarCi.k = false;
                        if (zCo) {
                        }
                    }
                    z = false;
                }
                z = true;
            } else {
                eus eusVar = eutVar.ax;
                if (eusVar == null || (cbwVar = eusVar.r) == null) {
                    zPerformShortcut = false;
                } else {
                    cbwVar.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
                    zPerformShortcut = cbwVar.performShortcut(keyCode, keyEvent, 0);
                }
                if (zPerformShortcut) {
                    z = true;
                } else {
                    ibVar = icVar.az;
                    if (ibVar == null) {
                        if (icVar.az == null) {
                            ib ibVarCi2 = icVar.ci(0);
                            icVar.cp(ibVarCi2, keyEvent);
                            zCo = icVar.co(ibVarCi2, keyEvent.getKeyCode(), keyEvent);
                            ibVarCi2.k = false;
                            if (zCo) {
                                z = true;
                            }
                        }
                        z = false;
                    } else {
                        if (icVar.az == null) {
                            ib ibVarCi22 = icVar.ci(0);
                            icVar.cp(ibVarCi22, keyEvent);
                            zCo = icVar.co(ibVarCi22, keyEvent.getKeyCode(), keyEvent);
                            ibVarCi22.k = false;
                            if (zCo) {
                                z = true;
                            }
                        }
                        z = false;
                    }
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    public final void f(Window.Callback callback) {
        try {
            this.b = true;
            callback.onContentChanged();
        } finally {
            this.b = false;
        }
    }

    public final boolean g(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    public final void h(int i, Menu menu) {
        this.a.onPanelClosed(i, menu);
    }

    public final void i(List list, Menu menu, int i) {
        eup.a(this.a, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.b) {
            this.a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof cbw)) {
            return this.a.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        g(i, menu);
        if (i == 108) {
            ic icVar = this.e;
            icVar.cj();
            eut eutVar = icVar.ab;
            if (eutVar != null) {
                ArrayList arrayList = eutVar.bb;
                if (true != eutVar.ba) {
                    eutVar.ba = true;
                    if (arrayList.size() > 0) {
                        arrayList.get(0).getClass();
                        throw new ClassCastException();
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.d) {
            this.a.onPanelClosed(i, menu);
            return;
        }
        h(i, menu);
        ic icVar = this.e;
        if (i != 108) {
            if (i == 0) {
                ib ibVarCi = icVar.ci(i);
                if (ibVarCi.m) {
                    icVar.cc(ibVarCi, false);
                    return;
                }
                return;
            }
            return;
        }
        icVar.cj();
        eut eutVar = icVar.ab;
        if (eutVar != null) {
            ArrayList arrayList = eutVar.bb;
            if (eutVar.ba) {
                eutVar.ba = false;
                if (arrayList.size() <= 0) {
                    return;
                }
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        euq.a(this.a, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        cbw cbwVar = menu instanceof cbw ? (cbw) menu : null;
        if (i == 0 && cbwVar == null) {
            return false;
        }
        if (cbwVar != null) {
            cbwVar.y = true;
        }
        boolean zOnPreparePanel = this.a.onPreparePanel(i, view, menu);
        if (cbwVar != null) {
            cbwVar.y = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        cbw cbwVar = this.e.ci(0).h;
        if (cbwVar != null) {
            i(list, cbwVar, i);
        } else {
            i(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return euo.a(this.a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        if (i != 0) {
            return euo.b(this.a, callback, i);
        }
        ic icVar = this.e;
        Context context = icVar.x;
        chm chmVar = new chm();
        chmVar.e = context;
        chmVar.d = callback;
        chmVar.c = new ArrayList();
        boolean z = false;
        chmVar.f = new dhq(0);
        da daVar = icVar.ah;
        if (daVar != null) {
            daVar.c();
        }
        io ioVar = new io(icVar, chmVar, 3, z);
        icVar.cj();
        eut eutVar = icVar.ab;
        int i2 = 1;
        if (eutVar != null) {
            eus eusVar = eutVar.ax;
            if (eusVar != null) {
                eusVar.c();
            }
            eutVar.ar.setHideOnContentScrollEnabled(false);
            eutVar.au.aa();
            eus eusVar2 = new eus(eutVar, eutVar.au.getContext(), ioVar);
            cbw cbwVar = eusVar2.r;
            cbwVar.av();
            try {
                boolean zAn = ((chm) eusVar2.s.c).an(eusVar2, cbwVar);
                cbwVar.au();
                if (zAn) {
                    eutVar.ax = eusVar2;
                    eusVar2.i();
                    eutVar.au.y(eusVar2);
                    eutVar.bn(true);
                } else {
                    eusVar2 = null;
                }
                icVar.ah = eusVar2;
            } catch (Throwable th) {
                cbwVar.au();
                throw th;
            }
        }
        if (icVar.ah == null) {
            esg esgVar = icVar.al;
            if (esgVar != null) {
                esgVar.c();
            }
            da daVar2 = icVar.ah;
            if (daVar2 != null) {
                daVar2.c();
            }
            if (icVar.ai == null) {
                if (icVar.av) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        afv afvVar = new afv(context, 0);
                        afvVar.getTheme().setTo(themeNewTheme);
                        context = afvVar;
                    }
                    icVar.ai = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    icVar.aj = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    icVar.aj.setContentView(icVar.ai);
                    icVar.aj.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    icVar.ai.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    icVar.aj.setHeight(-2);
                    icVar.ak = new hp(icVar, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) icVar.an.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        icVar.cj();
                        eut eutVar2 = icVar.ab;
                        Context contextBo = eutVar2 != null ? eutVar2.bo() : null;
                        if (contextBo != null) {
                            context = contextBo;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        icVar.ai = (ActionBarContextView) viewStubCompat.e();
                    }
                }
            }
            if (icVar.ai != null) {
                esg esgVar2 = icVar.al;
                if (esgVar2 != null) {
                    esgVar2.c();
                }
                icVar.ai.aa();
                Context context2 = icVar.ai.getContext();
                ActionBarContextView actionBarContextView = icVar.ai;
                dme dmeVar = new dme();
                dmeVar.q = context2;
                dmeVar.r = actionBarContextView;
                dmeVar.s = ioVar;
                cbw cbwVar2 = new cbw(actionBarContextView.getContext());
                cbwVar2.m = 1;
                dmeVar.v = cbwVar2;
                cbwVar2.f = dmeVar;
                if (chmVar.an(dmeVar, cbwVar2)) {
                    dmeVar.i();
                    icVar.ai.y(dmeVar);
                    icVar.ah = dmeVar;
                    if (icVar.am && (viewGroup = icVar.an) != null && viewGroup.isLaidOut()) {
                        icVar.ai.setAlpha(0.0f);
                        esg esgVarG = eqz.g(icVar.ai);
                        esgVarG.b(1.0f);
                        icVar.al = esgVarG;
                        esgVarG.e(new hr(icVar, i2));
                    } else {
                        icVar.ai.setAlpha(1.0f);
                        icVar.ai.setVisibility(0);
                        if (icVar.ai.getParent() instanceof View) {
                            View view = (View) icVar.ai.getParent();
                            WeakHashMap weakHashMap = eqz.a;
                            eqo.c(view);
                        }
                    }
                    if (icVar.aj != null) {
                        icVar.y.getDecorView().post(icVar.ak);
                    }
                } else {
                    icVar.ah = null;
                }
            }
            icVar.cr();
            icVar.ah = icVar.ah;
        }
        icVar.cr();
        da daVar3 = icVar.ah;
        if (daVar3 != null) {
            return chmVar.ab(daVar3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
