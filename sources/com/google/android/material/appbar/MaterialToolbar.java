package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.bmy;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.ex;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] bm = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer bn;
    public boolean bo;
    public boolean bp;
    public ImageView.ScaleType bq;
    public Boolean br;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayAn = FastKV.an(context2, attributeSet, cxs.ac, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayAn.hasValue(2)) {
            setNavigationIconTint(typedArrayAn.getColor(2, -1));
        }
        this.bo = typedArrayAn.getBoolean(4, false);
        this.bp = typedArrayAn.getBoolean(3, false);
        int i = typedArrayAn.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = bm;
            if (i < scaleTypeArr.length) {
                this.bq = scaleTypeArr[i];
            }
        }
        if (typedArrayAn.hasValue(0)) {
            this.br = Boolean.valueOf(typedArrayAn.getBoolean(0, false));
        }
        typedArrayAn.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : cmz.x(background);
        if (colorStateListValueOf != null) {
            cau cauVar = new cau();
            cauVar.dz(colorStateListValueOf);
            cauVar.dx(context2);
            WeakHashMap weakHashMap = ViewCompat.a;
            cauVar.dy(eqq.e(this));
            setBackground(cauVar);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void bd(int i) {
        Menu menu = getMenu();
        boolean z = menu instanceof cbw;
        if (z) {
            ((cbw) menu).av();
        }
        super.bd(i);
        if (z) {
            ((cbw) menu).au();
        }
    }

    public final void bs(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.bq;
    }

    public Integer getNavigationIconTint() {
        return this.bn;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        KotlinHelpers2.bj(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        ex exVar = bmy.i;
        ImageView imageView2 = null;
        if (this.bo || this.bp) {
            ArrayList arrayListV = bmy.v(this, getTitle());
            TextView textView = arrayListV.isEmpty() ? null : (TextView) Collections.min(arrayListV, exVar);
            ArrayList arrayListV2 = bmy.v(this, getSubtitle());
            TextView textView2 = arrayListV2.isEmpty() ? null : (TextView) Collections.max(arrayListV2, exVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i5 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i6 = 0; i6 < getChildCount(); i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i5 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i5 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.bo && textView != null) {
                    bs(textView, pair);
                }
                if (this.bp && textView2 != null) {
                    bs(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt2 = getChildAt(i7);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.br;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.bq;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        KotlinHelpers2.bh(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.br;
        if (bool == null || bool.booleanValue() != z) {
            this.br = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.bq != scaleType) {
            this.bq = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.bn != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.bn.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.bn = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.bp != z) {
            this.bp = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.bo != z) {
            this.bo = z;
            requestLayout();
        }
    }
}
