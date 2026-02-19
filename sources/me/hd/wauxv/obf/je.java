package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class je extends Spinner {
    public static final int[] a = {R.attr.spinnerMode};
    public final ea b;
    public final Context c;
    public final iu d;
    public SpinnerAdapter e;
    public final boolean f;
    public final jd g;
    public int h;
    public final Rect i;

    /* JADX WARN: Found duplicated region for block: B:26:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Found duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Found duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00d7  */
    public je(Context context, AttributeSet attributeSet) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, me.hd.wauxv.R.attr.spinnerStyle);
        this.i = new Rect();
        drm.h(this, getContext());
        int[] iArr = cyf.u;
        FactoryPools factoryPoolsVarK = FactoryPools.k(context, attributeSet, iArr, me.hd.wauxv.R.attr.spinnerStyle);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        this.b = new ea(this);
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            this.c = new afv(context, resourceId);
        } else {
            this.c = context;
        }
        int i = -1;
        TypedArray typedArray2 = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a, me.hd.wauxv.R.attr.spinnerStyle, 0);
            try {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    if (typedArrayObtainStyledAttributes != null) {
                    }
                    if (i != 0) {
                        ix ixVar = new ix(this);
                        this.g = ixVar;
                        ixVar.c = typedArray.getString(2);
                    } else if (i == 1) {
                        jb jbVar = new jb(this, this.c, attributeSet);
                        FactoryPools factoryPoolsVarK2 = FactoryPools.k(this.c, attributeSet, iArr, me.hd.wauxv.R.attr.spinnerStyle);
                        this.h = ((TypedArray) factoryPoolsVarK2.e).getLayoutDimension(3, -2);
                        jbVar.k(factoryPoolsVarK2.s(1));
                        jbVar.a = typedArray.getString(2);
                        factoryPoolsVarK2.ae();
                        this.g = jbVar;
                        this.d = new iu(this, this, jbVar);
                    }
                    textArray = typedArray.getTextArray(0);
                    if (textArray != null) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                        arrayAdapter.setDropDownViewResource(me.hd.wauxv.R.layout.support_simple_spinner_dropdown_item);
                        setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    factoryPoolsVarK.ae();
                    this.f = true;
                    spinnerAdapter = this.e;
                    if (spinnerAdapter != null) {
                        setAdapter(spinnerAdapter);
                        this.e = null;
                    }
                    this.b.t(attributeSet, me.hd.wauxv.R.attr.spinnerStyle);
                }
            } catch (Throwable th) {
                th = th;
                typedArray2 = typedArrayObtainStyledAttributes;
                if (typedArray2 != null) {
                    typedArray2.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            ix ixVar2 = new ix(this);
            this.g = ixVar2;
            ixVar2.c = typedArray.getString(2);
        } else if (i == 1) {
            jb jbVar2 = new jb(this, this.c, attributeSet);
            FactoryPools factoryPoolsVarK22 = FactoryPools.k(this.c, attributeSet, iArr, me.hd.wauxv.R.attr.spinnerStyle);
            this.h = ((TypedArray) factoryPoolsVarK22.e).getLayoutDimension(3, -2);
            jbVar2.k(factoryPoolsVarK22.s(1));
            jbVar2.a = typedArray.getString(2);
            factoryPoolsVarK22.ae();
            this.g = jbVar2;
            this.d = new iu(this, this, jbVar2);
        }
        textArray = typedArray.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(me.hd.wauxv.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        factoryPoolsVarK.ae();
        this.f = true;
        spinnerAdapter = this.e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.e = null;
        }
        this.b.t(attributeSet, me.hd.wauxv.R.attr.spinnerStyle);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.h();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        jd jdVar = this.g;
        return jdVar != null ? jdVar.f() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        jd jdVar = this.g;
        return jdVar != null ? jdVar.o() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.g != null ? this.h : super.getDropDownWidth();
    }

    public final jd getInternalPopup() {
        return this.g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        jd jdVar = this.g;
        return jdVar != null ? jdVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        jd jdVar = this.g;
        return jdVar != null ? jdVar.h() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.b;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.b;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public final int j(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.i;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        jd jdVar = this.g;
        if (jdVar == null || !jdVar.e()) {
            return;
        }
        jdVar.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        jc jcVar = (jc) parcelable;
        super.onRestoreInstanceState(jcVar.getSuperState());
        if (!jcVar.a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new iv(this, 0));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        jc jcVar = new jc(super.onSaveInstanceState());
        jd jdVar = this.g;
        jcVar.a = jdVar != null && jdVar.e();
        return jcVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        iu iuVar = this.d;
        if (iuVar == null || !iuVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        jd jdVar = this.g;
        if (jdVar == null) {
            return super.performClick();
        }
        if (jdVar.e()) {
            return true;
        }
        jdVar.n(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        jd jdVar = this.g;
        if (jdVar == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            jdVar.m(i);
            jdVar.g(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        jd jdVar = this.g;
        if (jdVar != null) {
            jdVar.l(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        jd jdVar = this.g;
        if (jdVar != null) {
            jdVar.k(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(cmz.y(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        jd jdVar = this.g;
        if (jdVar != null) {
            jdVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        jd jdVar = this.g;
        if (jdVar != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            iy iyVar = new iy();
            iyVar.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                iyVar.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                iw.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            jdVar.p(iyVar);
        }
    }
}
