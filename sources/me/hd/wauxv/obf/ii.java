package me.hd.wauxv.obf;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ii {
    public final TextView a;
    public final erp b;

    public ii(TextView textView) {
        this.a = textView;
        this.b = new erp(textView);
    }

    public final InputFilter[] c(InputFilter[] inputFilterArr) {
        return ((emc) this.b.v)._x(inputFilterArr);
    }

    public final void d(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, cyf.i, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            f(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void e(boolean z) {
        ((emc) this.b.v).k(z);
    }

    public final void f(boolean z) {
        ((emc) this.b.v).l(z);
    }
}
