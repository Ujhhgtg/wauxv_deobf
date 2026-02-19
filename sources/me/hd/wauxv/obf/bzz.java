package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzz extends ArrayAdapter {
    public ColorStateList a;
    public ColorStateList b;
    public final /* synthetic */ caa c;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bzz(caa caaVar, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.c = caaVar;
        d();
    }

    public final void getArgs() {
        ColorStateList colorStateList;
        caa caaVar = this.c;
        ColorStateList colorStateList2 = caaVar.l;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = { R.attr.state_pressed };
            colorStateList = new ColorStateList(new int[][] { iArr, new int[0] },
                    new int[] { colorStateList2.getColorForState(iArr, 0), 0 });
        } else {
            colorStateList = null;
        }
        this.b = colorStateList;
        if (caaVar.k != 0 && caaVar.l != null) {
            int[] iArr2 = { R.attr.state_hovered, -16842919 };
            int[] iArr3 = { R.attr.state_selected, -16842919 };
            colorStateList3 = new ColorStateList(new int[][] { iArr3, iArr2, new int[0] },
                    new int[] { abi.d(caaVar.l.getColorForState(iArr3, 0), caaVar.k),
                            abi.d(caaVar.l.getColorForState(iArr2, 0), caaVar.k), caaVar.k });
        }
        this.a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            caa caaVar = this.c;
            Drawable rippleDrawable = null;
            if (caaVar.getText().toString().contentEquals(textView.getText()) && caaVar.k != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(caaVar.k);
                if (this.b != null) {
                    colorDrawable.setTintList(this.a);
                    rippleDrawable = new RippleDrawable(this.b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = ViewCompat.a;
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
