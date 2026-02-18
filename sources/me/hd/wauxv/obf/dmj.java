package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmj extends LinearLayout {
    public final TextInputLayout a;
    public final jp b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public int g;
    public ImageView.ScaleType h;
    public View.OnLongClickListener i;
    public boolean j;

    public dmj(TextInputLayout textInputLayout, jx jxVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        jp jpVar = new jp(getContext(), null);
        this.b = jpVar;
        if (cnb.ad(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        bhu.bb(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        bhu.bb(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) jxVar.e;
        if (typedArray.hasValue(69)) {
            this.e = cnb.w(getContext(), jxVar, 69);
        }
        if (typedArray.hasValue(70)) {
            this.f = ewz.ap(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            l(jxVar.s(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.g) {
            this.g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(68)) {
            ImageView.ScaleType scaleTypeU = bhu.u(typedArray.getInt(68, -1));
            this.h = scaleTypeU;
            checkableImageButton.setScaleType(scaleTypeU);
        }
        jpVar.setVisibility(8);
        jpVar.setId(R.id.textinput_prefix_text);
        jpVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = eqz.a;
        jpVar.setAccessibilityLiveRegion(1);
        jpVar.setTextAppearance(typedArray.getResourceId(60, 0));
        if (typedArray.hasValue(61)) {
            jpVar.setTextColor(jxVar.r(61));
        }
        CharSequence text2 = typedArray.getText(59);
        this.c = TextUtils.isEmpty(text2) ? null : text2;
        jpVar.setText(text2);
        o();
        addView(checkableImageButton);
        addView(jpVar);
    }

    public final int k() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        WeakHashMap weakHashMap = eqz.a;
        return this.b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void l(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.e;
            PorterDuff.Mode mode = this.f;
            TextInputLayout textInputLayout = this.a;
            bhu.o(textInputLayout, checkableImageButton, colorStateList, mode);
            m(true);
            bhu.av(textInputLayout, checkableImageButton, this.e);
            return;
        }
        m(false);
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        bhu.bb(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        bhu.bb(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void m(boolean z) {
        CheckableImageButton checkableImageButton = this.d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            n();
            o();
        }
    }

    public final void n() {
        int paddingStart;
        EditText editText = this.a.e;
        if (editText == null) {
            return;
        }
        if (this.d.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = eqz.a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = eqz.a;
        this.b.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void o() {
        int i = (this.c == null || this.j) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.a.cq();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        n();
    }
}
