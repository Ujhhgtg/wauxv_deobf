package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.adk;
import me.hd.wauxv.obf.adl;
import me.hd.wauxv.obf.adp;
import me.hd.wauxv.obf.LateinitProperty;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.cyg;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.zz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends cyg implements zz {
    public final SparseArray aa;
    public final c ab;
    public final int[] ac;
    public final float[] ad;
    public final int ae;
    public final int af;
    public final int ag;
    public final int ah;
    public final String[] ai;
    public float aj;
    public final ColorStateList ak;
    public final ClockHandView w;
    public final Rect x;
    public final RectF y;
    public final Rect z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new Rect();
        this.y = new RectF();
        this.z = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.aa = sparseArray;
        this.ad = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.i, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListV = cnb.v(context, typedArrayObtainStyledAttributes, 1);
        this.ak = colorStateListV;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.w = clockHandView;
        this.ae = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListV.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListV.getDefaultColor());
        this.ac = new int[]{colorForState, colorForState, colorStateListV.getDefaultColor()};
        clockHandView.c.add(this);
        int defaultColor = ResourcesCompat.v(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListV2 = cnb.v(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListV2 != null ? colorStateListV2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.ab = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.ai = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z = false;
        for (int i = 0; i < Math.max(this.ai.length, size); i++) {
            TextView textView = (TextView) sparseArray.get(i);
            if (i >= this.ai.length) {
                removeView(textView);
                sparseArray.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i, textView);
                    addView(textView);
                }
                textView.setText(this.ai[i]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i));
                int i2 = (i / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i2));
                z = i2 > 1 ? true : z;
                ViewCompat.setAccessibilityDelegate(textView, this.ab);
                textView.setTextColor(this.ak);
            }
        }
        ClockHandView clockHandView2 = this.w;
        if (clockHandView2.b && !z) {
            clockHandView2.m = 1;
        }
        clockHandView2.b = z;
        clockHandView2.invalidate();
        this.af = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.ag = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.ah = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // me.hd.wauxv.obf.cyg
    public final void al() {
        adp adpVar = new adp();
        adpVar.m(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i2 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i2 == null) {
                    i2 = 1;
                }
                if (!map.containsKey(i2)) {
                    map.put(i2, new ArrayList());
                }
                ((List) map.get(i2)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.ao * 0.66f) : this.ao;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                Integer numValueOf = Integer.valueOf(id);
                HashMap map2 = adpVar.f;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id), new adk());
                }
                adl adlVar = ((adk) map2.get(Integer.valueOf(id))).d;
                adlVar.aa = R.id.circle_center;
                adlVar.ab = iRound;
                adlVar.ac = size;
                size += 360.0f / list.size();
            }
        }
        adpVar.l(this);
        setConstraintSet(null);
        requestLayout();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.aa;
            if (i3 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i3)).setVisibility(0);
            i3++;
        }
    }

    public final void am() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.w.g;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.aa;
            int size = sparseArray.size();
            rect = this.x;
            rectF = this.y;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f) {
                    textView = textView2;
                    f = fHeight;
                }
            }
            i++;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            TextView textView3 = (TextView) sparseArray.get(i2);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.z);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.ac, this.ad, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) LateinitProperty.f(1, this.ai.length, 1).e);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        am();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.ah / Math.max(Math.max(this.af / displayMetrics.heightPixels, this.ag / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
