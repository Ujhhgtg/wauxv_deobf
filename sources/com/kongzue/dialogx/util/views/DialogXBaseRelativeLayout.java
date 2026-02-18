package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.anj;
import me.hd.wauxv.obf.ank;
import me.hd.wauxv.obf.anm;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.bat;
import me.hd.wauxv.obf.bau;
import me.hd.wauxv.obf.baw;
import me.hd.wauxv.obf.bax;
import me.hd.wauxv.obf.bfm;
import me.hd.wauxv.obf.bfp;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.crc;
import me.hd.wauxv.obf.cxt;
import me.hd.wauxv.obf.eqo;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.ng;
import me.hd.wauxv.obf.ut;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DialogXBaseRelativeLayout extends RelativeLayout {
    public static final /* synthetic */ int a = 0;
    public bfm b;
    public WeakReference c;
    public boolean d;
    public final boolean e;
    public final boolean f;
    public aye g;
    public ank h;
    public bax i;
    public final boolean j;
    public boolean k;
    public float l;
    public float m;
    public WeakReference n;
    public Rect o;
    public boolean p;
    public float q;
    public final int[] r;

    public DialogXBaseRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 1;
        this.d = true;
        this.e = true;
        this.f = true;
        this.j = false;
        this.o = new Rect();
        this.p = true;
        this.r = new int[4];
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            setForceDarkAllowed(false);
        }
        if (this.j) {
            return;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxt.a);
            this.e = typedArrayObtainStyledAttributes.getBoolean(1, true);
            this.d = typedArrayObtainStyledAttributes.getBoolean(0, true);
            this.f = typedArrayObtainStyledAttributes.getBoolean(2, true);
            typedArrayObtainStyledAttributes.recycle();
            this.j = true;
        }
        if (this.e) {
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
        s(0.0f);
        if (getParentDialog() != null && getParentDialog().v != 1) {
            setFitsSystemWindows(true);
        }
        setClipChildren(false);
        setClipToPadding(false);
        setDefaultFocusHighlightEnabled(false);
        erp erpVar = new erp(this, 15);
        bax baxVar = new bax();
        baxVar.a = false;
        baxVar.b = this;
        baxVar.c = erpVar;
        baxVar.d = getParentDialog();
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = baxVar.b;
        WeakHashMap weakHashMap = eqz.a;
        int paddingStart = dialogXBaseRelativeLayout.getPaddingStart();
        int paddingTop = baxVar.b.getPaddingTop();
        int paddingEnd = baxVar.b.getPaddingEnd();
        int paddingBottom = baxVar.b.getPaddingBottom();
        baw bawVar = new baw();
        bawVar.a = paddingStart;
        bawVar.b = paddingTop;
        bawVar.c = paddingEnd;
        bawVar.d = paddingBottom;
        eqq.l(baxVar.b, new ut(baxVar, bawVar));
        if (i2 >= 30) {
            eqz.u(baxVar.b, new bat(baxVar, bawVar));
        }
        if (baxVar.b.isAttachedToWindow()) {
            eqo.c(baxVar.b);
        } else {
            baxVar.b.addOnAttachStateChangeListener(new bau(baxVar, i, bawVar));
        }
        this.i = baxVar;
    }

    @Override // android.view.View
    public final boolean callOnClick() {
        if (isEnabled()) {
            return super.callOnClick();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        if (!isAttachedToWindow() || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4 || !this.f || this.h == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        ((ng) this.c.get()).getClass();
        this.h.a();
        return true;
    }

    public bax getFitSystemBarUtils() {
        return this.i;
    }

    public crc getOnSafeInsetsChangeListener() {
        return this.b;
    }

    public ng getParentDialog() {
        WeakReference weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return (ng) weakReference.get();
    }

    public int getRootPaddingBottom() {
        return this.r[3];
    }

    public int getRootPaddingLeft() {
        return this.r[0];
    }

    public int getRootPaddingRight() {
        return this.r[2];
    }

    public int getRootPaddingTop() {
        return this.r[1];
    }

    public float getSafeHeight() {
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.o;
        return (measuredHeight - rect.bottom) - rect.top;
    }

    public Rect getUnsafePlace() {
        return this.o;
    }

    public int getUseAreaHeight() {
        return getHeight() - getRootPaddingBottom();
    }

    public int getUseAreaWidth() {
        return getWidth() - getRootPaddingRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || getParentDialog() == null || getParentDialog().as() == null) {
            return;
        }
        aye ayeVar = this.g;
        if (ayeVar != null) {
            ayeVar.aa();
        }
        this.p = (getResources().getConfiguration().uiMode & 48) == 16;
        if (this.e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.p == ((configuration.uiMode & 48) == 16) || anj.g != 3 || getParentDialog() == null) {
            return;
        }
        getParentDialog().ay();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        aye ayeVar = this.g;
        if (ayeVar != null) {
            ayeVar.z();
        }
        bax baxVar = this.i;
        if (baxVar != null) {
            View viewL = baxVar.l();
            if (viewL != null && baxVar.i != null) {
                viewL.getViewTreeObserver().removeOnGlobalLayoutListener(baxVar.i);
            }
            baxVar.i = null;
            baxVar.c = null;
            baxVar.b = null;
            baxVar.d = null;
        }
        this.i = null;
        this.b = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = true;
            this.l = motionEvent.getX();
            this.m = motionEvent.getY();
        } else if (action == 1 && this.k && findFocus() != this && getParentDialog() != null) {
            float f = (int) ((5.0f * getParentDialog().at().getDisplayMetrics().density) + 0.5f);
            if (Math.abs(motionEvent.getX() - this.l) <= f && Math.abs(motionEvent.getY() - this.m) <= f) {
                callOnClick();
            }
        }
        getParentDialog();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled()) {
            return super.performClick();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        WeakReference weakReference;
        if (getParentDialog() != null) {
            getParentDialog();
        }
        if (i == 130 && (weakReference = this.n) != null && weakReference.get() != null && this.n.get() != this) {
            return ((View) this.n.get()).requestFocus();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || viewFindFocus == this) {
            return super.requestFocus(i, rect);
        }
        viewFindFocus.requestFocus();
        return true;
    }

    public final void s(float f) {
        this.q = f;
        if (getBackground() != null) {
            getBackground().mutate().setAlpha((int) (f * 255.0f));
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        drawable.setAlpha((int) (this.q * 255.0f));
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setBackground(new ColorDrawable(i));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8 && getAlpha() == 0.0f) {
            setAlpha(0.01f);
        }
        super.setVisibility(i);
    }

    public final void t(ng ngVar) {
        this.c = new WeakReference(ngVar);
        if (ngVar != null && ngVar.v != 1) {
            setFitsSystemWindows(true);
        }
        if (this.o != null) {
            Objects.toString(getParentDialog());
            Rect rect = this.o;
            u(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(int i, int i2, int i3, int i4) {
        Objects.toString(getParentDialog());
        bht bhtVar = anj.a;
        getParentDialog();
        if ((getParentDialog() instanceof bfp) || (findViewWithTag("DialogXSafetyArea") instanceof anm)) {
            View viewFindViewWithTag = findViewWithTag("DialogXSafetyArea");
            if (viewFindViewWithTag instanceof anm) {
                int dialogXSafetyMode = ((anm) viewFindViewWithTag).getDialogXSafetyMode();
                boolean z = (dialogXSafetyMode & 1) != 0;
                boolean z2 = (dialogXSafetyMode & 2) != 0;
                boolean z3 = (dialogXSafetyMode & 4) != 0;
                boolean z4 = (dialogXSafetyMode & 8) != 0;
                Objects.toString(viewFindViewWithTag);
                viewFindViewWithTag.setPadding(z2 ? i : 0, z ? i2 : 0, z4 ? i3 : 0, z3 ? i4 : 0);
                if (z) {
                    i2 = 0;
                }
                if (z2) {
                    i = 0;
                }
                if (z4) {
                    i3 = 0;
                }
                if (z3) {
                }
            } else {
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bkg);
                ((bfp) getParentDialog()).getClass();
                if (viewGroup != null) {
                    viewGroup.setPadding(0, 0, 0, i4);
                }
            }
            i4 = 0;
        }
        if (this.d) {
            setPadding(i, i2, i3, i4);
        }
    }
}
