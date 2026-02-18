package me.hd.wauxv.obf;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class caa extends hc {
    public final bwn a;
    public final AccessibilityManager b;
    public final Rect c;
    public final int h;
    public final float i;
    public ColorStateList j;
    public int k;
    public ColorStateList l;

    public caa(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.c = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayAn = bhu.an(context2, attributeSet, cxs.q, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayAn.hasValue(0) && typedArrayAn.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.h = typedArrayAn.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.i = typedArrayAn.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayAn.hasValue(2)) {
            this.j = ColorStateList.valueOf(typedArrayAn.getColor(2, 0));
        }
        this.k = typedArrayAn.getColor(4, 0);
        this.l = cnb.v(context2, typedArrayAn, 5);
        this.b = (AccessibilityManager) context2.getSystemService("accessibility");
        bwn bwnVar = new bwn(context2, null, R.attr.listPopupWindowStyle, 0);
        this.a = bwnVar;
        bwnVar.au = true;
        bwnVar.av.setFocusable(true);
        bwnVar.ak = this;
        bwnVar.av.setInputMethodMode(2);
        bwnVar.p(getAdapter());
        bwnVar.al = new iz(this, 1);
        if (typedArrayAn.hasValue(6)) {
            setSimpleItems(typedArrayAn.getResourceId(6, 0));
        }
        typedArrayAn.recycle();
    }

    public static void m(caa caaVar, Object obj) {
        caaVar.setText(caaVar.convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (o()) {
            this.a.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.j;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutN = n();
        return (textInputLayoutN == null || !textInputLayoutN.af) ? super.getHint() : textInputLayoutN.getHint();
    }

    public float getPopupElevation() {
        return this.i;
    }

    public int getSimpleItemSelectedColor() {
        return this.k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.l;
    }

    public final TextInputLayout n() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean o() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutN = n();
        if (textInputLayoutN != null && textInputLayoutN.af && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutN = n();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutN != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                bwn bwnVar = this.a;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !bwnVar.av.isShowing() ? -1 : bwnVar.w.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutN);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = bwnVar.av.getBackground();
                if (background != null) {
                    Rect rect = this.c;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutN.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        if (o()) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.a.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        bwn bwnVar = this.a;
        if (bwnVar != null) {
            bwnVar.k(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof cau) {
            ((cau) dropDownBackground).dz(this.j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.a.am = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i) {
        super.setRawInputType(i);
        TextInputLayout textInputLayoutN = n();
        if (textInputLayoutN != null) {
            textInputLayoutN.cs();
        }
    }

    public void setSimpleItemSelectedColor(int i) {
        this.k = i;
        if (getAdapter() instanceof bzz) {
            ((bzz) getAdapter()).d();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.l = colorStateList;
        if (getAdapter() instanceof bzz) {
            ((bzz) getAdapter()).d();
        }
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (o()) {
            this.a.ag();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new bzz(this, getContext(), this.h, strArr));
    }
}
