package me.hd.wauxv.obf;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csk extends Paint {
    public float a = measureText(" ");
    public boolean b;

    public csk(boolean z) {
        this.b = z;
        measureText("\t");
    }

    public final float c(char[] cArr, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5) {
        float fMeasureText;
        float textRunAdvances = getTextRunAdvances(cArr, i, i2, i3, i4, z, fArr, i5);
        if (this.b) {
            for (int i6 = 0; i6 < i2; i6++) {
                char c = cArr[i + i6];
                if (ajn.u(c)) {
                    float fMeasureText2 = measureText(ajn.t(c));
                    if (fArr != null) {
                        int i7 = i5 + i6;
                        fMeasureText = textRunAdvances - fArr[i7];
                        fArr[i7] = fMeasureText2;
                    } else {
                        fMeasureText = textRunAdvances - measureText(Character.toString(c));
                    }
                    textRunAdvances = fMeasureText + fMeasureText2;
                }
            }
        }
        return textRunAdvances;
    }

    public final void getArgs() {
        this.a = measureText(" ");
        measureText("\t");
    }

    @Override // android.graphics.Paint
    public final void setLetterSpacing(float f) {
        super.setLetterSpacing(f);
        d();
    }
}
