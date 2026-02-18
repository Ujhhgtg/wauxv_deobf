package me.hd.wauxv.obf;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cay {
    public static final Random a = new Random();

    public static float b(float f, float f2) {
        int i = (int) f;
        return a.nextInt((((int) f2) - i) + 1) + i;
    }
}
