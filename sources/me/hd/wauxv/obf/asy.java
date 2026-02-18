package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import com.android.dx.io.Opcodes;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asy {
    public static final int a = (int) Math.round(5.1000000000000005d);
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;

    public asy(Context context) {
        Integer numValueOf;
        Integer numValueOf2;
        boolean zAm = cmz.am(context, R.attr.elevationOverlayEnabled, false);
        TypedValue typedValueAl = cmz.al(context, R.attr.elevationOverlayColor);
        Integer numValueOf3 = null;
        if (typedValueAl != null) {
            int i = typedValueAl.resourceId;
            numValueOf = Integer.valueOf(i != 0 ? context.getColor(i) : typedValueAl.data);
        } else {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        TypedValue typedValueAl2 = cmz.al(context, R.attr.elevationOverlayAccentColor);
        if (typedValueAl2 != null) {
            int i2 = typedValueAl2.resourceId;
            numValueOf2 = Integer.valueOf(i2 != 0 ? context.getColor(i2) : typedValueAl2.data);
        } else {
            numValueOf2 = null;
        }
        int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 0;
        TypedValue typedValueAl3 = cmz.al(context, R.attr.colorSurface);
        if (typedValueAl3 != null) {
            int i3 = typedValueAl3.resourceId;
            numValueOf3 = Integer.valueOf(i3 != 0 ? context.getColor(i3) : typedValueAl3.data);
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : 0;
        float f = context.getResources().getDisplayMetrics().density;
        this.b = zAm;
        this.c = iIntValue;
        this.d = iIntValue2;
        this.e = iIntValue3;
        this.f = f;
    }

    public final int g(int i, float f) {
        int i2;
        if (!this.b || abi.f(i, Opcodes.CONST_METHOD_TYPE) != this.e) {
            return i;
        }
        float fMin = (this.f <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iAd = cna.ad(abi.f(i, Opcodes.CONST_METHOD_TYPE), fMin, this.c);
        if (fMin > 0.0f && (i2 = this.d) != 0) {
            iAd = abi.d(abi.f(i2, a), iAd);
        }
        return abi.f(iAd, iAlpha);
    }
}
