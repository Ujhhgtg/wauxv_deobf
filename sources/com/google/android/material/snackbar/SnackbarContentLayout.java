package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ff;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {
    public TextView a;
    public Button b;
    public int c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ajn.ae(context, R.attr.motionEasingEmphasizedInterpolator, ff.b);
    }

    public final boolean d(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.a;
        WeakHashMap weakHashMap = eqz.a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i2, textView.getPaddingEnd(), i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.snackbar_text);
        this.b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.a.getLayout();
        boolean z = layout != null && layout.getLineCount() > 1;
        if (!z || this.c <= 0 || this.b.getMeasuredWidth() <= this.c) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!d(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.c = i;
    }
}
