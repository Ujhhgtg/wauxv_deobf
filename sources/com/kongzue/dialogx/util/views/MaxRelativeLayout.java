package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import me.hd.wauxv.obf.anj;
import me.hd.wauxv.obf.anm;
import me.hd.wauxv.obf.bfm;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.caz;
import me.hd.wauxv.obf.cxt;
import me.hd.wauxv.obf.no;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaxRelativeLayout extends RelativeLayout implements anm {
    public static final /* synthetic */ int a = 0;
    public int b;
    public int c;
    public int d;
    public int e;
    public final boolean f;
    public final int g;
    public int h;
    public bfm i;
    public int j;
    public View.OnTouchListener k;
    public boolean l;

    public MaxRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxt.b);
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f = typedArrayObtainStyledAttributes.getBoolean(2, false);
            typedArrayObtainStyledAttributes.getBoolean(1, true);
            this.g = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        int i = this.d;
        this.d = i == 0 ? getMinimumWidth() : i;
        int i2 = this.e;
        this.e = i2 == 0 ? getMinimumHeight() : i2;
        if (isInEditMode()) {
            return;
        }
        animate().setUpdateListener(new no(this, 7));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.k;
        if (onTouchListener != null) {
            this.l = onTouchListener.onTouch(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // me.hd.wauxv.obf.anm
    public int getDialogXSafetyMode() {
        return this.g;
    }

    public caz getOnYChanged() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j != 0) {
            ResourcesCompat resourcesCompatVar = anj.a;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.l;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (this.h == -1 && size2 != 0) {
            this.h = size2;
        }
        if (this.f) {
            this.b = Math.min(this.b, Math.min(size2, this.h));
        }
        int i3 = this.c;
        if (size > i3 && i3 != 0) {
            size = getPaddingBottom() + i3 + getPaddingTop();
        }
        int i4 = this.b;
        if (size2 > i4 && i4 != 0) {
            size2 = getPaddingLeft() + i4 + getPaddingRight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, mode2), View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setContentView(View view) {
    }

    public void setMinHeight(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public void setMinWidth(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    public void setNavBarHeight(int i) {
        this.j = i;
        invalidate();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.k = onTouchListener;
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        bfm bfmVar = this.i;
        if (bfmVar != null) {
            bfmVar.c(f);
        }
    }

    @Override // android.view.View
    public void setY(float f) {
        super.setY(f);
    }
}
