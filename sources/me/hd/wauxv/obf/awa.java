package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awa extends LinearLayout {
    public final TextInputLayout a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public View.OnLongClickListener f;
    public final CheckableImageButton g;
    public final avz h;
    public int i;
    public final LinkedHashSet j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence p;
    public final jp q;
    public boolean r;
    public EditText s;
    public final AccessibilityManager t;
    public qp u;
    public final avx v;

    public awa(TextInputLayout textInputLayout, jx jxVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.i = 0;
        this.j = new LinkedHashSet();
        this.v = new avx(this);
        avy avyVar = new avy(this);
        this.t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonW = w(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.c = checkableImageButtonW;
        CheckableImageButton checkableImageButtonW2 = w(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.g = checkableImageButtonW2;
        this.h = new avz(this, jxVar);
        jp jpVar = new jp(getContext(), null);
        this.q = jpVar;
        TypedArray typedArray = (TypedArray) jxVar.e;
        if (typedArray.hasValue(38)) {
            this.d = cnb.w(getContext(), jxVar, 38);
        }
        if (typedArray.hasValue(39)) {
            this.e = ewz.ap(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            ae(jxVar.s(37));
        }
        checkableImageButtonW.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = eqz.a;
        checkableImageButtonW.setImportantForAccessibility(2);
        checkableImageButtonW.setClickable(false);
        checkableImageButtonW.setPressable(false);
        checkableImageButtonW.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.k = cnb.w(getContext(), jxVar, 32);
            }
            if (typedArray.hasValue(33)) {
                this.l = ewz.ap(typedArray.getInt(33, -1), null);
            }
        }
        int i = 1;
        if (typedArray.hasValue(30)) {
            ac(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonW2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonW2.setContentDescription(text);
            }
            checkableImageButtonW2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.k = cnb.w(getContext(), jxVar, 54);
            }
            if (typedArray.hasValue(55)) {
                this.l = ewz.ap(typedArray.getInt(55, -1), null);
            }
            ac(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (checkableImageButtonW2.getContentDescription() != text2) {
                checkableImageButtonW2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.m) {
            this.m = dimensionPixelSize;
            checkableImageButtonW2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonW2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonW.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonW.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeU = bhu.u(typedArray.getInt(31, -1));
            this.n = scaleTypeU;
            checkableImageButtonW2.setScaleType(scaleTypeU);
            checkableImageButtonW.setScaleType(scaleTypeU);
        }
        jpVar.setVisibility(8);
        jpVar.setId(R.id.textinput_suffix_text);
        jpVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        jpVar.setAccessibilityLiveRegion(1);
        jpVar.setTextAppearance(typedArray.getResourceId(72, 0));
        if (typedArray.hasValue(73)) {
            jpVar.setTextColor(jxVar.r(73));
        }
        CharSequence text3 = typedArray.getText(71);
        this.p = TextUtils.isEmpty(text3) ? null : text3;
        jpVar.setText(text3);
        aj();
        frameLayout.addView(checkableImageButtonW2);
        addView(jpVar);
        addView(frameLayout);
        addView(checkableImageButtonW);
        textInputLayout.bc.add(avyVar);
        if (textInputLayout.e != null) {
            avyVar.b(textInputLayout);
        }
        addOnAttachStateChangeListener(new tj(this, i));
    }

    public final boolean aa() {
        return this.c.getVisibility() == 0;
    }

    public final void ab(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z3;
        awb awbVarX = x();
        boolean zAk = awbVarX.ak();
        CheckableImageButton checkableImageButton = this.g;
        boolean z4 = true;
        if (!zAk || (z3 = checkableImageButton.b) == awbVarX.aa()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(awbVarX instanceof aql) || (zIsActivated = checkableImageButton.isActivated()) == ((aql) awbVarX).h) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z4) {
            bhu.av(this.a, checkableImageButton, this.k);
        }
    }

    public final void ac(int i) {
        if (this.i == i) {
            return;
        }
        awb awbVarX = x();
        qp qpVar = this.u;
        AccessibilityManager accessibilityManager = this.t;
        if (qpVar != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new ar(qpVar));
        }
        this.u = null;
        awbVarX.s();
        this.i = i;
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        ad(i != 0);
        awb awbVarX2 = x();
        int iL = this.h.a;
        if (iL == 0) {
            iL = awbVarX2.l();
        }
        Drawable drawableY = iL != 0 ? cmz.y(getContext(), iL) : null;
        CheckableImageButton checkableImageButton = this.g;
        checkableImageButton.setImageDrawable(drawableY);
        TextInputLayout textInputLayout = this.a;
        if (drawableY != null) {
            bhu.o(textInputLayout, checkableImageButton, this.k, this.l);
            bhu.av(textInputLayout, checkableImageButton, this.k);
        }
        int iK = awbVarX2.k();
        CharSequence text = iK != 0 ? getResources().getText(iK) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(awbVarX2.ak());
        if (!awbVarX2.z(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        awbVarX2.r();
        qp qpVarY = awbVarX2.y();
        this.u = qpVarY;
        if (qpVarY != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = eqz.a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new ar(this.u));
            }
        }
        View.OnClickListener onClickListenerN = awbVarX2.n();
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(onClickListenerN);
        bhu.bb(checkableImageButton, onLongClickListener);
        EditText editText = this.s;
        if (editText != null) {
            awbVarX2.p(editText);
            af(awbVarX2);
        }
        bhu.o(textInputLayout, checkableImageButton, this.k, this.l);
        ab(true);
    }

    public final void ad(boolean z) {
        if (z() != z) {
            this.g.setVisibility(z ? 0 : 8);
            ag();
            ai();
            this.a.cq();
        }
    }

    public final void ae(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        ah();
        bhu.o(this.a, checkableImageButton, this.d, this.e);
    }

    public final void af(awb awbVar) {
        if (this.s == null) {
            return;
        }
        if (awbVar.m() != null) {
            this.s.setOnFocusChangeListener(awbVar.m());
        }
        if (awbVar.o() != null) {
            this.g.setOnFocusChangeListener(awbVar.o());
        }
    }

    public final void ag() {
        this.b.setVisibility((this.g.getVisibility() != 0 || aa()) ? 8 : 0);
        setVisibility((z() || aa() || ((this.p == null || this.r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void ah() {
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.k.q && textInputLayout.cm()) ? 0 : 8);
        ag();
        ai();
        if (this.i != 0) {
            return;
        }
        textInputLayout.cq();
    }

    public final void ai() {
        int paddingEnd;
        TextInputLayout textInputLayout = this.a;
        if (textInputLayout.e == null) {
            return;
        }
        if (z() || aa()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.e;
            WeakHashMap weakHashMap = eqz.a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.e.getPaddingTop();
        int paddingBottom = textInputLayout.e.getPaddingBottom();
        WeakHashMap weakHashMap2 = eqz.a;
        this.q.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void aj() {
        jp jpVar = this.q;
        int visibility = jpVar.getVisibility();
        int i = (this.p == null || this.r) ? 8 : 0;
        if (visibility != i) {
            x().q(i == 0);
        }
        ag();
        jpVar.setVisibility(i);
        this.a.cq();
    }

    public final CheckableImageButton w(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (cnb.ad(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final awb x() {
        awb aisVar;
        int i = this.i;
        avz avzVar = this.h;
        SparseArray sparseArray = (SparseArray) avzVar.c;
        awb awbVar = (awb) sparseArray.get(i);
        if (awbVar != null) {
            return awbVar;
        }
        awa awaVar = (awa) avzVar.d;
        if (i == -1) {
            aisVar = new ais(awaVar, 0);
        } else if (i == 0) {
            aisVar = new ais(awaVar, 1);
        } else if (i == 1) {
            aisVar = new ctb(awaVar, avzVar.b);
        } else if (i == 2) {
            aisVar = new zv(awaVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(bjs.i(i, "Invalid end icon mode: "));
            }
            aisVar = new aql(awaVar);
        }
        sparseArray.append(i, aisVar);
        return aisVar;
    }

    public final int y() {
        int marginStart;
        if (z() || aa()) {
            CheckableImageButton checkableImageButton = this.g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap weakHashMap = eqz.a;
        return this.q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean z() {
        return this.b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }
}
