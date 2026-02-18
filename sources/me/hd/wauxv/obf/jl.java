package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class jl {
    public final TextView a;
    public eke b;
    public eke c;
    public eke d;
    public eke e;
    public eke f;
    public eke g;
    public eke h;
    public final jt i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public jl(TextView textView) {
        this.a = textView;
        this.i = new jt(textView);
    }

    public static eke n(Context context, C0023if c0023if, int i) {
        ColorStateList colorStateListN;
        synchronized (c0023if) {
            colorStateListN = c0023if.c.n(context, i);
        }
        if (colorStateListN == null) {
            return null;
        }
        eke ekeVar = new eke();
        ekeVar.d = true;
        ekeVar.a = colorStateListN;
        return ekeVar;
    }

    public static void o(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            ay.e(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            ay.e(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            cnf.bm(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            cnf.bm(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            cnf.bm(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        cnf.bm(editorInfo,
                i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i2, iMin + i2))
                        : text.subSequence(i9, i10 + iMin + i9),
                iMin2, i10);
    }

    public final void p(Drawable drawable, eke ekeVar) {
        if (drawable == null || ekeVar == null) {
            return;
        }
        C0023if.g(drawable, ekeVar, this.a.getDrawableState());
    }

    public final void q() {
        eke ekeVar = this.b;
        TextView textView = this.a;
        if (ekeVar != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            p(compoundDrawables[0], this.b);
            p(compoundDrawables[1], this.c);
            p(compoundDrawables[2], this.d);
            p(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        p(compoundDrawablesRelative[0], this.f);
        p(compoundDrawablesRelative[2], this.g);
    }

    public final ColorStateList r() {
        eke ekeVar = this.h;
        if (ekeVar != null) {
            return ekeVar.a;
        }
        return null;
    }

    public final PorterDuff.Mode s() {
        eke ekeVar = this.h;
        if (ekeVar != null) {
            return ekeVar.b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        String string2;
        int i2;
        int i3;
        int i4;
        int i5;
        float dimensionPixelSize;
        ColorStateList colorStateList;
        int resourceId;
        int i6;
        int resourceId2;
        TextView textView = this.a;
        Context context = textView.getContext();
        C0023if c0023ifD = C0023if.d();
        int[] iArr = cyf.h;
        jx jxVarK = jx.k(context, attributeSet, iArr, i);
        eqz.r(textView, textView.getContext(), iArr, attributeSet, (TypedArray) jxVarK.e, i, 0);
        TypedArray typedArray = (TypedArray) jxVarK.e;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.b = n(context, c0023ifD, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.c = n(context, c0023ifD, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.d = n(context, c0023ifD, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.e = n(context, c0023ifD, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.f = n(context, c0023ifD, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.g = n(context, c0023ifD, typedArray.getResourceId(6, 0));
        }
        jxVarK.ae();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = cyf.w;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            jx jxVar = new jx(context, typedArrayObtainStyledAttributes);
            if (z3 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z2 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z = true;
            }
            x(context, jxVar);
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15)
                    : null;
            string = typedArrayObtainStyledAttributes.hasValue(13) ? typedArrayObtainStyledAttributes.getString(13)
                    : null;
            jxVar.ae();
        } else {
            z = false;
            z2 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        jx jxVar2 = new jx(context, typedArrayObtainStyledAttributes2);
        if (!z3 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z2 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z = true;
        }
        boolean z4 = z2;
        int i7 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i7 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0)
                && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        x(context, jxVar2);
        jxVar2.ae();
        if (!z3 && z) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                textView.setTypeface(typeface, this.j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            jj.d(textView, string);
        }
        if (string2 != null) {
            ji.tryGetClassByName(textView, ji.a(string2));
        }
        jt jtVar = this.i;
        Context context2 = jtVar.h;
        int[] iArr3 = cyf.i;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = jtVar.g;
        eqz.r(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i, 0);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            jtVar.a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4)
                ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f)
                : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2)
                ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f)
                : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1)
                ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f)
                : -1.0f;
        if (!typedArrayObtainStyledAttributes3.hasValue(3)
                || (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) <= 0) {
            i2 = 0;
        } else {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources()
                    .obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            i2 = 0;
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i8 = 0; i8 < length; i8++) {
                    iArr4[i8] = typedArrayObtainTypedArray.getDimensionPixelSize(i8, -1);
                }
                int[] iArrI = jt.i(iArr4);
                jtVar.e = iArrI;
                boolean z5 = iArrI.length > 0;
                jtVar.f = z5;
                if (z5) {
                    jtVar.a = 1;
                    jtVar.c = iArrI[0];
                    jtVar.d = iArrI[r6 - 1];
                    jtVar.b = -1.0f;
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!jtVar.j()) {
            jtVar.a = i2;
        } else if (jtVar.a == 1) {
            if (!jtVar.f) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i6 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i6 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i6, 112.0f, displayMetrics);
                }
                float f = dimension3;
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                if (dimension2 <= 0.0f) {
                    throw new IllegalArgumentException(
                            "Minimum auto-size text size (" + dimension2 + "px) is less or equal to (0px)");
                }
                if (f <= dimension2) {
                    throw new IllegalArgumentException("Maximum auto-size text size (" + f
                            + "px) is less or equal to minimum auto-size text size (" + dimension2 + "px)");
                }
                if (dimension <= 0.0f) {
                    throw new IllegalArgumentException(
                            "The auto-size step granularity (" + dimension + "px) is less or equal to (0px)");
                }
                jtVar.a = 1;
                jtVar.c = dimension2;
                jtVar.d = f;
                jtVar.b = dimension;
                jtVar.f = i2;
            }
            if (jtVar.j() && jtVar.a == 1 && (!jtVar.f || jtVar.e.length == 0)) {
                int iFloor = ((int) Math.floor((jtVar.d - jtVar.c) / jtVar.b)) + 1;
                int[] iArr5 = new int[iFloor];
                for (int i9 = 0; i9 < iFloor; i9++) {
                    iArr5[i9] = Math.round((i9 * jtVar.b) + jtVar.c);
                }
                jtVar.e = jt.i(iArr5);
            }
        }
        if (jtVar.a != 0) {
            int[] iArr6 = jtVar.e;
            if (iArr6.length > 0) {
                if (jj.a(textView) != -1.0f) {
                    jj.b(textView, Math.round(jtVar.c), Math.round(jtVar.d), Math.round(jtVar.b), 0);
                } else {
                    jj.c(textView, iArr6, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableH = resourceId4 != -1 ? c0023ifD.h(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableH2 = resourceId5 != -1 ? c0023ifD.h(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableH3 = resourceId6 != -1 ? c0023ifD.h(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableH4 = resourceId7 != -1 ? c0023ifD.h(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableH5 = resourceId8 != -1 ? c0023ifD.h(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableH6 = resourceId9 != -1 ? c0023ifD.h(context, resourceId9) : null;
        if (drawableH5 != null || drawableH6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawableH5 == null) {
                drawableH5 = compoundDrawablesRelative[0];
            }
            if (drawableH2 == null) {
                drawableH2 = compoundDrawablesRelative[1];
            }
            if (drawableH6 == null) {
                drawableH6 = compoundDrawablesRelative[2];
            }
            if (drawableH4 == null) {
                drawableH4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableH5, drawableH2, drawableH6, drawableH4);
        } else if (drawableH != null || drawableH2 != null || drawableH3 != null || drawableH4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative2[0];
            if (drawable == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableH == null) {
                    drawableH = compoundDrawables[0];
                }
                if (drawableH2 == null) {
                    drawableH2 = compoundDrawables[1];
                }
                if (drawableH3 == null) {
                    drawableH3 = compoundDrawables[2];
                }
                if (drawableH4 == null) {
                    drawableH4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableH, drawableH2, drawableH3, drawableH4);
            } else {
                if (drawableH2 == null) {
                    drawableH2 = compoundDrawablesRelative2[1];
                }
                if (drawableH4 == null) {
                    drawableH4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableH2,
                        compoundDrawablesRelative2[2], drawableH4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11)
                    || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0
                    || (colorStateList = bht.v(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            i3 = -1;
            textView.setCompoundDrawableTintMode(apy.f(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i3 = -1;
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, i3);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, i3);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                i4 = -1;
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
                i5 = -1;
            } else {
                int i10 = typedValuePeekValue.data;
                int i11 = i10 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i10);
                i5 = i11;
                i4 = -1;
            }
        } else {
            i4 = -1;
            i5 = -1;
            dimensionPixelSize = -1.0f;
        }
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != i4) {
            cnb.am(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i4) {
            cnb.an(textView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (i5 == i4) {
                cnb.trimStackTraceToClass(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                ba.h(textView, i5, dimensionPixelSize);
            } else {
                cnb.trimStackTraceToClass(textView, Math.round(TypedValue.applyDimension(i5, dimensionPixelSize,
                        textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public final void u(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cyf.w);
        jx jxVar = new jx(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)
                && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        x(context, jxVar);
        if (typedArrayObtainStyledAttributes.hasValue(13)
                && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            jj.d(textView, string);
        }
        jxVar.ae();
        Typeface typeface = this.l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void v(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new eke();
        }
        eke ekeVar = this.h;
        ekeVar.a = colorStateList;
        ekeVar.d = colorStateList != null;
        this.b = ekeVar;
        this.c = ekeVar;
        this.d = ekeVar;
        this.e = ekeVar;
        this.f = ekeVar;
        this.g = ekeVar;
    }

    public final void w(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new eke();
        }
        eke ekeVar = this.h;
        ekeVar.b = mode;
        ekeVar.c = mode != null;
        this.b = ekeVar;
        this.c = ekeVar;
        this.d = ekeVar;
        this.e = ekeVar;
        this.f = ekeVar;
        this.g = ekeVar;
    }

    public final void x(Context context, jx jxVar) {
        String string;
        int i = this.j;
        TypedArray typedArray = (TypedArray) jxVar.e;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceU = jxVar.u(i5, this.j, new jg(this, i6, i7, new WeakReference(this.a)));
                if (typefaceU != null) {
                    if (i2 < 28 || this.k == -1) {
                        this.l = typefaceU;
                    } else {
                        this.l = jk.a(Typeface.create(typefaceU, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(string, this.j);
        } else {
            this.l = jk.a(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
    }
}
