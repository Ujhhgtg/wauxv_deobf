package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adm {
    public static final SparseIntArray a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public int h;
    public String i;
    public int j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void k(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxx.f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (a.get(index)) {
                case 1:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 2:
                    this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        String str = dqc.at[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.b = adp.i(typedArrayObtainStyledAttributes, index, this.b);
                    break;
                case 6:
                    this.c = typedArrayObtainStyledAttributes.getInteger(index, this.c);
                    break;
                case 7:
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 8:
                    this.h = typedArrayObtainStyledAttributes.getInteger(index, this.h);
                    break;
                case 9:
                    this.g = typedArrayObtainStyledAttributes.getFloat(index, this.g);
                    break;
                case 10:
                    int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i2 == 1) {
                        this.j = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    } else if (i2 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.i = string;
                        if (string.indexOf("/") > 0) {
                            this.j = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.j);
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
