package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cib {
    public static final int[] a;
    public static final int[] b;

    static {
        if (a != null) {
            return;
        }
        int[] iArr = new int[2048];
        b = iArr;
        a = new int[2048];
        Arrays.fill(iArr, 0);
        Arrays.fill(a, 0);
        for (int i = 0; i <= 65535; i++) {
            char c = (char) i;
            if (Character.isJavaIdentifierPart(c)) {
                int[] iArr2 = b;
                int i2 = i / 32;
                iArr2[i2] = iArr2[i2] | (1 << (i % 32));
            }
            if (Character.isJavaIdentifierStart(c)) {
                int[] iArr3 = a;
                int i3 = i / 32;
                iArr3[i3] = (1 << (i % 32)) | iArr3[i3];
            }
        }
    }

    public static boolean c(int[] iArr, int i) {
        return (iArr[i / 32] & (1 << (i % 32))) != 0;
    }
}
