package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adn {
    public int a;
    public int b;
    public float c;
    public float d;

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxx.g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
            } else if (index == 0) {
                int i2 = typedArrayObtainStyledAttributes.getInt(index, this.a);
                this.a = i2;
                this.a = adp.a[i2];
            } else if (index == 4) {
                this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
            } else if (index == 3) {
                this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
