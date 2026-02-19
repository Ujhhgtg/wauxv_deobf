package me.hd.wauxv.obf;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface btr extends afp {
    int e();

    long f(float f, float f2);

    int g();

    float[] h(int i, int i2, float[] fArr);

    ddo i(int i, SparseArray sparseArray);

    long j(int i, int i2);

    int k(int i);

    int l(int i);

    void m();

    long n(int i, int i2);

    int o(int i);

    void p(SyntheticPileOfMess bmuVar);

    ddm q(int i);

    default float[] r(int i, int i2) {
        return h(i, i2, new float[2]);
    }

    int s();
}
