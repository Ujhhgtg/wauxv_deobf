package me.hd.wauxv.obf;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class asl {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[amu.values().length];
        b = iArr;
        try {
            iArr[3] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[1] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[2] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[Paint.Align.values().length];
        a = iArr2;
        try {
            iArr2[Paint.Align.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[Paint.Align.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[Paint.Align.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
