package me.hd.wauxv.obf;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auq extends emc {
    public final TextView a;
    public final aue b;
    public boolean c;

    public auq(TextView textView) {
        super(7);
        this.a = textView;
        this.c = true;
        this.b = new aue(textView);
    }

    @Override // me.hd.wauxv.obf.emc
    public final InputFilter[] _x(InputFilter[] inputFilterArr) {
        if (!this.c) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof aue) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            aue aueVar = this.b;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = aueVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == aueVar) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean _y() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.emc
    public final void k(boolean z) {
        if (z) {
            TextView textView = this.a;
            textView.setTransformationMethod(m(textView.getTransformationMethod()));
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final void l(boolean z) {
        this.c = z;
        TextView textView = this.a;
        textView.setTransformationMethod(m(textView.getTransformationMethod()));
        textView.setFilters(_x(textView.getFilters()));
    }

    @Override // me.hd.wauxv.obf.emc
    public final TransformationMethod m(TransformationMethod transformationMethod) {
        return this.c ? ((transformationMethod instanceof auu) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new auu(transformationMethod) : transformationMethod instanceof auu ? ((auu) transformationMethod).a : transformationMethod;
    }
}
