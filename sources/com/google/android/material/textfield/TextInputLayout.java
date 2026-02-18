package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.C0023if;
import me.hd.wauxv.obf.aat;
import me.hd.wauxv.obf.abi;
import me.hd.wauxv.obf.ahe;
import me.hd.wauxv.obf.aiw;
import me.hd.wauxv.obf.aix;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.ama;
import me.hd.wauxv.obf.apy;
import me.hd.wauxv.obf.aql;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.avy;
import me.hd.wauxv.obf.awa;
import me.hd.wauxv.obf.axy;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bhv;
import me.hd.wauxv.obf.bpb;
import me.hd.wauxv.obf.bpc;
import me.hd.wauxv.obf.caa;
import me.hd.wauxv.obf.cat;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.cxc;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dc;
import me.hd.wauxv.obf.ddk;
import me.hd.wauxv.obf.df;
import me.hd.wauxv.obf.dgl;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dh;
import me.hd.wauxv.obf.dmj;
import me.hd.wauxv.obf.dqi;
import me.hd.wauxv.obf.dqm;
import me.hd.wauxv.obf.dqn;
import me.hd.wauxv.obf.dqo;
import me.hd.wauxv.obf.dqp;
import me.hd.wauxv.obf.elp;
import me.hd.wauxv.obf.eqt;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.jp;
import me.hd.wauxv.obf.jx;
import me.hd.wauxv.obf.no;
import me.hd.wauxv.obf.o;
import me.hd.wauxv.obf.ot;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] a = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList aa;
    public ColorStateList ab;
    public ColorStateList ac;
    public boolean ad;
    public CharSequence ae;
    public boolean af;
    public cau ag;
    public cau ah;
    public StateListDrawable ai;
    public boolean aj;
    public cau ak;
    public cau al;
    public dgm am;
    public boolean an;
    public final int ao;
    public int ap;
    public int aq;
    public int ar;
    public int as;
    public int at;
    public int au;
    public int av;
    public final Rect aw;
    public final Rect ax;
    public final RectF ay;
    public Typeface az;
    public final FrameLayout b;
    public ColorDrawable ba;
    public int bb;
    public final LinkedHashSet bc;
    public ColorDrawable bd;
    public int be;
    public Drawable bf;
    public ColorStateList bg;
    public ColorStateList bh;
    public int bi;
    public int bj;
    public int bk;
    public ColorStateList bl;
    public int bm;
    public int bn;
    public int bo;
    public int bp;
    public int bq;
    public int br;
    public boolean bs;
    public final aat bt;
    public boolean bu;
    public boolean bv;
    public ValueAnimator bw;
    public boolean bx;
    public boolean by;
    public boolean bz;
    public final dmj c;
    public final awa d;
    public EditText e;
    public CharSequence f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final bpc k;
    public boolean l;
    public int m;
    public boolean n;
    public dqo o;
    public jp p;
    public int q;
    public int r;
    public CharSequence s;
    public boolean t;
    public jp u;
    public ColorStateList v;
    public int w;
    public axy x;
    public axy y;
    public ColorStateList z;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, me.hd.wauxv.R.attr.textInputStyle, me.hd.wauxv.R.style.Widget_Design_TextInputLayout), attributeSet, me.hd.wauxv.R.attr.textInputStyle);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = new bpc(this);
        this.o = new df(6);
        this.aw = new Rect();
        this.ax = new Rect();
        this.ay = new RectF();
        this.bc = new LinkedHashSet();
        aat aatVar = new aat(this);
        this.bt = aatVar;
        this.bz = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = ff.a;
        aatVar.aw = linearInterpolator;
        aatVar.bz(false);
        aatVar.av = linearInterpolator;
        aatVar.bz(false);
        aatVar.cc(8388659);
        jx jxVarAo = bhu.ao(context2, attributeSet, cxs.aq, me.hd.wauxv.R.attr.textInputStyle, me.hd.wauxv.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 49);
        dmj dmjVar = new dmj(this, jxVarAo);
        this.c = dmjVar;
        TypedArray typedArray = (TypedArray) jxVarAo.e;
        this.ad = typedArray.getBoolean(48, true);
        setHint(typedArray.getText(4));
        this.bv = typedArray.getBoolean(47, true);
        this.bu = typedArray.getBoolean(42, true);
        if (typedArray.hasValue(6)) {
            setMinEms(typedArray.getInt(6, -1));
        } else if (typedArray.hasValue(3)) {
            setMinWidth(typedArray.getDimensionPixelSize(3, -1));
        }
        if (typedArray.hasValue(5)) {
            setMaxEms(typedArray.getInt(5, -1));
        } else if (typedArray.hasValue(2)) {
            setMaxWidth(typedArray.getDimensionPixelSize(2, -1));
        }
        this.am = dgm.n(context2, attributeSet, me.hd.wauxv.R.attr.textInputStyle, me.hd.wauxv.R.style.Widget_Design_TextInputLayout).m();
        this.ao = context2.getResources().getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.aq = typedArray.getDimensionPixelOffset(9, 0);
        this.as = typedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.at = typedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.ar = this.as;
        float dimension = typedArray.getDimension(13, -1.0f);
        float dimension2 = typedArray.getDimension(12, -1.0f);
        float dimension3 = typedArray.getDimension(10, -1.0f);
        float dimension4 = typedArray.getDimension(11, -1.0f);
        dgl dglVarQ = this.am.q();
        if (dimension >= 0.0f) {
            dglVarQ.e = new o(dimension);
        }
        if (dimension2 >= 0.0f) {
            dglVarQ.f = new o(dimension2);
        }
        if (dimension3 >= 0.0f) {
            dglVarQ.g = new o(dimension3);
        }
        if (dimension4 >= 0.0f) {
            dglVarQ.h = new o(dimension4);
        }
        this.am = dglVarQ.m();
        ColorStateList colorStateListW = cnb.w(context2, jxVarAo, 7);
        if (colorStateListW != null) {
            int defaultColor = colorStateListW.getDefaultColor();
            this.bm = defaultColor;
            this.av = defaultColor;
            if (colorStateListW.isStateful()) {
                this.bn = colorStateListW.getColorForState(new int[]{-16842910}, -1);
                this.bo = colorStateListW.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.bp = colorStateListW.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.bo = this.bm;
                ColorStateList colorStateListV = bht.v(context2, me.hd.wauxv.R.color.mtrl_filled_background_color);
                this.bn = colorStateListV.getColorForState(new int[]{-16842910}, -1);
                this.bp = colorStateListV.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.av = 0;
            this.bm = 0;
            this.bn = 0;
            this.bo = 0;
            this.bp = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList colorStateListR = jxVarAo.r(1);
            this.bh = colorStateListR;
            this.bg = colorStateListR;
        }
        ColorStateList colorStateListW2 = cnb.w(context2, jxVarAo, 14);
        this.bk = typedArray.getColor(14, 0);
        this.bi = context2.getColor(me.hd.wauxv.R.color.mtrl_textinput_default_box_stroke_color);
        this.bq = context2.getColor(me.hd.wauxv.R.color.mtrl_textinput_disabled_color);
        this.bj = context2.getColor(me.hd.wauxv.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListW2 != null) {
            setBoxStrokeColorStateList(colorStateListW2);
        }
        if (typedArray.hasValue(15)) {
            setBoxStrokeErrorColor(cnb.w(context2, jxVarAo, 15));
        }
        if (typedArray.getResourceId(49, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(49, 0));
        }
        this.ab = jxVarAo.r(24);
        this.ac = jxVarAo.r(25);
        int resourceId = typedArray.getResourceId(40, 0);
        CharSequence text = typedArray.getText(35);
        int i = typedArray.getInt(34, 1);
        boolean z = typedArray.getBoolean(36, false);
        int resourceId2 = typedArray.getResourceId(45, 0);
        boolean z2 = typedArray.getBoolean(44, false);
        CharSequence text2 = typedArray.getText(43);
        int resourceId3 = typedArray.getResourceId(57, 0);
        CharSequence text3 = typedArray.getText(56);
        boolean z3 = typedArray.getBoolean(18, false);
        setCounterMaxLength(typedArray.getInt(19, -1));
        this.r = typedArray.getResourceId(22, 0);
        this.q = typedArray.getResourceId(20, 0);
        setBoxBackgroundMode(typedArray.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.q);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.r);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(41)) {
            setErrorTextColor(jxVarAo.r(41));
        }
        if (typedArray.hasValue(46)) {
            setHelperTextColor(jxVarAo.r(46));
        }
        if (typedArray.hasValue(50)) {
            setHintTextColor(jxVarAo.r(50));
        }
        if (typedArray.hasValue(23)) {
            setCounterTextColor(jxVarAo.r(23));
        }
        if (typedArray.hasValue(21)) {
            setCounterOverflowTextColor(jxVarAo.r(21));
        }
        if (typedArray.hasValue(58)) {
            setPlaceholderTextColor(jxVarAo.r(58));
        }
        awa awaVar = new awa(this, jxVarAo);
        this.d = awaVar;
        boolean z4 = typedArray.getBoolean(0, true);
        jxVarAo.ae();
        setImportantForAccessibility(2);
        eqt.b(this, 1);
        frameLayout.addView(dmjVar);
        frameLayout.addView(awaVar);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    public static void ca(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                ca((ViewGroup) childAt, z);
            }
        }
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.e;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.ag;
        }
        int iV = cna.v(this.e, me.hd.wauxv.R.attr.colorControlHighlight);
        int i = this.ap;
        int[][] iArr = a;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            cau cauVar = this.ag;
            int i2 = this.av;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{cna.ad(iV, 0.1f, i2), i2}), cauVar, cauVar);
        }
        Context context = getContext();
        cau cauVar2 = this.ag;
        int iU = cna.u(context, me.hd.wauxv.R.attr.colorSurface, "TextInputLayout");
        cau cauVar3 = new cau(cauVar2.ct.b);
        int iAd = cna.ad(iV, 0.1f, iU);
        cauVar3.dz(new ColorStateList(iArr, new int[]{iAd, 0}));
        cauVar3.setTint(iU);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iAd, iU});
        cau cauVar4 = new cau(cauVar2.ct.b);
        cauVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, cauVar3, cauVar4), cauVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.ai == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.ai = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.ai.addState(new int[0], cg(false));
        }
        return this.ai;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.ah == null) {
            this.ah = cg(true);
        }
        return this.ah;
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i = this.g;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.i);
        }
        int i2 = this.h;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.j);
        }
        this.aj = false;
        cj();
        setTextInputAccessibilityDelegate(new dqn(this));
        Typeface typeface = this.e.getTypeface();
        aat aatVar = this.bt;
        boolean zCd = aatVar.cd(typeface);
        boolean zCf = aatVar.cf(typeface);
        if (zCd || zCf) {
            aatVar.bz(false);
        }
        float textSize = this.e.getTextSize();
        if (aatVar.l != textSize) {
            aatVar.l = textSize;
            aatVar.bz(false);
        }
        int i3 = Build.VERSION.SDK_INT;
        float letterSpacing = this.e.getLetterSpacing();
        if (aatVar.bg != letterSpacing) {
            aatVar.bg = letterSpacing;
            aatVar.bz(false);
        }
        int gravity = this.e.getGravity();
        aatVar.cc((gravity & (-113)) | 48);
        if (aatVar.j != gravity) {
            aatVar.j = gravity;
            aatVar.bz(false);
        }
        WeakHashMap weakHashMap = eqz.a;
        this.br = editText.getMinimumHeight();
        this.e.addTextChangedListener(new dqm(this, editText));
        if (this.bg == null) {
            this.bg = this.e.getHintTextColors();
        }
        if (this.ad) {
            if (TextUtils.isEmpty(this.ae)) {
                CharSequence hint = this.e.getHint();
                this.f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.af = true;
        }
        if (i3 >= 29) {
            cp();
        }
        if (this.p != null) {
            cn(this.e.getText());
        }
        cr();
        this.k.ad();
        this.c.bringToFront();
        awa awaVar = this.d;
        awaVar.bringToFront();
        Iterator it = this.bc.iterator();
        while (it.hasNext()) {
            ((avy) it.next()).b(this);
        }
        awaVar.ai();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        cu(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.ae)) {
            return;
        }
        this.ae = charSequence;
        aat aatVar = this.bt;
        if (charSequence == null || !TextUtils.equals(aatVar.ag, charSequence)) {
            aatVar.ag = charSequence;
            aatVar.ah = null;
            Bitmap bitmap = aatVar.ak;
            if (bitmap != null) {
                bitmap.recycle();
                aatVar.ak = null;
            }
            aatVar.bz(false);
        }
        if (this.bs) {
            return;
        }
        ck();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.t == z) {
            return;
        }
        if (z) {
            jp jpVar = this.u;
            if (jpVar != null) {
                this.b.addView(jpVar);
                this.u.setVisibility(0);
            }
        } else {
            jp jpVar2 = this.u;
            if (jpVar2 != null) {
                jpVar2.setVisibility(8);
            }
            this.u = null;
        }
        this.t = z;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.b;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        ct();
        setEditText((EditText) view);
    }

    public final void cb(float f) {
        aat aatVar = this.bt;
        if (aatVar.b == f) {
            return;
        }
        if (this.bw == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.bw = valueAnimator;
            valueAnimator.setInterpolator(ajn.ae(getContext(), me.hd.wauxv.R.attr.motionEasingEmphasizedInterpolator, ff.b));
            this.bw.setDuration(ajn.ad(getContext(), me.hd.wauxv.R.attr.motionDurationMedium4, 167));
            this.bw.addUpdateListener(new no(this, 10));
        }
        this.bw.setFloatValues(aatVar.b, f);
        this.bw.start();
    }

    public final void cc() {
        Integer numValueOf;
        int i;
        int i2;
        cau cauVar = this.ag;
        if (cauVar == null) {
            return;
        }
        dgm dgmVar = cauVar.ct.b;
        dgm dgmVar2 = this.am;
        if (dgmVar != dgmVar2) {
            cauVar.setShapeAppearanceModel(dgmVar2);
        }
        if (this.ap == 2 && (i = this.ar) > -1 && (i2 = this.au) != 0) {
            cau cauVar2 = this.ag;
            cauVar2.ct.k = i;
            cauVar2.invalidateSelf();
            cauVar2.ed(ColorStateList.valueOf(i2));
        }
        int iD = this.av;
        if (this.ap == 1) {
            Context context = getContext();
            TypedValue typedValueAl = cmz.al(context, me.hd.wauxv.R.attr.colorSurface);
            if (typedValueAl != null) {
                int i3 = typedValueAl.resourceId;
                numValueOf = Integer.valueOf(i3 != 0 ? context.getColor(i3) : typedValueAl.data);
            } else {
                numValueOf = null;
            }
            iD = abi.d(this.av, numValueOf != null ? numValueOf.intValue() : 0);
        }
        this.av = iD;
        this.ag.dz(ColorStateList.valueOf(iD));
        cau cauVar3 = this.ak;
        if (cauVar3 != null && this.al != null) {
            if (this.ar > -1 && this.au != 0) {
                cauVar3.dz(this.e.isFocused() ? ColorStateList.valueOf(this.bi) : ColorStateList.valueOf(this.au));
                this.al.dz(ColorStateList.valueOf(this.au));
            }
            invalidate();
        }
        cs();
    }

    public final int cd() {
        float fBw;
        if (!this.ad) {
            return 0;
        }
        int i = this.ap;
        aat aatVar = this.bt;
        if (i == 0) {
            fBw = aatVar.bw();
        } else {
            if (i != 2) {
                return 0;
            }
            fBw = aatVar.bw() / 2.0f;
        }
        return (int) fBw;
    }

    public final axy ce() {
        axy axyVar = new axy();
        axyVar.ai = ajn.ad(getContext(), me.hd.wauxv.R.attr.motionDurationShort2, 87);
        axyVar.aj = ajn.ae(getContext(), me.hd.wauxv.R.attr.motionEasingLinearInterpolator, ff.a);
        return axyVar;
    }

    public final boolean cf() {
        return this.ad && !TextUtils.isEmpty(this.ae) && (this.ag instanceof aix);
    }

    public final cau cg(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_shape_corner_size_small_component);
        float f = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.e;
        float popupElevation = editText instanceof caa ? ((caa) editText).getPopupElevation() : getResources().getDimensionPixelOffset(me.hd.wauxv.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ddk ddkVar = new ddk();
        ddk ddkVar2 = new ddk();
        ddk ddkVar3 = new ddk();
        ddk ddkVar4 = new ddk();
        arj arjVar = new arj();
        arj arjVar2 = new arj();
        arj arjVar3 = new arj();
        arj arjVar4 = new arj();
        o oVar = new o(f);
        o oVar2 = new o(f);
        o oVar3 = new o(dimensionPixelOffset);
        o oVar4 = new o(dimensionPixelOffset);
        dgm dgmVar = new dgm();
        dgmVar.a = ddkVar;
        dgmVar.b = ddkVar2;
        dgmVar.c = ddkVar3;
        dgmVar.d = ddkVar4;
        dgmVar.e = oVar;
        dgmVar.f = oVar2;
        dgmVar.g = oVar4;
        dgmVar.h = oVar3;
        dgmVar.i = arjVar;
        dgmVar.j = arjVar2;
        dgmVar.k = arjVar3;
        dgmVar.l = arjVar4;
        EditText editText2 = this.e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof caa ? ((caa) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = cau.cs;
            dropDownBackgroundTintList = ColorStateList.valueOf(cna.u(context, me.hd.wauxv.R.attr.colorSurface, cau.class.getSimpleName()));
        }
        cau cauVar = new cau();
        cauVar.dx(context);
        cauVar.dz(dropDownBackgroundTintList);
        cauVar.dy(popupElevation);
        cauVar.setShapeAppearanceModel(dgmVar);
        cat catVar = cauVar.ct;
        if (catVar.h == null) {
            catVar.h = new Rect();
        }
        cauVar.ct.h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        cauVar.invalidateSelf();
        return cauVar;
    }

    public final int ch(int i, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.e.getCompoundPaddingLeft() : this.d.y() : this.c.k()) + i;
    }

    public final int ci(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.e.getCompoundPaddingRight() : this.c.k() : this.d.y());
    }

    public final void cj() {
        int i = this.ap;
        if (i == 0) {
            this.ag = null;
            this.ak = null;
            this.al = null;
        } else if (i == 1) {
            this.ag = new cau(this.am);
            this.ak = new cau();
            this.al = new cau();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(yg.m(new StringBuilder(), " is illegal; only @BoxBackgroundMode constants are supported.", this.ap));
            }
            if (!this.ad || (this.ag instanceof aix)) {
                this.ag = new cau(this.am);
            } else {
                dgm dgmVar = this.am;
                int i2 = aix.a;
                if (dgmVar == null) {
                    dgmVar = new dgm();
                }
                aiw aiwVar = new aiw(dgmVar, new RectF());
                aix aixVar = new aix(aiwVar);
                aixVar.b = aiwVar;
                this.ag = aixVar;
            }
            this.ak = null;
            this.al = null;
        }
        cs();
        cx();
        if (this.ap == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.aq = getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (cnb.ad(getContext())) {
                this.aq = getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.e != null && this.ap == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.e;
                WeakHashMap weakHashMap = eqz.a;
                editText.setPaddingRelative(editText.getPaddingStart(), getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_filled_edittext_font_2_0_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (cnb.ad(getContext())) {
                EditText editText2 = this.e;
                WeakHashMap weakHashMap2 = eqz.a;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_filled_edittext_font_1_3_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.ap != 0) {
            ct();
        }
        EditText editText3 = this.e;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.ap;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:44:0x008d  */
    public final void ck() {
        float f;
        float f2;
        float f3;
        RectF rectF;
        float f4;
        int i;
        float f5;
        int i2;
        if (cf()) {
            int width = this.e.getWidth();
            int gravity = this.e.getGravity();
            aat aatVar = this.bt;
            boolean zBt = aatVar.bt(aatVar.ag);
            aatVar.ai = zBt;
            Rect rect = aatVar.h;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zBt) {
                        i2 = rect.left;
                        f3 = i2;
                    } else {
                        f = rect.right;
                        f2 = aatVar.bj;
                    }
                } else if (zBt) {
                    f = rect.right;
                    f2 = aatVar.bj;
                } else {
                    i2 = rect.left;
                    f3 = i2;
                }
                float fMax = Math.max(f3, rect.left);
                rectF = this.ay;
                rectF.left = fMax;
                rectF.top = rect.top;
                if (gravity == 17 && (gravity & 7) != 1) {
                    if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                        if (aatVar.ai) {
                            f5 = aatVar.bj;
                            f4 = f5 + fMax;
                        } else {
                            i = rect.right;
                            f4 = i;
                        }
                    } else if (aatVar.ai) {
                        i = rect.right;
                        f4 = i;
                    } else {
                        f5 = aatVar.bj;
                        f4 = f5 + fMax;
                    }
                }
                rectF.right = Math.min(f4, rect.right);
                rectF.bottom = aatVar.bw() + rect.top;
                if (rectF.width() > 0.0f || rectF.height() <= 0.0f) {
                }
                float f6 = rectF.left;
                float f7 = this.ao;
                rectF.left = f6 - f7;
                rectF.right += f7;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.ar);
                aix aixVar = (aix) this.ag;
                aixVar.getClass();
                aixVar.d(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            f = width / 2.0f;
            f2 = aatVar.bj / 2.0f;
            f3 = f - f2;
            float fMax2 = Math.max(f3, rect.left);
            rectF = this.ay;
            rectF.left = fMax2;
            rectF.top = rect.top;
            f4 = gravity == 17 ? (width / 2.0f) + (aatVar.bj / 2.0f) : (width / 2.0f) + (aatVar.bj / 2.0f);
            rectF.right = Math.min(f4, rect.right);
            rectF.bottom = aatVar.bw() + rect.top;
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void cl(jp jpVar, int i) {
        try {
            jpVar.setTextAppearance(i);
            if (jpVar.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        jpVar.setTextAppearance(me.hd.wauxv.R.style.TextAppearance_AppCompat_Caption);
        jpVar.setTextColor(getContext().getColor(me.hd.wauxv.R.color.design_error));
    }

    public final boolean cm() {
        bpc bpcVar = this.k;
        return (bpcVar.o != 1 || bpcVar.r == null || TextUtils.isEmpty(bpcVar.p)) ? false : true;
    }

    public final void cn(Editable editable) {
        ((df) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.n;
        int i = this.m;
        if (i == -1) {
            this.p.setText(String.valueOf(length));
            this.p.setContentDescription(null);
            this.n = false;
        } else {
            this.n = length > i;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.n ? me.hd.wauxv.R.string.character_counter_overflowed_content_description : me.hd.wauxv.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.m)));
            if (z != this.n) {
                co();
            }
            String str = ot.a;
            ot otVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? ot.d : ot.c;
            jp jpVar = this.p;
            String string = getContext().getString(me.hd.wauxv.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m));
            otVar.getClass();
            cxc cxcVar = dqi.a;
            jpVar.setText(string != null ? otVar.h(string).toString() : null);
        }
        if (this.e == null || z == this.n) {
            return;
        }
        cu(false, false);
        cx();
        cr();
    }

    public final void co() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        jp jpVar = this.p;
        if (jpVar != null) {
            cl(jpVar, this.n ? this.q : this.r);
            if (!this.n && (colorStateList2 = this.z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.aa) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x0025  */
    public final void cp() {
        ColorStateList colorStateList;
        ColorStateList colorStateListValueOf = this.ab;
        if (colorStateListValueOf == null) {
            Context context = getContext();
            TypedValue typedValueAl = cmz.al(context, me.hd.wauxv.R.attr.colorControlActivated);
            if (typedValueAl != null) {
                int i = typedValueAl.resourceId;
                if (i != 0) {
                    colorStateListValueOf = bht.v(context, i);
                } else {
                    int i2 = typedValueAl.data;
                    colorStateListValueOf = i2 != 0 ? ColorStateList.valueOf(i2) : null;
                }
            }
        }
        EditText editText = this.e;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = this.e.getTextCursorDrawable().mutate();
        if ((cm() || (this.p != null && this.n)) && (colorStateList = this.ac) != null) {
            colorStateListValueOf = colorStateList;
        }
        drawableMutate.setTintList(colorStateListValueOf);
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Found duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0078  */
    public final boolean cq() {
        boolean z;
        if (this.e == null) {
            return false;
        }
        CheckableImageButton checkableImageButton = null;
        boolean z2 = true;
        if (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) {
            dmj dmjVar = this.c;
            if (dmjVar.getMeasuredWidth() > 0) {
                int measuredWidth = dmjVar.getMeasuredWidth() - this.e.getPaddingLeft();
                if (this.ba == null || this.bb != measuredWidth) {
                    ColorDrawable colorDrawable = new ColorDrawable();
                    this.ba = colorDrawable;
                    this.bb = measuredWidth;
                    colorDrawable.setBounds(0, 0, measuredWidth, 1);
                }
                Drawable[] compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
                Drawable drawable = compoundDrawablesRelative[0];
                ColorDrawable colorDrawable2 = this.ba;
                if (drawable != colorDrawable2) {
                    this.e.setCompoundDrawablesRelative(colorDrawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z = true;
                } else {
                    z = false;
                }
            } else if (this.ba != null) {
                Drawable[] compoundDrawablesRelative2 = this.e.getCompoundDrawablesRelative();
                this.e.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.ba = null;
                z = true;
            } else {
                z = false;
            }
        } else if (this.ba != null) {
            Drawable[] compoundDrawablesRelative22 = this.e.getCompoundDrawablesRelative();
            this.e.setCompoundDrawablesRelative(null, compoundDrawablesRelative22[1], compoundDrawablesRelative22[2], compoundDrawablesRelative22[3]);
            this.ba = null;
            z = true;
        } else {
            z = false;
        }
        awa awaVar = this.d;
        if ((awaVar.aa() || ((awaVar.i != 0 && awaVar.z()) || awaVar.p != null)) && awaVar.getMeasuredWidth() > 0) {
            int measuredWidth2 = awaVar.q.getMeasuredWidth() - this.e.getPaddingRight();
            if (awaVar.aa()) {
                checkableImageButton = awaVar.c;
            } else if (awaVar.i != 0 && awaVar.z()) {
                checkableImageButton = awaVar.g;
            }
            if (checkableImageButton != null) {
                measuredWidth2 = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = this.e.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable3 = this.bd;
            if (colorDrawable3 != null && this.be != measuredWidth2) {
                this.be = measuredWidth2;
                colorDrawable3.setBounds(0, 0, measuredWidth2, 1);
                this.e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.bd, compoundDrawablesRelative3[3]);
                return true;
            }
            if (colorDrawable3 == null) {
                ColorDrawable colorDrawable4 = new ColorDrawable();
                this.bd = colorDrawable4;
                this.be = measuredWidth2;
                colorDrawable4.setBounds(0, 0, measuredWidth2, 1);
            }
            Drawable drawable2 = compoundDrawablesRelative3[2];
            ColorDrawable colorDrawable5 = this.bd;
            if (drawable2 != colorDrawable5) {
                this.bf = drawable2;
                this.e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], colorDrawable5, compoundDrawablesRelative3[3]);
                return true;
            }
        } else if (this.bd != null) {
            Drawable[] compoundDrawablesRelative4 = this.e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.bd) {
                this.e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.bf, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.bd = null;
            return z2;
        }
        return z;
    }

    public final void cr() {
        Drawable background;
        jp jpVar;
        EditText editText = this.e;
        if (editText == null || this.ap != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = apy.a;
        Drawable drawableMutate = background.mutate();
        if (cm()) {
            drawableMutate.setColorFilter(C0023if.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (jpVar = this.p) != null) {
            drawableMutate.setColorFilter(C0023if.e(jpVar.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.e.refreshDrawableState();
        }
    }

    public final void cs() {
        EditText editText = this.e;
        if (editText == null || this.ag == null) {
            return;
        }
        if ((this.aj || editText.getBackground() == null) && this.ap != 0) {
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            EditText editText2 = this.e;
            WeakHashMap weakHashMap = eqz.a;
            editText2.setBackground(editTextBoxBackground);
            this.aj = true;
        }
    }

    public final void ct() {
        if (this.ap != 1) {
            FrameLayout frameLayout = this.b;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iCd = cd();
            if (iCd != layoutParams.topMargin) {
                layoutParams.topMargin = iCd;
                frameLayout.requestLayout();
            }
        }
    }

    public final void cu(boolean z, boolean z2) {
        ColorStateList colorStateList;
        jp jpVar;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.bg;
        aat aatVar = this.bt;
        if (colorStateList2 != null) {
            aatVar.ca(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.bg;
            aatVar.ca(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.bq) : this.bq));
        } else if (cm()) {
            jp jpVar2 = this.k.r;
            aatVar.ca(jpVar2 != null ? jpVar2.getTextColors() : null);
        } else if (this.n && (jpVar = this.p) != null) {
            aatVar.ca(jpVar.getTextColors());
        } else if (z4 && (colorStateList = this.bh) != null && aatVar.o != colorStateList) {
            aatVar.o = colorStateList;
            aatVar.bz(false);
        }
        awa awaVar = this.d;
        dmj dmjVar = this.c;
        if (z3 || !this.bu || (isEnabled() && z4)) {
            if (z2 || this.bs) {
                ValueAnimator valueAnimator = this.bw;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.bw.cancel();
                }
                if (z && this.bv) {
                    cb(1.0f);
                } else {
                    aatVar.cg(1.0f);
                }
                this.bs = false;
                if (cf()) {
                    ck();
                }
                EditText editText3 = this.e;
                cv(editText3 != null ? editText3.getText() : null);
                dmjVar.j = false;
                dmjVar.o();
                awaVar.r = false;
                awaVar.aj();
                return;
            }
            return;
        }
        if (z2 || !this.bs) {
            ValueAnimator valueAnimator2 = this.bw;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.bw.cancel();
            }
            if (z && this.bv) {
                cb(0.0f);
            } else {
                aatVar.cg(0.0f);
            }
            if (cf() && !((aix) this.ag).b.a.isEmpty() && cf()) {
                ((aix) this.ag).d(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.bs = true;
            jp jpVar3 = this.u;
            if (jpVar3 != null && this.t) {
                jpVar3.setText((CharSequence) null);
                elp.d(this.b, this.y);
                this.u.setVisibility(4);
            }
            dmjVar.j = true;
            dmjVar.o();
            awaVar.r = true;
            awaVar.aj();
        }
    }

    public final void cv(Editable editable) {
        ((df) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.b;
        if (length != 0 || this.bs) {
            jp jpVar = this.u;
            if (jpVar == null || !this.t) {
                return;
            }
            jpVar.setText((CharSequence) null);
            elp.d(frameLayout, this.y);
            this.u.setVisibility(4);
            return;
        }
        if (this.u == null || !this.t || TextUtils.isEmpty(this.s)) {
            return;
        }
        this.u.setText(this.s);
        elp.d(frameLayout, this.x);
        this.u.setVisibility(0);
        this.u.bringToFront();
        announceForAccessibility(this.s);
    }

    public final void cw(boolean z, boolean z2) {
        int defaultColor = this.bl.getDefaultColor();
        int colorForState = this.bl.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.bl.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.au = colorForState2;
        } else if (z2) {
            this.au = colorForState;
        } else {
            this.au = defaultColor;
        }
    }

    public final void cx() {
        jp jpVar;
        EditText editText;
        EditText editText2;
        if (this.ag == null || this.ap == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.au = this.bq;
        } else if (cm()) {
            if (this.bl != null) {
                cw(z2, z);
            } else {
                this.au = getErrorCurrentTextColors();
            }
        } else if (!this.n || (jpVar = this.p) == null) {
            if (z2) {
                this.au = this.bk;
            } else if (z) {
                this.au = this.bj;
            } else {
                this.au = this.bi;
            }
        } else if (this.bl != null) {
            cw(z2, z);
        } else {
            this.au = jpVar.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            cp();
        }
        awa awaVar = this.d;
        TextInputLayout textInputLayout = awaVar.a;
        CheckableImageButton checkableImageButton = awaVar.g;
        TextInputLayout textInputLayout2 = awaVar.a;
        awaVar.ah();
        bhu.av(textInputLayout2, awaVar.c, awaVar.d);
        bhu.av(textInputLayout2, checkableImageButton, awaVar.k);
        if (awaVar.x() instanceof aql) {
            if (!textInputLayout.cm() || checkableImageButton.getDrawable() == null) {
                bhu.o(textInputLayout, checkableImageButton, awaVar.k, awaVar.l);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        dmj dmjVar = this.c;
        bhu.av(dmjVar.a, dmjVar.d, dmjVar.e);
        if (this.ap == 2) {
            int i = this.ar;
            if (z2 && isEnabled()) {
                this.ar = this.at;
            } else {
                this.ar = this.as;
            }
            if (this.ar != i && cf() && !this.bs) {
                if (cf()) {
                    ((aix) this.ag).d(0.0f, 0.0f, 0.0f, 0.0f);
                }
                ck();
            }
        }
        if (this.ap == 1) {
            if (!isEnabled()) {
                this.av = this.bn;
            } else if (z && !z2) {
                this.av = this.bp;
            } else if (z2) {
                this.av = this.bo;
            } else {
                this.av = this.bm;
            }
        }
        cc();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f != null) {
            boolean z = this.af;
            this.af = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.e.setHint(hint);
                this.af = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.b;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.by = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.by = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        cau cauVar;
        super.draw(canvas);
        boolean z = this.ad;
        aat aatVar = this.bt;
        if (z) {
            aatVar.bv(canvas);
        }
        if (this.al == null || (cauVar = this.ak) == null) {
            return;
        }
        cauVar.draw(canvas);
        if (this.e.isFocused()) {
            Rect bounds = this.al.getBounds();
            Rect bounds2 = this.ak.getBounds();
            float f = aatVar.b;
            int iCenterX = bounds2.centerX();
            bounds.left = ff.h(iCenterX, f, bounds2.left);
            bounds.right = ff.h(iCenterX, f, bounds2.right);
            this.al.draw(canvas);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        if (this.bx) {
            return;
        }
        this.bx = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        aat aatVar = this.bt;
        if (aatVar != null) {
            aatVar.ar = drawableState;
            ColorStateList colorStateList2 = aatVar.o;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = aatVar.n) == null || !colorStateList.isStateful())) {
                z = false;
            } else {
                aatVar.bz(false);
                z = true;
            }
        } else {
            z = false;
        }
        if (this.e != null) {
            WeakHashMap weakHashMap = eqz.a;
            cu(isLaidOut() && isEnabled(), false);
        }
        cr();
        cx();
        if (z) {
            invalidate();
        }
        this.bx = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return cd() + getPaddingTop() + editText.getBaseline();
    }

    public cau getBoxBackground() {
        int i = this.ap;
        if (i == 1 || i == 2) {
            return this.ag;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.av;
    }

    public int getBoxBackgroundMode() {
        return this.ap;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.aq;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zAl = ewz.al(this);
        RectF rectF = this.ay;
        return zAl ? this.am.h.b(rectF) : this.am.g.b(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zAl = ewz.al(this);
        RectF rectF = this.ay;
        return zAl ? this.am.g.b(rectF) : this.am.h.b(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zAl = ewz.al(this);
        RectF rectF = this.ay;
        return zAl ? this.am.e.b(rectF) : this.am.f.b(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zAl = ewz.al(this);
        RectF rectF = this.ay;
        return zAl ? this.am.f.b(rectF) : this.am.e.b(rectF);
    }

    public int getBoxStrokeColor() {
        return this.bk;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.bl;
    }

    public int getBoxStrokeWidth() {
        return this.as;
    }

    public int getBoxStrokeWidthFocused() {
        return this.at;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    public CharSequence getCounterOverflowDescription() {
        jp jpVar;
        if (this.l && this.n && (jpVar = this.p) != null) {
            return jpVar.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.aa;
    }

    public ColorStateList getCounterTextColor() {
        return this.z;
    }

    public ColorStateList getCursorColor() {
        return this.ab;
    }

    public ColorStateList getCursorErrorColor() {
        return this.ac;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.bg;
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.d.g.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.d.g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.d.m;
    }

    public int getEndIconMode() {
        return this.d.i;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.d.n;
    }

    public CheckableImageButton getEndIconView() {
        return this.d.g;
    }

    public CharSequence getError() {
        bpc bpcVar = this.k;
        if (bpcVar.q) {
            return bpcVar.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.k.t;
    }

    public CharSequence getErrorContentDescription() {
        return this.k.s;
    }

    public int getErrorCurrentTextColors() {
        jp jpVar = this.k.r;
        if (jpVar != null) {
            return jpVar.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.d.c.getDrawable();
    }

    public CharSequence getHelperText() {
        bpc bpcVar = this.k;
        if (bpcVar.x) {
            return bpcVar.w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        jp jpVar = this.k.y;
        if (jpVar != null) {
            return jpVar.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.ad) {
            return this.ae;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.bt.bw();
    }

    public final int getHintCurrentCollapsedTextColor() {
        aat aatVar = this.bt;
        return aatVar.bx(aatVar.o);
    }

    public ColorStateList getHintTextColor() {
        return this.bh;
    }

    public dqo getLengthCounter() {
        return this.o;
    }

    public int getMaxEms() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.j;
    }

    public int getMinEms() {
        return this.g;
    }

    public int getMinWidth() {
        return this.i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.d.g.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.d.g.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.t) {
            return this.s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.v;
    }

    public CharSequence getPrefixText() {
        return this.c.c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.c.b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.c.b;
    }

    public dgm getShapeAppearanceModel() {
        return this.am;
    }

    public CharSequence getStartIconContentDescription() {
        return this.c.d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.c.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.c.g;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.c.h;
    }

    public CharSequence getSuffixText() {
        return this.d.p;
    }

    public ColorStateList getSuffixTextColor() {
        return this.d.q.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.d.q;
    }

    public Typeface getTypeface() {
        return this.az;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bt.by(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        awa awaVar = this.d;
        awaVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.bz = false;
        if (this.e != null && this.e.getMeasuredHeight() < (iMax = Math.max(awaVar.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            this.e.setMinimumHeight(iMax);
            z = true;
        }
        boolean zCq = cq();
        if (z || zCq) {
            this.e.post(new dh(this, 19));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.e;
        if (editText != null) {
            ThreadLocal threadLocal = ama.a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.aw;
            rect.set(0, 0, width, height);
            ama.d(this, editText, rect);
            cau cauVar = this.ak;
            if (cauVar != null) {
                int i5 = rect.bottom;
                cauVar.setBounds(rect.left, i5 - this.as, rect.right, i5);
            }
            cau cauVar2 = this.al;
            if (cauVar2 != null) {
                int i6 = rect.bottom;
                cauVar2.setBounds(rect.left, i6 - this.at, rect.right, i6);
            }
            if (this.ad) {
                float textSize = this.e.getTextSize();
                aat aatVar = this.bt;
                if (aatVar.l != textSize) {
                    aatVar.l = textSize;
                    aatVar.bz(false);
                }
                int gravity = this.e.getGravity();
                aatVar.cc((gravity & (-113)) | 48);
                if (aatVar.j != gravity) {
                    aatVar.j = gravity;
                    aatVar.bz(false);
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                boolean zAl = ewz.al(this);
                int i7 = rect.bottom;
                Rect rect2 = this.ax;
                rect2.bottom = i7;
                int i8 = this.ap;
                if (i8 == 1) {
                    rect2.left = ch(rect.left, zAl);
                    rect2.top = rect.top + this.aq;
                    rect2.right = ci(rect.right, zAl);
                } else if (i8 != 2) {
                    rect2.left = ch(rect.left, zAl);
                    rect2.top = getPaddingTop();
                    rect2.right = ci(rect.right, zAl);
                } else {
                    rect2.left = this.e.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - cd();
                    rect2.right = rect.right - this.e.getPaddingRight();
                }
                int i9 = rect2.left;
                int i10 = rect2.top;
                int i11 = rect2.right;
                int i12 = rect2.bottom;
                Rect rect3 = aatVar.h;
                if (rect3.left != i9 || rect3.top != i10 || rect3.right != i11 || rect3.bottom != i12) {
                    rect3.set(i9, i10, i11, i12);
                    aatVar.as = true;
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = aatVar.au;
                textPaint.setTextSize(aatVar.l);
                textPaint.setTypeface(aatVar.z);
                textPaint.setLetterSpacing(aatVar.bg);
                float f = -textPaint.ascent();
                rect2.left = this.e.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.ap != 1 || this.e.getMinLines() > 1) ? rect.top + this.e.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.ap != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i13 = rect2.left;
                int i14 = rect2.top;
                int i15 = rect2.right;
                Rect rect4 = aatVar.g;
                if (rect4.left != i13 || rect4.top != i14 || rect4.right != i15 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i13, i14, i15, compoundPaddingBottom);
                    aatVar.as = true;
                }
                aatVar.bz(false);
                if (!cf() || this.bs) {
                    return;
                }
                ck();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.bz;
        awa awaVar = this.d;
        if (!z) {
            awaVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.bz = true;
        }
        if (this.u != null && (editText = this.e) != null) {
            this.u.setGravity(editText.getGravity());
            this.u.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        awaVar.ai();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof dqp)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        dqp dqpVar = (dqp) parcelable;
        super.onRestoreInstanceState(dqpVar.g);
        setError(dqpVar.a);
        if (dqpVar.b) {
            post(new dc(this, 17));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.an) {
            ahe aheVar = this.am.e;
            RectF rectF = this.ay;
            float fB = aheVar.b(rectF);
            float fB2 = this.am.f.b(rectF);
            float fB3 = this.am.h.b(rectF);
            float fB4 = this.am.g.b(rectF);
            dgm dgmVar = this.am;
            bhv bhvVar = dgmVar.a;
            bhv bhvVar2 = dgmVar.b;
            bhv bhvVar3 = dgmVar.d;
            bhv bhvVar4 = dgmVar.c;
            arj arjVar = new arj();
            arj arjVar2 = new arj();
            arj arjVar3 = new arj();
            arj arjVar4 = new arj();
            o oVar = new o(fB2);
            o oVar2 = new o(fB);
            o oVar3 = new o(fB4);
            o oVar4 = new o(fB3);
            dgm dgmVar2 = new dgm();
            dgmVar2.a = bhvVar2;
            dgmVar2.b = bhvVar;
            dgmVar2.c = bhvVar3;
            dgmVar2.d = bhvVar4;
            dgmVar2.e = oVar;
            dgmVar2.f = oVar2;
            dgmVar2.g = oVar4;
            dgmVar2.h = oVar3;
            dgmVar2.i = arjVar;
            dgmVar2.j = arjVar2;
            dgmVar2.k = arjVar3;
            dgmVar2.l = arjVar4;
            this.an = z;
            setShapeAppearanceModel(dgmVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        dqp dqpVar = new dqp(super.onSaveInstanceState());
        if (cm()) {
            dqpVar.a = getError();
        }
        awa awaVar = this.d;
        dqpVar.b = awaVar.i != 0 && awaVar.g.b;
        return dqpVar;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.av != i) {
            this.av = i;
            this.bm = i;
            this.bo = i;
            this.bp = i;
            cc();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.bm = defaultColor;
        this.av = defaultColor;
        this.bn = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.bo = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.bp = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        cc();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.ap) {
            return;
        }
        this.ap = i;
        if (this.e != null) {
            cj();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.aq = i;
    }

    public void setBoxCornerFamily(int i) {
        dgl dglVarQ = this.am.q();
        ahe aheVar = this.am.e;
        dglVarQ.a = cnd.ao(i);
        dglVarQ.e = aheVar;
        ahe aheVar2 = this.am.f;
        dglVarQ.b = cnd.ao(i);
        dglVarQ.f = aheVar2;
        ahe aheVar3 = this.am.h;
        dglVarQ.d = cnd.ao(i);
        dglVarQ.h = aheVar3;
        ahe aheVar4 = this.am.g;
        dglVarQ.c = cnd.ao(i);
        dglVarQ.g = aheVar4;
        this.am = dglVarQ.m();
        cc();
    }

    public void setBoxStrokeColor(int i) {
        if (this.bk != i) {
            this.bk = i;
            cx();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.bi = colorStateList.getDefaultColor();
            this.bq = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.bj = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.bk = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.bk != colorStateList.getDefaultColor()) {
            this.bk = colorStateList.getDefaultColor();
        }
        cx();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.bl != colorStateList) {
            this.bl = colorStateList;
            cx();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.as = i;
        cx();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.at = i;
        cx();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            bpc bpcVar = this.k;
            if (z) {
                jp jpVar = new jp(getContext(), null);
                this.p = jpVar;
                jpVar.setId(me.hd.wauxv.R.id.textinput_counter);
                Typeface typeface = this.az;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                bpcVar.ac(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(me.hd.wauxv.R.dimen.mtrl_textinput_counter_margin_start));
                co();
                if (this.p != null) {
                    EditText editText = this.e;
                    cn(editText != null ? editText.getText() : null);
                }
            } else {
                bpcVar.ai(this.p, 2);
                this.p = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i > 0) {
                this.m = i;
            } else {
                this.m = -1;
            }
            if (!this.l || this.p == null) {
                return;
            }
            EditText editText = this.e;
            cn(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            co();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.aa != colorStateList) {
            this.aa = colorStateList;
            co();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.r != i) {
            this.r = i;
            co();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            co();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.ab != colorStateList) {
            this.ab = colorStateList;
            cp();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.ac != colorStateList) {
            this.ac = colorStateList;
            if (cm() || (this.p != null && this.n)) {
                cp();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.bg = colorStateList;
        this.bh = colorStateList;
        if (this.e != null) {
            cu(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        ca(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.d.g.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.d.g.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        awa awaVar = this.d;
        CharSequence text = i != 0 ? awaVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = awaVar.g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        awa awaVar = this.d;
        Drawable drawableY = i != 0 ? cmz.y(awaVar.getContext(), i) : null;
        TextInputLayout textInputLayout = awaVar.a;
        CheckableImageButton checkableImageButton = awaVar.g;
        checkableImageButton.setImageDrawable(drawableY);
        if (drawableY != null) {
            bhu.o(textInputLayout, checkableImageButton, awaVar.k, awaVar.l);
            bhu.av(textInputLayout, checkableImageButton, awaVar.k);
        }
    }

    public void setEndIconMinSize(int i) {
        awa awaVar = this.d;
        if (i < 0) {
            awaVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != awaVar.m) {
            awaVar.m = i;
            CheckableImageButton checkableImageButton = awaVar.g;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = awaVar.c;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.d.ac(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        awa awaVar = this.d;
        CheckableImageButton checkableImageButton = awaVar.g;
        View.OnLongClickListener onLongClickListener = awaVar.o;
        checkableImageButton.setOnClickListener(onClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        awa awaVar = this.d;
        awaVar.o = onLongClickListener;
        CheckableImageButton checkableImageButton = awaVar.g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        awa awaVar = this.d;
        awaVar.n = scaleType;
        awaVar.g.setScaleType(scaleType);
        awaVar.c.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        awa awaVar = this.d;
        if (awaVar.k != colorStateList) {
            awaVar.k = colorStateList;
            bhu.o(awaVar.a, awaVar.g, colorStateList, awaVar.l);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        awa awaVar = this.d;
        if (awaVar.l != mode) {
            awaVar.l = mode;
            bhu.o(awaVar.a, awaVar.g, awaVar.k, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.d.ad(z);
    }

    public void setError(CharSequence charSequence) {
        bpc bpcVar = this.k;
        if (!bpcVar.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            bpcVar.ah();
            return;
        }
        bpcVar.ae();
        bpcVar.p = charSequence;
        bpcVar.r.setText(charSequence);
        int i = bpcVar.n;
        if (i != 1) {
            bpcVar.o = 1;
        }
        bpcVar.ak(i, bpcVar.o, bpcVar.aj(bpcVar.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        bpc bpcVar = this.k;
        bpcVar.t = i;
        jp jpVar = bpcVar.r;
        if (jpVar != null) {
            WeakHashMap weakHashMap = eqz.a;
            jpVar.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        bpc bpcVar = this.k;
        bpcVar.s = charSequence;
        jp jpVar = bpcVar.r;
        if (jpVar != null) {
            jpVar.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        bpc bpcVar = this.k;
        TextInputLayout textInputLayout = bpcVar.h;
        if (bpcVar.q == z) {
            return;
        }
        bpcVar.ae();
        if (z) {
            jp jpVar = new jp(bpcVar.g, null);
            bpcVar.r = jpVar;
            jpVar.setId(me.hd.wauxv.R.id.textinput_error);
            bpcVar.r.setTextAlignment(5);
            Typeface typeface = bpcVar.ab;
            if (typeface != null) {
                bpcVar.r.setTypeface(typeface);
            }
            int i = bpcVar.u;
            bpcVar.u = i;
            jp jpVar2 = bpcVar.r;
            if (jpVar2 != null) {
                bpcVar.h.cl(jpVar2, i);
            }
            ColorStateList colorStateList = bpcVar.v;
            bpcVar.v = colorStateList;
            jp jpVar3 = bpcVar.r;
            if (jpVar3 != null && colorStateList != null) {
                jpVar3.setTextColor(colorStateList);
            }
            CharSequence charSequence = bpcVar.s;
            bpcVar.s = charSequence;
            jp jpVar4 = bpcVar.r;
            if (jpVar4 != null) {
                jpVar4.setContentDescription(charSequence);
            }
            int i2 = bpcVar.t;
            bpcVar.t = i2;
            jp jpVar5 = bpcVar.r;
            if (jpVar5 != null) {
                WeakHashMap weakHashMap = eqz.a;
                jpVar5.setAccessibilityLiveRegion(i2);
            }
            bpcVar.r.setVisibility(4);
            bpcVar.ac(bpcVar.r, 0);
        } else {
            bpcVar.ah();
            bpcVar.ai(bpcVar.r, 0);
            bpcVar.r = null;
            textInputLayout.cr();
            textInputLayout.cx();
        }
        bpcVar.q = z;
    }

    public void setErrorIconDrawable(int i) {
        awa awaVar = this.d;
        awaVar.ae(i != 0 ? cmz.y(awaVar.getContext(), i) : null);
        bhu.av(awaVar.a, awaVar.c, awaVar.d);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        awa awaVar = this.d;
        CheckableImageButton checkableImageButton = awaVar.c;
        View.OnLongClickListener onLongClickListener = awaVar.f;
        checkableImageButton.setOnClickListener(onClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        awa awaVar = this.d;
        awaVar.f = onLongClickListener;
        CheckableImageButton checkableImageButton = awaVar.c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        awa awaVar = this.d;
        if (awaVar.d != colorStateList) {
            awaVar.d = colorStateList;
            bhu.o(awaVar.a, awaVar.c, colorStateList, awaVar.e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        awa awaVar = this.d;
        if (awaVar.e != mode) {
            awaVar.e = mode;
            bhu.o(awaVar.a, awaVar.c, awaVar.d, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        bpc bpcVar = this.k;
        bpcVar.u = i;
        jp jpVar = bpcVar.r;
        if (jpVar != null) {
            bpcVar.h.cl(jpVar, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        bpc bpcVar = this.k;
        bpcVar.v = colorStateList;
        jp jpVar = bpcVar.r;
        if (jpVar == null || colorStateList == null) {
            return;
        }
        jpVar.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.bu != z) {
            this.bu = z;
            cu(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        bpc bpcVar = this.k;
        if (zIsEmpty) {
            if (bpcVar.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!bpcVar.x) {
            setHelperTextEnabled(true);
        }
        bpcVar.ae();
        bpcVar.w = charSequence;
        bpcVar.y.setText(charSequence);
        int i = bpcVar.n;
        if (i != 2) {
            bpcVar.o = 2;
        }
        bpcVar.ak(i, bpcVar.o, bpcVar.aj(bpcVar.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        bpc bpcVar = this.k;
        bpcVar.aa = colorStateList;
        jp jpVar = bpcVar.y;
        if (jpVar == null || colorStateList == null) {
            return;
        }
        jpVar.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        bpc bpcVar = this.k;
        TextInputLayout textInputLayout = bpcVar.h;
        if (bpcVar.x == z) {
            return;
        }
        bpcVar.ae();
        if (z) {
            jp jpVar = new jp(bpcVar.g, null);
            bpcVar.y = jpVar;
            jpVar.setId(me.hd.wauxv.R.id.textinput_helper_text);
            bpcVar.y.setTextAlignment(5);
            Typeface typeface = bpcVar.ab;
            if (typeface != null) {
                bpcVar.y.setTypeface(typeface);
            }
            bpcVar.y.setVisibility(4);
            bpcVar.y.setAccessibilityLiveRegion(1);
            int i = bpcVar.z;
            bpcVar.z = i;
            jp jpVar2 = bpcVar.y;
            if (jpVar2 != null) {
                jpVar2.setTextAppearance(i);
            }
            ColorStateList colorStateList = bpcVar.aa;
            bpcVar.aa = colorStateList;
            jp jpVar3 = bpcVar.y;
            if (jpVar3 != null && colorStateList != null) {
                jpVar3.setTextColor(colorStateList);
            }
            bpcVar.ac(bpcVar.y, 1);
            bpcVar.y.setAccessibilityDelegate(new bpb(bpcVar));
        } else {
            bpcVar.ae();
            int i2 = bpcVar.n;
            if (i2 == 2) {
                bpcVar.o = 0;
            }
            bpcVar.ak(i2, bpcVar.o, bpcVar.aj(bpcVar.y, ""));
            bpcVar.ai(bpcVar.y, 1);
            bpcVar.y = null;
            textInputLayout.cr();
            textInputLayout.cx();
        }
        bpcVar.x = z;
    }

    public void setHelperTextTextAppearance(int i) {
        bpc bpcVar = this.k;
        bpcVar.z = i;
        jp jpVar = bpcVar.y;
        if (jpVar != null) {
            jpVar.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ad) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.bv = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.ad) {
            this.ad = z;
            if (z) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.ae)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.af = true;
            } else {
                this.af = false;
                if (!TextUtils.isEmpty(this.ae) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.ae);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                ct();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        aat aatVar = this.bt;
        aatVar.cb(i);
        this.bh = aatVar.o;
        if (this.e != null) {
            cu(false, false);
            ct();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.bh != colorStateList) {
            if (this.bg == null) {
                aat aatVar = this.bt;
                if (aatVar.o != colorStateList) {
                    aatVar.o = colorStateList;
                    aatVar.bz(false);
                }
            }
            this.bh = colorStateList;
            if (this.e != null) {
                cu(false, false);
            }
        }
    }

    public void setLengthCounter(dqo dqoVar) {
        this.o = dqoVar;
    }

    public void setMaxEms(int i) {
        this.h = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.j = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.g = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.i = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        awa awaVar = this.d;
        awaVar.g.setContentDescription(i != 0 ? awaVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        awa awaVar = this.d;
        awaVar.g.setImageDrawable(i != 0 ? cmz.y(awaVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        awa awaVar = this.d;
        if (z && awaVar.i != 1) {
            awaVar.ac(1);
        } else if (z) {
            awaVar.getClass();
        } else {
            awaVar.ac(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        awa awaVar = this.d;
        awaVar.k = colorStateList;
        bhu.o(awaVar.a, awaVar.g, colorStateList, awaVar.l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        awa awaVar = this.d;
        awaVar.l = mode;
        bhu.o(awaVar.a, awaVar.g, awaVar.k, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.u == null) {
            jp jpVar = new jp(getContext(), null);
            this.u = jpVar;
            jpVar.setId(me.hd.wauxv.R.id.textinput_placeholder);
            this.u.setImportantForAccessibility(2);
            axy axyVarCe = ce();
            this.x = axyVarCe;
            axyVarCe.ah = 67L;
            this.y = ce();
            setPlaceholderTextAppearance(this.w);
            setPlaceholderTextColor(this.v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.t) {
                setPlaceholderTextEnabled(true);
            }
            this.s = charSequence;
        }
        EditText editText = this.e;
        cv(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.w = i;
        jp jpVar = this.u;
        if (jpVar != null) {
            jpVar.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            jp jpVar = this.u;
            if (jpVar == null || colorStateList == null) {
                return;
            }
            jpVar.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        dmj dmjVar = this.c;
        dmjVar.getClass();
        dmjVar.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        dmjVar.b.setText(charSequence);
        dmjVar.o();
    }

    public void setPrefixTextAppearance(int i) {
        this.c.b.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.c.b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(dgm dgmVar) {
        cau cauVar = this.ag;
        if (cauVar == null || cauVar.ct.b == dgmVar) {
            return;
        }
        this.am = dgmVar;
        cc();
    }

    public void setStartIconCheckable(boolean z) {
        this.c.d.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? cmz.y(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        dmj dmjVar = this.c;
        if (i < 0) {
            dmjVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != dmjVar.g) {
            dmjVar.g = i;
            CheckableImageButton checkableImageButton = dmjVar.d;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        dmj dmjVar = this.c;
        CheckableImageButton checkableImageButton = dmjVar.d;
        View.OnLongClickListener onLongClickListener = dmjVar.i;
        checkableImageButton.setOnClickListener(onClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        dmj dmjVar = this.c;
        dmjVar.i = onLongClickListener;
        CheckableImageButton checkableImageButton = dmjVar.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        bhu.bb(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        dmj dmjVar = this.c;
        dmjVar.h = scaleType;
        dmjVar.d.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        dmj dmjVar = this.c;
        if (dmjVar.e != colorStateList) {
            dmjVar.e = colorStateList;
            bhu.o(dmjVar.a, dmjVar.d, colorStateList, dmjVar.f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        dmj dmjVar = this.c;
        if (dmjVar.f != mode) {
            dmjVar.f = mode;
            bhu.o(dmjVar.a, dmjVar.d, dmjVar.e, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.c.m(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        awa awaVar = this.d;
        awaVar.getClass();
        awaVar.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        awaVar.q.setText(charSequence);
        awaVar.aj();
    }

    public void setSuffixTextAppearance(int i) {
        this.d.q.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.d.q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(dqn dqnVar) {
        EditText editText = this.e;
        if (editText != null) {
            eqz.s(editText, dqnVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.az) {
            this.az = typeface;
            aat aatVar = this.bt;
            boolean zCd = aatVar.cd(typeface);
            boolean zCf = aatVar.cf(typeface);
            if (zCd || zCf) {
                aatVar.bz(false);
            }
            bpc bpcVar = this.k;
            if (typeface != bpcVar.ab) {
                bpcVar.ab = typeface;
                jp jpVar = bpcVar.r;
                if (jpVar != null) {
                    jpVar.setTypeface(typeface);
                }
                jp jpVar2 = bpcVar.y;
                if (jpVar2 != null) {
                    jpVar2.setTypeface(typeface);
                }
            }
            jp jpVar3 = this.p;
            if (jpVar3 != null) {
                jpVar3.setTypeface(typeface);
            }
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.c.d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.c.l(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.d.g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.d.g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.d.ae(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.d.g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        awa awaVar = this.d;
        TextInputLayout textInputLayout = awaVar.a;
        CheckableImageButton checkableImageButton = awaVar.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            bhu.o(textInputLayout, checkableImageButton, awaVar.k, awaVar.l);
            bhu.av(textInputLayout, checkableImageButton, awaVar.k);
        }
    }
}
