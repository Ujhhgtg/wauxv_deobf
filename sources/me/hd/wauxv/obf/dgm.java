package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgm {
    public bhv a = new ddk();
    public bhv b = new ddk();
    public bhv c = new ddk();
    public bhv d = new ddk();
    public ahe e = new o(0.0f);
    public ahe f = new o(0.0f);
    public ahe g = new o(0.0f);
    public ahe h = new o(0.0f);
    public arj i = new arj();
    public arj j = new arj();
    public arj k = new arj();
    public arj l = new arj();

    public static dgl m(Context context, int i, int i2, o oVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(cxs.ai);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(1, i3);
            ahe aheVarO = o(typedArrayObtainStyledAttributes, 5, oVar);
            ahe aheVarO2 = o(typedArrayObtainStyledAttributes, 8, aheVarO);
            ahe aheVarO3 = o(typedArrayObtainStyledAttributes, 9, aheVarO);
            ahe aheVarO4 = o(typedArrayObtainStyledAttributes, 7, aheVarO);
            ahe aheVarO5 = o(typedArrayObtainStyledAttributes, 6, aheVarO);
            dgl dglVar = new dgl();
            dglVar.a = cnd.ao(i4);
            dglVar.e = aheVarO2;
            dglVar.b = cnd.ao(i5);
            dglVar.f = aheVarO3;
            dglVar.c = cnd.ao(i6);
            dglVar.g = aheVarO4;
            dglVar.d = cnd.ao(i7);
            dglVar.h = aheVarO5;
            return dglVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static dgl n(Context context, AttributeSet attributeSet, int i, int i2) {
        o oVar = new o(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.y, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return m(context, resourceId, resourceId2, oVar);
    }

    public static ahe o(TypedArray typedArray, int i, ahe aheVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new o(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new dat(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return aheVar;
    }

    public final boolean p(RectF rectF) {
        boolean z = this.l.getClass().equals(arj.class) && this.j.getClass().equals(arj.class) && this.i.getClass().equals(arj.class) && this.k.getClass().equals(arj.class);
        float fB = this.e.b(rectF);
        return z && ((this.f.b(rectF) > fB ? 1 : (this.f.b(rectF) == fB ? 0 : -1)) == 0 && (this.h.b(rectF) > fB ? 1 : (this.h.b(rectF) == fB ? 0 : -1)) == 0 && (this.g.b(rectF) > fB ? 1 : (this.g.b(rectF) == fB ? 0 : -1)) == 0) && ((this.b instanceof ddk) && (this.a instanceof ddk) && (this.c instanceof ddk) && (this.d instanceof ddk));
    }

    public final dgl q() {
        dgl dglVar = new dgl();
        dglVar.a = this.a;
        dglVar.b = this.b;
        dglVar.c = this.c;
        dglVar.d = this.d;
        dglVar.e = this.e;
        dglVar.f = this.f;
        dglVar.g = this.g;
        dglVar.h = this.h;
        dglVar.i = this.i;
        dglVar.j = this.j;
        dglVar.k = this.k;
        dglVar.l = this.l;
        return dglVar;
    }
}
