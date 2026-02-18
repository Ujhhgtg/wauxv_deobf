package me.hd.wauxv.obf;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhs {
    public final int d;
    public boolean e;
    public final float[] c = new float[65536];
    public final char[] b = new char[10];
    public final float[] a = new float[10];

    public dhs(int i) {
        new SparseArray();
        this.d = i;
    }

    public final float f(char c, csk cskVar) {
        int i;
        if (c == '\t') {
            c = ' ';
            i = this.d;
        } else {
            i = 1;
        }
        float[] fArr = this.c;
        float fMeasureText = fArr[c];
        if (fMeasureText == 0.0f) {
            char[] cArr = this.b;
            cArr[0] = c;
            fMeasureText = cskVar.measureText(cArr, 0, 1);
            fArr[c] = fMeasureText;
        }
        return fMeasureText * i;
    }

    public final float g(CharSequence charSequence, int i, int i2, csk cskVar) {
        char[] cArr;
        double dCeil;
        long jCeil = 0;
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 55356 || cCharAt == 55357 || cCharAt == 55358) {
                if (i + 4 <= i2) {
                    float[] fArr = this.a;
                    cskVar.getTextWidths(charSequence, i, 4, fArr);
                    if (fArr[0] > 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[3] == 0.0f) {
                        i += 3;
                        dCeil = Math.ceil(r3 * 1000.0f);
                        jCeil += (long) dCeil;
                    }
                }
                int iMin = Math.min(i2, i + 2) - i;
                int i3 = 0;
                while (true) {
                    cArr = this.b;
                    if (i3 >= iMin) {
                        break;
                    }
                    cArr[i3] = charSequence.charAt(i + i3);
                    i3++;
                }
                jCeil += (long) Math.ceil(cskVar.measureText(cArr, 0, iMin) * 1000.0f);
                i += iMin - 1;
            } else if (this.e && ajn.u(cCharAt)) {
                String strT = ajn.t(cCharAt);
                for (int i4 = 0; i4 < strT.length(); i4++) {
                    jCeil += (long) Math.ceil(f(strT.charAt(i4), cskVar) * 1000.0f);
                }
            } else {
                dCeil = Math.ceil(f(cCharAt, cskVar) * 1000.0f);
                jCeil += (long) dCeil;
            }
            i++;
        }
        return jCeil / 1000.0f;
    }

    public final float h(char[] cArr, int i, csk cskVar) {
        double dCeil;
        long jCeil = 0;
        int i2 = 0;
        while (i2 < i) {
            char c = cArr[i2];
            if (c == 55356 || c == 55357 || c == 55358) {
                if (i2 + 4 <= i) {
                    float[] fArr = this.a;
                    cskVar.getTextWidths(cArr, i2, 4, fArr);
                    if (fArr[0] > 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[3] == 0.0f) {
                        i2 += 3;
                        dCeil = Math.ceil(r5 * 1000.0f);
                        jCeil += (long) dCeil;
                    }
                }
                int iMin = Math.min(i, i2 + 2) - i2;
                char[] cArr2 = this.b;
                if (iMin >= 0) {
                    System.arraycopy(cArr, i2, cArr2, 0, iMin);
                }
                jCeil += (long) Math.ceil(cskVar.measureText(cArr2, 0, iMin) * 1000.0f);
                i2 += iMin - 1;
            } else if (this.e && ajn.u(c)) {
                String strT = ajn.t(c);
                for (int i3 = 0; i3 < strT.length(); i3++) {
                    jCeil += (long) Math.ceil(f(strT.charAt(i3), cskVar) * 1000.0f);
                }
            } else {
                dCeil = Math.ceil(f(c, cskVar) * 1000.0f);
                jCeil += (long) dCeil;
            }
            i2++;
        }
        return jCeil / 1000.0f;
    }
}
