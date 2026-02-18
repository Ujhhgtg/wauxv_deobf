package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bvg extends ViewGroup {
    public int aa;
    public int ab;
    public float ac;
    public boolean ad;
    public int[] ae;
    public int[] af;
    public Drawable ag;
    public int ah;
    public int ai;
    public int aj;
    public int ak;
    public boolean w;
    public int x;
    public int y;
    public int z;

    public bvg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.w = true;
        this.x = -1;
        this.y = 0;
        this.aa = 8388659;
        int[] iArr = cyf.n;
        jx jxVarK = jx.k(context, attributeSet, iArr, 0);
        eqz.r(this, context, iArr, attributeSet, (TypedArray) jxVarK.e, 0, 0);
        TypedArray typedArray = (TypedArray) jxVarK.e;
        int i2 = typedArray.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = typedArray.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.ac = typedArray.getFloat(4, -1.0f);
        this.x = typedArray.getInt(3, -1);
        this.ad = typedArray.getBoolean(7, false);
        setDividerDrawable(jxVarK.s(5));
        this.aj = typedArray.getInt(8, 0);
        this.ak = typedArray.getDimensionPixelSize(6, 0);
        jxVarK.ae();
    }

    public final void al(Canvas canvas, int i) {
        this.ag.setBounds(getPaddingLeft() + this.ak, i, (getWidth() - getPaddingRight()) - this.ak, this.ai + i);
        this.ag.draw(canvas);
    }

    public final void am(Canvas canvas, int i) {
        this.ag.setBounds(i, getPaddingTop() + this.ak, this.ah + i, (getHeight() - getPaddingBottom()) - this.ak);
        this.ag.draw(canvas);
    }

    public final boolean an(int i) {
        if (i == 0) {
            return (this.aj & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.aj & 4) != 0;
        }
        if ((this.aj & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof bvf;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.x < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.x;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.x == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.y;
        if (this.z == 1 && (i = this.aa & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.ab) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.ab;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((bvf) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.x;
    }

    public Drawable getDividerDrawable() {
        return this.ag;
    }

    public int getDividerPadding() {
        return this.ak;
    }

    public int getDividerWidth() {
        return this.ah;
    }

    public int getGravity() {
        return this.aa;
    }

    public int getOrientation() {
        return this.z;
    }

    public int getShowDividers() {
        return this.aj;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.ac;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.ag == null) {
            return;
        }
        int i2 = 0;
        if (this.z == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && an(i2)) {
                    al(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((bvf) childAt.getLayoutParams())).topMargin) - this.ai);
                }
                i2++;
            }
            if (an(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                al(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.ai : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((bvf) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = getLayoutDirection() == 1;
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && an(i2)) {
                bvf bvfVar = (bvf) childAt3.getLayoutParams();
                am(canvas, z ? childAt3.getRight() + ((LinearLayout.LayoutParams) bvfVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) bvfVar).leftMargin) - this.ah);
            }
            i2++;
        }
        if (an(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                bvf bvfVar2 = (bvf) childAt4.getLayoutParams();
                if (z) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) bvfVar2).leftMargin;
                    i = this.ah;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) bvfVar2).rightMargin;
                }
            } else if (z) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.ah;
                right = left - i;
            }
            am(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Found duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Found duplicated region for block: B:65:0x0161  */
    /* JADX WARN: Found duplicated region for block: B:67:0x0165  */
    /* JADX WARN: Found duplicated region for block: B:69:0x0169  */
    /* JADX WARN: Found duplicated region for block: B:70:0x016d  */
    /* JADX WARN: Found duplicated region for block: B:72:0x0175  */
    /* JADX WARN: Found duplicated region for block: B:74:0x0181  */
    /* JADX WARN: Found duplicated region for block: B:76:0x0188  */
    /* JADX WARN: Found duplicated region for block: B:77:0x018f  */
    /* JADX WARN: Found duplicated region for block: B:80:0x01a2  */
    /* JADX WARN: Found duplicated region for block: B:81:0x01a7  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int baseline;
        int i9;
        int i10;
        int i11;
        int measuredHeight;
        char c;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        char c2 = 2;
        if (this.z == 1) {
            int paddingLeft = getPaddingLeft();
            int i16 = i3 - i;
            int paddingRight = i16 - getPaddingRight();
            int paddingRight2 = (i16 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i17 = this.aa;
            int i18 = i17 & 112;
            int i19 = 8388615 & i17;
            int paddingTop = i18 != 16 ? i18 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.ab : getPaddingTop() + (((i4 - i2) - this.ab) / 2);
            int i20 = 0;
            while (i20 < virtualChildCount) {
                View childAt = getChildAt(i20);
                if (childAt == null || childAt.getVisibility() == i15) {
                    c = c2;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    bvf bvfVar = (bvf) childAt.getLayoutParams();
                    c = c2;
                    int i21 = ((LinearLayout.LayoutParams) bvfVar).gravity;
                    if (i21 < 0) {
                        i21 = i19;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i21, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i14 = ((LinearLayout.LayoutParams) bvfVar).leftMargin + paddingLeft;
                        } else {
                            i12 = paddingRight - measuredWidth;
                            i13 = ((LinearLayout.LayoutParams) bvfVar).rightMargin;
                        }
                        if (an(i20)) {
                            paddingTop += this.ai;
                        }
                        int i22 = paddingTop + ((LinearLayout.LayoutParams) bvfVar).topMargin;
                        childAt.layout(i14, i22, measuredWidth + i14, i22 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) bvfVar).bottomMargin + i22;
                    } else {
                        i12 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) bvfVar).leftMargin;
                        i13 = ((LinearLayout.LayoutParams) bvfVar).rightMargin;
                    }
                    i14 = i12 - i13;
                    if (an(i20)) {
                        paddingTop += this.ai;
                    }
                    int i222 = paddingTop + ((LinearLayout.LayoutParams) bvfVar).topMargin;
                    childAt.layout(i14, i222, measuredWidth + i14, i222 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) bvfVar).bottomMargin + i222;
                }
                i20++;
                c2 = c;
                i15 = 8;
            }
            return;
        }
        boolean z2 = getLayoutDirection() == 1;
        int paddingTop2 = getPaddingTop();
        int i23 = i4 - i2;
        int paddingBottom = i23 - getPaddingBottom();
        int paddingBottom2 = (i23 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i24 = this.aa;
        int i25 = 8388615 & i24;
        int i26 = i24 & 112;
        boolean z3 = this.w;
        int[] iArr = this.ae;
        int[] iArr2 = this.af;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i25, getLayoutDirection());
        int paddingLeft2 = absoluteGravity2 != 1 ? absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.ab : getPaddingLeft() + (((i3 - i) - this.ab) / 2);
        if (z2) {
            i6 = virtualChildCount2 - 1;
            i5 = -1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i27 = 0;
        while (i27 < virtualChildCount2) {
            int i28 = (i5 * i27) + i6;
            View childAt2 = getChildAt(i28);
            if (childAt2 == null) {
                i7 = i6;
            } else {
                i7 = i6;
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    bvf bvfVar2 = (bvf) childAt2.getLayoutParams();
                    int i29 = paddingLeft2;
                    if (z3) {
                        i8 = paddingTop2;
                        baseline = ((LinearLayout.LayoutParams) bvfVar2).height != -1 ? childAt2.getBaseline() : -1;
                        i9 = ((LinearLayout.LayoutParams) bvfVar2).gravity;
                        if (i9 < 0) {
                            i9 = i26;
                        }
                        i10 = i9 & 112;
                        if (i10 != 16) {
                            if (i10 != 48) {
                                i11 = i8 + ((LinearLayout.LayoutParams) bvfVar2).topMargin;
                                if (baseline != -1) {
                                    i11 = (iArr[1] - baseline) + i11;
                                }
                            } else if (i10 != 80) {
                                i11 = i8;
                            } else {
                                i11 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) bvfVar2).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                                }
                            }
                            int i30 = (an(i28) ? i29 + this.ah : i29) + ((LinearLayout.LayoutParams) bvfVar2).leftMargin;
                            childAt2.layout(i30, i11, i30 + measuredWidth2, i11 + measuredHeight3);
                            paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) bvfVar2).rightMargin + i30;
                        } else {
                            i11 = ((paddingBottom2 - measuredHeight3) / 2) + i8 + ((LinearLayout.LayoutParams) bvfVar2).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) bvfVar2).bottomMargin;
                        }
                        i11 -= measuredHeight;
                        int i302 = (an(i28) ? i29 + this.ah : i29) + ((LinearLayout.LayoutParams) bvfVar2).leftMargin;
                        childAt2.layout(i302, i11, i302 + measuredWidth2, i11 + measuredHeight3);
                        paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) bvfVar2).rightMargin + i302;
                    } else {
                        i8 = paddingTop2;
                    }
                    i9 = ((LinearLayout.LayoutParams) bvfVar2).gravity;
                    if (i9 < 0) {
                        i9 = i26;
                    }
                    i10 = i9 & 112;
                    if (i10 != 16) {
                        if (i10 != 48) {
                            i11 = i8 + ((LinearLayout.LayoutParams) bvfVar2).topMargin;
                            if (baseline != -1) {
                                i11 = (iArr[1] - baseline) + i11;
                            }
                        } else if (i10 != 80) {
                            i11 = i8;
                        } else {
                            i11 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) bvfVar2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        int i3022 = (an(i28) ? i29 + this.ah : i29) + ((LinearLayout.LayoutParams) bvfVar2).leftMargin;
                        childAt2.layout(i3022, i11, i3022 + measuredWidth2, i11 + measuredHeight3);
                        paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) bvfVar2).rightMargin + i3022;
                    } else {
                        i11 = ((paddingBottom2 - measuredHeight3) / 2) + i8 + ((LinearLayout.LayoutParams) bvfVar2).topMargin;
                        measuredHeight = ((LinearLayout.LayoutParams) bvfVar2).bottomMargin;
                    }
                    i11 -= measuredHeight;
                    int i30222 = (an(i28) ? i29 + this.ah : i29) + ((LinearLayout.LayoutParams) bvfVar2).leftMargin;
                    childAt2.layout(i30222, i11, i30222 + measuredWidth2, i11 + measuredHeight3);
                    paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) bvfVar2).rightMargin + i30222;
                }
                i27++;
                i6 = i7;
                paddingTop2 = i8;
            }
            i8 = paddingTop2;
            i27++;
            i6 = i7;
            paddingTop2 = i8;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:228:0x04e3  */
    /* JADX WARN: Found duplicated region for block: B:231:0x04f8  */
    /* JADX WARN: Found duplicated region for block: B:233:0x0501  */
    /* JADX WARN: Found duplicated region for block: B:235:0x0505  */
    /* JADX WARN: Found duplicated region for block: B:237:0x0526  */
    /* JADX WARN: Found duplicated region for block: B:243:0x0536  */
    /* JADX WARN: Found duplicated region for block: B:246:0x053d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:248:0x0540  */
    /* JADX WARN: Found duplicated region for block: B:250:0x0547 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:252:0x054a  */
    /* JADX WARN: Found duplicated region for block: B:366:0x079c  */
    /* JADX WARN: Found duplicated region for block: B:64:0x013f A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:66:0x0142  */
    /* JADX WARN: Found duplicated region for block: B:68:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:70:0x014b  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iMax;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int[] iArr;
        int i10;
        int i11;
        boolean z;
        boolean z2;
        bvf bvfVar;
        int i12;
        int[] iArr2;
        int i13;
        View view;
        int i14;
        boolean z3;
        int i15;
        int measuredHeight;
        boolean z4;
        int iMax2;
        int i16;
        int baseline2;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z5;
        int i25;
        int i26;
        int i27;
        View view2;
        boolean z6;
        bvg bvgVar = this;
        int i28 = -2;
        int iMax3 = 0;
        int i29 = 1073741824;
        int i30 = 8;
        if (bvgVar.z == 1) {
            bvgVar.ab = 0;
            int virtualChildCount = bvgVar.getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i31 = bvgVar.x;
            boolean z7 = bvgVar.ad;
            int i32 = 0;
            int iMax4 = 0;
            int iMax5 = 0;
            boolean z8 = false;
            int i33 = 0;
            boolean z9 = false;
            boolean z10 = true;
            float f = 0.0f;
            int iMax6 = 0;
            while (i32 < virtualChildCount) {
                int i34 = mode;
                View childAt = bvgVar.getChildAt(i32);
                if (childAt == null) {
                    bvgVar.ab = bvgVar.ab;
                } else {
                    if (childAt.getVisibility() != i30) {
                        if (bvgVar.an(i32)) {
                            bvgVar.ab += bvgVar.ai;
                        }
                        bvf bvfVar2 = (bvf) childAt.getLayoutParams();
                        float f2 = ((LinearLayout.LayoutParams) bvfVar2).weight;
                        f += f2;
                        if (mode2 == i29 && ((LinearLayout.LayoutParams) bvfVar2).height == 0 && f2 > 0.0f) {
                            int i35 = bvgVar.ab;
                            bvgVar.ab = Math.max(i35, ((LinearLayout.LayoutParams) bvfVar2).topMargin + i35 + ((LinearLayout.LayoutParams) bvfVar2).bottomMargin);
                            view2 = childAt;
                            i24 = mode2;
                            i25 = i31;
                            z5 = z7;
                            i26 = i32;
                            z8 = true;
                            i27 = i34;
                        } else {
                            if (((LinearLayout.LayoutParams) bvfVar2).height != 0 || f2 <= 0.0f) {
                                i21 = Integer.MIN_VALUE;
                            } else {
                                ((LinearLayout.LayoutParams) bvfVar2).height = i28;
                                i21 = 0;
                            }
                            if (f == 0.0f) {
                                i22 = i32;
                                i23 = bvgVar.ab;
                            } else {
                                i22 = i32;
                                i23 = 0;
                            }
                            i24 = mode2;
                            z5 = z7;
                            i25 = i31;
                            i26 = i22;
                            i27 = i34;
                            bvgVar.measureChildWithMargins(childAt, i, 0, i2, i23);
                            if (i21 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) bvfVar2).height = i21;
                            }
                            int measuredHeight2 = childAt.getMeasuredHeight();
                            int i36 = bvgVar.ab;
                            view2 = childAt;
                            bvgVar.ab = Math.max(i36, i36 + measuredHeight2 + ((LinearLayout.LayoutParams) bvfVar2).topMargin + ((LinearLayout.LayoutParams) bvfVar2).bottomMargin);
                            if (z5) {
                                iMax6 = Math.max(measuredHeight2, iMax6);
                            }
                        }
                        if (i25 >= 0 && i25 == i26 + 1) {
                            bvgVar.y = bvgVar.ab;
                        }
                        if (i26 < i25 && ((LinearLayout.LayoutParams) bvfVar2).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (i27 == 1073741824 || ((LinearLayout.LayoutParams) bvfVar2).width != -1) {
                            z6 = false;
                        } else {
                            z6 = true;
                            z9 = true;
                        }
                        int i37 = ((LinearLayout.LayoutParams) bvfVar2).leftMargin + ((LinearLayout.LayoutParams) bvfVar2).rightMargin;
                        int measuredWidth = view2.getMeasuredWidth() + i37;
                        iMax3 = Math.max(iMax3, measuredWidth);
                        int measuredState = view2.getMeasuredState();
                        boolean z11 = z6;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i33, measuredState);
                        if (z10) {
                            i33 = iCombineMeasuredStates;
                            boolean z12 = ((LinearLayout.LayoutParams) bvfVar2).width == -1;
                            if (((LinearLayout.LayoutParams) bvfVar2).weight > 0.0f) {
                                if (!z11) {
                                    i37 = measuredWidth;
                                }
                                iMax5 = Math.max(iMax5, i37);
                            } else {
                                if (!z11) {
                                    i37 = measuredWidth;
                                }
                                iMax4 = Math.max(iMax4, i37);
                            }
                            z10 = z12;
                        } else {
                            i33 = iCombineMeasuredStates;
                        }
                        if (((LinearLayout.LayoutParams) bvfVar2).weight > 0.0f) {
                            if (!z11) {
                                i37 = measuredWidth;
                            }
                            iMax5 = Math.max(iMax5, i37);
                        } else {
                            if (!z11) {
                                i37 = measuredWidth;
                            }
                            iMax4 = Math.max(iMax4, i37);
                        }
                        z10 = z12;
                    }
                    i32 = i26 + 1;
                    i31 = i25;
                    mode = i27;
                    z7 = z5;
                    mode2 = i24;
                    i28 = -2;
                    i29 = 1073741824;
                    i30 = 8;
                }
                i24 = mode2;
                i25 = i31;
                z5 = z7;
                i26 = i32;
                i27 = i34;
                i32 = i26 + 1;
                i31 = i25;
                mode = i27;
                z7 = z5;
                mode2 = i24;
                i28 = -2;
                i29 = 1073741824;
                i30 = 8;
            }
            int i38 = mode;
            int i39 = mode2;
            boolean z13 = z7;
            int i40 = i33;
            int i41 = i2;
            if (bvgVar.ab > 0 && bvgVar.an(virtualChildCount)) {
                bvgVar.ab += bvgVar.ai;
            }
            if (z13 && (i39 == Integer.MIN_VALUE || i39 == 0)) {
                bvgVar.ab = 0;
                for (int i42 = 0; i42 < virtualChildCount; i42++) {
                    View childAt2 = bvgVar.getChildAt(i42);
                    if (childAt2 == null) {
                        bvgVar.ab = bvgVar.ab;
                    } else if (childAt2.getVisibility() != 8) {
                        bvf bvfVar3 = (bvf) childAt2.getLayoutParams();
                        int i43 = bvgVar.ab;
                        bvgVar.ab = Math.max(i43, i43 + iMax6 + ((LinearLayout.LayoutParams) bvfVar3).topMargin + ((LinearLayout.LayoutParams) bvfVar3).bottomMargin);
                    }
                }
            }
            int paddingBottom = bvgVar.getPaddingBottom() + bvgVar.getPaddingTop() + bvgVar.ab;
            bvgVar.ab = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, bvgVar.getSuggestedMinimumHeight()), i41, 0);
            int i44 = (iResolveSizeAndState & 16777215) - bvgVar.ab;
            if (z8 || (i44 != 0 && f > 0.0f)) {
                float f3 = bvgVar.ac;
                if (f3 > 0.0f) {
                    f = f3;
                }
                bvgVar.ab = 0;
                int iCombineMeasuredStates2 = i40;
                int i45 = 0;
                while (i45 < virtualChildCount) {
                    View childAt3 = bvgVar.getChildAt(i45);
                    if (childAt3.getVisibility() == 8) {
                        i18 = i45;
                    } else {
                        bvf bvfVar4 = (bvf) childAt3.getLayoutParams();
                        float f4 = ((LinearLayout.LayoutParams) bvfVar4).weight;
                        if (f4 > 0.0f) {
                            int i46 = (int) ((i44 * f4) / f);
                            f -= f4;
                            i44 -= i46;
                            i18 = i45;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, bvgVar.getPaddingRight() + bvgVar.getPaddingLeft() + ((LinearLayout.LayoutParams) bvfVar4).leftMargin + ((LinearLayout.LayoutParams) bvfVar4).rightMargin, ((LinearLayout.LayoutParams) bvfVar4).width);
                            if (((LinearLayout.LayoutParams) bvfVar4).height == 0) {
                                i20 = 1073741824;
                                if (i39 == 1073741824) {
                                    if (i46 <= 0) {
                                        i46 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i46, 1073741824));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                            } else {
                                i20 = 1073741824;
                            }
                            int measuredHeight3 = childAt3.getMeasuredHeight() + i46;
                            if (measuredHeight3 < 0) {
                                measuredHeight3 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight3, i20));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                        } else {
                            i18 = i45;
                        }
                        int i47 = ((LinearLayout.LayoutParams) bvfVar4).leftMargin + ((LinearLayout.LayoutParams) bvfVar4).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i47;
                        iMax3 = Math.max(iMax3, measuredWidth2);
                        if (i38 != 1073741824) {
                            i19 = -1;
                            if (((LinearLayout.LayoutParams) bvfVar4).width == -1) {
                                measuredWidth2 = i47;
                            }
                        } else {
                            i19 = -1;
                        }
                        iMax4 = Math.max(iMax4, measuredWidth2);
                        boolean z14 = z10 && ((LinearLayout.LayoutParams) bvfVar4).width == i19;
                        int i48 = bvgVar.ab;
                        bvgVar.ab = Math.max(i48, childAt3.getMeasuredHeight() + i48 + ((LinearLayout.LayoutParams) bvfVar4).topMargin + ((LinearLayout.LayoutParams) bvfVar4).bottomMargin);
                        z10 = z14;
                    }
                    i45 = i18 + 1;
                }
                bvgVar.ab = bvgVar.getPaddingBottom() + bvgVar.getPaddingTop() + bvgVar.ab;
                i40 = iCombineMeasuredStates2;
            } else {
                iMax4 = Math.max(iMax4, iMax5);
                if (z13 && i39 != 1073741824) {
                    for (int i49 = 0; i49 < virtualChildCount; i49++) {
                        View childAt4 = bvgVar.getChildAt(i49);
                        if (childAt4 != null && childAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((bvf) childAt4.getLayoutParams())).weight > 0.0f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(iMax6, 1073741824));
                        }
                    }
                }
            }
            if (z10 || i38 == 1073741824) {
                iMax4 = iMax3;
            }
            bvgVar.setMeasuredDimension(View.resolveSizeAndState(Math.max(bvgVar.getPaddingRight() + bvgVar.getPaddingLeft() + iMax4, bvgVar.getSuggestedMinimumWidth()), i, i40), iResolveSizeAndState);
            if (z9) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bvgVar.getMeasuredWidth(), 1073741824);
                int i50 = 0;
                while (i50 < virtualChildCount) {
                    View childAt5 = bvgVar.getChildAt(i50);
                    if (childAt5.getVisibility() != 8) {
                        bvf bvfVar5 = (bvf) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) bvfVar5).width == -1) {
                            int i51 = ((LinearLayout.LayoutParams) bvfVar5).height;
                            ((LinearLayout.LayoutParams) bvfVar5).height = childAt5.getMeasuredHeight();
                            bvgVar.measureChildWithMargins(childAt5, iMakeMeasureSpec, 0, i41, 0);
                            ((LinearLayout.LayoutParams) bvfVar5).height = i51;
                        }
                    }
                    i50++;
                    i41 = i2;
                }
                return;
            }
            return;
        }
        int i52 = i;
        bvgVar.ab = 0;
        int virtualChildCount2 = bvgVar.getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i52);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (bvgVar.ae == null || bvgVar.af == null) {
            bvgVar.ae = new int[4];
            bvgVar.af = new int[4];
        }
        int[] iArr3 = bvgVar.ae;
        int[] iArr4 = bvgVar.af;
        iArr3[3] = -1;
        char c = 2;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z15 = bvgVar.w;
        boolean z16 = bvgVar.ad;
        boolean z17 = mode3 == 1073741824;
        float f5 = 0.0f;
        boolean z18 = true;
        int i53 = 0;
        int i54 = 0;
        int i55 = 0;
        int iMax7 = 0;
        int iMax8 = 0;
        int iCombineMeasuredStates3 = 0;
        boolean z19 = false;
        boolean z20 = false;
        while (i53 < virtualChildCount2) {
            char c2 = c;
            View childAt6 = bvgVar.getChildAt(i53);
            if (childAt6 == null) {
                bvgVar.ab = bvgVar.ab;
                i11 = i53;
                i16 = i55;
                iArr2 = iArr3;
                iArr = iArr4;
                z = z15;
                z2 = z16;
            } else {
                int i56 = i54;
                if (childAt6.getVisibility() == 8) {
                    i52 = i;
                    i11 = i53;
                    i16 = i55;
                    iArr = iArr4;
                    z = z15;
                    z2 = z16;
                    i54 = i56;
                    iArr2 = iArr3;
                } else {
                    if (bvgVar.an(i53)) {
                        bvgVar.ab += bvgVar.ah;
                    }
                    bvf bvfVar6 = (bvf) childAt6.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) bvfVar6).weight;
                    f5 += f6;
                    int i57 = i53;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) bvfVar6).width == 0 && f6 > 0.0f) {
                        if (z17) {
                            bvgVar.ab = ((LinearLayout.LayoutParams) bvfVar6).leftMargin + ((LinearLayout.LayoutParams) bvfVar6).rightMargin + bvgVar.ab;
                        } else {
                            int i58 = bvgVar.ab;
                            bvgVar.ab = Math.max(i58, ((LinearLayout.LayoutParams) bvfVar6).leftMargin + i58 + ((LinearLayout.LayoutParams) bvfVar6).rightMargin);
                        }
                        if (z15) {
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
                            view = childAt6;
                            z = z15;
                            z2 = z16;
                            i12 = i56;
                            i11 = i57;
                            bvfVar = bvfVar6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i52 = i;
                            i13 = i55;
                            i10 = iMax7;
                        } else {
                            view = childAt6;
                            z = z15;
                            z2 = z16;
                            z20 = true;
                            i12 = i56;
                            i11 = i57;
                            i14 = 1073741824;
                            bvfVar = bvfVar6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i52 = i;
                            i13 = i55;
                            i10 = iMax7;
                        }
                        if (mode4 == i14 && ((LinearLayout.LayoutParams) bvfVar).height == -1) {
                            z3 = true;
                            z19 = true;
                        }
                        i15 = ((LinearLayout.LayoutParams) bvfVar).topMargin + ((LinearLayout.LayoutParams) bvfVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i15;
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                        if (z) {
                            baseline2 = view.getBaseline();
                            z4 = z3;
                            if (baseline2 != -1) {
                                i17 = ((LinearLayout.LayoutParams) bvfVar).gravity;
                                if (i17 < 0) {
                                    i17 = bvgVar.aa;
                                }
                                int i59 = (((i17 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i59] = Math.max(iArr2[i59], baseline2);
                                iArr[i59] = Math.max(iArr[i59], measuredHeight - baseline2);
                            }
                        } else {
                            z4 = z3;
                        }
                        int iMax9 = Math.max(i12, measuredHeight);
                        boolean z21 = !z18 && ((LinearLayout.LayoutParams) bvfVar).height == -1;
                        if (((LinearLayout.LayoutParams) bvfVar).weight > 0.0f) {
                            if (!z4) {
                                i15 = measuredHeight;
                            }
                            iMax7 = Math.max(i10, i15);
                            iMax2 = i13;
                        } else {
                            if (!z4) {
                                i15 = measuredHeight;
                            }
                            iMax2 = Math.max(i13, i15);
                            iMax7 = i10;
                        }
                        int i60 = iMax2;
                        i54 = iMax9;
                        i16 = i60;
                        z18 = z21;
                    } else {
                        if (((LinearLayout.LayoutParams) bvfVar6).width != 0 || f6 <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) bvfVar6).width = -2;
                            i9 = 0;
                        }
                        iArr = iArr4;
                        i10 = iMax7;
                        i11 = i57;
                        z = z15;
                        z2 = z16;
                        int i61 = i9;
                        bvfVar = bvfVar6;
                        i12 = i56;
                        i52 = i;
                        iArr2 = iArr3;
                        i13 = i55;
                        bvgVar.measureChildWithMargins(childAt6, i52, f5 == 0.0f ? bvgVar.ab : 0, i2, 0);
                        if (i61 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) bvfVar).width = i61;
                        }
                        int measuredWidth3 = childAt6.getMeasuredWidth();
                        if (z17) {
                            view = childAt6;
                            bvgVar.ab = ((LinearLayout.LayoutParams) bvfVar).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) bvfVar).rightMargin + bvgVar.ab;
                        } else {
                            view = childAt6;
                            int i62 = bvgVar.ab;
                            bvgVar.ab = Math.max(i62, i62 + measuredWidth3 + ((LinearLayout.LayoutParams) bvfVar).leftMargin + ((LinearLayout.LayoutParams) bvfVar).rightMargin);
                        }
                        if (z2) {
                            iMax8 = Math.max(measuredWidth3, iMax8);
                        }
                    }
                    i14 = 1073741824;
                    z3 = mode4 == i14 ? false : false;
                    i15 = ((LinearLayout.LayoutParams) bvfVar).topMargin + ((LinearLayout.LayoutParams) bvfVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i15;
                    iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                    if (z) {
                        baseline2 = view.getBaseline();
                        z4 = z3;
                        if (baseline2 != -1) {
                            i17 = ((LinearLayout.LayoutParams) bvfVar).gravity;
                            if (i17 < 0) {
                                i17 = bvgVar.aa;
                            }
                            int i592 = (((i17 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i592] = Math.max(iArr2[i592], baseline2);
                            iArr[i592] = Math.max(iArr[i592], measuredHeight - baseline2);
                        }
                    } else {
                        z4 = z3;
                    }
                    int iMax92 = Math.max(i12, measuredHeight);
                    if (z18) {
                    }
                    if (((LinearLayout.LayoutParams) bvfVar).weight > 0.0f) {
                        if (!z4) {
                            i15 = measuredHeight;
                        }
                        iMax7 = Math.max(i10, i15);
                        iMax2 = i13;
                    } else {
                        if (!z4) {
                            i15 = measuredHeight;
                        }
                        iMax2 = Math.max(i13, i15);
                        iMax7 = i10;
                    }
                    int i602 = iMax2;
                    i54 = iMax92;
                    i16 = i602;
                    z18 = z21;
                }
            }
            i55 = i16;
            i53 = i11 + 1;
            c = c2;
            iArr3 = iArr2;
            iArr4 = iArr;
            z15 = z;
            z16 = z2;
        }
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c3 = c;
        boolean z22 = z15;
        boolean z23 = z16;
        int i63 = i54;
        int i64 = i55;
        int i65 = iMax7;
        if (bvgVar.ab > 0 && bvgVar.an(virtualChildCount2)) {
            bvgVar.ab += bvgVar.ah;
        }
        int i66 = iArr5[1];
        int iMax10 = (i66 == -1 && iArr5[0] == -1 && iArr5[c3] == -1 && iArr5[3] == -1) ? i63 : Math.max(i63, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[c3]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i66, iArr5[c3]))));
        if (z23 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
            bvgVar.ab = 0;
            for (int i67 = 0; i67 < virtualChildCount2; i67++) {
                View childAt7 = bvgVar.getChildAt(i67);
                if (childAt7 == null) {
                    bvgVar.ab = bvgVar.ab;
                } else if (childAt7.getVisibility() != 8) {
                    bvf bvfVar7 = (bvf) childAt7.getLayoutParams();
                    if (z17) {
                        bvgVar.ab = ((LinearLayout.LayoutParams) bvfVar7).leftMargin + iMax8 + ((LinearLayout.LayoutParams) bvfVar7).rightMargin + bvgVar.ab;
                    } else {
                        int i68 = bvgVar.ab;
                        bvgVar.ab = Math.max(i68, i68 + iMax8 + ((LinearLayout.LayoutParams) bvfVar7).leftMargin + ((LinearLayout.LayoutParams) bvfVar7).rightMargin);
                    }
                }
            }
        }
        int paddingRight = bvgVar.getPaddingRight() + bvgVar.getPaddingLeft() + bvgVar.ab;
        bvgVar.ab = paddingRight;
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, bvgVar.getSuggestedMinimumWidth()), i52, 0);
        int i69 = (iResolveSizeAndState2 & 16777215) - bvgVar.ab;
        if (z20 || (i69 != 0 && f5 > 0.0f)) {
            float f7 = bvgVar.ac;
            if (f7 > 0.0f) {
                f5 = f7;
            }
            iArr5[3] = -1;
            iArr5[c3] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[c3] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            bvgVar.ab = 0;
            iMax10 = -1;
            int i70 = 0;
            while (i70 < virtualChildCount2) {
                View childAt8 = bvgVar.getChildAt(i70);
                if (childAt8 == null || childAt8.getVisibility() == 8) {
                    i6 = iResolveSizeAndState2;
                } else {
                    bvf bvfVar8 = (bvf) childAt8.getLayoutParams();
                    float f8 = ((LinearLayout.LayoutParams) bvfVar8).weight;
                    if (f8 > 0.0f) {
                        int i71 = (int) ((i69 * f8) / f5);
                        f5 -= f8;
                        i69 -= i71;
                        i6 = iResolveSizeAndState2;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, bvgVar.getPaddingBottom() + bvgVar.getPaddingTop() + ((LinearLayout.LayoutParams) bvfVar8).topMargin + ((LinearLayout.LayoutParams) bvfVar8).bottomMargin, ((LinearLayout.LayoutParams) bvfVar8).height);
                        if (((LinearLayout.LayoutParams) bvfVar8).width == 0) {
                            i8 = 1073741824;
                            if (mode3 == 1073741824) {
                                if (i71 <= 0) {
                                    i71 = 0;
                                }
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i71, 1073741824), childMeasureSpec2);
                            }
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                        } else {
                            i8 = 1073741824;
                        }
                        int measuredWidth4 = childAt8.getMeasuredWidth() + i71;
                        if (measuredWidth4 < 0) {
                            measuredWidth4 = 0;
                        }
                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i8), childMeasureSpec2);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                    } else {
                        i6 = iResolveSizeAndState2;
                    }
                    if (z17) {
                        bvgVar.ab = childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) bvfVar8).leftMargin + ((LinearLayout.LayoutParams) bvfVar8).rightMargin + bvgVar.ab;
                    } else {
                        int i72 = bvgVar.ab;
                        bvgVar.ab = Math.max(i72, childAt8.getMeasuredWidth() + i72 + ((LinearLayout.LayoutParams) bvfVar8).leftMargin + ((LinearLayout.LayoutParams) bvfVar8).rightMargin);
                    }
                    boolean z24 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) bvfVar8).height == -1;
                    int i73 = ((LinearLayout.LayoutParams) bvfVar8).topMargin + ((LinearLayout.LayoutParams) bvfVar8).bottomMargin;
                    int measuredHeight4 = childAt8.getMeasuredHeight() + i73;
                    iMax10 = Math.max(iMax10, measuredHeight4);
                    if (!z24) {
                        i73 = measuredHeight4;
                    }
                    int iMax11 = Math.max(i64, i73);
                    if (z18) {
                        i7 = -1;
                        boolean z25 = ((LinearLayout.LayoutParams) bvfVar8).height == -1;
                        if (!z22 && (baseline = childAt8.getBaseline()) != i7) {
                            int i74 = ((LinearLayout.LayoutParams) bvfVar8).gravity;
                            if (i74 < 0) {
                                i74 = bvgVar.aa;
                            }
                            int i75 = (((i74 & 112) >> 4) & (-2)) >> 1;
                            iArr5[i75] = Math.max(iArr5[i75], baseline);
                            iArr6[i75] = Math.max(iArr6[i75], measuredHeight4 - baseline);
                        }
                        z18 = z25;
                        i64 = iMax11;
                    } else {
                        i7 = -1;
                    }
                    if (!z22) {
                    }
                    z18 = z25;
                    i64 = iMax11;
                }
                i70++;
                iResolveSizeAndState2 = i6;
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            bvgVar.ab = bvgVar.getPaddingRight() + bvgVar.getPaddingLeft() + bvgVar.ab;
            int i76 = iArr5[1];
            if (i76 == -1 && iArr5[0] == -1 && iArr5[c3] == -1 && iArr5[3] == -1) {
                i5 = 0;
            } else {
                i5 = 0;
                iMax10 = Math.max(iMax10, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[c3]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i76, iArr5[c3]))));
            }
            iMax = i64;
        } else {
            iMax = Math.max(i64, i65);
            if (z23 && mode3 != 1073741824) {
                for (int i77 = 0; i77 < virtualChildCount2; i77++) {
                    View childAt9 = bvgVar.getChildAt(i77);
                    if (childAt9 != null && childAt9.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((bvf) childAt9.getLayoutParams())).weight > 0.0f) {
                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(iMax8, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt9.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            i5 = 0;
        }
        if (!z18 && mode4 != 1073741824) {
            iMax10 = iMax;
        }
        bvgVar.setMeasuredDimension(i3 | (iCombineMeasuredStates3 & i4), View.resolveSizeAndState(Math.max(bvgVar.getPaddingBottom() + bvgVar.getPaddingTop() + iMax10, bvgVar.getSuggestedMinimumHeight()), i2, iCombineMeasuredStates3 << 16));
        if (z19) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(bvgVar.getMeasuredHeight(), 1073741824);
            int i78 = i5;
            while (i78 < virtualChildCount2) {
                View childAt10 = bvgVar.getChildAt(i78);
                if (childAt10.getVisibility() != 8) {
                    bvf bvfVar9 = (bvf) childAt10.getLayoutParams();
                    if (((LinearLayout.LayoutParams) bvfVar9).height == -1) {
                        int i79 = ((LinearLayout.LayoutParams) bvfVar9).width;
                        ((LinearLayout.LayoutParams) bvfVar9).width = childAt10.getMeasuredWidth();
                        bvgVar.measureChildWithMargins(childAt10, i52, 0, iMakeMeasureSpec3, 0);
                        ((LinearLayout.LayoutParams) bvfVar9).width = i79;
                    }
                }
                i78++;
                bvgVar = this;
                i52 = i;
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public bvf generateDefaultLayoutParams() {
        int i = this.z;
        if (i == 0) {
            return new bvf(-2, -2);
        }
        if (i == 1) {
            return new bvf(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public bvf generateLayoutParams(AttributeSet attributeSet) {
        return new bvf(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public bvf generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof bvf ? new bvf((bvf) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new bvf((ViewGroup.MarginLayoutParams) layoutParams) : new bvf(layoutParams);
    }

    public void setBaselineAligned(boolean z) {
        this.w = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.x = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.ag) {
            return;
        }
        this.ag = drawable;
        if (drawable != null) {
            this.ah = drawable.getIntrinsicWidth();
            this.ai = drawable.getIntrinsicHeight();
        } else {
            this.ah = 0;
            this.ai = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.ak = i;
    }

    public void setGravity(int i) {
        if (this.aa != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.aa = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.aa;
        if ((8388615 & i3) != i2) {
            this.aa = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.ad = z;
    }

    public void setOrientation(int i) {
        if (this.z != i) {
            this.z = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.aj) {
            requestLayout();
        }
        this.aj = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.aa;
        if ((i3 & 112) != i2) {
            this.aa = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.ac = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
