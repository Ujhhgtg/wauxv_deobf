package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dqd {
    public static final bmu a;

    static {
        bmu bmuVar = new bmu();
        bmuVar.h = null;
        a = bmuVar;
    }

    public static float[] b(int i) {
        float[] fArr;
        bmu bmuVar = a;
        synchronized (bmuVar) {
            fArr = (float[]) bmuVar.h;
            bmuVar.h = null;
        }
        return (fArr == null || fArr.length < i) ? new float[i] : fArr;
    }

    public static void c(float[] fArr) {
        bmu bmuVar = a;
        if (fArr.length > 1000) {
            return;
        }
        synchronized (bmuVar) {
            bmuVar.h = fArr;
        }
    }
}
