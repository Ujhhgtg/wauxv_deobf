package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class est extends bhs {
    public static boolean a = true;
    public static boolean ah = true;
    public static boolean ai = true;
    public static boolean aj = true;

    @Override // me.hd.wauxv.obf.bhs
    public void ag(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.ag(view, i);
        } else if (aj) {
            try {
                ess.a(view, i);
            } catch (NoSuchMethodError unused) {
                aj = false;
            }
        }
    }

    public void ak(View view, int i, int i2, int i3, int i4) {
        if (ai) {
            try {
                esr.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                ai = false;
            }
        }
    }

    public void al(View view, Matrix matrix) {
        if (a) {
            try {
                esq.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }

    public void am(View view, Matrix matrix) {
        if (ah) {
            try {
                esq.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                ah = false;
            }
        }
    }
}
