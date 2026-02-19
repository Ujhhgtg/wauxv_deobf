package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.slider.Slider;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ns extends View {
    public final Paint a;
    public int aa;
    public int ab;
    public int ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;
    public int ah;
    public int ai;
    public int aj;
    public int ak;
    public int al;
    public final int am;
    public float an;
    public MotionEvent ao;
    public boolean ap;
    public float aq;
    public float ar;
    public ArrayList as;
    public int at;
    public int au;
    public float av;
    public float[] aw;
    public boolean ax;
    public int ay;
    public int az;
    public final Paint b;
    public int ba;
    public boolean bb;
    public boolean bc;
    public ColorStateList bd;
    public ColorStateList be;
    public ColorStateList bf;
    public ColorStateList bg;
    public ColorStateList bh;
    public final Path bi;
    public final RectF bj;
    public final RectF bk;
    public final cau bl;
    public Drawable bm;
    public List bn;
    public float bo;
    public int bp;
    public final nn bq;
    public final Paint c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final nq h;
    public final AccessibilityManager i;
    public np j;
    public final int k;
    public final ArrayList l;
    public final ArrayList m;
    public final ArrayList n;
    public boolean o;
    public ValueAnimator p;
    public ValueAnimator q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* JADX WARN: Type inference failed for: r1v5, types: [me.hd.wauxv.obf.nn] */
    public ns(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider), attributeSet,
                R.attr.sliderStyle);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = false;
        this.ai = -1;
        this.aj = -1;
        this.ap = false;
        this.as = new ArrayList();
        this.at = -1;
        this.au = -1;
        this.av = 0.0f;
        this.ax = true;
        this.bb = false;
        this.bi = new Path();
        this.bj = new RectF();
        this.bk = new RectF();
        cau cauVar = new cau();
        this.bl = cauVar;
        this.bn = Collections.EMPTY_LIST;
        this.bp = 0;
        final Slider slider = (Slider) this;
        this.bq = new ViewTreeObserver.OnScrollChangedListener() { // from class: me.hd.wauxv.obf.nn
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                slider.cn();
            }
        };
        Context context2 = getContext();
        this.a = new Paint();
        this.b = new Paint();
        Paint paint = new Paint(1);
        this.c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.z = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.s = dimensionPixelOffset;
        this.ad = dimensionPixelOffset;
        this.t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.w = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.am = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        FastKV.p(context2, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        int[] iArr = cxs.al;
        FastKV.q(context2, attributeSet, iArr, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr,
                R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        this.k = typedArrayObtainStyledAttributes.getResourceId(8, R.style.Widget_MaterialComponents_Tooltip);
        this.aq = typedArrayObtainStyledAttributes.getFloat(3, 0.0f);
        this.ar = typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.aq));
        this.av = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
        this.y = (int) Math
                .ceil(typedArrayObtainStyledAttributes.getDimension(9, (float) Math.ceil(StaticAndroidHelpers.ag(getContext(), 48))));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(24);
        int i = zHasValue ? 24 : 26;
        int i2 = zHasValue ? 24 : 25;
        ColorStateList colorStateListV = cnb.v(context2, typedArrayObtainStyledAttributes, i);
        setTrackInactiveTintList(colorStateListV == null ? ResourcesCompat.v(context2, R.color.material_slider_inactive_track_color)
                : colorStateListV);
        ColorStateList colorStateListV2 = cnb.v(context2, typedArrayObtainStyledAttributes, i2);
        setTrackActiveTintList(colorStateListV2 == null ? ResourcesCompat.v(context2, R.color.material_slider_active_track_color)
                : colorStateListV2);
        cauVar.dz(cnb.v(context2, typedArrayObtainStyledAttributes, 10));
        if (typedArrayObtainStyledAttributes.hasValue(14)) {
            setThumbStrokeColor(cnb.v(context2, typedArrayObtainStyledAttributes, 14));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(15, 0.0f));
        ColorStateList colorStateListV3 = cnb.v(context2, typedArrayObtainStyledAttributes, 5);
        setHaloTintList(
                colorStateListV3 == null ? ResourcesCompat.v(context2, R.color.material_slider_halo_color) : colorStateListV3);
        this.ax = typedArrayObtainStyledAttributes.getBoolean(23, true);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(18);
        int i3 = zHasValue2 ? 18 : 20;
        int i4 = zHasValue2 ? 18 : 19;
        ColorStateList colorStateListV4 = cnb.v(context2, typedArrayObtainStyledAttributes, i3);
        setTickInactiveTintList(
                colorStateListV4 == null ? ResourcesCompat.v(context2, R.color.material_slider_inactive_tick_marks_color)
                        : colorStateListV4);
        ColorStateList colorStateListV5 = cnb.v(context2, typedArrayObtainStyledAttributes, i4);
        setTickActiveTintList(
                colorStateListV5 == null ? ResourcesCompat.v(context2, R.color.material_slider_active_tick_marks_color)
                        : colorStateListV5);
        setThumbTrackGapSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0));
        setTrackStopIndicatorSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(29, 0));
        setTrackInsideCornerSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(28, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, 0) * 2;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(11, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(27, 0));
        setTickActiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(21, this.ak / 2));
        setTickInactiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(22, this.ak / 2));
        setLabelBehavior(typedArrayObtainStyledAttributes.getInt(7, 0));
        if (!typedArrayObtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        cauVar.ec();
        this.r = ViewConfiguration.get(context2).getScaledTouchSlop();
        nq nqVar = new nq(slider);
        this.h = nqVar;
        ViewCompat.setAccessibilityDelegate(this, nqVar);
        this.i = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public final void br(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.ae, this.af);
        } else {
            float fMax = Math.max(this.ae, this.af) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final int bs() {
        int i = this.aa / 2;
        int i2 = this.ab;
        return i + ((i2 == 1 || i2 == 3) ? ((ekv) this.l.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator bt(boolean z) {
        int iAd;
        TimeInterpolator timeInterpolatorAe;
        float fFloatValue = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.q : this.p;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z ? 1.0f : 0.0f);
        if (z) {
            iAd = ajn.ad(getContext(), R.attr.motionDurationMedium4, 83);
            timeInterpolatorAe = ajn.ae(getContext(), R.attr.motionEasingEmphasizedInterpolator, ff.e);
        } else {
            iAd = ajn.ad(getContext(), R.attr.motionDurationShort3, 117);
            timeInterpolatorAe = ajn.ae(getContext(), R.attr.motionEasingEmphasizedAccelerateInterpolator, ff.c);
        }
        valueAnimatorOfFloat.setDuration(iAd);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorAe);
        valueAnimatorOfFloat.addUpdateListener(new no(this, 0));
        return valueAnimatorOfFloat;
    }

    public final void bu(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        canvas.translate((this.ad + ((int) (cf(f) * i))) - (drawable.getBounds().width() / 2.0f),
                i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void bv() {
        if (!this.o) {
            this.o = true;
            ValueAnimator valueAnimatorBt = bt(true);
            this.p = valueAnimatorBt;
            this.q = null;
            valueAnimatorBt.start();
        }
        ArrayList arrayList = this.l;
        Iterator it = arrayList.iterator();
        for (int i = 0; i < this.as.size() && it.hasNext(); i++) {
            if (i != this.au) {
                ch((ekv) it.next(), ((Float) this.as.get(i)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)",
                    Integer.valueOf(arrayList.size()), Integer.valueOf(this.as.size())));
        }
        ch((ekv) it.next(), ((Float) this.as.get(this.au)).floatValue());
    }

    public final void bw() {
        if (this.o) {
            this.o = false;
            ValueAnimator valueAnimatorBt = bt(false);
            this.q = valueAnimatorBt;
            this.p = null;
            valueAnimatorBt.addListener(new ci(this, 2));
            this.q.start();
        }
    }

    public final float[] bx() {
        float fFloatValue = ((Float) this.as.get(0)).floatValue();
        float fFloatValue2 = ((Float) StaticHelpers6.getLastNElem(1, this.as)).floatValue();
        if (this.as.size() == 1) {
            fFloatValue = this.aq;
        }
        float fCf = cf(fFloatValue);
        float fCf2 = cf(fFloatValue2);
        return cb() ? new float[] { fCf2, fCf } : new float[] { fCf, fCf2 };
    }

    public final int by(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean bz(double d) {
        double dDoubleValue = new BigDecimal(Double.toString(d))
                .divide(new BigDecimal(Float.toString(this.av)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean ca(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1))
                        && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean cb() {
        WeakHashMap weakHashMap = ViewCompat.a;
        return getLayoutDirection() == 1;
    }

    public final void cc() {
        if (this.av <= 0.0f) {
            return;
        }
        cq();
        int iMin = Math.min((int) (((this.ar - this.aq) / this.av) + 1.0f), (this.ba / this.x) + 1);
        float[] fArr = this.aw;
        if (fArr == null || fArr.length != iMin * 2) {
            this.aw = new float[iMin * 2];
        }
        float f = this.ba / (iMin - 1);
        for (int i = 0; i < iMin * 2; i += 2) {
            float[] fArr2 = this.aw;
            fArr2[i] = ((i / 2.0f) * f) + this.ad;
            fArr2[i + 1] = bs();
        }
    }

    public final boolean cd(int i) {
        int i2 = this.au;
        long j = ((long) i2) + ((long) i);
        long size = this.as.size() - 1;
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i3 = (int) j;
        this.au = i3;
        if (i3 == i2) {
            return false;
        }
        if (this.at != -1) {
            this.at = i3;
        }
        cm();
        postInvalidate();
        return true;
    }

    public final void ce(int i) {
        if (cb()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        cd(i);
    }

    public final float cf(float f) {
        float f2 = this.aq;
        float f3 = (f - f2) / (this.ar - f2);
        return cb() ? 1.0f - f3 : f3;
    }

    public final void cg() {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
    }

    public final void ch(ekv ekvVar, float f) {
        String str = String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
        if (!TextUtils.equals(ekvVar.a, str)) {
            ekvVar.a = str;
            ekvVar.e.e = true;
            ekvVar.invalidateSelf();
        }
        int iCf = (this.ad + ((int) (cf(f) * this.ba))) - (ekvVar.getIntrinsicWidth() / 2);
        int iBs = bs() - ((this.af / 2) + this.am);
        ekvVar.setBounds(iCf, iBs - ekvVar.getIntrinsicHeight(), ekvVar.getIntrinsicWidth() + iCf, iBs);
        Rect rect = new Rect(ekvVar.getBounds());
        ama.d(StaticAndroidHelpers.ah(this), this, rect);
        ekvVar.setBounds(rect);
        ViewGroup viewGroupAh = StaticAndroidHelpers.ah(this);
        ((ViewOverlay) (viewGroupAh == null ? null : new InstantCollection(viewGroupAh)).cachedConstructors).add(ekvVar);
    }

    public final void ci(ArrayList arrayList) {
        ViewGroup viewGroupAh;
        int resourceId;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.as.size() == arrayList.size() && this.as.equals(arrayList)) {
            return;
        }
        this.as = arrayList;
        this.bc = true;
        this.au = 0;
        cm();
        ArrayList<ekv> arrayList2 = this.l;
        if (arrayList2.size() > this.as.size()) {
            List<ekv> listSubList = arrayList2.subList(this.as.size(), arrayList2.size());
            for (ekv ekvVar : listSubList) {
                WeakHashMap weakHashMap = ViewCompat.a;
                if (isAttachedToWindow()) {
                    ViewGroup viewGroupAh2 = StaticAndroidHelpers.ah(this);
                    InstantCollection instantCollectionVar = viewGroupAh2 == null ? null : new InstantCollection(viewGroupAh2);
                    if (instantCollectionVar != null) {
                        ((ViewOverlay) instantCollectionVar.instantBuilders).remove(ekvVar);
                        ViewGroup viewGroupAh3 = StaticAndroidHelpers.ah(this);
                        if (viewGroupAh3 == null) {
                            ekvVar.getClass();
                        } else {
                            viewGroupAh3.removeOnLayoutChangeListener(ekvVar.f);
                        }
                    }
                }
            }
            listSubList.clear();
        }
        while (arrayList2.size() < this.as.size()) {
            Context context = getContext();
            int i = this.k;
            ekv ekvVar2 = new ekv(context, i);
            TypedArray typedArrayAn = FastKV.an(ekvVar2.b, null, cxs.as, 0, i, new int[0]);
            Context context2 = ekvVar2.b;
            ekvVar2.m = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            boolean z = typedArrayAn.getBoolean(8, true);
            ekvVar2.l = z;
            if (z) {
                dgl dglVarQ = ekvVar2.ct.b.q();
                dglVarQ.k = ekvVar2.u();
                ekvVar2.setShapeAppearanceModel(dglVarQ.m());
            } else {
                ekvVar2.m = 0;
            }
            CharSequence text = typedArrayAn.getText(6);
            boolean zEquals = TextUtils.equals(ekvVar2.a, text);
            dqk dqkVar = ekvVar2.e;
            if (!zEquals) {
                ekvVar2.a = text;
                dqkVar.e = true;
                ekvVar2.invalidateSelf();
            }
            dqh dqhVar = (!typedArrayAn.hasValue(0) || (resourceId = typedArrayAn.getResourceId(0, 0)) == 0) ? null
                    : new dqh(context2, resourceId);
            if (dqhVar != null && typedArrayAn.hasValue(1)) {
                dqhVar.j = cnb.v(context2, typedArrayAn, 1);
            }
            dqkVar.j(dqhVar, context2);
            ekvVar2.dz(ColorStateList.valueOf(typedArrayAn.getColor(7, abi.d(
                    abi.f(cna.u(context2, R.attr.colorOnBackground, ekv.class.getCanonicalName()), 153),
                    abi.f(cna.u(context2, android.R.attr.colorBackground, ekv.class.getCanonicalName()), 229)))));
            ekvVar2.ed(ColorStateList.valueOf(cna.u(context2, R.attr.colorSurface, ekv.class.getCanonicalName())));
            ekvVar2.h = typedArrayAn.getDimensionPixelSize(2, 0);
            ekvVar2.i = typedArrayAn.getDimensionPixelSize(4, 0);
            ekvVar2.j = typedArrayAn.getDimensionPixelSize(5, 0);
            ekvVar2.k = typedArrayAn.getDimensionPixelSize(3, 0);
            typedArrayAn.recycle();
            arrayList2.add(ekvVar2);
            WeakHashMap weakHashMap2 = ViewCompat.a;
            if (isAttachedToWindow() && (viewGroupAh = StaticAndroidHelpers.ah(this)) != null) {
                int[] iArr = new int[2];
                viewGroupAh.getLocationOnScreen(iArr);
                ekvVar2.o = iArr[0];
                viewGroupAh.getWindowVisibleDisplayFrame(ekvVar2.g);
                viewGroupAh.addOnLayoutChangeListener(ekvVar2.f);
            }
        }
        int i2 = arrayList2.size() == 1 ? 0 : 1;
        for (ekv ekvVar3 : arrayList2) {
            ekvVar3.ct.k = i2;
            ekvVar3.invalidateSelf();
        }
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            Iterator it2 = this.as.iterator();
            if (it2.hasNext()) {
                ((Float) it2.next()).getClass();
                throw null;
            }
        }
        postInvalidate();
    }

    public final boolean cj(int i, float f) {
        this.au = i;
        if (Math.abs(f - ((Float) this.as.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.bp == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f2 = this.aq;
                minSeparation = yg.a(f2, this.ar, (minSeparation - this.ad) / this.ba, f2);
            }
        }
        if (cb()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        this.as.set(i,
                Float.valueOf(HugeSyntheticPileOfHelpers.ar(f, i3 < 0 ? this.aq : minSeparation + ((Float) this.as.get(i3)).floatValue(),
                        i2 >= this.as.size() ? this.ar : ((Float) this.as.get(i2)).floatValue() - minSeparation)));
        Iterator it = this.m.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            ((Float) this.as.get(i)).getClass();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.i;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            Runnable runnable = this.j;
            if (runnable == null) {
                this.j = new np(this);
            } else {
                removeCallbacks(runnable);
            }
            np npVar = this.j;
            npVar.b = i;
            postDelayed(npVar, 200L);
        }
        return true;
    }

    public final void ck() {
        double dRound;
        float f = this.bo;
        float f2 = this.av;
        if (f2 > 0.0f) {
            int i = (int) ((this.ar - this.aq) / f2);
            dRound = ((double) Math.round(f * i)) / ((double) i);
        } else {
            dRound = f;
        }
        if (cb()) {
            dRound = 1.0d - dRound;
        }
        float f3 = this.ar;
        float f4 = this.aq;
        cj(this.at, (float) ((dRound * ((double) (f3 - f4))) + ((double) f4)));
    }

    public final void cl(int i, Rect rect) {
        int iCf = this.ad + ((int) (cf(getValues().get(i).floatValue()) * this.ba));
        int iBs = bs();
        int iMax = Math.max(this.ae / 2, this.y / 2);
        int iMax2 = Math.max(this.af / 2, this.y / 2);
        rect.set(iCf - iMax, iBs - iMax2, iCf + iMax, iBs + iMax2);
    }

    public final void cm() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iCf = (int) ((cf(((Float) this.as.get(this.au)).floatValue()) * this.ba) + this.ad);
            int iBs = bs();
            int i = this.ag;
            background.setHotspotBounds(iCf - i, iBs - i, iCf + i, iBs + i);
        }
    }

    public final void cn() {
        int i = this.ab;
        if (i == 0 || i == 1) {
            if (this.at == -1 || !isEnabled()) {
                bw();
                return;
            } else {
                bv();
                return;
            }
        }
        if (i == 2) {
            bw();
            return;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.ab);
        }
        if (isEnabled()) {
            Rect rect = new Rect();
            StaticAndroidHelpers.ah(this).getHitRect(rect);
            if (getLocalVisibleRect(rect)) {
                bv();
                return;
            }
        }
        bw();
    }

    public final void co(Canvas canvas, Paint paint, RectF rectF, int i) {
        float f;
        float f2 = this.ac / 2.0f;
        int iAe = StaticHelpers6.ae(i);
        if (iAe == 1) {
            f = this.al;
        } else if (iAe != 2) {
            if (iAe == 3) {
                f2 = this.al;
            }
            f = f2;
        } else {
            f = f2;
            f2 = this.al;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        Path path = this.bi;
        path.reset();
        if (rectF.width() >= f2 + f) {
            path.addRoundRect(rectF, new float[] { f2, f2, f, f, f, f, f2, f2 }, Path.Direction.CW);
            canvas.drawPath(path, paint);
            return;
        }
        float fMin = Math.min(f2, f);
        float fMax = Math.max(f2, f);
        canvas.save();
        path.addRoundRect(rectF, fMin, fMin, Path.Direction.CW);
        canvas.clipPath(path);
        int iAe2 = StaticHelpers6.ae(i);
        RectF rectF2 = this.bk;
        if (iAe2 == 1) {
            float f3 = rectF.left;
            rectF2.set(f3, rectF.top, (2.0f * fMax) + f3, rectF.bottom);
        } else if (iAe2 != 2) {
            rectF2.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
        } else {
            float f4 = rectF.right;
            rectF2.set(f4 - (2.0f * fMax), rectF.top, f4, rectF.bottom);
        }
        canvas.drawRoundRect(rectF2, fMax, fMax, paint);
        canvas.restore();
    }

    public final void cp() {
        boolean z;
        int iMax = Math.max(this.z, Math.max(this.ac + getPaddingBottom() + getPaddingTop(),
                getPaddingBottom() + getPaddingTop() + this.af));
        boolean z2 = true;
        if (iMax == this.aa) {
            z = false;
        } else {
            this.aa = iMax;
            z = true;
        }
        int iMax2 = Math.max(Math.max(Math.max((this.ae / 2) - this.t, 0), Math.max((this.ac - this.u) / 2, 0)),
                Math.max(Math.max(this.ay - this.v, 0), Math.max(this.az - this.w, 0))) + this.s;
        if (this.ad == iMax2) {
            z2 = false;
        } else {
            this.ad = iMax2;
            WeakHashMap weakHashMap = ViewCompat.a;
            if (isLaidOut()) {
                this.ba = Math.max(getWidth() - (this.ad * 2), 0);
                cc();
            }
        }
        if (z) {
            requestLayout();
        } else if (z2) {
            postInvalidate();
        }
    }

    public final void cq() {
        if (this.bc) {
            float f = this.aq;
            float f2 = this.ar;
            if (f >= f2) {
                throw new IllegalStateException(
                        "valueFrom(" + this.aq + ") must be smaller than valueTo(" + this.ar + ")");
            }
            if (f2 <= f) {
                throw new IllegalStateException(
                        "valueTo(" + this.ar + ") must be greater than valueFrom(" + this.aq + ")");
            }
            if (this.av > 0.0f && !cr(f2)) {
                throw new IllegalStateException("The stepSize(" + this.av + ") must be 0, or a factor of the valueFrom("
                        + this.aq + ")-valueTo(" + this.ar + ") range");
            }
            for (Float f3 : this.as) {
                if (f3.floatValue() < this.aq || f3.floatValue() > this.ar) {
                    throw new IllegalStateException("Slider value(" + f3 + ") must be greater or equal to valueFrom("
                            + this.aq + "), and lower or equal to valueTo(" + this.ar + ")");
                }
                if (this.av > 0.0f && !cr(f3.floatValue())) {
                    float f4 = this.aq;
                    float f5 = this.av;
                    throw new IllegalStateException("Value(" + f3 + ") must be equal to valueFrom(" + f4
                            + ") plus a multiple of stepSize(" + f5 + ") when using stepSize(" + f5 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f6 = this.av;
            if (f6 > 0.0f && minSeparation > 0.0f) {
                if (this.bp != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation
                            + ") cannot be set as a dimension when using stepSize(" + this.av + ")");
                }
                if (minSeparation < f6 || !bz(minSeparation)) {
                    float f7 = this.av;
                    throw new IllegalStateException(
                            "minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize("
                                    + f7 + ") when using stepSize(" + f7 + ")");
                }
            }
            float f8 = this.av;
            if (f8 != 0.0f) {
                if (((int) f8) != f8) {
                    Log.w("ᛱᛱᛲᲈᛵ", "Floating point value used for stepSize(" + f8
                            + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f9 = this.aq;
                if (((int) f9) != f9) {
                    Log.w("ᛱᛱᛲᲈᛵ", "Floating point value used for valueFrom(" + f9
                            + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f10 = this.ar;
                if (((int) f10) != f10) {
                    Log.w("ᛱᛱᛲᲈᛵ", "Floating point value used for valueTo(" + f10
                            + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.bc = false;
        }
    }

    public final boolean cr(float f) {
        return bz(new BigDecimal(Float.toString(f))
                .subtract(new BigDecimal(Float.toString(this.aq)), MathContext.DECIMAL64).doubleValue());
    }

    public final float cs(float f) {
        return (cf(f) * this.ba) + this.ad;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.h.aj(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(by(this.bh));
        this.b.setColor(by(this.bg));
        this.e.setColor(by(this.bf));
        this.f.setColor(by(this.be));
        this.g.setColor(by(this.bg));
        for (ekv ekvVar : this.l) {
            if (ekvVar.isStateful()) {
                ekvVar.setState(getDrawableState());
            }
        }
        cau cauVar = this.bl;
        if (cauVar.isStateful()) {
            cauVar.setState(getDrawableState());
        }
        int iBy = by(this.bd);
        Paint paint = this.d;
        paint.setColor(iBy);
        paint.setAlpha(63);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.h.ad;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public abstract int getThumbRadius();

    public List<Float> getValues() {
        return new ArrayList(this.as);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.bq);
        for (ekv ekvVar : this.l) {
            ViewGroup viewGroupAh = StaticAndroidHelpers.ah(this);
            if (viewGroupAh == null) {
                ekvVar.getClass();
            } else {
                ekvVar.getClass();
                int[] iArr = new int[2];
                viewGroupAh.getLocationOnScreen(iArr);
                ekvVar.o = iArr[0];
                viewGroupAh.getWindowVisibleDisplayFrame(ekvVar.g);
                viewGroupAh.addOnLayoutChangeListener(ekvVar.f);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        np npVar = this.j;
        if (npVar != null) {
            removeCallbacks(npVar);
        }
        this.o = false;
        for (ekv ekvVar : this.l) {
            ViewGroup viewGroupAh = StaticAndroidHelpers.ah(this);
            InstantCollection instantCollectionVar = viewGroupAh == null ? null : new InstantCollection(viewGroupAh);
            if (instantCollectionVar != null) {
                ((ViewOverlay) instantCollectionVar.instantBuilders).remove(ekvVar);
                ViewGroup viewGroupAh2 = StaticAndroidHelpers.ah(this);
                if (viewGroupAh2 == null) {
                    ekvVar.getClass();
                } else {
                    viewGroupAh2.removeOnLayoutChangeListener(ekvVar.f);
                }
            }
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.bq);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Found duplicated region for block: B:117:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:59:0x0176 */
    /* JADX WARN: Found duplicated region for block: B:77:0x01f6 */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        float f;
        int i2;
        int i3;
        float f2;
        ns nsVar = this;
        Canvas canvas2 = canvas;
        if (nsVar.bc) {
            nsVar.cq();
            nsVar.cc();
        }
        super.onDraw(canvas);
        int iBs = nsVar.bs();
        float fFloatValue = ((Float) nsVar.as.get(0)).floatValue();
        float fFloatValue2 = ((Float) StaticHelpers6.getLastNElem(1, nsVar.as)).floatValue();
        float f3 = nsVar.ar;
        RectF rectF = nsVar.bj;
        if (fFloatValue2 < f3 || (nsVar.as.size() > 1 && fFloatValue > nsVar.aq)) {
            int i4 = nsVar.ba;
            float[] fArrBx = nsVar.bx();
            int i5 = nsVar.ad;
            float f4 = i4;
            float f5 = (fArrBx[1] * f4) + i5;
            float f6 = i5 + i4;
            Paint paint = nsVar.a;
            if (f5 < f6) {
                int i6 = nsVar.ah;
                if (i6 > 0) {
                    float f7 = f5 + i6;
                    float f8 = iBs;
                    f = 2.0f;
                    float f9 = nsVar.ac / 2.0f;
                    i = 0;
                    rectF.set(f7, f8 - f9, i5 + i4 + f9, f9 + f8);
                    nsVar.co(canvas2, paint, rectF, 3);
                } else {
                    i = 0;
                    f = 2.0f;
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    float f10 = iBs;
                    canvas2.drawLine(f5, f10, nsVar.ad + i4, f10, paint);
                }
            } else {
                i = 0;
                f = 2.0f;
            }
            int i7 = nsVar.ad;
            float f11 = i7;
            float f12 = (fArrBx[i] * f4) + f11;
            if (f12 > f11) {
                int i8 = nsVar.ah;
                if (i8 > 0) {
                    float f13 = nsVar.ac / f;
                    float f14 = iBs;
                    rectF.set(i7 - f13, f14 - f13, f12 - i8, f13 + f14);
                    nsVar.co(canvas2, paint, rectF, 2);
                } else {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    float f15 = iBs;
                    canvas2.drawLine(nsVar.ad, f15, f12, f15, paint);
                }
            }
        } else {
            i = 0;
            f = 2.0f;
        }
        if (fFloatValue2 > nsVar.aq) {
            int i9 = nsVar.ba;
            float[] fArrBx2 = nsVar.bx();
            float f16 = nsVar.ad;
            float f17 = i9;
            float fCs = (fArrBx2[1] * f17) + f16;
            float fCs2 = (fArrBx2[i] * f17) + f16;
            int i10 = nsVar.ah;
            Paint paint2 = nsVar.b;
            if (i10 > 0) {
                int i11 = nsVar.as.size() == 1 ? nsVar.cb() ? 3 : 2 : 4;
                for (int i12 = i; i12 < nsVar.as.size(); i12++) {
                    if (nsVar.as.size() > 1) {
                        if (i12 > 0) {
                            fCs2 = nsVar.cs(((Float) nsVar.as.get(i12 - 1)).floatValue());
                        }
                        fCs = nsVar.cs(((Float) nsVar.as.get(i12)).floatValue());
                        if (nsVar.cb()) {
                            fCs = fCs2;
                            fCs2 = fCs;
                        }
                    }
                    int iAe = StaticHelpers6.ae(i11);
                    if (iAe != 1) {
                        if (iAe == 2) {
                            fCs2 += nsVar.ah;
                            fCs = (nsVar.ac / f) + fCs;
                        } else if (iAe == 3) {
                            f2 = nsVar.ah;
                            fCs2 += f2;
                        }
                        if (fCs2 >= fCs) {
                            float f18 = iBs;
                            float f19 = nsVar.ac / f;
                            rectF.set(fCs2, f18 - f19, fCs, f19 + f18);
                            nsVar.co(canvas2, paint2, rectF, i11);
                        }
                    } else {
                        fCs2 -= nsVar.ac / f;
                        f2 = nsVar.ah;
                    }
                    fCs -= f2;
                    if (fCs2 >= fCs) {
                        float f182 = iBs;
                        float f192 = nsVar.ac / f;
                        rectF.set(fCs2, f182 - f192, fCs, f192 + f182);
                        nsVar.co(canvas2, paint2, rectF, i11);
                    }
                }
            } else {
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeCap(Paint.Cap.ROUND);
                float f20 = iBs;
                canvas2.drawLine(fCs2, f20, fCs, f20, paint2);
            }
        }
        if (nsVar.ax && nsVar.av > 0.0f) {
            float[] fArrBx3 = nsVar.bx();
            int iCeil = (int) Math.ceil(((nsVar.aw.length / f) - 1.0f) * fArrBx3[i]);
            int iFloor = (int) Math.floor(((nsVar.aw.length / f) - 1.0f) * fArrBx3[1]);
            Paint paint3 = nsVar.e;
            if (iCeil > 0) {
                canvas2.drawPoints(nsVar.aw, i, iCeil * 2, paint3);
            }
            if (iCeil <= iFloor) {
                canvas2.drawPoints(nsVar.aw, iCeil * 2, ((iFloor - iCeil) + 1) * 2, nsVar.f);
            }
            int i13 = (iFloor + 1) * 2;
            float[] fArr = nsVar.aw;
            if (i13 < fArr.length) {
                canvas2.drawPoints(fArr, i13, fArr.length - i13, paint3);
            }
        }
        if (nsVar.ak <= 0) {
            i2 = 0;
        } else {
            int size = nsVar.as.size();
            Paint paint4 = nsVar.g;
            if (size >= 1) {
                float fFloatValue3 = ((Float) StaticHelpers6.getLastNElem(1, nsVar.as)).floatValue();
                float f21 = nsVar.ar;
                if (fFloatValue3 < f21) {
                    canvas2.drawPoint(nsVar.cs(f21), iBs, paint4);
                }
            }
            if (nsVar.as.size() > 1) {
                i2 = 0;
                float fFloatValue4 = ((Float) nsVar.as.get(0)).floatValue();
                float f22 = nsVar.aq;
                if (fFloatValue4 > f22) {
                    canvas2.drawPoint(nsVar.cs(f22), iBs, paint4);
                }
            } else {
                i2 = 0;
            }
        }
        if ((nsVar.ap || nsVar.isFocused()) && nsVar.isEnabled()) {
            int i14 = nsVar.ba;
            if (!(nsVar.getBackground() instanceof RippleDrawable)) {
                int iCf = (int) ((nsVar.cf(((Float) nsVar.as.get(nsVar.au)).floatValue()) * i14) + nsVar.ad);
                if (Build.VERSION.SDK_INT < 28) {
                    int i15 = nsVar.ag;
                    canvas2.clipRect(iCf - i15, iBs - i15, iCf + i15, i15 + iBs, Region.Op.UNION);
                }
                canvas2.drawCircle(iCf, iBs, nsVar.ag, nsVar.d);
            }
        }
        nsVar.cn();
        int i16 = nsVar.ba;
        while (i2 < nsVar.as.size()) {
            float fFloatValue5 = ((Float) nsVar.as.get(i2)).floatValue();
            Drawable drawable = nsVar.bm;
            if (drawable != null) {
                i3 = iBs;
                nsVar.bu(canvas2, i16, i3, fFloatValue5, drawable);
            } else {
                i3 = iBs;
                if (i2 < nsVar.bn.size()) {
                    nsVar.bu(canvas, i16, i3, fFloatValue5, (Drawable) nsVar.bn.get(i2));
                } else {
                    if (!nsVar.isEnabled()) {
                        canvas.drawCircle((nsVar.cf(fFloatValue5) * i16) + nsVar.ad, i3, nsVar.getThumbRadius(),
                                nsVar.c);
                    }
                    nsVar.bu(canvas, i16, i3, fFloatValue5, nsVar.bl);
                }
            }
            i2++;
            nsVar = this;
            canvas2 = canvas;
            iBs = i3;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        nq nqVar = this.h;
        if (!z) {
            this.at = -1;
            nqVar.ag(this.au);
            return;
        }
        if (i == 1) {
            cd(Integer.MAX_VALUE);
        } else if (i == 2) {
            cd(Integer.MIN_VALUE);
        } else if (i == 17) {
            ce(Integer.MAX_VALUE);
        } else if (i == 66) {
            ce(Integer.MIN_VALUE);
        }
        nqVar.an(this.au);
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0047 */
    /* JADX WARN: Found duplicated region for block: B:22:0x004d */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.as.size() == 1) {
            this.at = 0;
        }
        Float fValueOf = null;
        Boolean boolValueOf = null;
        if (this.at == -1) {
            if (i == 61) {
                boolValueOf = keyEvent.hasNoModifiers() ? Boolean.valueOf(cd(1))
                        : keyEvent.isShiftPressed() ? Boolean.valueOf(cd(-1)) : Boolean.FALSE;
            } else if (i == 66) {
                this.at = this.au;
                postInvalidate();
                boolValueOf = Boolean.TRUE;
            } else if (i == 81) {
                cd(1);
                boolValueOf = Boolean.TRUE;
            } else if (i == 69) {
                cd(-1);
                boolValueOf = Boolean.TRUE;
            } else if (i != 70) {
                switch (i) {
                    case 21:
                        ce(-1);
                        boolValueOf = Boolean.TRUE;
                        break;
                    case 22:
                        ce(1);
                        boolValueOf = Boolean.TRUE;
                        break;
                    case 23:
                        this.at = this.au;
                        postInvalidate();
                        boolValueOf = Boolean.TRUE;
                        break;
                }
            } else {
                cd(1);
                boolValueOf = Boolean.TRUE;
            }
            return boolValueOf != null ? boolValueOf.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        boolean zIsLongPress = this.bb | keyEvent.isLongPress();
        this.bb = zIsLongPress;
        if (zIsLongPress) {
            float f = this.av;
            fRound = f != 0.0f ? f : 1.0f;
            if ((this.ar - this.aq) / fRound > 20) {
                fRound *= Math.round(r0 / r11);
            }
        } else {
            float f2 = this.av;
            if (f2 != 0.0f) {
                fRound = f2;
            }
        }
        if (i == 21) {
            if (!cb()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i == 22) {
            if (cb()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i == 69) {
            fValueOf = Float.valueOf(-fRound);
        } else if (i == 70 || i == 81) {
            fValueOf = Float.valueOf(fRound);
        }
        if (fValueOf != null) {
            if (cj(this.at, fValueOf.floatValue() + ((Float) this.as.get(this.at)).floatValue())) {
                cm();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return cd(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return cd(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.at = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.bb = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = this.aa;
        int i4 = this.ab;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(
                i3 + ((i4 == 1 || i4 == 3) ? ((ekv) this.l.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        nr nrVar = (nr) parcelable;
        super.onRestoreInstanceState(nrVar.getSuperState());
        this.aq = nrVar.a;
        this.ar = nrVar.b;
        ci(nrVar.c);
        this.av = nrVar.d;
        if (nrVar.e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        nr nrVar = new nr(super.onSaveInstanceState());
        nrVar.a = this.aq;
        nrVar.b = this.ar;
        nrVar.c = new ArrayList(this.as);
        nrVar.d = this.av;
        nrVar.e = hasFocus();
        return nrVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.ba = Math.max(i - (this.ad * 2), 0);
        cc();
        cm();
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x0075 */
    /* JADX WARN: Found duplicated region for block: B:37:0x00b2 */
    /* JADX WARN: Found duplicated region for block: B:41:0x00bc */
    /* JADX WARN: Found duplicated region for block: B:51:0x00e5 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        Iterator it;
        int i;
        float f;
        Slider slider;
        if (isEnabled()) {
            float x = motionEvent.getX();
            float f2 = (x - this.ad) / this.ba;
            this.bo = f2;
            float fMax = Math.max(0.0f, f2);
            this.bo = fMax;
            this.bo = Math.min(1.0f, fMax);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                int i2 = this.r;
                if (actionMasked == 1) {
                    this.ap = false;
                    motionEvent2 = this.ao;
                    if (motionEvent2 != null && motionEvent2.getActionMasked() == 0) {
                        f = i2;
                        if (Math.abs(this.ao.getX() - motionEvent.getX()) <= f
                                && Math.abs(this.ao.getY() - motionEvent.getY()) <= f) {
                            slider = (Slider) this;
                            if (slider.getActiveThumbIndex() == -1) {
                                slider.setActiveThumbIndex(0);
                            }
                            cg();
                        }
                    }
                    if (this.at != -1) {
                        ck();
                        cm();
                        if (this.ah > 0 && (i = this.ai) != -1 && this.aj != -1) {
                            setThumbWidth(i);
                            setThumbTrackGapSize(this.aj);
                        }
                        this.at = -1;
                        it = this.n.iterator();
                        if (it.hasNext()) {
                            throw yg.d(it);
                        }
                    }
                    invalidate();
                } else if (actionMasked == 2) {
                    if (!this.ap) {
                        if (!ca(motionEvent) || Math.abs(x - this.an) >= i2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            cg();
                        }
                    }
                    Slider slider2 = (Slider) this;
                    if (slider2.getActiveThumbIndex() == -1) {
                        slider2.setActiveThumbIndex(0);
                    }
                    this.ap = true;
                    ck();
                    cm();
                    invalidate();
                } else if (actionMasked == 3) {
                    this.ap = false;
                    motionEvent2 = this.ao;
                    if (motionEvent2 != null) {
                        f = i2;
                        if (Math.abs(this.ao.getX() - motionEvent.getX()) <= f) {
                            slider = (Slider) this;
                            if (slider.getActiveThumbIndex() == -1) {
                                slider.setActiveThumbIndex(0);
                            }
                            cg();
                        }
                    }
                    if (this.at != -1) {
                        ck();
                        cm();
                        if (this.ah > 0) {
                            setThumbWidth(i);
                            setThumbTrackGapSize(this.aj);
                        }
                        this.at = -1;
                        it = this.n.iterator();
                        if (it.hasNext()) {
                            throw yg.d(it);
                        }
                    }
                    invalidate();
                }
            } else {
                this.an = x;
                if (!ca(motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    Slider slider3 = (Slider) this;
                    if (slider3.getActiveThumbIndex() == -1) {
                        slider3.setActiveThumbIndex(0);
                    }
                    requestFocus();
                    this.ap = true;
                    ck();
                    cm();
                    int i3 = this.ah;
                    if (i3 > 0) {
                        int i4 = this.ae;
                        this.ai = i4;
                        this.aj = i3;
                        int iRound = Math.round(i4 * 0.5f);
                        int i5 = this.ae - iRound;
                        setThumbWidth(iRound);
                        setThumbTrackGapSize(this.ah - (i5 / 2));
                    }
                    invalidate();
                    cg();
                }
            }
            setPressed(this.ap);
            this.ao = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ViewGroup viewGroupAh = StaticAndroidHelpers.ah(this);
            InstantCollection instantCollectionVar = viewGroupAh == null ? null : new InstantCollection(viewGroupAh);
            if (instantCollectionVar == null) {
                return;
            }
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((ViewOverlay) instantCollectionVar.instantBuilders).remove((ekv) it.next());
            }
        }
    }

    public void setActiveThumbIndex(int i) {
        this.at = i;
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public abstract void setHaloRadius(int i);

    public abstract void setHaloTintList(ColorStateList colorStateList);

    public abstract void setLabelBehavior(int i);

    public void setSeparationUnit(int i) {
        this.bp = i;
        this.bc = true;
        postInvalidate();
    }

    public abstract void setThumbElevation(float f);

    public abstract void setThumbHeight(int i);

    public abstract void setThumbStrokeColor(ColorStateList colorStateList);

    public abstract void setThumbStrokeWidth(float f);

    public abstract void setThumbTrackGapSize(int i);

    public abstract void setThumbWidth(int i);

    public abstract void setTickActiveRadius(int i);

    public abstract void setTickActiveTintList(ColorStateList colorStateList);

    public abstract void setTickInactiveRadius(int i);

    public abstract void setTickInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackActiveTintList(ColorStateList colorStateList);

    public abstract void setTrackHeight(int i);

    public abstract void setTrackInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackInsideCornerSize(int i);

    public abstract void setTrackStopIndicatorSize(int i);

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        ci(arrayList);
    }

    public void setValues(List<Float> list) {
        ci(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.bm = null;
        this.bn = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.bn;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            br(drawableNewDrawable);
            list.add(drawableNewDrawable);
        }
        postInvalidate();
    }
}
