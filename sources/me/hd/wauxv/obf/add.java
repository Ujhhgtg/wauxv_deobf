package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class add extends View {
    public int[] e;
    public int f;
    public Context g;
    public bkw h;
    public String i;
    public String j;
    public HashMap k;

    public abstract void b(adq adqVar, boolean z);

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.e, this.f);
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x004c  */
    public final void l(String str) {
        int iIntValue;
        HashMap map;
        Context context = this.g;
        if (str == null || str.length() == 0 || context == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (isInEditMode() && constraintLayout != null) {
            Object obj = (strTrim == null || (map = constraintLayout.n) == null || !map.containsKey(strTrim)) ? null : constraintLayout.n.get(strTrim);
            iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        }
        if (iIntValue == 0 && constraintLayout != null) {
            iIntValue = q(constraintLayout, strTrim);
        }
        if (iIntValue == 0) {
            try {
                iIntValue = cxp.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (iIntValue == 0) {
            iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
        }
        if (iIntValue != 0) {
            this.k.put(Integer.valueOf(iIntValue), strTrim);
            m(iIntValue);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
        }
    }

    public final void m(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f + 1;
        int[] iArr = this.e;
        if (i2 > iArr.length) {
            this.e = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.e;
        int i3 = this.f;
        iArr2[i3] = i;
        this.f = i3 + 1;
    }

    public final void n(String str) {
        if (str == null || str.length() == 0 || this.g == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof adf) && strTrim.equals(((adf) layoutParams).ay)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    m(childAt.getId());
                }
            }
        }
    }

    public final void o(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.f; i++) {
            View view = (View) constraintLayout.b.get(this.e[i]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.i;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.j;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public final int q(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.g.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public void r(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxx.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 35) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.i = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.j = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void s() {
        if (this.h == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof adf) {
            ((adf) layoutParams).bp = this.h;
        }
    }

    public void setIds(String str) {
        this.i = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                l(str.substring(i));
                return;
            } else {
                l(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.j = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                n(str.substring(i));
                return;
            } else {
                n(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.i = null;
        this.f = 0;
        for (int i : iArr) {
            m(i);
        }
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.i == null) {
            m(i);
        }
    }
}
