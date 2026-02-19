package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dqd {
    public static final SyntheticPileOfMess a;

    static {
        SyntheticPileOfMess bmuVar = new SyntheticPileOfMess();
        bmuVar.obj = null;
        a = bmuVar;
    }

    public static float[] b(int i) {
        float[] fArr;
        SyntheticPileOfMess bmuVar = a;
        synchronized (bmuVar) {
            fArr = (float[]) bmuVar.obj;
            bmuVar.obj = null;
        }
        return (fArr == null || fArr.length < i) ? new float[i] : fArr;
    }

    public static void c(float[] fArr) {
        SyntheticPileOfMess bmuVar = a;
        if (fArr.length > 1000) {
            return;
        }
        synchronized (bmuVar) {
            bmuVar.obj = fArr;
        }
    }
}
