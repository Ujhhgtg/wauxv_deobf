package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmh extends cce implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public final Context a;
    public final cbw b;
    public final cbt c;
    public final boolean d;
    public final int f;
    public final int g;
    public final cck h;
    public final iv i;
    public final tj j;
    public PopupWindow.OnDismissListener k;
    public View l;
    public View m;
    public ccl n;
    public ViewTreeObserver o;
    public boolean p;
    public boolean q;
    public int r;
    public int s = 0;
    public boolean t;

    public dmh(Context context, cbw cbwVar, View view, int i, boolean z) {
        int i2 = 3;
        this.i = new iv(this, i2);
        this.j = new tj(this, i2);
        this.a = context;
        this.b = cbwVar;
        this.d = z;
        this.c = new cbt(cbwVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.g = i;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2,
                resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.l = view;
        this.h = new cck(context, null, i, 0);
        cbwVar.aa(this, context);
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
        if (cbwVar != this.b) {
            return;
        }
        dismiss();
        ccl cclVar = this.n;
        if (cclVar != null) {
            cclVar.c(cbwVar, z);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        this.q = false;
        cbt cbtVar = this.c;
        if (cbtVar != null) {
            cbtVar.notifyDataSetChanged();
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ad() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dho
    public final void ag() {
        View view;
        if (initOnce()) {
            return;
        }
        if (this.p || (view = this.l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.m = view;
        cck cckVar = this.h;
        in inVar = cckVar.av;
        in inVar2 = cckVar.av;
        inVar.setOnDismissListener(this);
        cckVar.al = this;
        cckVar.au = true;
        inVar2.setFocusable(true);
        View view2 = this.m;
        boolean z = this.o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.o = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.i);
        }
        view2.addOnAttachStateChangeListener(this.j);
        cckVar.ak = view2;
        cckVar.af = this.s;
        boolean z2 = this.q;
        Context context = this.a;
        cbt cbtVar = this.c;
        if (!z2) {
            this.r = cce.aw(cbtVar, context, this.f);
            this.q = true;
        }
        cckVar.ax(this.r);
        inVar2.setInputMethodMode(2);
        Rect rect = this.av;
        cckVar.at = rect != null ? new Rect(rect) : null;
        cckVar.ag();
        aqe aqeVar = cckVar.w;
        aqeVar.setOnKeyListener(this);
        if (this.t) {
            cbw cbwVar = this.b;
            if (cbwVar.n != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context)
                        .inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) aqeVar, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(cbwVar.n);
                }
                frameLayout.setEnabled(false);
                aqeVar.addHeaderView(frameLayout, null, false);
            }
        }
        cckVar.p(cbtVar);
        cckVar.ag();
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
    }

    @Override // me.hd.wauxv.obf.dho
    public final aqe ai() {
        return this.h.w;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        boolean z;
        if (dnwVar.hasVisibleItems()) {
            ccg ccgVar = new ccg(this.a, dnwVar, this.m, this.d, this.g, 0);
            ccl cclVar = this.n;
            ccgVar.k = cclVar;
            cce cceVar = ccgVar.l;
            if (cceVar != null) {
                cceVar.ak(cclVar);
            }
            int size = dnwVar.g.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = dnwVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            ccgVar.j = z;
            cce cceVar2 = ccgVar.l;
            if (cceVar2 != null) {
                cceVar2.ao(z);
            }
            ccgVar.m = this.k;
            this.k = null;
            this.b.ab(false);
            cck cckVar = this.h;
            int width = cckVar.z;
            int iO = cckVar.o();
            if ((Gravity.getAbsoluteGravity(this.s, this.l.getLayoutDirection()) & 7) == 5) {
                width += this.l.getWidth();
            }
            if (!ccgVar.p()) {
                if (ccgVar.h != null) {
                    ccgVar.q(width, iO, true, true);
                }
            }
            ccl cclVar2 = this.n;
            if (cclVar2 != null) {
                cclVar2.d(dnwVar);
            }
            return true;
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ak(ccl cclVar) {
        this.n = cclVar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        return null;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void am(cbw cbwVar) {
    }

    @Override // me.hd.wauxv.obf.cce
    public final void an(View view) {
        this.l = view;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ao(boolean z) {
        this.c.c = z;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ap(int i) {
        this.s = i;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void aq(int i) {
        this.h.z = i;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ar(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void as(boolean z) {
        this.t = z;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void at(int i) {
        this.h.l(i);
    }

    @Override // me.hd.wauxv.obf.dho
    public final void dismiss() {
        if (initOnce()) {
            this.h.dismiss();
        }
    }

    @Override // me.hd.wauxv.obf.dho
    public final boolean getThisObject() {
        return !this.p && this.h.av.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.p = true;
        this.b.ab(true);
        ViewTreeObserver viewTreeObserver = this.o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.o = this.m.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.i);
            this.o = null;
        }
        this.m.removeOnAttachStateChangeListener(this.j);
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }
}
