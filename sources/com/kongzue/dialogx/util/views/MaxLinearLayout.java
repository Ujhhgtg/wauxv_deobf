package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import me.hd.wauxv.obf.cxt;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaxLinearLayout extends LinearLayout {
    public final int a;
    public final int b;
    public int c;
    public int d;
    public int e;

    public MaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxt.b);
            this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        int i = this.c;
        this.c = i == 0 ? getMinimumWidth() : i;
        int i2 = this.d;
        this.d = i2 == 0 ? getMinimumHeight() : i2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (this.e == -1 && size2 != 0) {
            this.e = size2;
        }
        int i3 = this.b;
        if (size > i3 && i3 != 0) {
            size = i3;
        }
        int i4 = this.a;
        if (size2 > i4 && i4 != 0) {
            size2 = i4;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, mode2), View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.d = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.c = i;
        super.setMinimumWidth(i);
    }
}
