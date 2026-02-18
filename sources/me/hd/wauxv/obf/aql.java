package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aql extends awb {
    public final int a;
    public final int b;
    public final TimeInterpolator c;
    public AutoCompleteTextView d;
    public final bq e;
    public final zs f;
    public final qp g;
    public boolean h;
    public boolean i;
    public boolean t;
    public long u;
    public AccessibilityManager v;
    public ValueAnimator w;
    public ValueAnimator x;

    public aql(awa awaVar) {
        super(awaVar);
        this.e = new bq(this, 5);
        this.f = new zs(this, 1);
        this.g = new qp(this, 2);
        this.u = Long.MAX_VALUE;
        this.b = ajn.ad(awaVar.getContext(), R.attr.motionDurationShort3, 67);
        this.a = ajn.ad(awaVar.getContext(), R.attr.motionDurationShort3, 50);
        this.c = ajn.ae(awaVar.getContext(), R.attr.motionEasingLinearInterpolator, ff.a);
    }

    @Override // me.hd.wauxv.obf.awb
    public final boolean aa() {
        return this.t;
    }

    @Override // me.hd.wauxv.obf.awb
    public final void ab(bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        if (this.d.getInputType() == 0) {
            bdVar.k(Spinner.class.getName());
        }
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // me.hd.wauxv.obf.awb
    public final void ac(AccessibilityEvent accessibilityEvent) {
        if (this.v.isEnabled() && this.d.getInputType() == 0) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.t && !this.d.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                ae();
                this.i = true;
                this.u = System.currentTimeMillis();
            }
        }
    }

    public final void ad(boolean z) {
        if (this.t != z) {
            this.t = z;
            this.x.cancel();
            this.w.start();
        }
    }

    public final void ae() {
        if (this.d == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.u;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.i = false;
        }
        if (this.i) {
            this.i = false;
            return;
        }
        ad(!this.t);
        if (!this.t) {
            this.d.dismissDropDown();
        } else {
            this.d.requestFocus();
            this.d.showDropDown();
        }
    }

    @Override // me.hd.wauxv.obf.awb
    public final void j() {
        if (this.v.isTouchExplorationEnabled() && this.d.getInputType() != 0 && !this.ai.hasFocus()) {
            this.d.dismissDropDown();
        }
        this.d.post(new dh(this, 6));
    }

    @Override // me.hd.wauxv.obf.awb
    public final int k() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // me.hd.wauxv.obf.awb
    public final int l() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnFocusChangeListener m() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnClickListener n() {
        return this.e;
    }

    @Override // me.hd.wauxv.obf.awb
    public final void p(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.d = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: me.hd.wauxv.obf.aqj
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    aql aqlVar = this.a;
                    long j = jCurrentTimeMillis - aqlVar.u;
                    if (j < 0 || j > 300) {
                        aqlVar.i = false;
                    }
                    aqlVar.ae();
                    aqlVar.i = true;
                    aqlVar.u = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.d.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: me.hd.wauxv.obf.aqk
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                aql aqlVar = this.a;
                aqlVar.i = true;
                aqlVar.u = System.currentTimeMillis();
                aqlVar.ad(false);
            }
        });
        this.d.setThreshold(0);
        TextInputLayout textInputLayout = this.af;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.v.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = eqz.a;
            this.ai.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // me.hd.wauxv.obf.awb
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.c;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.b);
        int i = 0;
        valueAnimatorOfFloat.addUpdateListener(new aqi(this, i));
        this.x = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.a);
        valueAnimatorOfFloat2.addUpdateListener(new aqi(this, i));
        this.w = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new ci(this, 3));
        this.v = (AccessibilityManager) this.ah.getSystemService("accessibility");
    }

    @Override // me.hd.wauxv.obf.awb
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.d;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.d.setOnDismissListener(null);
        }
    }

    @Override // me.hd.wauxv.obf.awb
    public final qp y() {
        return this.g;
    }

    @Override // me.hd.wauxv.obf.awb
    public final boolean z(int i) {
        return i != 0;
    }
}
