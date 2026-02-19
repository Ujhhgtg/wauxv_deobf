package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzy extends ek {
    public final cau v;
    public final Rect w;

    /* JADX WARN: Illegal instructions before constructor call */
    public bzy(Context context) {
        TypedValue typedValueAl = cmz.al(context, R.attr.materialAlertDialogTheme);
        int i = typedValueAl == null ? 0 : typedValueAl.data;
        Context contextAq = cmz.aq(context, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        contextAq = i != 0 ? new afv(contextAq, i) : contextAq;
        TypedValue typedValueAl2 = cmz.al(context, R.attr.materialAlertDialogTheme);
        super(contextAq, typedValueAl2 == null ? 0 : typedValueAl2.data);
        ContextThemeWrapper contextThemeWrapper = ((eg) this.d).a;
        Resources.Theme theme = contextThemeWrapper.getTheme();
        FastKV.p(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int[] iArr = cxs.p;
        FastKV.q(contextThemeWrapper, null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (contextThemeWrapper.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.w = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int iU = cna.u(contextThemeWrapper, R.attr.colorSurface, bzy.class.getCanonicalName());
        TypedArray typedArrayObtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int color = typedArrayObtainStyledAttributes2.getColor(4, iU);
        typedArrayObtainStyledAttributes2.recycle();
        cau cauVar = new cau(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        cauVar.dx(contextThemeWrapper);
        cauVar.dz(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(((eg) this.d).a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                dgl dglVarQ = cauVar.ct.b.q();
                dglVarQ.n(dimension);
                cauVar.setShapeAppearanceModel(dglVarQ.m());
            }
        }
        this.v = cauVar;
    }

    @Override // me.hd.wauxv.obf.ek
    public final el i() {
        el elVarI = super.i();
        Window window = elVarI.getWindow();
        View decorView = window.getDecorView();
        cau cauVar = this.v;
        if (cauVar != null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            cauVar.dy(eqq.e(decorView));
        }
        Rect rect = this.w;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) cauVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new bpr(elVarI, rect));
        return elVarI;
    }
}
